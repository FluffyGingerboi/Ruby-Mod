package ruby.fluffy.helpme.items_displayed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IngotBlock extends AbstractStackableBlock {
    public static final MapCodec<IngotBlock> CODEC = simpleCodec(IngotBlock::new);

    public IngotBlock(Properties props) {
        super(props);
    }

    public MapCodec<IngotBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        int i = this.getStacks(state);

        return switch (i) {
            case 1 -> {
                switch (state.getValue(FACING)) {
                    case NORTH:
                    case SOUTH:
                        yield box(5.5, 0.0, 3.0, 10.5, 3.0, 13.0);
                    case EAST:
                    case WEST:
                        yield box(3.0, 0.0, 5.5, 13.0, 3.0, 10.5);
                    default:
                        yield box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0);
                }
            }
            case 2 -> {
                switch (state.getValue(FACING)) {
                    case NORTH:
                    case SOUTH:
                        yield box(1.0, 0.0, 2.0, 15.0, 3.0, 14.0);
                    case EAST:
                    case WEST:
                        yield box(2.0, 0.0, 1.0, 14.0, 3.0, 15.0);
                    default:
                        yield box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0);
                }
            }
            case 3, 4 -> {
                switch (state.getValue(FACING)) {
                    case NORTH:
                    case SOUTH:
                        yield box(2.0, 0.0, 3.0, 14.0, 6.0, 13.0);
                    case EAST:
                    case WEST:
                        yield box(3.0, 0.0, 2.0, 13.0, 6.0, 14.0);
                    default:
                        yield box(1.0, 0.0, 1.0, 15.0, 6.0, 15.0);
                }
            }
            default -> box(1.0, 0.0, 1.0, 15.0, 6.0, 15.0);
        };
    }

    @Override
    public int getMaxStackable() {
        return 3;
    }
}
