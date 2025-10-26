package ruby.fluffy.helpme.items_displayed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ArmorTrimBlock extends AbstractItemBlock implements IDisplayBlock, IPillowBlock {
    public static final MapCodec<ArmorTrimBlock> CODEC = simpleCodec(ArmorTrimBlock::new);

    public ArmorTrimBlock(Properties props) {
        super(props);
    }

    public MapCodec<ArmorTrimBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH, SOUTH -> box(4.0, 0.0, 2.0, 12.0, 4.0, 14.0);
            case EAST, WEST -> box(2.0, 0.0, 4.0, 14.0, 4.0, 12.0);
            default -> box(4.0, 0.0, 2.0, 12.0, 4.0, 14.0);
        };
    }
}
