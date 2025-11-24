package ruby.fluffy.helpme;

import com.google.common.collect.Lists;
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
import org.slf4j.Logger;
import ruby.fluffy.helpme.configs.SlabsConfig;
import ruby.fluffy.helpme.datagen.RubysDatagen;
import ruby.fluffy.helpme.datagen.providers.RubysRecipesProvider;
import ruby.fluffy.helpme.events.RubysEvents;
import ruby.fluffy.helpme.items_displayed.init.*;
import ruby.fluffy.helpme.registries.*;
import ruby.fluffy.helpme.utilites.RubysConfig;
import ruby.fluffy.helpme.utilites.RubysRecipeData;

@Mod(RubyMod.MOD_ID)
public class RubyMod {
    public static final String MOD_ID = "ru3yy";
    public static ResourceLocation id(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
    public static final Logger LOGGER = LogUtils.getLogger();

    public RubyMod(IEventBus rubyBus, ModContainer rubyContainer) {
        NeoForge.EVENT_BUS.register(this);

        RubysItems.REGISTRY.register(rubyBus);
        RubysSounds.REGISTRY.register(rubyBus);
        RubysItems.ITEMS.register(rubyBus);
        RubysCreativeTabs.REGISTRY.register(rubyBus);
        RubysBlocks.registerBlocks(rubyBus);
        RubysItems.registerItems(rubyBus);
        RubysRecipes.SERIALIZERS.register(rubyBus);
        RubysRecipes.TYPES.register(rubyBus);
        RubysMenus.MENUS.register(rubyBus);
        RubysArmorMaterials.ARMOR_MATERIALS.register(rubyBus);
        rubyBus.addListener(this::commonSetup);

        /**
         * NOT MY CODE, courtesy of Items Displayed {@link https://modrinth.com/mod/items-displayed-forge/versions}
         **/

        DisplayMobs.REGISTRY.register(rubyBus);
        DisplayBlocks.REGISTRY.register(rubyBus);
        DisplayItems.REGISTRY.register(rubyBus);
        DisplayTabs.REGISTRY.register(rubyBus);
        DisplayBlocks.setupBlocks();
        DisplayItems.setupBlockItems();

        RubysEvents.init();
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("I love you cookie, I always will :heart: :3");
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(
                    RubysBlocks.FLOWERING_OAK_SAPLING.getId(),
                    RubysBlocks.POTTED_FLOWERING_OAK_SAPLING
            );
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("She is sooooo cute am I right? If you don't agree I am legally obligated and allowed to murder you :3");
    }
}
