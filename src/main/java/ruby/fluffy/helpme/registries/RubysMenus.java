package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.displays.menus.KilnMenu;

public class RubysMenus {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, RubyMod.MOD_ID);

    // Register the menu type with a supplier
    public static final DeferredHolder<MenuType<?>, MenuType<KilnMenu>> KILN_MENU =
            MENUS.register("kiln", () -> new MenuType<>(KilnMenu::new, FeatureFlags.VANILLA_SET));
}