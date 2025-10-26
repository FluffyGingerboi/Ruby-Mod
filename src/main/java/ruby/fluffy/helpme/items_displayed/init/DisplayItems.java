package ruby.fluffy.helpme.items_displayed.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.items_displayed.item.DisplayItem;
import ruby.fluffy.helpme.items_displayed.item.PillowItem;

public class DisplayItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, "items_displayed");
    public static final DeferredHolder<Item, Item> DISPLAY = REGISTRY.register("item_display", () -> new DisplayItem(createBaseProps("item_display")));

    public static final DeferredHolder<Item, Item> WHITE_PILLOW = REGISTRY.register(
            "white_jewelry_pillow", () -> new PillowItem(createBaseProps("white_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> LG_PILLOW = REGISTRY.register(
            "light_gray_jewelry_pillow", () -> new PillowItem(createBaseProps("light_gray_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> GRAY_PILLOW = REGISTRY.register(
            "gray_jewelry_pillow", () -> new PillowItem(createBaseProps("gray_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> BLACK_PILLOW = REGISTRY.register(
            "black_jewelry_pillow", () -> new PillowItem(createBaseProps("black_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> RED_PILLOW = REGISTRY.register(
            "red_jewelry_pillow", () -> new PillowItem(createBaseProps("red_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> ORANGE_PILLOW = REGISTRY.register(
            "orange_jewelry_pillow", () -> new PillowItem(createBaseProps("orange_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> YELLOW_PILLOW = REGISTRY.register(
            "yellow_jewelry_pillow", () -> new PillowItem(createBaseProps("yellow_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> LIME_PILLOW = REGISTRY.register(
            "lime_jewelry_pillow", () -> new PillowItem(createBaseProps("lime_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> GREEN_PILLOW = REGISTRY.register(
            "green_jewelry_pillow", () -> new PillowItem(createBaseProps("green_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> LB_PILLOW = REGISTRY.register(
            "light_blue_jewelry_pillow", () -> new PillowItem(createBaseProps("light_blue_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> CYAN_PILLOW = REGISTRY.register(
            "cyan_jewelry_pillow", () -> new PillowItem(createBaseProps("cyan_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> BLUE_PILLOW = REGISTRY.register(
            "blue_jewelry_pillow", () -> new PillowItem(createBaseProps("blue_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> PURPLE_PILLOW = REGISTRY.register(
            "purple_jewelry_pillow", () -> new PillowItem(createBaseProps("purple_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> MAGE_PILLOW = REGISTRY.register(
            "magenta_jewelry_pillow", () -> new PillowItem(createBaseProps("magenta_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> PINK_PILLOW = REGISTRY.register(
            "pink_jewelry_pillow", () -> new PillowItem(createBaseProps("pink_jewelry_pillow"))
    );

    public static final DeferredHolder<Item, Item> BROWN_PILLOW = REGISTRY.register(
            "brown_jewelry_pillow", () -> new PillowItem(createBaseProps("brown_jewelry_pillow"))
    );

    public static void setupBlockItems() {
        for (DeferredHolder<Block, ? extends Block> block : DisplayBlocks.REGISTRY.getEntries()) {
            REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), createBaseProps(block.getId().getPath())));
        }
    }

    private static Properties createBaseProps(String name) {
        return new Properties();
    }
}
