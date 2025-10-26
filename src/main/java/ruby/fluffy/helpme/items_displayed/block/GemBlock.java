package ruby.fluffy.helpme.items_displayed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GemBlock extends AbstractStackableBlock implements IPillowBlock {

    public static final MapCodec<GemBlock> CODEC = simpleCodec(GemBlock::new);

    public GemBlock(Properties props) {
        super(props);
    }

    public MapCodec<GemBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        int i = this.getStacks(state);

        return switch (i) {
            case 1 -> {
                switch (state.getValue(FACING)) {
                    case NORTH:
                    case SOUTH:
                        yield box(6.0, 0.0, 5.0, 10.0, 2.0, 11.0);
                    case EAST:
                    case WEST:
                        yield box(5.0, 0.0, 6.0, 11.0, 2.0, 10.0);
                    default:
                        yield box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
                }
            }
            case 2 -> box(2.0, 0.0, 2.0, 14.0, 2.0, 14.0);
            case 3 -> box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
            case 4 -> box(1.0, 0.0, 1.0, 15.0, 4.0, 15.0);
            default -> box(1.0, 0.0, 1.0, 15.0, 4.0, 15.0);
        };
    }

    @Override
    public int getMaxStackable() {
        return 4;
    }
}
