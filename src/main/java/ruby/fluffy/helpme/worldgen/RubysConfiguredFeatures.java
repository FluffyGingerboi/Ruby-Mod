package ruby.fluffy.helpme.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysBlocks;

import java.util.List;
import java.util.OptionalInt;

public class RubysConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK_KEY = registerKey("flowering_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_FANCY_OAK_KEY = registerKey("flowering_fancy_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK_SELECTOR_KEY = registerKey("flowering_oak_selector");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_WHITE_WILDFLOWERS_KEY = registerKey("blue_white_wildflowers");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        var leavesProvider = new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder()
                        .add(Blocks.OAK_LEAVES.defaultBlockState(), 7)
                        .add(RubysBlocks.FLOWERING_OAK_LEAVES.get().defaultBlockState(), 3)
                        .build()
        );

        register(context, FLOWERING_OAK_SELECTOR_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(
                        List.of(new WeightedPlacedFeature(
                                PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE)
                                        .getOrThrow(FLOWERING_FANCY_OAK_KEY)), 0.1F
                        )),
                        PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE)
                                .getOrThrow(FLOWERING_OAK_KEY)) // 90% normal
                )
        );

        // Normal vanilla-style oak
        register(context, FLOWERING_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                leavesProvider,
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).build());

        // Fancy tree
        register(context, FLOWERING_FANCY_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG),
                new FancyTrunkPlacer(3, 11, 0),
                leavesProvider,
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        ).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
