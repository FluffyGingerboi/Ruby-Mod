package ruby.fluffy.helpme.blocks.bases;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RubysBaseLanternBlock extends Block {
    public RubysBaseLanternBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.SEA_LANTERN));
    }
}
