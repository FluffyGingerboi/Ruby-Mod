package ruby.fluffy.helpme.registries;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.blocks.RubyLanternBlock;

public class RubysBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RubyMod.MOD_ID);

    public static final DeferredBlock<Block> RED_LANTERN = BLOCKS.register("red_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> PURPUR_LANTERN = BLOCKS.register("purpur_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> YELLER_LANTERN = BLOCKS.register("yeller_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> BLUE_LANTERN = BLOCKS.register("blue_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> ORANGE_LANTERN = BLOCKS.register("orange_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> GREEN_LANTERN = BLOCKS.register("green_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> LIT_BLUE_LANTERN = BLOCKS.register("lit_blue_lantern", RubyLanternBlock::new);
}
