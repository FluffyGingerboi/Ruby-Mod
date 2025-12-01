package ruby.fluffy.helpme.items.bases;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import ruby.fluffy.helpme.events.client.EnameledArmorExtensions;
import ruby.fluffy.helpme.utilites.interfaces.IEnameled;

import java.util.function.Consumer;

@SuppressWarnings({"deprecated", "removal"})
public class RubysBaseEnameledArmorItem extends ArmorItem implements IEnameled {

    public RubysBaseEnameledArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new EnameledArmorExtensions());
    }
}
