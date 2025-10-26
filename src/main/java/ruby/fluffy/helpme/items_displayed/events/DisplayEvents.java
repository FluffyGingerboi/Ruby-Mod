package ruby.fluffy.helpme.items_displayed.events;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.TagsUpdatedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import ruby.fluffy.helpme.items_displayed.init.DisplayBlocks;
import ruby.fluffy.helpme.items_displayed.init.DisplayTags;
import ruby.fluffy.helpme.items_displayed.util.BlockAssociations;

import java.util.Optional;

@EventBusSubscriber
public class DisplayEvents {

    @SubscribeEvent
    public static void onBlockCheck(RightClickBlock event) {
        if (event.getEntity().isCrouching() && event.getItemStack().is(DisplayTags.DISPLAYABLE)) {
            DisplayManager.placeItem(event.getEntity(), event.getLevel(), event.getHitVec(), event.getHand() == InteractionHand.MAIN_HAND);
        }
    }

    @SubscribeEvent
    public static void onItemCheck(RightClickItem event) {
        if (event.getEntity().isCrouching() && event.getItemStack().is(DisplayTags.DISPLAYABLE)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onTags(TagsUpdatedEvent event) {
        Optional<Named<Item>> items = event.getRegistryAccess().lookupOrThrow(Registries.ITEM).get(DisplayTags.DISPLAYABLE);
        if (items.isPresent()) {
            for (Holder<Item> target : items.get()) {
                for (DeferredHolder<Block, ? extends Block> block : DisplayBlocks.REGISTRY.getEntries()) {
                    if (target.getRegisteredName().contains(block.getId().getPath()) && BlockAssociations.getItemFor(block.get()) == Items.AIR) {
                        BlockAssociations.addToMap(target.value(), block.get());
                        break;
                    }
                }
            }
        }
    }
}
