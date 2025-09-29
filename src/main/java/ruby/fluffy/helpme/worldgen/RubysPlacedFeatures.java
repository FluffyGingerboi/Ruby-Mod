package ruby.fluffy.helpme.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import ruby.fluffy.helpme.RubyMod;

import java.util.List;

public class RubysPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FLOWERING_OAK_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "flowering_oak"));

    public static void bootstrap(BootstrapContext<PlacedFeature> ctx) {
        ctx.register(
                FLOWERING_OAK_PLACED_KEY,
                new PlacedFeature(
                        ctx.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(RubysConfiguredFeatures.FLOWERING_OAK_SELECTOR_KEY),
                        List.of(
                                RarityFilter.onAverageOnceEvery(100), // ~1% chance per chunk
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );
    }
}
