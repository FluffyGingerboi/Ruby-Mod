package ruby.fluffy.helpme.entities.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import ruby.fluffy.helpme.displays.menus.KilnMenu;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysRecipes;

public class RubysKilnBlockEntity extends AbstractFurnaceBlockEntity {
    public RubysKilnBlockEntity(BlockPos pos, BlockState state) {
        super(RubysBlocks.KILN_BLOCK_ENTITY.get(), pos, state, RubysRecipes.FIRING.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.kiln");
    }

    protected int getBurnDuration(ItemStack fuel) {
        return super.getBurnDuration(fuel) / 2;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new KilnMenu(id, player, this, this.dataAccess);
    }
}
