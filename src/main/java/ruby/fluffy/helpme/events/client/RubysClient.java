package ruby.fluffy.helpme.events.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import ruby.fluffy.helpme.client.renderers.RubysHorseArmorRenderer;
import ruby.fluffy.helpme.displays.screens.KilnScreen;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysMenus;

@SuppressWarnings("deprecation")
@EventBusSubscriber(Dist.CLIENT)
public class RubysClient {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        RubysBlockColors.registerBlockColors();
        RubysItemColors.registerItemColors();
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.FLOWERING_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.POTTED_FLOWERING_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.BLUE_WHITE_WILDFLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.PURPLE_WHITE_WILDFLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RubysBlocks.GRASS_SLAB.get(), RenderType.cutoutMipped());
    }

    @SubscribeEvent
    public static void doClientStuff(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get(), ChestRenderer::new);
    }

    @SubscribeEvent
    public static void screenSetup(RegisterMenuScreensEvent event) {
        event.register(RubysMenus.KILN_MENU.get(), KilnScreen::new);
    }

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        var renderer = event.getRenderer(EntityType.HORSE);

        if (renderer instanceof HorseRenderer horseRenderer) {
            horseRenderer.addLayer(new RubysHorseArmorRenderer(
                    horseRenderer,
                    event.getEntityModels()
            ));
        }
    }
}
