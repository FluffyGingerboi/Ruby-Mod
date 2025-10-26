package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysBlocks;

public class RubysBlockStatesProvider extends BlockStateProvider {
    public RubysBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RubyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(RubysBlocks.BLOOCK_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.GREYPE_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.LIT_GREYPE_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.PERIOD_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.ORANG_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.YELLER_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.GREN_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.LIM_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.BLUE_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.LIT_BLUE_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.NYAN_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.PURPUR_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.MAGENTER_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.PINKY_LANTERN, "lanterns");
        blockWithItem(RubysBlocks.POO_LANTERN, "lanterns");

        blockWithItem(RubysBlocks.POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.DOUBLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.TRIPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.QUADRUPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.QUINTUPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.SEXTUPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.SEPTUPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.OCTUPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.NONUPLE_COMPACTED_POPPY_BLOCK, "poppies");
        blockWithItem(RubysBlocks.DECUPLE_COMPACTED_POPPY_BLOCK , "poppies");
    }

    private void blockWithItem(DeferredBlock<?> block, String textureFolder) {
        String name = block.getId().getPath();
        String modelName = "block/" + textureFolder + "/" + name;
        simpleBlockWithItem(
                block.get(),
                models().cubeAll(modelName, modLoc("block/" + textureFolder + "/" + name))
        );
    }
}
