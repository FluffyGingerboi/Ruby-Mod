package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.blocks.items_displayed.MusicBlock;

public class RubysDisplayBlocks {

    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(Registries.BLOCK, RubyMod.MOD_ID);

    public static void setupBlocks() {
        if (ModList.get().isLoaded("ru3yydiscs")) {
            REGISTRY.register("disc_505", () -> new MusicBlock(createBlock("disc_505", SoundType.DECORATED_POT)));
        }
    }

    private static BlockBehaviour.Properties createBlock(String name, SoundType sound) {
        return createBaseProps(name).mapColor(MapColor.NONE).sound(sound);
    }

    private static BlockBehaviour.Properties createBaseProps(String name) {
        return BlockBehaviour.Properties.of().noTerrainParticles().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }
}
