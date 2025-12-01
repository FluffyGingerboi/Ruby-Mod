package ruby.fluffy.helpme.items.bases;

import net.minecraft.core.Holder;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import ruby.fluffy.helpme.events.client.EnameledArmorExtensions;
import ruby.fluffy.helpme.utilites.interfaces.IEnameled;

import java.util.function.Consumer;

@SuppressWarnings({"deprecated", "removal"})
public class RubysBaseEnameledHorseArmorItem extends AnimalArmorItem implements IEnameled {

    public RubysBaseEnameledHorseArmorItem(Holder<ArmorMaterial> armorMaterial, BodyType bodyType, boolean hasOverlay, Properties properties) {
        super(armorMaterial, bodyType, hasOverlay, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new EnameledArmorExtensions());
    }
}
