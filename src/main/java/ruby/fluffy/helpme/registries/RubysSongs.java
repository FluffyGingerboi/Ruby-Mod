package ruby.fluffy.helpme.registries;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.datagen.providers.RubysDiscProvider;

public class RubysSongs {
    public static final DeferredRegister<JukeboxSong> REGISTRY = DeferredRegister.create(
            Registries.JUKEBOX_SONG,
            RubyMod.MOD_ID
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_505 = register(
            "disc_505",
            RubysSounds.DISC_505,
            254f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_SECRET_DOOR = register(
            "disc_secret_door",
            RubysSounds.DISC_SECRET_DOOR,
            223f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_DO_I_WANNA_KNOW = register(
            "disc_do_i_wanna_know",
            RubysSounds.DISC_DO_I_WANNA_KNOW,
            265f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_WORLD_CAVES_IN = register(
            "disc_world_caves_in",
            RubysSounds.DISC_WORLD_CAVES_IN,
            214f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_BABY_IM_YOURS = register(
            "disc_baby_im_yours",
            RubysSounds.DISC_BABY_IM_YOURS,
            152f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_CRYING_LIGHTNING = register(
            "disc_crying_lightning",
            RubysSounds.DISC_CRYING_LIGHTNING,
            224f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_FLUORESCENT_ADOLESCENCE = register(
            "disc_fluorescent_adolescence",
            RubysSounds.DISC_FLUORESCENT_ADOLESCENCE,
            183f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_I_WANNA_BE_YOURS = register(
            "disc_i_wanna_be_yours",
            RubysSounds.DISC_I_WANNA_BE_YOURS,
            183f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_MY_PROPELLER = register(
            "disc_my_propeller",
            RubysSounds.DISC_MY_PROPELLER,
            205f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_SNAP_OUT_OF_IT = register(
            "disc_snap_out_of_it",
            RubysSounds.DISC_SNAP_OUT_OF_IT,
            193f
    );

    public static final DeferredHolder<JukeboxSong, JukeboxSong> DISC_WHEN_THE_SUN_GOES_DOWN = register(
            "disc_when_the_sun_goes_down",
            RubysSounds.DISC_WHEN_THE_SUN_GOES_DOWN,
            202f
    );

    private static DeferredHolder<JukeboxSong, JukeboxSong> register(
            String id,
            Holder<SoundEvent> event,
            float length
    ) {
        var song = new JukeboxSong(
                event,
                Component.translatable("jukebox_song." + REGISTRY.getNamespace() + "." + id),
                length,
                15
        );

        RubysDiscProvider.SONGS.add(Pair.of(
                song,
                ResourceLocation.fromNamespaceAndPath(REGISTRY.getNamespace(), id)
        ));

        return REGISTRY.register(id, () -> song);
    }
}
