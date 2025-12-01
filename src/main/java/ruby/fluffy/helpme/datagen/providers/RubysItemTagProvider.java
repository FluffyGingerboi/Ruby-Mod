package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.math.IEEE754rUtils;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysItems;
import ruby.fluffy.helpme.registries.RubysTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class RubysItemTagProvider extends ItemTagsProvider {

    public RubysItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RubyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.DYEABLE)
                .add(RubysItems.ENAMELED_CHAIN_HELMET.get())
                .add(RubysItems.ENAMELED_CHAIN_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_CHAIN_LEGGINGS.get())
                .add(RubysItems.ENAMELED_CHAIN_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get())

                .add(RubysItems.ENAMELED_IRON_HELMET.get())
                .add(RubysItems.ENAMELED_IRON_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_IRON_LEGGINGS.get())
                .add(RubysItems.ENAMELED_IRON_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get())

                .add(RubysItems.ENAMELED_GOLD_HELMET.get())
                .add(RubysItems.ENAMELED_GOLD_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_GOLD_LEGGINGS.get())
                .add(RubysItems.ENAMELED_GOLD_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get())

                .add(RubysItems.ENAMELED_DIAMOND_HELMET.get())
                .add(RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_DIAMOND_LEGGINGS.get())
                .add(RubysItems.ENAMELED_DIAMOND_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get())

                .add(RubysItems.ENAMELED_NETHERITE_HELMET.get())
                .add(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_NETHERITE_LEGGINGS.get())
                .add(RubysItems.ENAMELED_NETHERITE_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get())

                .add(RubysItems.ENAMELED_IRON_HORSE_ARMOR.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get())

                .add(RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get())

                .add(RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get());

        tag(RubysTags.Items.NOT_DYEABLE)
                .add(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get())

                .add(RubysItems.FIRED_ENAMELED_IRON_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get())

                .add(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get())

                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get())

                .add(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get())

                .add(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get())

                .add(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get())

                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get());

        tag(RubysTags.Items.ENAMEL_ARMOR)
                .add(RubysItems.ENAMELED_CHAIN_HELMET.get())
                .add(RubysItems.ENAMELED_CHAIN_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_CHAIN_LEGGINGS.get())
                .add(RubysItems.ENAMELED_CHAIN_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get())

                .add(RubysItems.ENAMELED_IRON_HELMET.get())
                .add(RubysItems.ENAMELED_IRON_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_IRON_LEGGINGS.get())
                .add(RubysItems.ENAMELED_IRON_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get())

                .add(RubysItems.ENAMELED_GOLD_HELMET.get())
                .add(RubysItems.ENAMELED_GOLD_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_GOLD_LEGGINGS.get())
                .add(RubysItems.ENAMELED_GOLD_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get())

                .add(RubysItems.ENAMELED_DIAMOND_HELMET.get())
                .add(RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_DIAMOND_LEGGINGS.get())
                .add(RubysItems.ENAMELED_DIAMOND_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get())

                .add(RubysItems.ENAMELED_NETHERITE_HELMET.get())
                .add(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get())
                .add(RubysItems.ENAMELED_NETHERITE_LEGGINGS.get())
                .add(RubysItems.ENAMELED_NETHERITE_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get())

                .add(RubysItems.ENAMELED_IRON_HORSE_ARMOR.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get())

                .add(RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get())

                .add(RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get());

        tag(RubysTags.Items.LEATHER_ARMOR)
                .add(Items.LEATHER_HELMET)
                .add(Items.LEATHER_CHESTPLATE)
                .add(Items.LEATHER_LEGGINGS)
                .add(Items.LEATHER_BOOTS)
                .add(Items.LEATHER_HORSE_ARMOR);

        tag(ItemTags.HEAD_ARMOR)
                .add(RubysItems.ENAMELED_CHAIN_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get())

                .add(RubysItems.ENAMELED_IRON_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_HELMET.get())

                .add(RubysItems.ENAMELED_GOLD_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get())

                .add(RubysItems.ENAMELED_DIAMOND_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get())

                .add(RubysItems.ENAMELED_NETHERITE_HELMET.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(RubysItems.ENAMELED_CHAIN_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get())

                .add(RubysItems.ENAMELED_IRON_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get())

                .add(RubysItems.ENAMELED_GOLD_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get())

                .add(RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get())

                .add(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(RubysItems.ENAMELED_CHAIN_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get())

                .add(RubysItems.ENAMELED_IRON_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get())

                .add(RubysItems.ENAMELED_GOLD_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get())

                .add(RubysItems.ENAMELED_DIAMOND_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get())

                .add(RubysItems.ENAMELED_NETHERITE_LEGGINGS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(RubysItems.ENAMELED_CHAIN_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get())

                .add(RubysItems.ENAMELED_IRON_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get())

                .add(RubysItems.ENAMELED_GOLD_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get())

                .add(RubysItems.ENAMELED_DIAMOND_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get())

                .add(RubysItems.ENAMELED_NETHERITE_BOOTS.get())
                .add(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get());

        tag(RubysTags.Items.CHEST_LOGS)
                .add(Items.OAK_LOG)
                .add(Items.STRIPPED_OAK_LOG)
                .add(Items.BIRCH_LOG)
                .add(Items.STRIPPED_BIRCH_LOG)
                .add(Items.JUNGLE_LOG)
                .add(Items.STRIPPED_JUNGLE_LOG)
                .add(Items.DARK_OAK_LOG)
                .add(Items.STRIPPED_DARK_OAK_LOG)
                .add(Items.MANGROVE_LOG)
                .add(Items.STRIPPED_MANGROVE_LOG)
                .add(Items.CRIMSON_STEM)
                .add(Items.STRIPPED_CRIMSON_STEM)
                .add(Items.WARPED_STEM)
                .add(Items.STRIPPED_WARPED_STEM);

        tag(RubysTags.Items.CHERRY_CHEST_LOGS)
                .add(Items.CHERRY_LOG)
                .add(Items.STRIPPED_CHERRY_LOG);

        tag(RubysTags.Items.SPRUCE_CHEST_LOGS)
                .add(Items.SPRUCE_LOG)
                .add(Items.STRIPPED_SPRUCE_LOG);

        tag(Tags.Items.FOODS_RAW_MEAT)
                .add(RubysItems.RAW_SQUID_MEAT.get())
                .add(RubysItems.RAW_HORSE_MEAT.get());

        tag(Tags.Items.FOODS_COOKED_MEAT)
                .add(RubysItems.COOKED_SQUID_MEAT.get())
                .add(RubysItems.COOKED_HORSE_MEAT.get());

        tag(ItemTags.MEAT)
                .add(RubysItems.RAW_SQUID_MEAT.get())
                .add(RubysItems.COOKED_SQUID_MEAT.get())
                .add(RubysItems.RAW_HORSE_MEAT.get())
                .add(RubysItems.COOKED_HORSE_MEAT.get());

    }
}