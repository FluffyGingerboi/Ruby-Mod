package ruby.fluffy.helpme.items.discs;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import ruby.fluffy.helpme.registries.RubysSongs;

public class WorldCavesInDisc extends Item {
    public WorldCavesInDisc() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.RARE)
                .jukeboxPlayable(RubysSongs.DISC_WORLD_CAVES_IN.getKey())
        );
    }
}
