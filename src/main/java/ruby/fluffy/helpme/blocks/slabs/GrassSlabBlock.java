package ruby.fluffy.helpme.blocks.slabs;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import ruby.fluffy.helpme.registries.RubysBlocks;

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
