package ruby.fluffy.helpme.blocks.items_displayed;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SherdBlock extends AbstractItemBlock implements IDisplayBlock, IPillowBlock {
    public static final MapCodec<SherdBlock> CODEC = simpleCodec(SherdBlock::new);

    public SherdBlock(Properties props) {
        super(props);
    }

    public MapCodec<SherdBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }
}

