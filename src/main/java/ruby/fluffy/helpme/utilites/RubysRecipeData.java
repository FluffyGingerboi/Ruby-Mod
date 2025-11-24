package ruby.fluffy.helpme.utilites;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.configs.SlabsConfig;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class RubysRecipeData {

    public record SawRecipeData(
            ItemLike input,
            ItemLike output
    ) {}

    public static final List<SawRecipeData> SAW_RECIPES = List.of(
            new SawRecipeData(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG),
            new SawRecipeData(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG),
            new SawRecipeData(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG),
            new SawRecipeData(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG),
            new SawRecipeData(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG),
            new SawRecipeData(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG),
            new SawRecipeData(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG),
            new SawRecipeData(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG),
            new SawRecipeData(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK),

            new SawRecipeData(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD),
            new SawRecipeData(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD),
            new SawRecipeData(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD),
            new SawRecipeData(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD),
            new SawRecipeData(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD),
            new SawRecipeData(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD),
            new SawRecipeData(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD),
            new SawRecipeData(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD),

            new SawRecipeData(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM),
            new SawRecipeData(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM),

            new SawRecipeData(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE),
            new SawRecipeData(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
    );

    // --- Stained glass recolor recipe structure ---
    public record GlassRecipeData(
            String color,
            ItemLike pigment,
            ItemLike result,
            List<ItemLike> validGlasses // other stained glass that can be recolored
    ) {}

    public static final List<GlassRecipeData> GLASS_RECIPES = List.of(
            new GlassRecipeData("black", RubysItems.BLOOCK_PIGMENT.get(), Items.BLACK_STAINED_GLASS, stainedGlassExcept(Items.BLACK_STAINED_GLASS)),
            new GlassRecipeData("brown", RubysItems.POO_PIGMENT.get(), Items.BROWN_STAINED_GLASS, stainedGlassExcept(Items.BROWN_STAINED_GLASS)),
            new GlassRecipeData("red", RubysItems.PERIOD_PIGMENT.get(), Items.RED_STAINED_GLASS, stainedGlassExcept(Items.RED_STAINED_GLASS)),
            new GlassRecipeData("blue", RubysItems.BLUE_PIGMENT.get(), Items.BLUE_STAINED_GLASS, stainedGlassExcept(Items.BLUE_STAINED_GLASS)),
            new GlassRecipeData("green", RubysItems.GREN_PIGMENT.get(), Items.GREEN_STAINED_GLASS, stainedGlassExcept(Items.GREEN_STAINED_GLASS)),
            new GlassRecipeData("yellow", RubysItems.YELLER_PIGMENT.get(), Items.YELLOW_STAINED_GLASS, stainedGlassExcept(Items.YELLOW_STAINED_GLASS)),
            new GlassRecipeData("orange", RubysItems.ORANG_PIGMENT.get(), Items.ORANGE_STAINED_GLASS, stainedGlassExcept(Items.ORANGE_STAINED_GLASS)),
            new GlassRecipeData("white", RubysItems.WIT_PIGMENT.get(), Items.WHITE_STAINED_GLASS, stainedGlassExcept(Items.WHITE_STAINED_GLASS)),
            new GlassRecipeData("light_gray", RubysItems.LIT_GREYPE_PIGMENT.get(), Items.LIGHT_GRAY_STAINED_GLASS, stainedGlassExcept(Items.LIGHT_GRAY_STAINED_GLASS)),
            new GlassRecipeData("light_blue", RubysItems.LIT_BLUE_PIGMENT.get(), Items.LIGHT_BLUE_STAINED_GLASS, stainedGlassExcept(Items.LIGHT_BLUE_STAINED_GLASS)),
            new GlassRecipeData("lime", RubysItems.LIM_PIGMENT.get(), Items.LIME_STAINED_GLASS, stainedGlassExcept(Items.LIME_STAINED_GLASS)),
            new GlassRecipeData("cyan", RubysItems.NYAN_PIGMENT.get(), Items.CYAN_STAINED_GLASS, stainedGlassExcept(Items.CYAN_STAINED_GLASS)),
            new GlassRecipeData("magenta", RubysItems.MAGENTER_PIGMENT.get(), Items.MAGENTA_STAINED_GLASS, stainedGlassExcept(Items.MAGENTA_STAINED_GLASS)),
            new GlassRecipeData("purple", RubysItems.PURPUR_PIGMENT.get(), Items.PURPLE_STAINED_GLASS, stainedGlassExcept(Items.PURPLE_STAINED_GLASS)),
            new GlassRecipeData("pink", RubysItems.PINKY_PIGMENT.get(), Items.PINK_STAINED_GLASS, stainedGlassExcept(Items.PINK_STAINED_GLASS))
    );

    // Helper to get all other stained glass except one
    private static List<ItemLike> stainedGlassExcept(ItemLike exclude) {
        List<Item> allGlasses = List.of(
                Items.BLACK_STAINED_GLASS,
                Items.BROWN_STAINED_GLASS,
                Items.RED_STAINED_GLASS,
                Items.BLUE_STAINED_GLASS,
                Items.GREEN_STAINED_GLASS,
                Items.YELLOW_STAINED_GLASS,
                Items.ORANGE_STAINED_GLASS,
                Items.WHITE_STAINED_GLASS,
                Items.LIGHT_GRAY_STAINED_GLASS,
                Items.LIGHT_BLUE_STAINED_GLASS,
                Items.LIME_STAINED_GLASS,
                Items.CYAN_STAINED_GLASS,
                Items.MAGENTA_STAINED_GLASS,
                Items.PURPLE_STAINED_GLASS,
                Items.PINK_STAINED_GLASS
        );

        // Filter out the one we are converting to, and convert to ItemLike
        return allGlasses.stream()
                .filter(b -> !b.equals(exclude))
                .map(i -> (ItemLike) i)
                .collect(Collectors.toList());
    }

    // Convert a list of ItemLike to Ingredient
    public static Ingredient ingredientOf(List<ItemLike> items) {
        return Ingredient.of(items.toArray(new ItemLike[0]));
    }

    /**
     * Dye one lantern with one pigment
     */

    public record LanternRecipeData(
            String color,
            Supplier<? extends ItemLike> pigment,
            Supplier<? extends ItemLike> result,
            Ingredient validLanterns) {}

    public static final List<LanternRecipeData> LANTERN_RECIPES = List.of(
            new LanternRecipeData("black", RubysItems.BLOOCK_PIGMENT, RubysItems.BLOOCK_LANTERN, lanternsExcept(RubysBlocks.BLOOCK_LANTERN)),
            new LanternRecipeData("grey", RubysItems.GREYPE_PIGMENT, RubysItems.GREYPE_LANTERN, lanternsExcept(RubysBlocks.GREYPE_LANTERN)),
            new LanternRecipeData("light_grey", RubysItems.LIT_GREYPE_PIGMENT, RubysItems.LIT_GREYPE_LANTERN, lanternsExcept(RubysBlocks.LIT_GREYPE_LANTERN)),
            new LanternRecipeData("brown", RubysItems.POO_PIGMENT, RubysItems.POO_LANTERN, lanternsExcept(RubysBlocks.POO_LANTERN)),
            new LanternRecipeData("white", RubysItems.WIT_PIGMENT, () -> Items.SEA_LANTERN, lanternsExcept(Items.SEA_LANTERN)),
            new LanternRecipeData("red", RubysItems.PERIOD_PIGMENT, RubysItems.PERIOD_LANTERN, lanternsExcept(RubysBlocks.PERIOD_LANTERN)),
            new LanternRecipeData("orange", RubysItems.ORANG_PIGMENT, RubysItems.ORANG_LANTERN, lanternsExcept(RubysBlocks.ORANG_LANTERN)),
            new LanternRecipeData("yellow", RubysItems.YELLER_PIGMENT, RubysItems.YELLER_LANTERN, lanternsExcept(RubysBlocks.YELLER_LANTERN)),
            new LanternRecipeData("blue", RubysItems.BLUE_PIGMENT, RubysItems.BLUE_LANTERN, lanternsExcept(RubysBlocks.BLUE_LANTERN)),
            new LanternRecipeData("light_blue", RubysItems.LIT_BLUE_PIGMENT, RubysItems.LIT_BLUE_LANTERN, lanternsExcept(RubysBlocks.LIT_BLUE_LANTERN)),
            new LanternRecipeData("cyan", RubysItems.NYAN_PIGMENT, RubysItems.NYAN_LANTERN, lanternsExcept(RubysBlocks.NYAN_LANTERN)),
            new LanternRecipeData("green", RubysItems.GREN_PIGMENT, RubysItems.GREN_LANTERN, lanternsExcept(RubysBlocks.GREN_LANTERN)),
            new LanternRecipeData("lime", RubysItems.LIM_PIGMENT, RubysItems.LIM_LANTERN, lanternsExcept(RubysBlocks.LIM_LANTERN)),
            new LanternRecipeData("purple", RubysItems.PURPUR_PIGMENT, RubysItems.PURPUR_LANTERN, lanternsExcept(RubysBlocks.PURPUR_LANTERN)),
            new LanternRecipeData("magenta", RubysItems.MAGENTER_PIGMENT, RubysItems.MAGENTER_LANTERN, lanternsExcept(RubysBlocks.MAGENTER_LANTERN)),
            new LanternRecipeData("pink", RubysItems.PINKY_PIGMENT, RubysItems.PINKY_LANTERN, lanternsExcept(RubysBlocks.PINKY_LANTERN))
    );

    private static Ingredient lanternsExcept(ItemLike exclude) {
        List<ItemLike> allLanterns = List.of(
                Items.SEA_LANTERN,
                RubysBlocks.BLOOCK_LANTERN.get(),
                RubysBlocks.GREYPE_LANTERN.get(),
                RubysBlocks.LIT_GREYPE_LANTERN.get(),
                RubysBlocks.POO_LANTERN.get(),
                RubysBlocks.PERIOD_LANTERN.get(),
                RubysBlocks.ORANG_LANTERN.get(),
                RubysBlocks.YELLER_LANTERN.get(),
                RubysBlocks.GREN_LANTERN.get(),
                RubysBlocks.LIM_LANTERN.get(),
                RubysBlocks.BLUE_LANTERN.get(),
                RubysBlocks.LIT_BLUE_LANTERN.get(),
                RubysBlocks.NYAN_LANTERN.get(),
                RubysBlocks.PURPUR_LANTERN.get(),
                RubysBlocks.MAGENTER_LANTERN.get(),
                RubysBlocks.PINKY_LANTERN.get()
        );

        List<ItemLike> filtered = allLanterns.stream()
                .filter(l -> !Objects.equals(l, exclude))
                .toList();

        return Ingredient.of(filtered.toArray(new ItemLike[0]));
    }

    /**
     * Turn 8 pigment and a water bucket into one dye
     */

    public record PigmentColor(String pigmentName, String dyeName, ItemLike pigment, ItemLike dye) {}

    public static final List<PigmentColor> PIGMENT_CONVERSIONS = List.of(
            new PigmentColor("bloock", "black", RubysItems.BLOOCK_PIGMENT.get(), Items.BLACK_DYE),
            new PigmentColor("greype", "gray", RubysItems.GREYPE_PIGMENT.get(), Items.GRAY_DYE),
            new PigmentColor("lit_greype", "light_gray", RubysItems.LIT_GREYPE_PIGMENT.get(), Items.LIGHT_GRAY_DYE),
            new PigmentColor("poo", "brown", RubysItems.POO_PIGMENT.get(), Items.BROWN_DYE),
            new PigmentColor("wit", "white", RubysItems.WIT_PIGMENT.get(), Items.WHITE_DYE),
            new PigmentColor("period", "red", RubysItems.PERIOD_PIGMENT.get(), Items.RED_DYE),
            new PigmentColor("orang", "orange", RubysItems.ORANG_PIGMENT.get(), Items.ORANGE_DYE),
            new PigmentColor("yeller", "yellow", RubysItems.YELLER_PIGMENT.get(), Items.YELLOW_DYE),
            new PigmentColor("blue", "blue", RubysItems.BLUE_PIGMENT.get(), Items.BLUE_DYE),
            new PigmentColor("lit_blue", "light_blue", RubysItems.LIT_BLUE_PIGMENT.get(), Items.LIGHT_BLUE_DYE),
            new PigmentColor("nyan", "cyan", RubysItems.NYAN_PIGMENT.get(), Items.CYAN_DYE),
            new PigmentColor("gren", "green", RubysItems.GREN_PIGMENT.get(), Items.GREEN_DYE),
            new PigmentColor("lim", "lime", RubysItems.LIM_PIGMENT.get(), Items.LIME_DYE),
            new PigmentColor("purpur", "purple", RubysItems.PURPUR_PIGMENT.get(), Items.PURPLE_DYE),
            new PigmentColor("magenter", "magenta", RubysItems.MAGENTER_PIGMENT.get(), Items.MAGENTA_DYE),
            new PigmentColor("pinky", "pink", RubysItems.PINKY_PIGMENT.get(), Items.PINK_DYE)
    );

    /**
     * Helper methods to be lazy
     */

    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, name);
    }

    public static ResourceLocation pigmentToDyeId(String pigmentName, String dyeName) {
        return ResourceLocation.fromNamespaceAndPath(
                RubyMod.MOD_ID,
                pigmentName + "_pigment_to_" + dyeName + "_dye"
        );
    }
}