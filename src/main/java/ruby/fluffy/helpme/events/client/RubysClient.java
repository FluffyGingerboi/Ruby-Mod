package ruby.fluffy.helpme.events.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import ruby.fluffy.helpme.registries.RubysBlocks;

@EventBusSubscriber(Dist.CLIENT)
public class RubysClient {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        RubysBlockColors.registerBlockColors();
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.FLOWERING_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.POTTED_FLOWERING_OAK_SAPLING.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void doClientStuff(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get(), ChestRenderer::new);
    }
}
