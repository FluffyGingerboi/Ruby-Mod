package ruby.fluffy.helpme.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class RubysBasePersistentItem extends Item {

    public RubysBasePersistentItem() {
        super(new Properties()
                .rarity(Rarity.COMMON)
                .stacksTo(1)
        );
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack.copy();
    }

}
