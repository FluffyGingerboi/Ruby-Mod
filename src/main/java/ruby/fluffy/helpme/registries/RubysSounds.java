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

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_BABY_IM_YOURS = REGISTRY.register(
            "disc_baby_im_yours",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_baby_im_yours"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_CRYING_LIGHTNING = REGISTRY.register(
            "disc_crying_lightning",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_crying_lightning"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_FLUORESCENT_ADOLESCENCE= REGISTRY.register(
            "disc_fluorescent_adolescence",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_fluorescent_adolescence"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_I_WANNA_BE_YOURS = REGISTRY.register(
            "disc_i_wanna_be_yours",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_i_wanna_be_yours"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_MY_PROPELLER = REGISTRY.register(
            "disc_my_propeller",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_my_propeller"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_SNAP_OUT_OF_IT = REGISTRY.register(
            "disc_snap_out_of_it",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_snap_out_of_it"))
    );

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_WHEN_THE_SUN_GOES_DOWN = REGISTRY.register(
            "disc_when_the_sun_goes_down",
            () -> SoundEvent.createVariableRangeEvent(
                    RubyMod.id(
                            "disc_when_the_sun_goes_down"))
    );
}
