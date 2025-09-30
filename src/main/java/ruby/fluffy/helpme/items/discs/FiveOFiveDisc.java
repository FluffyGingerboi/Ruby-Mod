package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class FiveOFiveDisc extends Item {
    public FiveOFiveDisc() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_505.getKey())
        );
    }
}
