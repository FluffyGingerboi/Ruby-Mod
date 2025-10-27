package ruby.fluffy.helpme.registries;

import net.minecraft.world.level.block.SoundType;

public class RubysSoundTypes {

    public static final SoundType DISC_505 = new SoundType(
            1.0F,
            1f,
            RubysSounds.DISC_505_BREAK.get(), //Break
            RubysSounds.DISC_505_BREAK.get(),
            RubysSounds.DISC_505_PLACE.get(), //Place
            RubysSounds.DISC_505_BREAK.get(),
            RubysSounds.DISC_505_BREAK.get()

    );
}
