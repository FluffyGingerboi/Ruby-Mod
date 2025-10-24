package ruby.fluffy.helpme.blocks.slabs;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.lighting.LightEngine;
import ruby.fluffy.helpme.registries.RubysBlocks;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.SNOWY;

public class GrassSlabBlock extends SlabBlock {
    public GrassSlabBlock() {
        super(Block.Properties.ofFullCopy(Blocks.GRASS_BLOCK));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeGrass(level, pos, state)) {
            level.setBlockAndUpdate(
                    pos,
                    RubysBlocks.DIRT_SLAB.get().defaultBlockState()
                            .setValue(SlabBlock.TYPE, state.getValue(SlabBlock.TYPE))
            );
        }
    }

    private static boolean canBeGrass(LevelReader level, BlockPos pos, BlockState state) {
        BlockPos abovePos = pos.above();
        BlockState aboveState = level.getBlockState(abovePos);

        int opacity = aboveState.getLightBlock(level, abovePos);
        return opacity < level.getMaxLightLevel();
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
}
