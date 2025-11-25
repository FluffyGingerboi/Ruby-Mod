package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.recipes.FiringRecipe;
import ruby.fluffy.helpme.recipes.builders.FiringRecipeBuilder;
import ruby.fluffy.helpme.recipes.builders.UndyeingRecipeBuilder;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysItems;
import ruby.fluffy.helpme.registries.RubysRecipes;
import ruby.fluffy.helpme.utilites.RubysRecipeData;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("deprecation")
public class RubysRecipesProvider extends RecipeProvider implements IConditionBuilder {
    public RubysRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        ItemStack waterBottle = new ItemStack(Items.POTION);
        waterBottle.set(DataComponents.POTION_CONTENTS, new PotionContents(Potions.WATER));

        Ingredient waterBottleIngredient = Ingredient.of(waterBottle);

        // Lantern recolors
        RubysRecipeData.LANTERN_RECIPES.forEach(data ->
                ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, data.result().get())
                        .requires(data.pigment().get())
                        .requires(data.validLanterns())
                        .unlockedBy("has_" + data.color() + "_pigment", has(data.pigment().get()))
                        .save(output, RubysRecipeData.id("dye_lantern_" + data.color()))
        );

        RubysRecipeData.GLASS_RECIPES.forEach(data -> {
            ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, data.result())
                    .requires(data.pigment())
                    .requires(RubysRecipeData.ingredientOf(data.validGlasses()))
                    .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(data.pigment().asItem()).getPath(), has(data.pigment()));

            builder.save(output, RubysRecipeData.id("dye_glass_" + data.color()));
        });

        // Pigment → dye
        RubysRecipeData.PIGMENT_CONVERSIONS.forEach(data -> {
            ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, data.dye())
                    .requires(Items.WATER_BUCKET)
                    .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET));

            for (int i = 0; i < 8; i++)
                builder.requires(data.pigment());

            builder.unlockedBy("has_pigment", has(data.pigment()))
                    .save(output, RubysRecipeData.pigmentToDyeId(data.pigmentName(), data.dyeName()));
        });

        // Dye → pigment
        RubysRecipeData.PIGMENT_CONVERSIONS.forEach(data ->
                ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, data.pigment(), 8)
                        .requires(data.dye())
                        .requires(RubysItems.MORTAR_AND_PESTLE.get())
                        .unlockedBy("has_" + data.dyeName() + "_dye", has(data.dye()))
                        .unlockedBy("has_mortar_and_pestle", has(RubysItems.MORTAR_AND_PESTLE.get()))
                        .save(output, RubysRecipeData.id("make_" + data.pigmentName() + "_pigment"))
        );

        for (RubysRecipeData.SawRecipeData recipe : RubysRecipeData.SAW_RECIPES) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, recipe.output())
                    .requires(RubysItems.SAW.get())   // your saw item
                    .requires(recipe.input())
                    .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(recipe.input().asItem()).getPath(),
                            has(recipe.input()))
                    .save(output, RubysRecipeData.id("saw_" + BuiltInRegistries.ITEM.getKey(recipe.input().asItem()).getPath()));
        }

        blockToSlabs(output,
                List.of(Items.GRASS_BLOCK),
                RecipeCategory.BUILDING_BLOCKS,
                RubysBlocks.GRASS_SLAB.get()
        );

        blockToSlabs(output,
                List.of(Items.DIRT),
                RecipeCategory.BUILDING_BLOCKS,
                RubysBlocks.DIRT_SLAB.get()
        );

        blockToSlabs(output,
                List.of(Items.SAND),
                RecipeCategory.BUILDING_BLOCKS,
                RubysBlocks.SAND_SLAB.get()
        );

        blockToSlabs(output,
                List.of(Items.GRAVEL),
                RecipeCategory.BUILDING_BLOCKS,
                RubysBlocks.GRAVEL_SLAB.get()
        );

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHAINMAIL_HELMET)
                .requires(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_chainmail_helmet"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHAINMAIL_CHESTPLATE)
                .requires(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_chainmail_chestplate"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHAINMAIL_LEGGINGS)
                .requires(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_chainmail_leggings"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CHAINMAIL_BOOTS)
                .requires(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_chainmail_boots"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_HELMET)
                .requires(RubysItems.FIRED_ENAMELED_IRON_HELMET.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_IRON_HELMET.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_iron_helmet"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_CHESTPLATE)
                .requires(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_iron_chestplate"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_LEGGINGS)
                .requires(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_iron_leggings"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_BOOTS)
                .requires(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_iron_boots"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLDEN_HELMET)
                .requires(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_golden_helmet"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLDEN_CHESTPLATE)
                .requires(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_golden_chestplate"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLDEN_LEGGINGS)
                .requires(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_golden_leggings"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLDEN_BOOTS)
                .requires(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_golden_boots"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND_HELMET)
                .requires(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_diamond_helmet"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND_CHESTPLATE)
                .requires(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_diamond_chestplate"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND_LEGGINGS)
                .requires(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_diamond_leggings"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND_BOOTS)
                .requires(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_diamond_boots"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHERITE_HELMET)
                .requires(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_netherite_helmet"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHERITE_CHESTPLATE)
                .requires(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_netherite_chestplate"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHERITE_LEGGINGS)
                .requires(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_netherite_leggings"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHERITE_BOOTS)
                .requires(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enamel", has(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_netherite_boots"));

        firing(output, RubysItems.ENAMELED_CHAIN_HELMET.get(), RecipeCategory.MISC,

                RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_CHAIN_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_CHAIN_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_CHAIN_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_IRON_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_HELMET.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_IRON_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_IRON_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_IRON_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_BOOTS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_GOLD_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_HELMET.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_GOLD_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_GOLD_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_GOLD_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_DIAMOND_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_DIAMOND_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_DIAMOND_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_NETHERITE_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_NETHERITE_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get(), 0.35f, 100, "firing"
        );

        firing(output, RubysItems.ENAMELED_NETHERITE_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get(), 0.35f, 100, "firing"
        );

        firing(output, Items.BRICK, RecipeCategory.MISC,
                Items.CLAY_BALL, 0.10f, 100, "firing"
        );

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubysItems.SAW.get())
                .pattern("  I")
                .pattern(" I ")
                .pattern("P  ")
                .define('I', Items.IRON_INGOT)
                .define('P', ItemTags.PLANKS)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, RubysItems.SCRAPER.get())
                .pattern("   ")
                .pattern(" I ")
                .pattern("P  ")
                .define('I', Items.IRON_INGOT)
                .define('P', ItemTags.PLANKS)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLACK_DYE)
                .requires(Items.COAL)
                .requires(RubysItems.MORTAR_AND_PESTLE.get())
                .unlockedBy("has_coal", has(Items.COAL))
                .unlockedBy("has_mortar_and_pestle", has(RubysItems.MORTAR_AND_PESTLE.get()))
                .save(output, "black_dye_from_coal");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLACK_DYE)
                .requires(Items.CHARCOAL)
                .requires(RubysItems.MORTAR_AND_PESTLE.get())
                .unlockedBy("has_charcoal", has(Items.CHARCOAL))
                .unlockedBy("has_mortar_and_pestle", has(RubysItems.MORTAR_AND_PESTLE.get()))
                .save(output, "black_dye_from_charcoal");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.MORTAR_AND_PESTLE.get())
                .requires(Items.STICK)
                .requires(Items.BOWL)
                .unlockedBy("has_bowl", has(Items.BOWL))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MELON_SLICE)
                .requires(Items.MELON)
                .unlockedBy("has_melon", has(Items.MELON))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMEL.get())
                .requires(RubysItems.MORTAR_AND_PESTLE.get())
                .requires(Items.GLASS)
                .requires(Items.SLIME_BALL)
                .requires(waterBottleIngredient)
                .unlockedBy("has_mortar_and_pestle", has(RubysItems.MORTAR_AND_PESTLE.get()))
                .unlockedBy("has_glass", has(Items.GLASS))
                .unlockedBy("has_slime_ball", has(Items.SLIME_BALL))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_HELMET.get())
                .requires(Items.CHAINMAIL_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_helmet", has(Items.CHAINMAIL_HELMET))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_CHESTPLATE.get())
                .requires(Items.CHAINMAIL_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_chestplate", has(Items.CHAINMAIL_CHESTPLATE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_LEGGINGS.get())
                .requires(Items.CHAINMAIL_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_leggings", has(Items.CHAINMAIL_LEGGINGS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_BOOTS.get())
                .requires(Items.CHAINMAIL_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_boots", has(Items.IRON_BOOTS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_HELMET.get())
                .requires(Items.IRON_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_helmet", has(Items.IRON_HELMET))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_CHESTPLATE.get())
                .requires(Items.IRON_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_chestplate", has(Items.IRON_CHESTPLATE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_LEGGINGS.get())
                .requires(Items.IRON_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_leggings", has(Items.IRON_LEGGINGS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_BOOTS.get())
                .requires(Items.IRON_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_boots", has(Items.IRON_BOOTS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_HELMET.get())
                .requires(Items.GOLDEN_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_helmet", has(Items.GOLDEN_HELMET))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_CHESTPLATE.get())
                .requires(Items.GOLDEN_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_chestplate", has(Items.GOLDEN_CHESTPLATE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_LEGGINGS.get())
                .requires(Items.GOLDEN_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_leggings", has(Items.GOLDEN_LEGGINGS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_BOOTS.get())
                .requires(Items.GOLDEN_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_boots", has(Items.GOLDEN_BOOTS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_HELMET.get())
                .requires(Items.DIAMOND_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_helmet", has(Items.DIAMOND_HELMET))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get())
                .requires(Items.DIAMOND_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_chestplate", has(Items.DIAMOND_CHESTPLATE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_LEGGINGS.get())
                .requires(Items.DIAMOND_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_leggings", has(Items.DIAMOND_LEGGINGS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_BOOTS.get())
                .requires(Items.DIAMOND_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_boots", has(Items.DIAMOND_BOOTS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_HELMET.get())
                .requires(Items.NETHERITE_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_helmet", has(Items.NETHERITE_HELMET))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get())
                .requires(Items.NETHERITE_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_chestplate", has(Items.NETHERITE_CHESTPLATE))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_LEGGINGS.get())
                .requires(Items.NETHERITE_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_leggings", has(Items.NETHERITE_LEGGINGS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_BOOTS.get())
                .requires(Items.NETHERITE_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_boots", has(Items.NETHERITE_BOOTS))
                .save(output);
    }

    protected static void blockToSlabs(RecipeOutput recipeOutput, List<ItemLike> blocks, RecipeCategory category, ItemLike slab) {
        for (ItemLike block : blocks) {
            ShapedRecipeBuilder.shaped(category, slab, 6) // 6 slabs from 3 blocks
                    .pattern("###") // 3 blocks in a row
                    .define('#', block)
                    .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(block.asItem()).getPath(), RecipeProvider.has(block))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, BuiltInRegistries.ITEM.getKey(block.asItem()).getPath() + "_to_" + BuiltInRegistries.ITEM.getKey(slab.asItem()).getPath()));
        }
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

    protected static void firing(RecipeOutput output, ItemLike ingredients, RecipeCategory category, ItemLike result, float xp, int time, String name) {
        String resultPath = BuiltInRegistries.ITEM
                .getKey(result.asItem())
                .getPath();
        FiringRecipeBuilder.firing(Ingredient.of(ingredients), category, result, xp, time, RubysRecipes.FIRING_SERIALIZER.get(), FiringRecipe::new)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ingredients.asItem()).getPath(), has(ingredients))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, resultPath + "_from_firing"));
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(pIngredients), has(pIngredients))
                    .save(recipeOutput, RubyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredients));
        }
    }
}
