package ruby.fluffy.helpme.items.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class RubysRawSquidFoodItem extends Item {

    public RubysRawSquidFoodItem() {
        super(new Properties()
                .stacksTo(64)
                .food(new FoodProperties.Builder()
                        .nutrition(1)
                        .saturationModifier(0.3F)
                        .build()
                ));
    }
}
