package ruby.fluffy.helpme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.worldgen.RubysConfiguredFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RubysDatagenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()

            .add(Registries.CONFIGURED_FEATURE, RubysConfiguredFeatures::bootstrap);

    public RubysDatagenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(RubyMod.MOD_ID));
    }
}
