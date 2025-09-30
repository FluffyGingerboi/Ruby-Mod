package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class SecretDoorDisc extends Item{
    public SecretDoorDisc() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_SECRET_DOOR.getKey())
        );
    }
}
