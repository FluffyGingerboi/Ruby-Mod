package ruby.fluffy.helpme.recipes.builders;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.crafting.AbstractCookingRecipe.Factory;
import ruby.fluffy.helpme.registries.RubysRecipes;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class FiringRecipeBuilder implements RecipeBuilder {

    private final RecipeCategory category;
    private final CookingBookCategory bookCategory;
    private final Item resultItem;
    private final ItemStack resultStack;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private final Factory<?> factory;

    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    public FiringRecipeBuilder(RecipeCategory category,
                                      CookingBookCategory bookCategory,
                                      ItemLike result,
                                      Ingredient ingredient,
                                      float experience,
                                      int cookingTime,
                                      Factory<?> factory) {

        this.category = category;
        this.bookCategory = bookCategory;
        this.resultItem = result.asItem();
        this.resultStack = new ItemStack(result);
        this.ingredient = ingredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
        this.factory = factory;
    }

    public static <T extends AbstractCookingRecipe> FiringRecipeBuilder firing(
            Ingredient ingredient,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            RecipeSerializer<T> serializer,
            Factory<T> factory
    ) {
        return new FiringRecipeBuilder(
                category,
                determineRecipeCategory(serializer, result),
                result,
                ingredient,
                experience,
                cookingTime,
                factory
        );
    }

    public static <T extends AbstractCookingRecipe> FiringRecipeBuilder firing(
            TagKey<Item> tag,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            RecipeSerializer<T> serializer,
            Factory<T> factory
    ) {
        return firing(Ingredient.of(tag), category, result, experience, cookingTime, serializer, factory);
    }

    @Override
    public FiringRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public FiringRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.resultItem;
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        ensureValid(id);

        // Advancements
        Advancement.Builder advancement = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancement::addCriterion);

        AbstractCookingRecipe recipe = this.factory.create(
                Objects.requireNonNullElse(this.group, ""),
                this.bookCategory,
                this.ingredient,
                this.resultStack,
                this.experience,
                this.cookingTime
        );

        output.accept(id, recipe,
                advancement.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    private static CookingBookCategory determineRecipeCategory(
            RecipeSerializer<?> serializer,
            ItemLike result
    ) {

        if (serializer == RubysRecipes.FIRING_SERIALIZER.get()) {
            return determineFiringRecipeCategory(result);
        }

        if (serializer == RecipeSerializer.SMELTING_RECIPE) {
            return determineSmeltingRecipeCategory(result);

        } else if (serializer == RecipeSerializer.BLASTING_RECIPE) {
            return determineBlastingRecipeCategory(result);

        } else if (serializer == RecipeSerializer.SMOKING_RECIPE
                || serializer == RecipeSerializer.CAMPFIRE_COOKING_RECIPE) {

            return CookingBookCategory.FOOD;
        }

        return CookingBookCategory.MISC;
    }

    private static CookingBookCategory determineFiringRecipeCategory(ItemLike result) {
        if (result.asItem().components().has(DataComponents.FOOD)) {
            return CookingBookCategory.FOOD;
        }
        if (result.asItem() instanceof BlockItem) {
            return CookingBookCategory.BLOCKS;
        }
        return CookingBookCategory.MISC;
    }

    private static CookingBookCategory determineSmeltingRecipeCategory(ItemLike result) {
        if (result.asItem().components().has(DataComponents.FOOD)) {
            return CookingBookCategory.FOOD;
        }
        return result.asItem() instanceof BlockItem
                ? CookingBookCategory.BLOCKS
                : CookingBookCategory.MISC;
    }

    private static CookingBookCategory determineBlastingRecipeCategory(ItemLike result) {
        return result.asItem() instanceof BlockItem
                ? CookingBookCategory.BLOCKS
                : CookingBookCategory.MISC;
    }

    private void ensureValid(ResourceLocation id) {
        if (criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}
