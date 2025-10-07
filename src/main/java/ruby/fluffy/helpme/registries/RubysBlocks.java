package ruby.fluffy.helpme.registries;

import com.sun.jna.platform.win32.WinNT;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
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
import ruby.fluffy.helpme.blocks.bases.RubysBaseLeafpileBlock;
import ruby.fluffy.helpme.blocks.bases.RubysBaseWildflowerBlock;
import ruby.fluffy.helpme.blocks.slabs.DirtSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.GrassSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.GravelSlabBlock;
import ruby.fluffy.helpme.blocks.slabs.SandSlabBlock;
import ruby.fluffy.helpme.entities.block.RubysChestBlockEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static net.minecraft.world.level.block.state.BlockBehaviour.Properties.ofFullCopy;

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

    public static final DeferredBlock<Block> BLUE_WHITE_WILDFLOWERS = BLOCKS.register("blue_white_wildflowers", RubysBaseWildflowerBlock::new);
    public static final DeferredBlock<Block> PURPLE_WHITE_WILDFLOWERS = BLOCKS.register("purple_white_wildflowers", RubysBaseWildflowerBlock::new);

    public static final DeferredBlock<Block> DIRT_SLAB = BLOCKS.register("dirt_slab", DirtSlabBlock::new);
    public static final DeferredBlock<Block> GRAVEL_SLAB = BLOCKS.register("gravel_slab", GravelSlabBlock::new);
    public static final DeferredBlock<Block> SAND_SLAB = BLOCKS.register("sand_slab", SandSlabBlock::new);
    public static final DeferredBlock<Block> GRASS_SLAB = BLOCKS.register("grass_slab", GrassSlabBlock::new);

    public static final DeferredBlock<Block> LOG_STAIRS = BLOCKS.register("log_stairs", LogStairsBlock::new);

    public static final DeferredBlock<Block> CHERRY_CHEST = registerChest("cherry", () -> new RubysBaseChestBlock(MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, "cherry"));
    public static final DeferredBlock<Block> SPRUCE_CHEST = registerChest("spruce", () -> new RubysBaseChestBlock(MapColor.TERRACOTTA_BROWN, SoundType.WOOD, "spruce"));

    public static final DeferredBlock<Block> POTTED_FLOWERING_OAK_SAPLING =
            BLOCKS.register("potted_flowering_oak_sapling",
                    () -> new PottedFloweringOakSaplingBlock(FLOWERING_OAK_SAPLING));

    public static Supplier<BlockEntityType<RubysChestBlockEntity>> MORE_CHEST_BLOCK_ENTITY;
    public static final List<DeferredBlock<Block>> more_chest = new ArrayList<>();

    public static void registerBlocks(IEventBus modBus) {
        addToArray(CHERRY_CHEST);
        addToArray(SPRUCE_CHEST);

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
