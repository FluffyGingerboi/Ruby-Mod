package ruby.fluffy.helpme.items_displayed.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DisplayTags {
    public static final TagKey<Item> DISPLAYABLE = ItemTags.create(ResourceLocation.fromNamespaceAndPath("items_displayed", "displayable"));
}
