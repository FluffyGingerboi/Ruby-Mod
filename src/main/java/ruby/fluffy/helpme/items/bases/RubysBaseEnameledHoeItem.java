package ruby.fluffy.helpme.items.bases;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import ruby.fluffy.helpme.events.client.EnameledArmorExtensions;

import java.util.function.Consumer;

@SuppressWarnings({"deprecated", "removal"})
public class RubysBaseEnameledHoeItem extends HoeItem {

    public RubysBaseEnameledHoeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new EnameledArmorExtensions());
    }
}
