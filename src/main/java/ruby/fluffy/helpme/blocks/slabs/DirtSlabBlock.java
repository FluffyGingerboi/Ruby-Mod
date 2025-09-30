package ruby.fluffy.helpme.blocks.slabs;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;

public class DirtSlabBlock extends SlabBlock {
    public DirtSlabBlock() {
        super(Block.Properties.ofFullCopy(Blocks.DIRT));
    }
}
