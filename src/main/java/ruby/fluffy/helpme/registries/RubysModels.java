package ruby.fluffy.helpme.registries;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import ruby.fluffy.helpme.client.model.ItemDisplayModel;

@EventBusSubscriber
public class RubysModels {
    public static final ModelLayerLocation DISPLAY = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ru3yy", "display"), "main");

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DISPLAY, ItemDisplayModel::createBodyLayer);
    }
}
