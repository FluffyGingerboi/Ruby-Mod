package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.worldgen.RubysBiomeModifiers;
import ruby.fluffy.helpme.worldgen.RubysConfiguredFeatures;
import ruby.fluffy.helpme.worldgen.RubysPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RubysDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()

            .add(Registries.CONFIGURED_FEATURE, RubysConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, RubysPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, RubysBiomeModifiers::bootstrap)
            .add(Registries.ENCHANTMENT, RubysEnchantsProvider::bootstrap);

    public RubysDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(RubyMod.MOD_ID));
    }
}
