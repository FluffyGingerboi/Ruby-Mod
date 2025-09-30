package ruby.fluffy.helpme.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import ruby.fluffy.helpme.registries.RubysBlocks;

@EventBusSubscriber
public class RubysEvents {

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get(),
                (be, context) -> new InvWrapper(be.getContainer())
        );
    }
}
