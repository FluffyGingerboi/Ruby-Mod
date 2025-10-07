package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class IWannaBeYoursDisc extends Item {
    public IWannaBeYoursDisc() {
        super(new Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_I_WANNA_BE_YOURS.getKey())
        );
    }
}
