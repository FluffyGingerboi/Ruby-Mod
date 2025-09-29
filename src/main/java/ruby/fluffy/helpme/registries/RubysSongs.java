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
import ruby.fluffy.helpme.datagen.RubysDiscGen;

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

        RubysDiscGen.SONGS.add(Pair.of(
                song,
                ResourceLocation.fromNamespaceAndPath(REGISTRY.getNamespace(), id)
        ));

        return REGISTRY.register(id, () -> song);
    }
}
