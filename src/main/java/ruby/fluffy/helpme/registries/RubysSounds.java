package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;

public class RubysSounds {

    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, RubyMod.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_505_BREAK =
            registerSound("disc_505_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_505_PLACE =
            registerSound("disc_505_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_FLUORESCENT_ADOLESCENCE_BREAK =
            registerSound("disc_fluorescent_adolescence_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_FLUORESCENT_ADOLESCENCE_PLACE =
            registerSound("disc_fluorescent_adolescence_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_SECRET_DOOR_BREAK =
            registerSound("disc_secret_door_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_SECRET_DOOR_PLACE =
            registerSound("disc_secret_door_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_CRYING_LIGHTNING_BREAK =
            registerSound("disc_crying_lightning_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_CRYING_LIGHTNING_PLACE =
            registerSound("disc_crying_lightning_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_MY_PROPELLER_BREAK =
            registerSound("disc_my_propeller_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_MY_PROPELLER_PLACE =
            registerSound("disc_my_propeller_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_DO_I_WANNA_KNOW_BREAK =
            registerSound("disc_do_i_wanna_know_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_DO_I_WANNA_KNOW_PLACE =
            registerSound("disc_do_i_wanna_know_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_I_WANNA_BE_YOURS_BREAK =
            registerSound("disc_i_wanna_be_yours_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_I_WANNA_BE_YOURS_PLACE =
            registerSound("disc_i_wanna_be_yours_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_SNAP_OUT_OF_IT_BREAK =
            registerSound("disc_snap_out_of_it_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_SNAP_OUT_OF_IT_PLACE =
            registerSound("disc_snap_out_of_it_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_WHEN_THE_SUN_GOES_DOWN_BREAK =
            registerSound("disc_when_the_sun_goes_down_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_WHEN_THE_SUN_GOES_DOWN_PLACE =
            registerSound("disc_when_the_sun_goes_down_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_BABY_IM_YOURS_BREAK =
            registerSound("disc_baby_im_yours_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_BABY_IM_YOURS_PLACE =
            registerSound("disc_baby_im_yours_place");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_AS_THE_WORLD_CAVES_IN_BREAK =
            registerSound("disc_as_the_world_caves_in_break");

    public static final DeferredHolder<SoundEvent, SoundEvent> DISC_AS_THE_WORLD_CAVES_IN_PLACE =
            registerSound("disc_as_the_world_caves_in_place");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSound(String soundName) {
        return REGISTRY.register(soundName, () -> SoundEvent.createVariableRangeEvent(
                ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, soundName)));
    }
}