package ruby.fluffy.helpme.worldgen;

import net.minecraft.world.level.block.grower.TreeGrower;
import ruby.fluffy.helpme.RubyMod;

import java.util.Optional;

public class RubysTreeGrowers {
    public static final TreeGrower FLOWERING_OAK = new TreeGrower(
            RubyMod.MOD_ID + ":flowering_oak",
            Optional.empty(),
            Optional.of(RubysConfiguredFeatures.FLOWERING_OAK_SELECTOR_KEY), // <- selector used here
            Optional.empty()
    );
}
