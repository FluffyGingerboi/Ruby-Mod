package ruby.fluffy.helpme.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import ruby.fluffy.helpme.registries.RubysBlocks;

import java.util.Set;

public class RubysLootTableGen extends BlockLootSubProvider {
    protected RubysLootTableGen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        this.dropSelf(RubysBlocks.YELLER_LANTERN.get());
        this.dropSelf(RubysBlocks.LIT_BLUE_LANTERN.get());
        this.dropSelf(RubysBlocks.RED_LANTERN.get());
        this.dropSelf(RubysBlocks.GREN_LANTERN.get());
        this.dropSelf(RubysBlocks.PURPUR_LANTERN.get());
        this.dropSelf(RubysBlocks.YELLER_LANTERN.get());
        this.dropSelf(RubysBlocks.BLUE_LANTERN.get());
        this.dropSelf(RubysBlocks.ORANGE_LANTERN.get());

        this.dropSelf(RubysBlocks.LOG_STAIRS.get());

        add(RubysBlocks.DIRT_SLAB.get(),
                block -> createSlabItemTable(RubysBlocks.DIRT_SLAB.get()));
        add(RubysBlocks.GRAVEL_SLAB.get(),
                block -> createSlabItemTable(RubysBlocks.GRAVEL_SLAB.get()));

        this.dropSelf(RubysBlocks.FLOWERING_OAK_SAPLING.get());
        add(RubysBlocks.POTTED_FLOWERING_OAK_SAPLING.get(),
                block -> createPotFlowerItemTable(RubysBlocks.FLOWERING_OAK_SAPLING));

        this.add(RubysBlocks.FLOWERING_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, RubysBlocks.FLOWERING_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RubysBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
