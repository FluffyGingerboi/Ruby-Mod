package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;

public class RubysSounds {

    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(
            Registries.SOUND_EVENT,
            RubyMod.MOD_ID
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_505 = REGISTRY.register(
            "disc_505",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_505"))
    );
}
