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

public class DirtSlabBlock extends SlabBlock {
    public DirtSlabBlock() {
        super(Block.Properties.ofFullCopy(Blocks.DIRT));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (canBeGrass(level, pos, state) && level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            for (int i = 0; i < 4; i++) {
                BlockPos nearbyPos = pos.offset(
                        random.nextInt(3) - 1,
                        random.nextInt(5) - 3,
                        random.nextInt(3) - 1
                );

                BlockState nearbyState = level.getBlockState(nearbyPos);

                if (nearbyState.is(RubysBlocks.DIRT_SLAB.get()) && canBeGrass(level, nearbyPos, nearbyState)) {
                    level.setBlockAndUpdate(
                            nearbyPos,
                            RubysBlocks.GRASS_SLAB.get().defaultBlockState()
                                    .setValue(SlabBlock.TYPE, nearbyState.getValue(SlabBlock.TYPE))
                    );
                }
            }
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
