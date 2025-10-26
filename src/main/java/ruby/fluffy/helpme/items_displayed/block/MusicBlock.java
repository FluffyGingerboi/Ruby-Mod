package ruby.fluffy.helpme.items_displayed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MusicBlock extends AbstractItemBlock implements IDisplayBlock, IPillowBlock {

    public static final MapCodec<MusicBlock> CODEC = simpleCodec(MusicBlock::new);

    public MusicBlock(Properties props) {
        super(props);
    }

    public MapCodec<MusicBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(2.0, 0.0, 2.0, 14.0, 1.0, 14.0);
    }
}
