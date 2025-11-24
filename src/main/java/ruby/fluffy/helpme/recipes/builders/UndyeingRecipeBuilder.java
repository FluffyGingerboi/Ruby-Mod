package ruby.fluffy.helpme.recipes.builders;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import ruby.fluffy.helpme.recipes.UndyeingRecipe;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class UndyeingRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final ItemStack resultStack;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    public UndyeingRecipeBuilder(RecipeCategory category, ItemStack result) {
        this.category = category;
        this.resultStack = result;
    }

    public static UndyeingRecipeBuilder shapeless(RecipeCategory category, ItemLike result) {
        return new UndyeingRecipeBuilder(category, new ItemStack(result));
    }

    public static UndyeingRecipeBuilder shapeless(RecipeCategory category, ItemLike result, int count) {
        return new UndyeingRecipeBuilder(category, new ItemStack(result, count));
    }

    public static UndyeingRecipeBuilder shapeless(RecipeCategory category, ItemStack result) {
        return new UndyeingRecipeBuilder(category, result);
    }

    public UndyeingRecipeBuilder requires(TagKey<Item> tag) {
        return this.requires(Ingredient.of(tag));
    }

    public UndyeingRecipeBuilder requires(ItemLike item) {
        return this.requires(item, 1);
    }

    public UndyeingRecipeBuilder requires(ItemLike item, int quantity) {
        for (int i = 0; i < quantity; ++i)
            this.requires(Ingredient.of(item));
        return this;
    }

    public UndyeingRecipeBuilder requires(Ingredient ingredient) {
        return this.requires(ingredient, 1);
    }

    public UndyeingRecipeBuilder requires(Ingredient ingredient, int quantity) {
        for (int i = 0; i < quantity; ++i)
            this.ingredients.add(ingredient);
        return this;
    }

    public UndyeingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public UndyeingRecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.resultStack.getItem();
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        this.ensureValid(id);

        Advancement.Builder advancement = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancement::addCriterion);

        UndyeingRecipe recipe = new UndyeingRecipe(
                Objects.requireNonNullElse(this.group, ""),
                RecipeBuilder.determineBookCategory(this.category),
                this.resultStack,
                this.ingredients
        );

        recipeOutput.accept(
                id,
                recipe,
                advancement.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/"))
        );
    }

    private void ensureValid(ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }
}