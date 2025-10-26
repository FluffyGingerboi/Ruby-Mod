package ruby.fluffy.helpme.items_displayed.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import ruby.fluffy.helpme.items_displayed.block.IDisplayBlock;
import ruby.fluffy.helpme.items_displayed.init.DisplayItems;

public class ItemDisplay extends AbstractDisplayEntity {

    public ItemDisplay(EntityType<ItemDisplay> type, Level world) {
        super(type, world);
    }

    public ItemStack getPickResult() {
        return new ItemStack(DisplayItems.DISPLAY.get());
    }

    @Override
    public boolean isCorrectBlock(Block target) {
        return target instanceof IDisplayBlock;
    }
}
