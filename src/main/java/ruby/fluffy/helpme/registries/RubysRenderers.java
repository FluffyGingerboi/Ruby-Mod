package ruby.fluffy.helpme.registries;

import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import ruby.fluffy.helpme.client.renderer.ItemDisplayRenderer;

public class RubysRenderers {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType)RubysEntities.DISPLAY.get(), ItemDisplayRenderer::new);
    }
}
