package ruby.fluffy.helpme.displays.menus;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import ruby.fluffy.helpme.registries.RubysMenus;
import ruby.fluffy.helpme.registries.RubysRecipes;

public class KilnMenu extends AbstractFurnaceMenu {
    public KilnMenu(int syncId, Inventory playerInventory) {
        super(RubysMenus.KILN_MENU.get(), RubysRecipes.FIRING.get(), RecipeBookType.FURNACE, syncId, playerInventory);
    }

    public KilnMenu(int syncId, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
        super(RubysMenus.KILN_MENU.get(), RubysRecipes.FIRING.get(), RecipeBookType.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }
}
