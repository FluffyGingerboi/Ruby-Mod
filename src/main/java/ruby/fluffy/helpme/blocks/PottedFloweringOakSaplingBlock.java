package ruby.fluffy.helpme.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;

import java.util.function.Supplier;

public class PottedFloweringOakSaplingBlock extends FlowerPotBlock {
    public PottedFloweringOakSaplingBlock(Supplier<Block> flower) {
        super(() -> (FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT,
                flower,
                Properties.of()
                        .instabreak()
                        .noOcclusion()
        );
    }
}
