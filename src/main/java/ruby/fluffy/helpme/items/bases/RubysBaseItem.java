package ruby.fluffy.helpme.items.bases;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.utilites.interfaces.IEnameled;

public class RubysBaseItem extends Item implements IEnameled {

    public RubysBaseItem() {
        super(new Properties()
                .rarity(Rarity.COMMON)
        );
    }
}
