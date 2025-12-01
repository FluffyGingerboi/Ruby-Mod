package ruby.fluffy.helpme.mixins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ArmorDyeRecipe;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ruby.fluffy.helpme.registries.RubysTags;

import java.util.ArrayList;
import java.util.List;

@Mixin(ArmorDyeRecipe.class)
public abstract class ArmorDyeRecipeMixin {


    @Inject(method = "matches", at = @At("HEAD"), cancellable = true)
    private void blockNotDyeable(CraftingInput input, Level level, CallbackInfoReturnable<Boolean> cir) {
        ItemStack armor = ItemStack.EMPTY;
        List<ItemStack> dyes = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (!stack.isEmpty()) {

                if (stack.is(RubysTags.Items.NOT_DYEABLE)) {
                    cir.setReturnValue(false);
                    return;
                }

                if (stack.is(net.minecraft.tags.ItemTags.DYEABLE)) {
                    if (!armor.isEmpty()) {
                        cir.setReturnValue(false);
                        return;
                    }
                    armor = stack;
                } else if (stack.getItem() instanceof DyeItem) {
                    dyes.add(stack);
                } else {
                    cir.setReturnValue(false);
                    return;
                }
            }
        }

        cir.setReturnValue(!armor.isEmpty() && !dyes.isEmpty());
    }

    @Inject(method = "assemble", at = @At("HEAD"), cancellable = true)
    private void preserveNBT(CraftingInput input, net.minecraft.core.HolderLookup.Provider registries, CallbackInfoReturnable<ItemStack> cir) {
        ItemStack armor = ItemStack.EMPTY;
        List<DyeItem> dyes = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.is(net.minecraft.tags.ItemTags.DYEABLE)) {
                    armor = stack.copy(); // preserves NBT
                } else if (stack.getItem() instanceof DyeItem dye) {
                    dyes.add(dye);
                }
            }
        }

        if (armor.isEmpty() || dyes.isEmpty()) {
            cir.setReturnValue(ItemStack.EMPTY);
            return;
        }

        cir.setReturnValue(net.minecraft.world.item.component.DyedItemColor.applyDyes(armor, dyes));
    }
}