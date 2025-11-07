package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.items.RubysBaseItem;
import ruby.fluffy.helpme.items.RubysBasePersistentItem;
import ruby.fluffy.helpme.items.SawItem;

public class RubysItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, RubyMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS_CHESTS = DeferredRegister.createItems(RubyMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RubyMod.MOD_ID);


    public static final DeferredHolder<Item,Item> PERIOD_LANTERN = block(RubysBlocks.PERIOD_LANTERN);
    public static final DeferredHolder<Item,Item> PURPUR_LANTERN = block(RubysBlocks.PURPUR_LANTERN);
    public static final DeferredHolder<Item,Item> YELLER_LANTERN = block(RubysBlocks.YELLER_LANTERN);
    public static final DeferredHolder<Item,Item> BLUE_LANTERN = block(RubysBlocks.BLUE_LANTERN);
    public static final DeferredHolder<Item,Item> ORANG_LANTERN = block(RubysBlocks.ORANG_LANTERN);
    public static final DeferredHolder<Item,Item> GREN_LANTERN = block(RubysBlocks.GREN_LANTERN);
    public static final DeferredHolder<Item,Item> LIT_BLUE_LANTERN = block(RubysBlocks.LIT_BLUE_LANTERN);
    public static final DeferredHolder<Item,Item> LIT_GREYPE_LANTERN = block(RubysBlocks.LIT_GREYPE_LANTERN);
    public static final DeferredHolder<Item,Item> GREYPE_LANTERN = block(RubysBlocks.GREYPE_LANTERN);
    public static final DeferredHolder<Item,Item> BLOOCK_LANTERN = block(RubysBlocks.BLOOCK_LANTERN);
    public static final DeferredHolder<Item,Item> LIM_LANTERN = block(RubysBlocks.LIM_LANTERN);
    public static final DeferredHolder<Item,Item> NYAN_LANTERN = block(RubysBlocks.NYAN_LANTERN);
    public static final DeferredHolder<Item,Item> MAGENTER_LANTERN = block(RubysBlocks.MAGENTER_LANTERN);
    public static final DeferredHolder<Item,Item> POO_LANTERN = block(RubysBlocks.POO_LANTERN);
    public static final DeferredHolder<Item,Item> PINKY_LANTERN = block(RubysBlocks.PINKY_LANTERN);

    public static final DeferredHolder<Item,Item> POPPY_BLOCK = block(RubysBlocks.POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> COMPACTED_POPPY_BLOCK = block(RubysBlocks.COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> DOUBLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.DOUBLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> TRIPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.TRIPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> QUADRUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.QUADRUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> QUINTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.QUINTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> SEXTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.SEXTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> SEPTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.SEPTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> OCTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.OCTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> NONUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.NONUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> DECUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.DECUPLE_COMPACTED_POPPY_BLOCK);

    public static final DeferredHolder<Item,Item> COBBLESTONE_KILN = block(RubysBlocks.COBBLESTONE_KILN);

    public static final DeferredHolder<Item,Item> FLOWERING_OAK_LEAVES = block(RubysBlocks.FLOWERING_OAK_LEAVES);

    public static final DeferredHolder<Item,Item> FLOWERING_OAK_SAPLING = block(RubysBlocks.FLOWERING_OAK_SAPLING);

    public static final DeferredItem<BlockItem> BLUE_WHITE_WILDFLOWERS = ITEMS.registerSimpleBlockItem(RubysBlocks.BLUE_WHITE_WILDFLOWERS);
    public static final DeferredItem<BlockItem> PURPLE_WHITE_WILDFLOWERS = ITEMS.registerSimpleBlockItem(RubysBlocks.PURPLE_WHITE_WILDFLOWERS);

    public static final DeferredHolder<Item,Item> DIRT_SLAB = block(RubysBlocks.DIRT_SLAB);
    public static final DeferredHolder<Item,Item> GRASS_SLAB = block(RubysBlocks.GRASS_SLAB);
    public static final DeferredHolder<Item,Item> GRAVEL_SLAB = block(RubysBlocks.GRAVEL_SLAB);
    public static final DeferredHolder<Item,Item> SAND_SLAB = block(RubysBlocks.SAND_SLAB);

    public static final DeferredHolder<Item,Item> LOG_STAIRS = block(RubysBlocks.LOG_STAIRS);

    public static final DeferredHolder<Item,Item> BLOOCK_PIGMENT = REGISTRY.register("bloock_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> GREYPE_PIGMENT = REGISTRY.register("greype_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> LIT_GREYPE_PIGMENT = REGISTRY.register("lit_greype_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> WIT_PIGMENT = REGISTRY.register("wit_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> RED_PIGMENT = REGISTRY.register("period_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> ORANG_PIGMENT = REGISTRY.register("orang_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> YELLER_PIGMENT = REGISTRY.register("yeller_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> GREN_PIGMENT = REGISTRY.register("gren_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> LIM_PIGMENT = REGISTRY.register("lim_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> BLUE_PIGMENT = REGISTRY.register("blue_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> LIT_BLUE_PIGMENT = REGISTRY.register("lit_blue_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> NYAN_PIGMENT = REGISTRY.register("nyan_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> PURPUR_PIGMENT = REGISTRY.register("purpur_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> MAGENTER_PIGMENT = REGISTRY.register("magenter_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> PINKY_PIGMENT = REGISTRY.register("pinky_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> POO_PIGMENT = REGISTRY.register("poo_pigment", RubysBaseItem::new);

    public static final DeferredHolder<Item,Item> MORTAR_AND_PESTLE = REGISTRY.register("mortar_and_pestle", RubysBasePersistentItem::new);
    public static final DeferredHolder<Item,Item> SAW = REGISTRY.register("saw", SawItem::new);

    public static final DeferredItem<BlockItem> CHERRY_CHEST_I = registerItem("cherry", RubysBlocks.CHERRY_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_CHEST_I = registerItem("spruce", RubysBlocks.SPRUCE_CHEST);

    public static void registerItems(IEventBus modBus) {
        ITEMS_CHESTS.register(modBus);
    }

    public static DeferredItem<BlockItem> registerItem(String name, DeferredBlock<Block> block) {
        return ITEMS_CHESTS.register(name + "_chest", ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    private static Properties createBaseProps(String name) {
        return new Properties();
    }

    private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static DeferredHolder<Item, Item> doubleBlock(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(
                block.getId().getPath(),
                () -> new DoubleHighBlockItem(block.get(), new Item.Properties())
        );
    }
}
