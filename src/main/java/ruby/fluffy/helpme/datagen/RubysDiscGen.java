package ruby.fluffy.helpme.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.JukeboxSong;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RubysDiscGen implements DataProvider {
    public static final List<Pair<JukeboxSong, ResourceLocation>> SONGS = new ArrayList<>();

    private final CompletableFuture<HolderLookup.Provider> lookupProvider;
    private final PackOutput.PathProvider pathProvider;

    public RubysDiscGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        this.lookupProvider = lookupProvider;
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "jukebox_song");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return lookupProvider.thenCompose((lookup) -> CompletableFuture.allOf(SONGS.stream()
                .map((it) -> DataProvider.saveStable(
                        cache,
                        serializeSong(
                                it.getFirst(),
                                lookup
                        ),
                        pathProvider.json(it.getSecond())
                ))
                .toArray(CompletableFuture[]::new)));
    }

    @Override
    public String getName() {
        return "Jukebox Songs";
    }

    private JsonElement serializeSong(JukeboxSong song, HolderLookup.Provider lookup) {
        JsonObject obj = new JsonObject();

        obj.addProperty("sound_event", song.soundEvent().getKey().location().toString());
        obj.addProperty("length_in_seconds", song.lengthInSeconds());
        obj.addProperty("comparator_output", song.comparatorOutput());

        obj.add(
                "description",
                ComponentSerialization.CODEC.encodeStart(
                                lookup.createSerializationContext(JsonOps.INSTANCE),
                                song.description()
                        )
                        .getOrThrow(JsonParseException::new)
        );

        return obj;
    }
}
