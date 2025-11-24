package ruby.fluffy.helpme.events.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysItems;

public class RubysBlockColors {

    public static void registerBlockColors() {
        BlockColors colors = Minecraft.getInstance().getBlockColors();

        colors.register(
                (state, world, pos, tintIndex) -> {
                    if (tintIndex == 0) {
                        return world != null && pos != null
                                ? BiomeColors.getAverageFoliageColor(world, pos)
                                : FoliageColor.getDefaultColor();
                    }
                    return 0xFFFFFFFF;
                },
                RubysBlocks.FLOWERING_OAK_LEAVES.get()
        );

        colors.register(
                (state, world, pos, tintIndex) -> {
                    if (tintIndex == 1) {
                        return world != null && pos != null
                                ? BiomeColors.getAverageGrassColor(world, pos)
                                : 0x00FF00;
                    }
                    return 0xFFFFFFFF;
                },
                RubysBlocks.BLUE_WHITE_WILDFLOWERS.get()
        );

        colors.register(
                (state, world, pos, tintIndex) -> {
                    if (tintIndex == 1) {
                        return world != null && pos != null
                                ? BiomeColors.getAverageGrassColor(world, pos)
                                : 0x00FF00;
                    }
                    return 0xFFFFFFFF;
                },
                RubysBlocks.PURPLE_WHITE_WILDFLOWERS.get()
        );


        colors.register(
                (state, world, pos, tintIndex) -> {
                    return world != null && pos != null
                            ? BiomeColors.getAverageGrassColor(world, pos)
                            : GrassColor.getDefaultColor();
                },
                RubysBlocks.GRASS_SLAB.get()
        );

        Minecraft.getInstance().getItemColors().register(
                (stack, tintIndex) -> tintIndex == 0
                ? FoliageColor.getDefaultColor()
                        : 0xFFFFFFFF,
                RubysBlocks.FLOWERING_OAK_LEAVES.get()
        );

        Minecraft.getInstance().getItemColors().register(
                (stack, tintIndex) -> tintIndex == 0
                        ? GrassColor.getDefaultColor()
                        : 0xFFFFFFFF,
                RubysBlocks.GRASS_SLAB.get()
        );
    }
}
