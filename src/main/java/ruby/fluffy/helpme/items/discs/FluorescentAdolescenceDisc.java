package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class FluorescentAdolescenceDisc extends Item {
    public FluorescentAdolescenceDisc() {
        super(new Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_FLUORESCENT_ADOLESCENCE.getKey())
        );
    }
}
