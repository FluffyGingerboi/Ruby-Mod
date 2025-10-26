package ruby.fluffy.helpme.blocks.bases;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class RubysBaseWildflowerBlock extends PinkPetalsBlock {
    public RubysBaseWildflowerBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_PETALS).mapColor(MapColor.PLANT));
    }
}
