package ruby.fluffy.helpme;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import ruby.fluffy.helpme.registries.*;

@Mod(RubyMod.MOD_ID)
public class RubyMod {
    public static final String MOD_ID = "ru3yy";
    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
    public static final Logger LOGGER = LogUtils.getLogger();

    public RubyMod(IEventBus rubyBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.register(this);

        RubysItems.REGISTRY.register(rubyBus);
        RubysItems.ITEMS.register(rubyBus);
        RubysCreativeTabs.REGISTRY.register(rubyBus);
        RubysSongs.REGISTRY.register(rubyBus);
        RubysSounds.REGISTRY.register(rubyBus);
        RubysBlocks.registerBlocks(rubyBus);
        RubysItems.registerItems(rubyBus);
        rubyBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    RubysBlocks.FLOWERING_OAK_SAPLING.getId(),
                    RubysBlocks.POTTED_FLOWERING_OAK_SAPLING
            );
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Blame ruby chat");
    }
}
