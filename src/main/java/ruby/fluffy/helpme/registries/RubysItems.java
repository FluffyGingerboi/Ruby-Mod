package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.items.discs.DoIWannaKnowDisc;
import ruby.fluffy.helpme.items.discs.FiveOFiveDisc;
import ruby.fluffy.helpme.items.discs.SecretDoorDisc;
import ruby.fluffy.helpme.items.discs.WorldCavesInDisc;

public class RubysItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, RubyMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS_CHESTS = DeferredRegister.createItems(RubyMod.MOD_ID);

    public static final DeferredHolder<Item,Item> RED_LANTERN = block(RubysBlocks.RED_LANTERN);
    public static final DeferredHolder<Item,Item> PURPUR_LANTERN = block(RubysBlocks.PURPUR_LANTERN);
    public static final DeferredHolder<Item,Item> YELLER_LANTERN = block(RubysBlocks.YELLER_LANTERN);
    public static final DeferredHolder<Item,Item> BLUE_LANTERN = block(RubysBlocks.BLUE_LANTERN);
    public static final DeferredHolder<Item,Item> ORANGE_LANTERN = block(RubysBlocks.ORANGE_LANTERN);
    public static final DeferredHolder<Item,Item> GREN_LANTERN = block(RubysBlocks.GREN_LANTERN);
    public static final DeferredHolder<Item,Item> LIT_BLUE_LANTERN = block(RubysBlocks.LIT_BLUE_LANTERN);

    public static final DeferredHolder<Item,Item> FLOWERING_OAK_LEAVES = block(RubysBlocks.FLOWERING_OAK_LEAVES);

    public static final DeferredHolder<Item,Item> FLOWERING_OAK_SAPLING = block(RubysBlocks.FLOWERING_OAK_SAPLING);

    public static final DeferredHolder<Item,Item> DIRT_SLAB = block(RubysBlocks.DIRT_SLAB);
    public static final DeferredHolder<Item,Item> GRAVEL_SLAB = block(RubysBlocks.GRAVEL_SLAB);
    public static final DeferredHolder<Item,Item> SAND_SLAB = block(RubysBlocks.SAND_SLAB);

    public static final DeferredHolder<Item,Item> LOG_STAIRS = block(RubysBlocks.LOG_STAIRS);

    public static final DeferredHolder<Item,Item> DISC_505 = REGISTRY.register("disc_505", FiveOFiveDisc::new);
    public static final DeferredHolder<Item,Item> DISC_SECRET_DOOR = REGISTRY.register("disc_secret_door", SecretDoorDisc::new);
    public static final DeferredHolder<Item,Item> DISC_DO_I_WANNA_KNOW = REGISTRY.register("disc_do_i_wanna_know", DoIWannaKnowDisc::new);
    public static final DeferredHolder<Item,Item> DISC_WORLD_CAVES_IN = REGISTRY.register("disc_world_caves_in", WorldCavesInDisc::new);

    public static final DeferredItem<BlockItem> OAK_CHEST_I = registerItem("oak", RubysBlocks.OAK_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_CHEST_I = registerItem("spruce", RubysBlocks.SPRUCE_CHEST);
    public static final DeferredItem<BlockItem> BIRCH_CHEST_I = registerItem("birch", RubysBlocks.BIRCH_CHEST);
    public static final DeferredItem<BlockItem> JUNGLE_CHEST_I = registerItem("jungle", RubysBlocks.JUNGLE_CHEST);
    public static final DeferredItem<BlockItem> ACACIA_CHEST_I = registerItem("acacia", RubysBlocks.ACACIA_CHEST);
    public static final DeferredItem<BlockItem> DARK_OAK_CHEST_I = registerItem("dark_oak", RubysBlocks.DARK_OAK_CHEST);
    public static final DeferredItem<BlockItem> MANGROVE_CHEST_I = registerItem("mangrove", RubysBlocks.MANGROVE_CHEST);
    public static final DeferredItem<BlockItem> CHERRY_CHEST_I = registerItem("cherry", RubysBlocks.CHERRY_CHEST);
    public static final DeferredItem<BlockItem> BAMBOO_CHEST_I = registerItem("bamboo", RubysBlocks.BAMBOO_CHEST);
    public static final DeferredItem<BlockItem> CRIMSON_CHEST_I = registerItem("crimson", RubysBlocks.CRIMSON_CHEST);
    public static final DeferredItem<BlockItem> WARPED_CHEST_I = registerItem("warped", RubysBlocks.WARPED_CHEST);

    public static void registerItems(IEventBus modBus) {
        ITEMS_CHESTS.register(modBus);
    }

    public static DeferredItem<BlockItem> registerItem(String name, DeferredBlock<Block> block) {
        return ITEMS_CHESTS.register(name + "_chest", ()-> new BlockItem(block.get(), new Item.Properties()));
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
