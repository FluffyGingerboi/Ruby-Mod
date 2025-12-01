package ruby.fluffy.helpme.items.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RubysCookedHorseFoodItem extends Item {

    public RubysCookedHorseFoodItem() {
        super(new Properties()
                .stacksTo(64)
                .food(new FoodProperties.Builder()
                        .nutrition(8)
                        .saturationModifier(0.8F)
                        .build()
                ));
    }
}
