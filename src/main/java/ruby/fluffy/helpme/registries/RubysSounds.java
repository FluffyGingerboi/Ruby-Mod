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

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_SECRET_DOOR = REGISTRY.register(
            "disc_secret_door",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_secret_door"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_DO_I_WANNA_KNOW = REGISTRY.register(
            "disc_do_i_wanna_know",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_do_i_wanna_know"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_WORLD_CAVES_IN = REGISTRY.register(
            "disc_world_caves_in",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_world_caves_in"))
    );
}
