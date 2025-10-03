package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.blocks.*;
import ruby.fluffy.helpme.blocks.bases.RubysBaseChestBlock;
import ruby.fluffy.helpme.blocks.bases.RubysBaseLanternBlock;
import ruby.fluffy.helpme.blocks.slabs.DirtSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.GravelSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.SandSlabBlock;
import ruby.fluffy.helpme.entities.RubysChestBlockEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RubysBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RubyMod.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, RubyMod.MOD_ID);


    public static final DeferredBlock<Block> RED_LANTERN = BLOCKS.register("red_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> PURPUR_LANTERN = BLOCKS.register("purpur_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> YELLER_LANTERN = BLOCKS.register("yeller_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> BLUE_LANTERN = BLOCKS.register("blue_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> ORANGE_LANTERN = BLOCKS.register("orange_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> GREN_LANTERN = BLOCKS.register("gren_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> LIT_BLUE_LANTERN = BLOCKS.register("lit_blue_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> LIT_GREYPE_LANTERN = BLOCKS.register("lit_greype_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> GREYPE_LANTERN = BLOCKS.register("greype_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> BLOOCK_LANTERN = BLOCKS.register("bloock_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> LIM_LANTERN = BLOCKS.register("lim_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> NYAN_LANTERN = BLOCKS.register("nyan_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> MAGENTER_LANTERN = BLOCKS.register("magenter_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> POO_LANTERN = BLOCKS.register("poo_lantern", RubysBaseLanternBlock::new);
    public static final DeferredBlock<Block> PINKY_LANTERN = BLOCKS.register("pinky_lantern", RubysBaseLanternBlock::new);

    public static final DeferredBlock<Block> FLOWERING_OAK_LEAVES = BLOCKS.register("flowering_oak_leaves", FloweringOakLeavesBlock::new);

    public static final DeferredBlock<Block> FLOWERING_OAK_SAPLING = BLOCKS.register("flowering_oak_sapling", FloweringOakSaplingBlock::new);

    public static final DeferredBlock<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", DirtSlabBlock::new);
    public static final DeferredBlock<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab", GravelSlabBlock::new);
    public static final DeferredBlock<Block> SAND_SLAB = BLOCKS.register("sand_slab", SandSlabBlock::new);

    public static final DeferredBlock<Block> LOG_STAIRS = BLOCKS.register("log_stairs", LogStairsBlock::new);

    public static final DeferredBlock<Block> OAK_CHEST = registerChest("oak", () -> new RubysBaseChestBlock(MapColor.WOOD, "oak"));
    public static final DeferredBlock<Block> SPRUCE_CHEST = registerChest("spruce", () -> new RubysBaseChestBlock(MapColor.PODZOL, "spruce"));
    public static final DeferredBlock<Block> BIRCH_CHEST = registerChest("birch", () -> new RubysBaseChestBlock(MapColor.SAND, "birch"));
    public static final DeferredBlock<Block> JUNGLE_CHEST = registerChest("jungle", () -> new RubysBaseChestBlock(MapColor.DIRT, "jungle"));
    public static final DeferredBlock<Block> ACACIA_CHEST = registerChest("acacia", () -> new RubysBaseChestBlock(MapColor.COLOR_ORANGE, "acacia"));
    public static final DeferredBlock<Block> DARK_OAK_CHEST = registerChest("dark_oak", () -> new RubysBaseChestBlock(MapColor.COLOR_BROWN, "dark_oak"));
    public static final DeferredBlock<Block> MANGROVE_CHEST = registerChest("mangrove", () -> new RubysBaseChestBlock(MapColor.COLOR_RED, "mangrove"));
    public static final DeferredBlock<Block> CHERRY_CHEST = registerChest("cherry", () -> new RubysBaseChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry"));
    public static final DeferredBlock<Block> BAMBOO_CHEST = registerChest("bamboo", () -> new RubysBaseChestBlock(MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD, "bamboo"));
    public static final DeferredBlock<Block> CRIMSON_CHEST = registerChest("crimson", () -> new RubysBaseChestBlock(MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, "crimson"));
    public static final DeferredBlock<Block> WARPED_CHEST = registerChest("warped", () -> new RubysBaseChestBlock(MapColor.WARPED_STEM, SoundType.NETHER_WOOD, "warped"));



    public static final DeferredBlock<Block> POTTED_FLOWERING_OAK_SAPLING =
            BLOCKS.register("potted_flowering_oak_sapling",
                    () -> new PottedFloweringOakSaplingBlock(FLOWERING_OAK_SAPLING));

    public static Supplier<BlockEntityType<RubysChestBlockEntity>> MORE_CHEST_BLOCK_ENTITY;
    public static final List<DeferredBlock<Block>> more_chest = new ArrayList<>();

    public static void registerBlocks(IEventBus modBus) {
        addToArray(OAK_CHEST);
        addToArray(SPRUCE_CHEST);
        addToArray(BIRCH_CHEST);
        addToArray(JUNGLE_CHEST);
        addToArray(ACACIA_CHEST);
        addToArray(DARK_OAK_CHEST);
        addToArray(MANGROVE_CHEST);
        addToArray(CHERRY_CHEST);
        addToArray(BAMBOO_CHEST);
        addToArray(CRIMSON_CHEST);
        addToArray(WARPED_CHEST);

        MORE_CHEST_BLOCK_ENTITY = BLOCKS_ENTITIES.register("chest_tile",
                () -> BlockEntityType.Builder.of(RubysChestBlockEntity::new, more_chest.stream().map(DeferredBlock::get).toArray(Block[]::new)).build(null));

        BLOCKS.register(modBus);
        BLOCKS_ENTITIES.register(modBus);
    }

    private static DeferredBlock<Block> registerChest(String name, Supplier<Block> block) {
        return BLOCKS.register(name + "_chest", block);
    }

    private static void addToArray(DeferredBlock<Block> chest) {
        more_chest.add(chest);
    }

}
