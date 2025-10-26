package ruby.fluffy.helpme.items_displayed.init;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import ruby.fluffy.helpme.items_displayed.client.model.ItemDisplayModel;
import ruby.fluffy.helpme.items_displayed.client.model.PillowModel;

@EventBusSubscriber
public class DisplayModels {

    @SubscribeEvent
    public static void registerLayerDefinitions(RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ItemDisplayModel.DISPLAY, ItemDisplayModel::createBodyLayer);
        event.registerLayerDefinition(PillowModel.PILLOW, PillowModel::createBodyLayer);
    }
}
