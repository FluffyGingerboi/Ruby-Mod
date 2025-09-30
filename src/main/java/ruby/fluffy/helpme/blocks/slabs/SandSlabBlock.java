package ruby.fluffy.helpme.blocks.slabs;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SandSlabBlock extends SlabBlock {
    public SandSlabBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND));
    }
}
