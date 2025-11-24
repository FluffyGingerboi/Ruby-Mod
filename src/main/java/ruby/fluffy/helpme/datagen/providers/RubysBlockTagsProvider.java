package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysBlocks;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class RubysBlockTagsProvider extends BlockTagsProvider {
    public RubysBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RubyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(RubysBlocks.COBBLESTONE_KILN.get());

        tag(BlockTags.SLABS)
                .add(RubysBlocks.GRASS_SLAB.get())
                .add(RubysBlocks.DIRT_SLAB.get())
                .add(RubysBlocks.GRAVEL_SLAB.get())
                .add(RubysBlocks.SAND_SLAB.get());
    }
}
