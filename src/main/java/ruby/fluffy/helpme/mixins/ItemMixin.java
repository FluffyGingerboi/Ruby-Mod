package ruby.fluffy.helpme.mixins;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ruby.fluffy.helpme.items_displayed.init.DisplayTags;

import java.util.List;

@Mixin({Item.class})
public abstract class ItemMixin {
   @Inject(
      method = {"appendHoverText"},
      at = {@At("TAIL")}
   )
   private void applyTooltip(ItemStack stack, TooltipContext context, List<Component> list, TooltipFlag flag, CallbackInfo ci) {
      if (stack.is(DisplayTags.DISPLAYABLE)) {
         list.add(Component.translatable("item.items_displayed.tooltip.shift_place").withStyle(ChatFormatting.GRAY));
      }
   }
}
