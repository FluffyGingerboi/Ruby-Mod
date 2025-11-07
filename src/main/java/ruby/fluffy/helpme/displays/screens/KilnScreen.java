package ruby.fluffy.helpme.displays.screens;

import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.displays.menus.KilnMenu;

public class KilnScreen extends AbstractFurnaceScreen<KilnMenu> {
    private static final ResourceLocation MAIN_TEXTURE = ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "textures/gui/container/kiln.png");
    private static final ResourceLocation LIT_TEXTURE = ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "container/kiln/lit_progress.png");
    private static final ResourceLocation BURN_TEXTURE = ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "container/kiln/burn_progress.png");

    public KilnScreen(KilnMenu abstractFurnaceMenu, Inventory inventory, Component component) {
        super(abstractFurnaceMenu, new KilnBookRecipeScreen(), inventory, component, MAIN_TEXTURE, LIT_TEXTURE, BURN_TEXTURE);
    }
}
