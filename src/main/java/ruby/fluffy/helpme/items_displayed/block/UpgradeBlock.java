package ruby.fluffy.helpme.items_displayed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UpgradeBlock extends AbstractItemBlock implements IDisplayBlock, IPillowBlock {
    public static final MapCodec<UpgradeBlock> CODEC = simpleCodec(UpgradeBlock::new);

    public UpgradeBlock(Properties props) {
        super(props);
    }

    public MapCodec<UpgradeBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH, SOUTH -> box(3.5, 0.0, 2.0, 12.5, 4.0, 14.0);
            case EAST, WEST -> box(2.0, 0.0, 3.5, 14.0, 4.0, 12.5);
            default -> box(3.5, 0.0, 2.0, 12.5, 4.0, 14.0);
        };
    }
}
