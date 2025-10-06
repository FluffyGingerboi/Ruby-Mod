package ruby.fluffy.helpme.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RubysBaseItem extends Item {

    public RubysBaseItem() {
        super(new Properties()
                .rarity(Rarity.COMMON)
        );
    }
}
