package ruby.fluffy.helpme.items;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.crafting.RecipeType;
import ruby.fluffy.helpme.registries.RubysEntities;

public class DisplayItem extends AbstractEntityItem {
    public DisplayItem(Properties props) {
        super(props);
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, context, list, flag);
            list.add(Component.translatable("item.items_displayed.tooltip.item_display_1").withStyle(ChatFormatting.GRAY));
            list.add(Component.translatable("item.items_displayed.tooltip.item_display_2").withStyle(ChatFormatting.GRAY));
            list.add(Component.translatable("item.items_displayed.tooltip.item_display_0").withStyle(ChatFormatting.GRAY));
    }

    public int getBurnTime(ItemStack stack, RecipeType type) {
        return 100;
    }

    @Override
    public EntityType<? extends LivingEntity> getType() {
        return RubysEntities.DISPLAY.get();
    }
}

