package ruby.fluffy.helpme.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import ruby.fluffy.helpme.registries.RubysRecipes;

public class UndyeingRecipe implements CraftingRecipe {

        final String group;
        final CraftingBookCategory category;
        final ItemStack result;
        final NonNullList<Ingredient> ingredients;
        private final boolean isSimple;

    public UndyeingRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList < Ingredient > ingredients)
        {
            this.group = group;
            this.category = category;
            this.result = result;
            this.ingredients = ingredients;
            this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
        }

        @Override
        public RecipeSerializer<?> getSerializer () {
            return RubysRecipes.COPYING_SHAPELESS.get();
        }

        @Override
        public String getGroup () {
            return this.group;
        }

        @Override
        public CraftingBookCategory category () {
            return this.category;
        }

        @Override
        public ItemStack getResultItem (HolderLookup.Provider registries){
            return this.result;
        }

        @Override
        public NonNullList<Ingredient> getIngredients () {
            return this.ingredients;
        }

        public boolean matches (CraftingInput input, Level level){
            if (input.ingredientCount() != this.ingredients.size()) {
                return false;
            } else if (!isSimple) {
                var nonEmptyItems = new java.util.ArrayList<ItemStack>(input.ingredientCount());
                for (var item : input.items())
                    if (!item.isEmpty())
                        nonEmptyItems.add(item);
                return net.neoforged.neoforge.common.util.RecipeMatcher.findMatches(nonEmptyItems, this.ingredients) != null;
            } else {
                return input.size() == 1 && this.ingredients.size() == 1
                        ? this.ingredients.getFirst().test(input.getItem(0))
                        : input.stackedContents().canCraft(this, null);
            }
        }

    @Override
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack output = this.result.copy();

        outer:
        for (Ingredient ingredient : this.ingredients) {
            for (int i = 0; i < input.size(); i++) {
                ItemStack slot = input.getItem(i);
                if (!slot.isEmpty() && ingredient.test(slot)) {

                    // --- COPY ONLY CERTAIN COMPONENTS ---

                    // copy custom name
                    if (slot.has(DataComponents.CUSTOM_NAME)) {
                        output.set(DataComponents.CUSTOM_NAME,
                                slot.get(DataComponents.CUSTOM_NAME));
                    }

                    // copy enchantments
                    if (slot.has(DataComponents.ENCHANTMENTS)) {
                        output.set(DataComponents.ENCHANTMENTS,
                                slot.get(DataComponents.ENCHANTMENTS));
                    }

                    // optionally remove dyed color if present
                    output.remove(DataComponents.DYED_COLOR);

                    break outer;
                }
            }
        }

        return output;
    }

        /**
         * Used to determine if this recipe can fit in a grid of the given width/height
         */
        @Override
        public boolean canCraftInDimensions ( int width, int height){
            return width * height >= this.ingredients.size();
        }

        public static class Serializer implements RecipeSerializer<UndyeingRecipe> {
            private static final MapCodec<UndyeingRecipe> CODEC = RecordCodecBuilder.mapCodec(
                    p_340779_ -> p_340779_.group(
                                    Codec.STRING.optionalFieldOf("group", "").forGetter(p_301127_ -> p_301127_.group),
                                    CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(p_301133_ -> p_301133_.category),
                                    ItemStack.STRICT_CODEC.fieldOf("result").forGetter(p_301142_ -> p_301142_.result),
                                    Ingredient.CODEC_NONEMPTY
                                            .listOf()
                                            .fieldOf("ingredients")
                                            .flatXmap(
                                                    p_301021_ -> {
                                                        Ingredient[] aingredient = p_301021_.toArray(Ingredient[]::new); // Neo skip the empty check and immediately create the array.
                                                        if (aingredient.length == 0) {
                                                            return DataResult.error(() -> "No ingredients for shapeless recipe");
                                                        } else {
                                                            return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()
                                                                    ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()))
                                                                    : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
                                                        }
                                                    },
                                                    DataResult::success
                                            )
                                            .forGetter(p_300975_ -> p_300975_.ingredients)
                            )
                            .apply(p_340779_, UndyeingRecipe::new)
            );
            public static final StreamCodec<RegistryFriendlyByteBuf, UndyeingRecipe> STREAM_CODEC = StreamCodec.of(
                    UndyeingRecipe.Serializer::toNetwork, UndyeingRecipe.Serializer::fromNetwork
            );

            @Override
            public MapCodec<UndyeingRecipe> codec() {
                return CODEC;
            }

            @Override
            public StreamCodec<RegistryFriendlyByteBuf, UndyeingRecipe> streamCodec() {
                return STREAM_CODEC;
            }

            private static UndyeingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
                String s = buffer.readUtf();
                CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
                int i = buffer.readVarInt();
                NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
                nonnulllist.replaceAll(p_319735_ -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
                ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
                return new UndyeingRecipe(s, craftingbookcategory, itemstack, nonnulllist);
            }

            private static void toNetwork(RegistryFriendlyByteBuf buffer, UndyeingRecipe recipe) {
                buffer.writeUtf(recipe.group);
                buffer.writeEnum(recipe.category);
                buffer.writeVarInt(recipe.ingredients.size());

                for (Ingredient ingredient : recipe.ingredients) {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
                }

                ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            }
        }
    }
