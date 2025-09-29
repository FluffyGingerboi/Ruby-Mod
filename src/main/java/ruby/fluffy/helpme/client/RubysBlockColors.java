package ruby.fluffy.helpme.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.FoliageColor;
import ruby.fluffy.helpme.registries.RubysBlocks;

import java.util.Objects;

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

        Minecraft.getInstance().getItemColors().register(
                (stack, tintIndex) -> tintIndex == 0
                ? FoliageColor.getDefaultColor()
                        : 0xFFFFFFFF,
                RubysBlocks.FLOWERING_OAK_LEAVES.get()
        );
    }
}
