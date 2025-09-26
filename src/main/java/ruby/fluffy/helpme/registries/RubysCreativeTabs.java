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
                        tabData.accept(RubysItems.GREEN_LANTERN.get());
                    })
                    .withSearchBar()
                    .build()
    );
}
