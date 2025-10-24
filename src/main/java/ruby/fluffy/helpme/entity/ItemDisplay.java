package ruby.fluffy.helpme.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import ruby.fluffy.helpme.blocks.items_displayed.IDisplayBlock;
import ruby.fluffy.helpme.registries.RubysItems;

public class ItemDisplay extends AbstractDisplayEntity {
    public ItemDisplay(EntityType<ItemDisplay> type, Level world) {
        super(type, world);
    }

    public ItemStack getPickResult() {
        return new ItemStack((ItemLike) RubysItems.DISPLAY.get());
    }

    @Override
    public boolean isCorrectBlock(Block target) {
        return target instanceof IDisplayBlock;
    }
}

