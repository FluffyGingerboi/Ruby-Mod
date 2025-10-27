package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;

public class RubysSounds {

    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(
            Registries.SOUND_EVENT,
            RubyMod.MOD_ID
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_505_BREAK = REGISTRY.register(
            "disc_505_break",
            () -> SoundEvent.createFixedRangeEvent(
                    RubyMod.id(
                            "disc_505_break"),
            1f)
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_505_PLACE = REGISTRY.register(
            "disc_505_place",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_505_place"))
    );
}
