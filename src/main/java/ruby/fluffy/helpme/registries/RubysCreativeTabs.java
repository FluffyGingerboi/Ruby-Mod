package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;

public class RubysCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB,
            RubyMod.MOD_ID
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RUBYS_BLOCKS = REGISTRY.register(
            "blocks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemgroup.ru3yy.blocks"))
                    .icon(() -> new ItemStack(RubysItems.RED_LANTERN.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(RubysItems.RED_LANTERN.get());
                        tabData.accept(RubysItems.PURPUR_LANTERN.get());
                        tabData.accept(RubysItems.YELLER_LANTERN.get());
                        tabData.accept(RubysItems.BLUE_LANTERN.get());
                        tabData.accept(RubysItems.LIT_BLUE_LANTERN.get());
                        tabData.accept(RubysItems.ORANGE_LANTERN.get());
                        tabData.accept(RubysItems.GREN_LANTERN.get());
                        tabData.accept(RubysItems.DIRT_SLAB.get());
                        tabData.accept(RubysItems.GRAVEL_SLAB.get());
                        tabData.accept(RubysItems.SAND_SLAB.get());
                        tabData.accept(RubysItems.LOG_STAIRS.get());
                        tabData.accept(RubysItems.FLOWERING_OAK_LEAVES.get());
                        tabData.accept(RubysItems.FLOWERING_OAK_SAPLING.get());
                        tabData.accept(RubysItems.OAK_CHEST_I.get());
                        tabData.accept(RubysItems.SPRUCE_CHEST_I.get());
                        tabData.accept(RubysItems.MANGROVE_CHEST_I.get());
                        tabData.accept(RubysItems.BIRCH_CHEST_I.get());
                        tabData.accept(RubysItems.CHERRY_CHEST_I.get());
                        tabData.accept(RubysItems.CRIMSON_CHEST_I.get());
                    })
                    .withSearchBar()
                    .build()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RUBYS_DISCS = REGISTRY.register(
            "discs",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemgroup.ru3yy.discs"))
                    .icon(() -> new ItemStack(RubysItems.DISC_505.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(RubysItems.DISC_505.get());
                        tabData.accept(RubysItems.DISC_SECRET_DOOR.get());
                        tabData.accept(RubysItems.DISC_DO_I_WANNA_KNOW.get());
                        tabData.accept(RubysItems.DISC_WORLD_CAVES_IN.get());
                    })
                    .withSearchBar()
                    .build()
    );
}
