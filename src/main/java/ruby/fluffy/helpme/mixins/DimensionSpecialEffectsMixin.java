package ruby.fluffy.helpme.mixins;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionSpecialEffects.class)
public abstract class DimensionSpecialEffectsMixin {

    @Inject(method = "getCloudHeight", at = @At("RETURN"), cancellable = true)
    private void overrideOverworldCloudHeight(CallbackInfoReturnable<Float> cir) {
        DimensionSpecialEffects self = (DimensionSpecialEffects) (Object) this;

        if (self instanceof DimensionSpecialEffects.OverworldEffects) {
            cir.setReturnValue(256.0F);
        }
    }
}
