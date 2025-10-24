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
                    .icon(() -> new ItemStack(RubysItems.PERIOD_LANTERN.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(RubysItems.PERIOD_LANTERN.get());
                        tabData.accept(RubysItems.PURPUR_LANTERN.get());
                        tabData.accept(RubysItems.YELLER_LANTERN.get());
                        tabData.accept(RubysItems.BLUE_LANTERN.get());
                        tabData.accept(RubysItems.LIT_BLUE_LANTERN.get());
                        tabData.accept(RubysItems.ORANGE_LANTERN.get());
                        tabData.accept(RubysItems.LIT_GREYPE_LANTERN.get());
                        tabData.accept(RubysItems.GREYPE_LANTERN.get());
                        tabData.accept(RubysItems.NYAN_LANTERN.get());
                        tabData.accept(RubysItems.LIM_LANTERN.get());
                        tabData.accept(RubysItems.MAGENTER_LANTERN.get());
                        tabData.accept(RubysItems.PINKY_LANTERN.get());
                        tabData.accept(RubysItems.BLOOCK_LANTERN.get());
                        tabData.accept(RubysItems.POO_LANTERN.get());
                        tabData.accept(RubysItems.GREN_LANTERN.get());
                        tabData.accept(RubysItems.DIRT_SLAB.get());
                        tabData.accept(RubysItems.GRAVEL_SLAB.get());
                        tabData.accept(RubysItems.SAND_SLAB.get());
                        tabData.accept(RubysItems.GRASS_SLAB.get());
                        tabData.accept(RubysItems.LOG_STAIRS.get());
                        tabData.accept(RubysItems.FLOWERING_OAK_LEAVES.get());
                        tabData.accept(RubysItems.FLOWERING_OAK_SAPLING.get());
                        tabData.accept(RubysItems.BLUE_WHITE_WILDFLOWERS.get());
                        tabData.accept(RubysItems.PURPLE_WHITE_WILDFLOWERS.get());
                        tabData.accept(RubysItems.CHERRY_CHEST_I.get());
                        tabData.accept(RubysItems.SPRUCE_CHEST_I.get());
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
                        tabData.accept(RubysItems.DISC_BABY_IM_YOURS.get());
                        tabData.accept(RubysItems.DISC_CRYING_LIGHTNING.get());
                        tabData.accept(RubysItems.DISC_FLUORESCENT_ADOLESCENCE.get());
                        tabData.accept(RubysItems.DISC_I_WANNA_BE_YOURS.get());
                        tabData.accept(RubysItems.DISC_MY_PROPELLER.get());
                        tabData.accept(RubysItems.DISC_SNAP_OUT_OF_IT.get());
                        tabData.accept(RubysItems.DISC_WHEN_THE_SUN_GOES_DOWN.get());
                    })
                    .withSearchBar()
                    .build()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RUBYS_ITEMS = REGISTRY.register(
            "items",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemgroup.ru3yy.items"))
                    .icon(() -> new ItemStack(RubysItems.BLOOCK_PIGMENT.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(RubysItems.BLOOCK_PIGMENT.get());
                        tabData.accept(RubysItems.GREYPE_PIGMENT.get());
                        tabData.accept(RubysItems.LIT_GREYPE_PIGMENT.get());
                        tabData.accept(RubysItems.WIT_PIGMENT.get());
                        tabData.accept(RubysItems.POO_PIGMENT.get());
                        tabData.accept(RubysItems.RED_PIGMENT.get());
                        tabData.accept(RubysItems.ORANG_PIGMENT.get());
                        tabData.accept(RubysItems.YELLER_PIGMENT.get());
                        tabData.accept(RubysItems.GREN_PIGMENT.get());
                        tabData.accept(RubysItems.LIM_PIGMENT.get());
                        tabData.accept(RubysItems.BLUE_PIGMENT.get());
                        tabData.accept(RubysItems.NYAN_PIGMENT.get());
                        tabData.accept(RubysItems.LIT_BLUE_PIGMENT.get());
                        tabData.accept(RubysItems.PURPUR_PIGMENT.get());
                        tabData.accept(RubysItems.MAGENTER_PIGMENT.get());
                        tabData.accept(RubysItems.PINKY_PIGMENT.get());
                        tabData.accept(RubysItems.MORTAR_AND_PESTLE.get());
                        tabData.accept(RubysItems.SAW.get());
                    })
                    .withSearchBar()
                    .build()
    );
}
