package ruby.fluffy.helpme.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import ruby.fluffy.helpme.RubyMod;

public class RubysTags {

    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> NOT_DYEABLE = createTag("not_dyeable");
        public static final TagKey<Item> ENAMEL_ARMOR = createTag("enamel_armor");
        public static final TagKey<Item> LEATHER_ARMOR = createTag("leather_armor");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, name));
        }
    }
}