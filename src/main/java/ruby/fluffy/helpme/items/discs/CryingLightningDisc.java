package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class CryingLightningDisc extends Item {
    public CryingLightningDisc() {
        super(new Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_CRYING_LIGHTNING.getKey())
        );
    }
}
