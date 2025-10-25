package ruby.fluffy.helpme.blocks.bases;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RubysBasePoppyBlock extends Block {
    public RubysBasePoppyBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK));
    }
}
