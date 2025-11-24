package ruby.fluffy.helpme.events.client;

import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import ruby.fluffy.helpme.registries.RubysTags;

public class EnameledArmorExtensions implements IClientItemExtensions {

    @Override
    public int getDefaultDyeColor(ItemStack stack) {

        if (stack.is(RubysTags.Items.ENAMEL_ARMOR)) {
            int color = DyedItemColor.getOrDefault(stack, 0xFFFFFFFF);
            return FastColor.ARGB32.opaque(color);
        }

        return stack.is(ItemTags.DYEABLE) ? FastColor.ARGB32.opaque(DyedItemColor.getOrDefault(stack, DyedItemColor.LEATHER_COLOR)) : 0xFFFFFFFF;
    }
}
