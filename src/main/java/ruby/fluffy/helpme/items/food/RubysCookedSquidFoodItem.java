package ruby.fluffy.helpme.items.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RubysCookedSquidFoodItem extends Item {

    public RubysCookedSquidFoodItem() {
        super(new Properties()
                .stacksTo(64)
                .food(new FoodProperties.Builder()
                        .nutrition(6)
                        .saturationModifier(0.6F)
                        .build()
                ));
    }
}
