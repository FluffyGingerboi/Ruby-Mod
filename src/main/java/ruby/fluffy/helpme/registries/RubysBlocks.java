package ruby.fluffy.helpme.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.blocks.*;
import ruby.fluffy.helpme.blocks.slabs.DirtSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.GravelSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.SandSlabBlock;

public class RubysBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RubyMod.MOD_ID);

    public static final DeferredBlock<Block> RED_LANTERN = BLOCKS.register("red_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> PURPUR_LANTERN = BLOCKS.register("purpur_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> YELLER_LANTERN = BLOCKS.register("yeller_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> BLUE_LANTERN = BLOCKS.register("blue_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> ORANGE_LANTERN = BLOCKS.register("orange_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> GREN_LANTERN = BLOCKS.register("gren_lantern", RubyLanternBlock::new);
    public static final DeferredBlock<Block> LIT_BLUE_LANTERN = BLOCKS.register("lit_blue_lantern", RubyLanternBlock::new);

    public static final DeferredBlock<Block> FLOWERING_OAK_LEAVES = BLOCKS.register("flowering_oak_leaves", FloweringOakLeavesBlock::new);

    public static final DeferredBlock<Block> FLOWERING_OAK_SAPLING = BLOCKS.register("flowering_oak_sapling", FloweringOakSaplingBlock::new);

    public static final DeferredBlock<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", DirtSlabBlock::new);
    public static final DeferredBlock<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab", GravelSlabBlock::new);
    public static final DeferredBlock<Block> SAND_SLAB = BLOCKS.register("sand_slab", SandSlabBlock::new);

    public static final DeferredBlock<Block> LOG_STAIRS = BLOCKS.register("log_stairs", LogStairsBlock::new);

    public static final DeferredBlock<ChestBlock> CHERRY_CHEST = BLOCKS.register("cherry_chest",
            () -> new CherryChestBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHEST)));

    public static final DeferredBlock<Block> POTTED_FLOWERING_OAK_SAPLING =
            BLOCKS.register("potted_flowering_oak_sapling",
                    () -> new PottedFloweringOakSaplingBlock(FLOWERING_OAK_SAPLING));

}
