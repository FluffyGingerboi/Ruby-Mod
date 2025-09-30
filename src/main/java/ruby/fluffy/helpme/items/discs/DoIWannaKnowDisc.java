package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class DoIWannaKnowDisc extends Item {
    public DoIWannaKnowDisc() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_DO_I_WANNA_KNOW.getKey())
        );
    }
}
