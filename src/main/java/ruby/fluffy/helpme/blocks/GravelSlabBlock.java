package ruby.fluffy.helpme.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class GravelSlabBlock extends SlabBlock {
    public GravelSlabBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL));
    }
}
