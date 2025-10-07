package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class WhenTheSunGoesDownDisc extends Item {
    public WhenTheSunGoesDownDisc() {
        super(new Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_WHEN_THE_SUN_GOES_DOWN.getKey())
        );
    }
}
