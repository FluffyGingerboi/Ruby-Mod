package ruby.fluffy.helpme.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import ruby.fluffy.helpme.datagen.providers.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class RubysDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // ---- TAGS FIRST ----
        RubysBlockTagsProvider blockTagsProvider =
                new RubysBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        RubysItemTagProvider itemTagsProvider =
                new RubysItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper);
        generator.addProvider(event.includeServer(), itemTagsProvider);

        // ---- RECIPES (runs after tags) ----
        generator.addProvider(event.includeServer(), new RubysRecipesProvider(packOutput, lookupProvider));

        // ---- OTHER PROVIDERS ----
        generator.addProvider(event.includeServer(), new RubysDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ColonThreeLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new RubysItemModelsProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new RubysBlockStatesProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new RubysGlobalLootModifersProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(),
                new LootTableProvider(
                        packOutput,
                        Collections.emptySet(),
                        List.of(
                                new LootTableProvider.SubProviderEntry(RubysLootTableProvider::new, LootContextParamSets.BLOCK)
                        ),
                        lookupProvider
                )
        );
    }
}
