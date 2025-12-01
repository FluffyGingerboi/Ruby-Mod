package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import ruby.fluffy.helpme.registries.RubysBlocks;

import java.util.Set;

public class RubysLootTableProvider extends BlockLootSubProvider {
    public RubysLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        this.dropSelf(RubysBlocks.YELLER_LANTERN.get());
        this.dropSelf(RubysBlocks.LIT_BLUE_LANTERN.get());
        this.dropSelf(RubysBlocks.PERIOD_LANTERN.get());
        this.dropSelf(RubysBlocks.GREN_LANTERN.get());
        this.dropSelf(RubysBlocks.PURPUR_LANTERN.get());
        this.dropSelf(RubysBlocks.YELLER_LANTERN.get());
        this.dropSelf(RubysBlocks.BLUE_LANTERN.get());
        this.dropSelf(RubysBlocks.ORANG_LANTERN.get());
        this.dropSelf(RubysBlocks.NYAN_LANTERN.get());
        this.dropSelf(RubysBlocks.LIT_GREYPE_LANTERN.get());
        this.dropSelf(RubysBlocks.GREYPE_LANTERN.get());
        this.dropSelf(RubysBlocks.BLOOCK_LANTERN.get());
        this.dropSelf(RubysBlocks.LIM_LANTERN.get());
        this.dropSelf(RubysBlocks.MAGENTER_LANTERN.get());
        this.dropSelf(RubysBlocks.PINKY_LANTERN.get());
        this.dropSelf(RubysBlocks.POO_LANTERN.get());

        this.dropSelf(RubysBlocks.POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.DOUBLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.TRIPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.QUADRUPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.QUINTUPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.SEXTUPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.SEPTUPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.OCTUPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.NONUPLE_COMPACTED_POPPY_BLOCK.get());
        this.dropSelf(RubysBlocks.DECUPLE_COMPACTED_POPPY_BLOCK.get());

        this.dropSelf(RubysBlocks.CHERRY_CHEST.get());
        this.dropSelf(RubysBlocks.SPRUCE_CHEST.get());

        this.dropSelf(RubysBlocks.KILN.get());

        this.dropSelf(RubysBlocks.LOG_STAIRS.get());

        add(RubysBlocks.DIRT_SLAB.get(),
                block -> createSlabItemTable(RubysBlocks.DIRT_SLAB.get()));
        add(RubysBlocks.GRAVEL_SLAB.get(),
                block -> createSlabItemTable(RubysBlocks.GRAVEL_SLAB.get()));
        add(RubysBlocks.SAND_SLAB.get(),
                block -> createSlabItemTable(RubysBlocks.SAND_SLAB.get()));
        add(RubysBlocks.GRASS_SLAB.get(),
                block -> createSlabItemTable(RubysBlocks.DIRT_SLAB.get()));

        add(RubysBlocks.BLUE_WHITE_WILDFLOWERS.get(),
                block -> createPetalsDrops(RubysBlocks.BLUE_WHITE_WILDFLOWERS.get()));
        add(RubysBlocks.PURPLE_WHITE_WILDFLOWERS.get(),
                block -> createPetalsDrops(RubysBlocks.PURPLE_WHITE_WILDFLOWERS.get()));

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
