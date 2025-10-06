package ruby.fluffy.helpme.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;

public class LogStairsBlock extends StairBlock {
    public LogStairsBlock() {
        super(Blocks.OAK_PLANKS.defaultBlockState(),
                Properties.ofFullCopy(Blocks.OAK_PLANKS));
    }
}
