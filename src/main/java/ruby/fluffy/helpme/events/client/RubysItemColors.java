package ruby.fluffy.helpme.events.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.DyedItemColor;
import ruby.fluffy.helpme.registries.RubysItems;

@SuppressWarnings("deprecation")
public class RubysItemColors {

    public static void registerItemColors() {
        ItemColors colors = Minecraft.getInstance().getItemColors();

        colors.register(
                (stack, tintIndex) -> tintIndex > 0 ? -1 : (stack.has(DataComponents.DYED_COLOR)
                        ? DyedItemColor.getOrDefault(stack, tintIndex)
                        : -1),
                RubysItems.ENAMELED_CHAIN_HELMET.get(),
                RubysItems.ENAMELED_CHAIN_CHESTPLATE.get(),
                RubysItems.ENAMELED_CHAIN_LEGGINGS.get(),
                RubysItems.ENAMELED_CHAIN_BOOTS.get(),
                RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get(),
                RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get(),
                RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get(),
                RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get(),

                RubysItems.ENAMELED_IRON_HELMET.get(),
                RubysItems.ENAMELED_IRON_CHESTPLATE.get(),
                RubysItems.ENAMELED_IRON_LEGGINGS.get(),
                RubysItems.ENAMELED_IRON_BOOTS.get(),
                RubysItems.FIRED_ENAMELED_IRON_HELMET.get(),
                RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get(),
                RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get(),
                RubysItems.FIRED_ENAMELED_IRON_BOOTS.get(),

                RubysItems.ENAMELED_GOLD_HELMET.get(),
                RubysItems.ENAMELED_GOLD_CHESTPLATE.get(),
                RubysItems.ENAMELED_GOLD_LEGGINGS.get(),
                RubysItems.ENAMELED_GOLD_BOOTS.get(),
                RubysItems.FIRED_ENAMELED_GOLD_HELMET.get(),
                RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get(),
                RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get(),
                RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get(),

                RubysItems.ENAMELED_DIAMOND_HELMET.get(),
                RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get(),
                RubysItems.ENAMELED_DIAMOND_LEGGINGS.get(),
                RubysItems.ENAMELED_DIAMOND_BOOTS.get(),
                RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get(),
                RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get(),
                RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get(),
                RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get(),

                RubysItems.ENAMELED_NETHERITE_HELMET.get(),
                RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get(),
                RubysItems.ENAMELED_NETHERITE_LEGGINGS.get(),
                RubysItems.ENAMELED_NETHERITE_BOOTS.get(),
                RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get(),
                RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get(),
                RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get(),
                RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get(),

                RubysItems.ENAMELED_IRON_HORSE_ARMOR.get(),
                RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get(),

                RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get(),
                RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get(),

                RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get(),
                RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get()
        );
    }
}
