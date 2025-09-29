package ruby.fluffy.helpme.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import ruby.fluffy.helpme.worldgen.RubysTreeGrowers;

public class FloweringOakSaplingBlock extends SaplingBlock {
    public FloweringOakSaplingBlock() {
        super(RubysTreeGrowers.FLOWERING_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    }
}
