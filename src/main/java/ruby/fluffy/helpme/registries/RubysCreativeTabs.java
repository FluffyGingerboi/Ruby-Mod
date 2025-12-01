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
                        tabData.accept(RubysItems.ORANG_LANTERN.get());
                        tabData.accept(RubysItems.LIT_GREYPE_LANTERN.get());
                        tabData.accept(RubysItems.GREYPE_LANTERN.get());
                        tabData.accept(RubysItems.NYAN_LANTERN.get());
                        tabData.accept(RubysItems.LIM_LANTERN.get());
                        tabData.accept(RubysItems.MAGENTER_LANTERN.get());
                        tabData.accept(RubysItems.PINKY_LANTERN.get());
                        tabData.accept(RubysItems.BLOOCK_LANTERN.get());
                        tabData.accept(RubysItems.POO_LANTERN.get());
                        tabData.accept(RubysItems.GREN_LANTERN.get());
                        tabData.accept(RubysItems.POPPY_BLOCK.get());
                        tabData.accept(RubysItems.COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.DOUBLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.TRIPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.QUADRUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.QUINTUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.SEXTUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.SEPTUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.OCTUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.NONUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.DECUPLE_COMPACTED_POPPY_BLOCK.get());
                        tabData.accept(RubysItems.DIRT_SLAB.get());
                        tabData.accept(RubysItems.GRAVEL_SLAB.get());
                        tabData.accept(RubysItems.SAND_SLAB.get());
                        tabData.accept(RubysItems.GRASS_SLAB.get());
                        tabData.accept(RubysItems.LOG_STAIRS.get());
                        tabData.accept(RubysItems.FLOWERING_OAK_LEAVES.get());
                        tabData.accept(RubysItems.FLOWERING_OAK_SAPLING.get());
                        tabData.accept(RubysItems.BLUE_WHITE_WILDFLOWERS.get());
                        tabData.accept(RubysItems.PURPLE_WHITE_WILDFLOWERS.get());
                        tabData.accept(RubysItems.CHERRY_CHEST.get());
                        tabData.accept(RubysItems.SPRUCE_CHEST.get());
                        tabData.accept(RubysItems.KILN.get());
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
                        tabData.accept(RubysItems.PERIOD_PIGMENT.get());
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
                        tabData.accept(RubysItems.ENAMEL.get());
                        tabData.accept(RubysItems.SCRAPER.get());
                        tabData.accept(RubysItems.RAW_SQUID_MEAT.get());
                        tabData.accept(RubysItems.COOKED_SQUID_MEAT.get());
                        tabData.accept(RubysItems.RAW_HORSE_MEAT.get());
                        tabData.accept(RubysItems.COOKED_HORSE_MEAT.get());
                    })
                    .withSearchBar()
                    .build()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RUBYS_ARMOR = REGISTRY.register(
            "armor",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemgroup.ru3yy.armor"))
                    .icon(() -> new ItemStack(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(RubysItems.ENAMELED_CHAIN_HELMET.get());
                        tabData.accept(RubysItems.ENAMELED_CHAIN_CHESTPLATE.get());
                        tabData.accept(RubysItems.ENAMELED_CHAIN_LEGGINGS.get());
                        tabData.accept(RubysItems.ENAMELED_CHAIN_BOOTS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get());
                        tabData.accept(RubysItems.ENAMELED_IRON_HELMET.get());
                        tabData.accept(RubysItems.ENAMELED_IRON_CHESTPLATE.get());
                        tabData.accept(RubysItems.ENAMELED_IRON_LEGGINGS.get());
                        tabData.accept(RubysItems.ENAMELED_IRON_BOOTS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_IRON_HELMET.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get());
                        tabData.accept(RubysItems.ENAMELED_GOLD_HELMET.get());
                        tabData.accept(RubysItems.ENAMELED_GOLD_CHESTPLATE.get());
                        tabData.accept(RubysItems.ENAMELED_GOLD_LEGGINGS.get());
                        tabData.accept(RubysItems.ENAMELED_GOLD_BOOTS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get());
                        tabData.accept(RubysItems.ENAMELED_DIAMOND_HELMET.get());
                        tabData.accept(RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get());
                        tabData.accept(RubysItems.ENAMELED_DIAMOND_LEGGINGS.get());
                        tabData.accept(RubysItems.ENAMELED_DIAMOND_BOOTS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get());
                        tabData.accept(RubysItems.ENAMELED_NETHERITE_HELMET.get());
                        tabData.accept(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get());
                        tabData.accept(RubysItems.ENAMELED_NETHERITE_LEGGINGS.get());
                        tabData.accept(RubysItems.ENAMELED_NETHERITE_BOOTS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get());
                        tabData.accept(RubysItems.ENAMELED_IRON_HORSE_ARMOR.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get());
                        tabData.accept(RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get());
                        tabData.accept(RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get());
                        tabData.accept(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get());
                    })
                    .withSearchBar()
                    .build()
    );
}
