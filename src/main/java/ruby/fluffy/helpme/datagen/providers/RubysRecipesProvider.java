package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RubysRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public RubysRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        Ingredient black = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient grey = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(),  RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient light_grey = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient brown = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient red = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient orange = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient yellow = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient blue = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient light_blue = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient cyan = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient green = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient lime = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient purple = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PINKY_LANTERN.get());
        Ingredient pink = Ingredient.of(Items.SEA_LANTERN, RubysBlocks.BLOOCK_LANTERN.get(), RubysBlocks.GREYPE_LANTERN.get(), RubysBlocks.LIT_GREYPE_LANTERN.get(), RubysBlocks.POO_LANTERN.get(), RubysBlocks.PERIOD_LANTERN.get(), RubysBlocks.ORANG_LANTERN.get(), RubysBlocks.YELLER_LANTERN.get(), RubysBlocks.GREN_LANTERN.get(), RubysBlocks.LIM_LANTERN.get(), RubysBlocks.BLUE_LANTERN.get(), RubysBlocks.LIT_BLUE_LANTERN.get(), RubysBlocks.NYAN_LANTERN.get(), RubysBlocks.PURPUR_LANTERN.get());

        /* ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH)).save(recipeOutput); */

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.GREYPE_LANTERN.get(), 1)
                .requires(RubysItems.GREYPE_PIGMENT.get())
                .requires(grey)
                .unlockedBy("has_greype_pigment", has(RubysItems.GREYPE_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.LIT_GREYPE_LANTERN.get(), 1)
                .requires(RubysItems.LIT_GREYPE_PIGMENT.get())
                .requires(light_grey)
                .unlockedBy("has_lit_greype_pigment", has(RubysItems.LIT_GREYPE_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.POO_LANTERN.get(), 1)
                .requires(RubysItems.POO_PIGMENT.get())
                .requires(brown)
                .unlockedBy("has_poo_pigment", has(RubysItems.POO_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.PERIOD_LANTERN.get(), 1)
                .requires(RubysItems.PERIOD_PIGMENT.get())
                .requires(red)
                .unlockedBy("has_period_pigment", has(RubysItems.PERIOD_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ORANG_LANTERN.get(), 1)
                .requires(RubysItems.ORANG_PIGMENT.get())
                .requires(orange)
                .unlockedBy("has_bloock_pigment", has(RubysItems.ORANG_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.YELLER_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.BLOOCK_LANTERN.get(), 1)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(black)
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get())).save(recipeOutput);

        /* oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.25f, 100, "bismuth"); */
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, RubyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
