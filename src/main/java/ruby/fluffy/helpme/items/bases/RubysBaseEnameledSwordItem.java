package ruby.fluffy.helpme.items.bases;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import ruby.fluffy.helpme.events.client.EnameledArmorExtensions;

import java.util.function.Consumer;

@SuppressWarnings({"deprecated", "removal"})
public class RubysBaseEnameledSwordItem extends SwordItem {

    public RubysBaseEnameledSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new EnameledArmorExtensions());
    }
}
