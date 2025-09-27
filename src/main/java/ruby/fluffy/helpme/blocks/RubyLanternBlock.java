package ruby.fluffy.helpme.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RubyLanternBlock extends Block {
    public RubyLanternBlock() {
        super(BlockBehaviour.Properties.of()
                .sound(SoundType.GLASS)
                .lightLevel(BlockState -> 15));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }
}
