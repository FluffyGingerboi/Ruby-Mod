package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;

public class RubysItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, RubyMod.MOD_ID);

    public static final DeferredHolder<Item,Item> RED_LANTERN = block(RubysBlocks.RED_LANTERN);
    public static final DeferredHolder<Item,Item> PURPUR_LANTERN = block(RubysBlocks.PURPUR_LANTERN);
    public static final DeferredHolder<Item,Item> YELLER_LANTERN = block(RubysBlocks.YELLER_LANTERN);
    public static final DeferredHolder<Item,Item> BLUE_LANTERN = block(RubysBlocks.BLUE_LANTERN);
    public static final DeferredHolder<Item,Item> ORANGE_LANTERN = block(RubysBlocks.ORANGE_LANTERN);
    public static final DeferredHolder<Item,Item> GREEN_LANTERN = block(RubysBlocks.GREEN_LANTERN);
    public static final DeferredHolder<Item,Item> LIT_BLUE_LANTERN = block(RubysBlocks.LIT_BLUE_LANTERN);

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
