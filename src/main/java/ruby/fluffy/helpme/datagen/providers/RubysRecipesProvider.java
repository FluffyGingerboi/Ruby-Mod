package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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
import ruby.fluffy.helpme.registries.RubysTags;
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

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.IRON_HORSE_ARMOR)
                .requires(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enameled_iron_horse_armor", has(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_iron_horse_armor"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GOLDEN_HORSE_ARMOR)
                .requires(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enameled_gold_horse_armor", has(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_gold_horse_armor"));

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, Items.DIAMOND_HORSE_ARMOR)
                .requires(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get())
                .requires(RubysItems.SCRAPER.get())
                .unlockedBy("has_scraper", has(RubysItems.SCRAPER.get()))
                .unlockedBy("has_fired_enameled_diamond_horse_armor", has(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get()))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "remove_enamel_on_fired_enameled_diamond_horse_armor"));

        firing(output, RubysItems.ENAMELED_CHAIN_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_CHAIN_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_CHAIN_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_CHAIN_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_IRON_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_HELMET.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_IRON_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_IRON_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_IRON_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_BOOTS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_GOLD_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_HELMET.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_GOLD_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_GOLD_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_GOLD_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_DIAMOND_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_DIAMOND_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_DIAMOND_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_NETHERITE_HELMET.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_NETHERITE_LEGGINGS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_NETHERITE_BOOTS.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_IRON_HORSE_ARMOR.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get(), 0.35f, 100, "firing");

        firing(output, RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get(), RecipeCategory.MISC,
                RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get(), 0.35f, 100, "firing");

        firingTag(output, ItemTags.LOGS, RecipeCategory.MISC,
                Items.CHARCOAL, 0.10f, 100, "firing");

        firing(output, Items.ROTTEN_FLESH, RecipeCategory.MISC,
                Items.LEATHER, 0.10f, 100, "firing");

        firing(output, Items.CLAY_BALL, RecipeCategory.MISC,
                Items.BRICK, 0.10f, 100, "firing");

        firing(output, Items.SAND, RecipeCategory.MISC,
                Items.GLASS, 0.10f, 100, "firing");

        firing(output, Items.COBBLESTONE, RecipeCategory.MISC,
                Items.STONE, 0.10f, 100, "firing");

        firing(output, Items.STONE, RecipeCategory.MISC,
                Items.SMOOTH_STONE, 0.10f, 100, "firing");

        firing(output, Items.CLAY, RecipeCategory.MISC,
                Items.TERRACOTTA, 0.10f, 100, "firing");

        firing(output, Items.STONE_BRICKS, RecipeCategory.MISC,
                Items.CRACKED_STONE_BRICKS, 0.10f, 100, "firing");

        firing(output, Items.NETHERRACK, RecipeCategory.MISC,
                Items.NETHER_BRICK, 0.10f, 100, "firing");

        firing(output, Items.NETHER_BRICKS, RecipeCategory.MISC,
                Items.CRACKED_NETHER_BRICKS, 0.10f, 100, "firing");

        firing(output, Items.DEEPSLATE_BRICKS, RecipeCategory.MISC,
                Items.CRACKED_DEEPSLATE_BRICKS, 0.10f, 100, "firing");

        firing(output, Items.DEEPSLATE_TILES, RecipeCategory.MISC,
                Items.CRACKED_DEEPSLATE_TILES, 0.10f, 100, "firing");

        firing(output, Items.POLISHED_BLACKSTONE_BRICKS, RecipeCategory.MISC,
                Items.CRACKED_POLISHED_BLACKSTONE_BRICKS, 0.10f, 100, "firing");

        firing(output, Items.INFESTED_STONE_BRICKS, RecipeCategory.MISC,
                Items.INFESTED_CRACKED_STONE_BRICKS, 0.10f, 100, "firing");

        blasting(output, Items.RAW_COPPER_BLOCK, RecipeCategory.MISC,
                Items.COPPER_BLOCK, 6.3f, 900, "copper");

        blasting(output, Items.RAW_IRON_BLOCK, RecipeCategory.MISC,
                Items.IRON_BLOCK, 6.3f, 900, "iron");

        blasting(output, Items.RAW_GOLD_BLOCK, RecipeCategory.MISC,
                Items.GOLD_BLOCK, 9f, 900, "gold");

        smelting(output, Items.RAW_COPPER_BLOCK, RecipeCategory.MISC,
                Items.COPPER_BLOCK, 6.3F, 1800, "copper");

        smelting(output, Items.RAW_IRON_BLOCK, RecipeCategory.MISC,
                Items.IRON_BLOCK, 6.3F, 1800, "iron");

        smelting(output, Items.RAW_GOLD_BLOCK, RecipeCategory.MISC,
                Items.GOLD_BLOCK, 9F, 1800, "gold");

        smelting(output, Items.ROTTEN_FLESH, RecipeCategory.MISC,
                Items.LEATHER, 0.10F, 200, "leather");

        smelting(output, RubysItems.RAW_SQUID_MEAT.get(), RecipeCategory.FOOD,
                RubysItems.COOKED_SQUID_MEAT.get(), 0.10F, 200, "squid");

        smelting(output, RubysItems.RAW_HORSE_MEAT.get(), RecipeCategory.FOOD,
                RubysItems.COOKED_HORSE_MEAT.get(), 0.10F, 200, "horse");

        smoking(output, RubysItems.RAW_SQUID_MEAT.get(), RecipeCategory.FOOD,
                RubysItems.COOKED_SQUID_MEAT.get(), 0.10F, 100, "squid");

        smoking(output, RubysItems.RAW_HORSE_MEAT.get(), RecipeCategory.FOOD,
                RubysItems.COOKED_HORSE_MEAT.get(), 0.10F, 100, "horse");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.CHERRY_CHEST.get(), 4)
                .pattern("WWW")
                .pattern("W W")
                .pattern("WWW")
                .define('W', RubysTags.Items.CHERRY_CHEST_LOGS)
                .unlockedBy("has_cherry_log", has(RubysTags.Items.CHERRY_CHEST_LOGS))
                .save(output, "cherry_chest_from_cherry_logs");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.CHERRY_CHEST.get())
                .pattern("WWW")
                .pattern("W W")
                .pattern("WWW")
                .define('W', Items.CHERRY_PLANKS)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.SPRUCE_CHEST.get(), 4)
                .pattern("WWW")
                .pattern("W W")
                .pattern("WWW")
                .define('W', RubysTags.Items.SPRUCE_CHEST_LOGS)
                .unlockedBy("has_spruce_log", has(RubysTags.Items.SPRUCE_CHEST_LOGS))
                .save(output, "spruce_chest_from_logs");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.SPRUCE_CHEST.get())
                .pattern("WWW")
                .pattern("W W")
                .pattern("WWW")
                .define('W', Items.SPRUCE_PLANKS)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CHEST, 4)
                .pattern("WWW")
                .pattern("W W")
                .pattern("WWW")
                .define('W', RubysTags.Items.CHEST_LOGS)
                .unlockedBy("has_log", has(RubysTags.Items.CHEST_LOGS))
                .save(output, "chest_from_logs");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RubysItems.LOG_STAIRS.get(), 4)
                .pattern("W  ")
                .pattern("WW ")
                .pattern("WWW")
                .define('W', Items.OAK_LOG)
                .unlockedBy("has_log", has(Items.OAK_LOG))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 16)
                .pattern(" W ")
                .pattern(" W ")
                .define('W', ItemTags.LOGS)
                .unlockedBy("has_log", has(ItemTags.LOGS))
                .save(output, "sticks_from_logs");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STRING, 4)
                .pattern(" W ")
                .define('W', ItemTags.WOOL)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.BLUE_WHITE_WILDFLOWERS, 8)
                .pattern("AC ")
                .define('A', Items.AZURE_BLUET)
                .define('C', Items.CORNFLOWER)
                .unlockedBy("has_azure_bluet", has(Items.AZURE_BLUET))
                .unlockedBy("has_cornflower", has(Items.CORNFLOWER))
                .save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.PURPLE_WHITE_WILDFLOWERS, 8)
                .pattern("BA ")
                .define('B', Items.AZURE_BLUET)
                .define('A', Items.ALLIUM)
                .unlockedBy("has_azure_bluet", has(Items.AZURE_BLUET))
                .unlockedBy("has_allium", has(Items.ALLIUM))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.FLOWERING_OAK_SAPLING.get(), 1)
                .pattern("SF ")
                .define('F', ItemTags.FLOWERS)
                .define('S', Items.OAK_SAPLING)
                .unlockedBy("has_oak_sapling", has(Items.OAK_SAPLING))
                .unlockedBy("has_flowers", has(ItemTags.FLOWERS))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, RubysItems.KILN.get())
                .pattern("IBI")
                .pattern("BFB")
                .pattern("BBB")
                .define('B', Items.BRICKS)
                .define('I', Items.IRON_INGOT)
                .define('F', Items.FURNACE)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_furnace", has(Items.FURNACE))
                .unlockedBy("has_bricks", has(Items.BRICKS))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLACK_DYE)
                .requires(Items.COAL)
                .requires(RubysItems.MORTAR_AND_PESTLE.get())
                .unlockedBy("has_coal", has(Items.COAL))
                .unlockedBy("has_mortar_and_pestle", has(RubysItems.MORTAR_AND_PESTLE.get()))
                .save(output, "black_dye_from_coal");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE)
                .requires(RubysItems.BLUE_WHITE_WILDFLOWERS.get())
                .unlockedBy("has_blue_white_wildflowers", has(RubysItems.BLUE_WHITE_WILDFLOWERS))
                .save(output, "blue_dye_from_blue_white_wildflowers");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .requires(RubysItems.PURPLE_WHITE_WILDFLOWERS.get())
                .unlockedBy("has_purple_white_wildflowers", has(RubysItems.PURPLE_WHITE_WILDFLOWERS))
                .save(output, "magenta_dye_from_purple_white_wildflowers");

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MELON_SLICE, 9)
                .requires(Items.MELON)
                .unlockedBy("has_melon", has(Items.MELON))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.LIT_BLUE_PIGMENT.get(), 2)
                .requires(RubysItems.BLUE_PIGMENT.get())
                .requires(RubysItems.WIT_PIGMENT.get())
                .unlockedBy("has_blue_pigment", has(RubysItems.BLUE_PIGMENT.get()))
                .unlockedBy("has_wit_pigment", has(RubysItems.WIT_PIGMENT.get()))
                .save(output, "lit_blue_pigment_from_blue_wit_pigment");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.LIT_GREYPE_PIGMENT.get(), 3)
                .requires(RubysItems.BLOOCK_PIGMENT.get())
                .requires(RubysItems.WIT_PIGMENT.get())
                .requires(RubysItems.WIT_PIGMENT.get())
                .unlockedBy("has_bloock_pigment", has(RubysItems.BLOOCK_PIGMENT.get()))
                .unlockedBy("has_wit_pigment", has(RubysItems.WIT_PIGMENT.get()))
                .save(output, "lit_greype_pigment_from_bloock_wit_pigment");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.LIT_GREYPE_PIGMENT.get(), 2)
                .requires(RubysItems.GREYPE_PIGMENT.get())
                .requires(RubysItems.WIT_PIGMENT.get())
                .unlockedBy("has_greype_pigment", has(RubysItems.GREYPE_PIGMENT.get()))
                .unlockedBy("has_wit_pigment", has(RubysItems.WIT_PIGMENT.get()))
                .save(output, "lit_greype_pigment_from_greype_wit_pigment");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.MAGENTER_PIGMENT.get(), 3)
                .requires(RubysItems.BLUE_PIGMENT.get())
                .requires(RubysItems.PERIOD_PIGMENT.get())
                .requires(RubysItems.PINKY_PIGMENT.get())
                .unlockedBy("has_blue_pigment", has(RubysItems.BLUE_PIGMENT.get()))
                .unlockedBy("has_period_pigment", has(RubysItems.PERIOD_PIGMENT.get()))
                .unlockedBy("has_pinky_pigment", has(RubysItems.PINKY_PIGMENT.get()))
                .save(output, "magenter_pigment_from_blue_period_pinky");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.MAGENTER_PIGMENT.get(), 4)
                .requires(RubysItems.BLUE_PIGMENT.get())
                .requires(RubysItems.PERIOD_PIGMENT.get())
                .requires(RubysItems.PERIOD_PIGMENT.get())
                .requires(RubysItems.WIT_PIGMENT.get())
                .unlockedBy("has_blue_pigment", has(RubysItems.BLUE_PIGMENT.get()))
                .unlockedBy("has_period_pigment", has(RubysItems.PERIOD_PIGMENT.get()))
                .unlockedBy("has_wit_pigment", has(RubysItems.WIT_PIGMENT.get()))
                .save(output, "magenter_pigment_from_blue_period_wit_pigment");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.MAGENTER_PIGMENT.get(), 2)
                .requires(RubysItems.PURPUR_PIGMENT.get())
                .requires(RubysItems.PINKY_PIGMENT.get())
                .unlockedBy("has_purpur_pigment", has(RubysItems.PURPUR_PIGMENT.get()))
                .unlockedBy("has_pinky_pigment", has(RubysItems.PINKY_PIGMENT.get()))
                .save(output, "magenter_pigment_from_purpur_and_pinky");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ORANG_PIGMENT.get(), 2)
                .requires(RubysItems.ORANG_PIGMENT.get())
                .requires(RubysItems.YELLER_PIGMENT.get())
                .unlockedBy("has_orang_pigment", has(RubysItems.ORANG_PIGMENT.get()))
                .unlockedBy("has_yeller_pigment", has(RubysItems.YELLER_PIGMENT.get()))
                .save(output, "orang_pigment_from_period_yeller");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.PINKY_PIGMENT.get(), 2)
                .requires(RubysItems.PERIOD_PIGMENT.get())
                .requires(RubysItems.WIT_PIGMENT.get())
                .unlockedBy("has_period_pigment", has(RubysItems.PERIOD_PIGMENT.get()))
                .unlockedBy("has_wit_pigment", has(RubysItems.WIT_PIGMENT.get()))
                .save(output, "pinky_pigment_from_red_wit_pigment");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMEL.get())
                .requires(RubysItems.MORTAR_AND_PESTLE.get())
                .requires(Items.GLASS)
                .requires(Items.SLIME_BALL)
                .requires(waterBottleIngredient)
                .unlockedBy("has_mortar_and_pestle", has(RubysItems.MORTAR_AND_PESTLE.get()))
                .unlockedBy("has_glass", has(Items.GLASS))
                .unlockedBy("has_slime_ball", has(Items.SLIME_BALL))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_HELMET.get())
                .requires(Items.CHAINMAIL_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_helmet", has(Items.CHAINMAIL_HELMET))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_CHESTPLATE.get())
                .requires(Items.CHAINMAIL_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_chestplate", has(Items.CHAINMAIL_CHESTPLATE))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_LEGGINGS.get())
                .requires(Items.CHAINMAIL_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_leggings", has(Items.CHAINMAIL_LEGGINGS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_CHAIN_BOOTS.get())
                .requires(Items.CHAINMAIL_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_chainmail_boots", has(Items.IRON_BOOTS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_HELMET.get())
                .requires(Items.IRON_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_helmet", has(Items.IRON_HELMET))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_CHESTPLATE.get())
                .requires(Items.IRON_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_chestplate", has(Items.IRON_CHESTPLATE))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_LEGGINGS.get())
                .requires(Items.IRON_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_leggings", has(Items.IRON_LEGGINGS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_BOOTS.get())
                .requires(Items.IRON_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_boots", has(Items.IRON_BOOTS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_HELMET.get())
                .requires(Items.GOLDEN_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_helmet", has(Items.GOLDEN_HELMET))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_CHESTPLATE.get())
                .requires(Items.GOLDEN_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_chestplate", has(Items.GOLDEN_CHESTPLATE))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_LEGGINGS.get())
                .requires(Items.GOLDEN_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_leggings", has(Items.GOLDEN_LEGGINGS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_BOOTS.get())
                .requires(Items.GOLDEN_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_boots", has(Items.GOLDEN_BOOTS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_HELMET.get())
                .requires(Items.DIAMOND_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_helmet", has(Items.DIAMOND_HELMET))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get())
                .requires(Items.DIAMOND_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_chestplate", has(Items.DIAMOND_CHESTPLATE))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_LEGGINGS.get())
                .requires(Items.DIAMOND_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_leggings", has(Items.DIAMOND_LEGGINGS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_BOOTS.get())
                .requires(Items.DIAMOND_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_boots", has(Items.DIAMOND_BOOTS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_HELMET.get())
                .requires(Items.NETHERITE_HELMET)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_helmet", has(Items.NETHERITE_HELMET))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get())
                .requires(Items.NETHERITE_CHESTPLATE)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_chestplate", has(Items.NETHERITE_CHESTPLATE))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_LEGGINGS.get())
                .requires(Items.NETHERITE_LEGGINGS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_leggings", has(Items.NETHERITE_LEGGINGS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_NETHERITE_BOOTS.get())
                .requires(Items.NETHERITE_BOOTS)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_netherite_boots", has(Items.NETHERITE_BOOTS))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_IRON_HORSE_ARMOR.get())
                .requires(Items.IRON_HORSE_ARMOR)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_iron_horse_armor", has(Items.IRON_HORSE_ARMOR))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get())
                .requires(Items.GOLDEN_HORSE_ARMOR)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_golden_horse_armor", has(Items.GOLDEN_HORSE_ARMOR))
                .save(output);

        UndyeingRecipeBuilder.shapeless(RecipeCategory.MISC, RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get())
                .requires(Items.DIAMOND_HORSE_ARMOR)
                .requires(RubysItems.ENAMEL.get())
                .unlockedBy("has_enamel", has(RubysItems.ENAMEL.get()))
                .unlockedBy("has_diamond_horse_armor", has(Items.DIAMOND_HORSE_ARMOR))
                .save(output);

        compress(
                output,
                Items.POPPY,
                RubysItems.POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.COMPACTED_POPPY_BLOCK.get(),
                RubysItems.DOUBLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.DOUBLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.TRIPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.TRIPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.QUADRUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.QUADRUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.QUINTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.QUINTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.SEXTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.SEXTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.SEPTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.SEPTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.OCTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.OCTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.NONUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        compress(
                output,
                RubysItems.NONUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.DECUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.DECUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.NONUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.NONUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.OCTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.OCTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.SEPTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.SEPTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.SEXTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.SEXTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.QUINTUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.QUINTUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.QUADRUPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.QUADRUPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.TRIPLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.TRIPLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.DOUBLE_COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.DOUBLE_COMPACTED_POPPY_BLOCK.get(),
                RubysItems.COMPACTED_POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.COMPACTED_POPPY_BLOCK.get(),
                RubysItems.POPPY_BLOCK.get()
        );

        decompress(
                output,
                RubysItems.POPPY_BLOCK.get(),
                Items.POPPY
        );
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

    protected static void smelting(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                   float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void blasting(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                   float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void smoking(RecipeOutput recipeOutput, ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                   float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected static void firing(RecipeOutput output, ItemLike ingredients, RecipeCategory category, ItemLike result, float xp, int time, String name) {
        String resultPath = BuiltInRegistries.ITEM
                .getKey(result.asItem())
                .getPath();
        FiringRecipeBuilder.firing(Ingredient.of(ingredients), category, result, xp, time, RubysRecipes.FIRING_SERIALIZER.get(), FiringRecipe::new)
                .unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(ingredients.asItem()).getPath(), has(ingredients))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, resultPath + "_from_firing"));
    }

    protected static void firingTag(RecipeOutput output, TagKey<Item> ingredients, RecipeCategory category, ItemLike result, float xp, int time, String name) {
        String resultPath = BuiltInRegistries.ITEM
                .getKey(result.asItem())
                .getPath();
        FiringRecipeBuilder.firing(Ingredient.of(ingredients), category, result, xp, time, RubysRecipes.FIRING_SERIALIZER.get(), FiringRecipe::new)
                .unlockedBy("has_" + ingredients.location().getPath(), has(ingredients))
                .save(output, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, resultPath + "_from_firing"));
    }

    private void compress(RecipeOutput output, ItemLike input, ItemLike result) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(
                RecipeCategory.MISC,
                result,
                1
        );

        for (int i = 0; i < 9; i++) {
            builder.requires(input);
        }

        builder.unlockedBy("has_" + input.asItem().toString(), has(input));

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(
                "ru3yy",
                BuiltInRegistries.ITEM.getKey(result.asItem()).getPath() +
                        "_from_" +
                        BuiltInRegistries.ITEM.getKey(input.asItem()).getPath()
        );

        builder.save(output, id);
    }

    private void decompress(RecipeOutput output, ItemLike compressed, ItemLike resultItem) {
        ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(
                RecipeCategory.MISC,
                resultItem, 9
        );

        builder.requires(compressed);

        builder.unlockedBy("has_" + compressed.asItem().toString(), has(compressed));

        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(
                "ru3yy",
                BuiltInRegistries.ITEM.getKey(resultItem.asItem()).getPath() +
                        "_from_" +
                        BuiltInRegistries.ITEM.getKey(compressed.asItem()).getPath()
        );

        builder.save(output, id);
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       ItemLike pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(pIngredients), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(pIngredients), has(pIngredients))
                    .save(recipeOutput, RubyMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(pIngredients));
        }
    }
}
