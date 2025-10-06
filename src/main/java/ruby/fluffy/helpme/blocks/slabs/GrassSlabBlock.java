package ruby.fluffy.helpme.blocks.slabs;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;

public class GrassSlabBlock extends SlabBlock {
    public GrassSlabBlock() {
        super(Block.Properties.ofFullCopy(Blocks.GRASS_BLOCK));
    }
}
