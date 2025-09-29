package ruby.fluffy.helpme.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class FloweringOakLeavesBlock extends LeavesBlock {
    public FloweringOakLeavesBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
    }
}
