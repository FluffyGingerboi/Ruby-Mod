package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.datagen.helpers.RubysItemModelsHelpers;
import ruby.fluffy.helpme.registries.RubysItems;

public class RubysItemModelsProvider extends RubysItemModelsHelpers {

    public RubysItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RubyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(RubysItems.MORTAR_AND_PESTLE.get());
        basicItem(RubysItems.SAW.get());
        basicItem(RubysItems.SCRAPER.get());
        basicItem(RubysItems.ENAMEL.get());
        basicItem(RubysItems.RAW_SQUID_MEAT.get());
        basicItem(RubysItems.COOKED_SQUID_MEAT.get());
        basicItem(RubysItems.RAW_HORSE_MEAT.get());
        basicItem(RubysItems.COOKED_HORSE_MEAT.get());

        dyedItem(RubysItems.ENAMELED_IRON_HORSE_ARMOR.get(), "armor/horse_armor/", "enameled_iron_horse_armor");
        dyedItem(RubysItems.ENAMELED_GOLD_HORSE_ARMOR.get(), "armor/horse_armor/", "enameled_gold_horse_armor");
        dyedItem(RubysItems.ENAMELED_DIAMOND_HORSE_ARMOR.get(), "armor/horse_armor/", "enameled_diamond_horse_armor");

        dyedItem(RubysItems.FIRED_ENAMELED_IRON_HORSE_ARMOR.get(), "armor/horse_armor/", "enameled_iron_horse_armor");
        dyedItem(RubysItems.FIRED_ENAMELED_GOLD_HORSE_ARMOR.get(), "armor/horse_armor/", "enameled_gold_horse_armor");
        dyedItem(RubysItems.FIRED_ENAMELED_DIAMOND_HORSE_ARMOR.get(), "armor/horse_armor/", "enameled_diamond_horse_armor");

        helmetItem(RubysItems.ENAMELED_CHAIN_HELMET.get(), "armor/chainmail/", "enameled_chainmail_helmet");
        chestplateItem(RubysItems.ENAMELED_CHAIN_CHESTPLATE.get(), "armor/chainmail/", "enameled_chainmail_chestplate");
        leggingsItem(RubysItems.ENAMELED_CHAIN_LEGGINGS.get(), "armor/chainmail/", "enameled_chainmail_leggings");
        bootsItem(RubysItems.ENAMELED_CHAIN_BOOTS.get(), "armor/chainmail/", "enameled_chainmail_boots");

        helmetItem(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get(), "armor/chainmail/", "enameled_chainmail_helmet");
        chestplateItem(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get(), "armor/chainmail/", "enameled_chainmail_chestplate");
        leggingsItem(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get(), "armor/chainmail/", "enameled_chainmail_leggings");
        bootsItem(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get(), "armor/chainmail/", "enameled_chainmail_boots");

        helmetItem(RubysItems.ENAMELED_IRON_HELMET.get(), "armor/iron/", "enameled_iron_helmet");
        chestplateItem(RubysItems.ENAMELED_IRON_CHESTPLATE.get(), "armor/iron/", "enameled_iron_chestplate");
        leggingsItem(RubysItems.ENAMELED_IRON_LEGGINGS.get(), "armor/iron/", "enameled_iron_leggings");
        bootsItem(RubysItems.ENAMELED_IRON_BOOTS.get(), "armor/iron/", "enameled_iron_boots");

        helmetItem(RubysItems.FIRED_ENAMELED_IRON_HELMET.get(), "armor/iron/", "enameled_iron_helmet");
        chestplateItem(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get(), "armor/iron/", "enameled_iron_chestplate");
        leggingsItem(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get(), "armor/iron/", "enameled_iron_leggings");
        bootsItem(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get(), "armor/iron/", "enameled_iron_boots");

        helmetItem(RubysItems.ENAMELED_GOLD_HELMET.get(), "armor/golden/", "enameled_golden_helmet");
        chestplateItem(RubysItems.ENAMELED_GOLD_CHESTPLATE.get(), "armor/golden/", "enameled_golden_chestplate");
        leggingsItem(RubysItems.ENAMELED_GOLD_LEGGINGS.get(), "armor/golden/", "enameled_golden_leggings");
        bootsItem(RubysItems.ENAMELED_GOLD_BOOTS.get(), "armor/golden/", "enameled_golden_boots");

        helmetItem(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get(), "armor/golden/", "enameled_golden_helmet");
        chestplateItem(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get(), "armor/golden/", "enameled_golden_chestplate");
        leggingsItem(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get(), "armor/golden/", "enameled_golden_leggings");
        bootsItem(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get(), "armor/golden/", "enameled_golden_boots");

        helmetItem(RubysItems.ENAMELED_DIAMOND_HELMET.get(), "armor/diamond/", "enameled_diamond_helmet");
        chestplateItem(RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get(), "armor/diamond/", "enameled_diamond_chestplate");
        leggingsItem(RubysItems.ENAMELED_DIAMOND_LEGGINGS.get(), "armor/diamond/", "enameled_diamond_leggings");
        bootsItem(RubysItems.ENAMELED_DIAMOND_BOOTS.get(), "armor/diamond/", "enameled_diamond_boots");

        helmetItem(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get(), "armor/diamond/", "enameled_diamond_helmet");
        chestplateItem(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get(), "armor/diamond/", "enameled_diamond_chestplate");
        leggingsItem(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get(), "armor/diamond/", "enameled_diamond_leggings");
        bootsItem(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get(), "armor/diamond/", "enameled_diamond_boots");

        helmetItem(RubysItems.ENAMELED_NETHERITE_HELMET.get(), "armor/netherite/", "enameled_netherite_helmet");
        chestplateItem(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get(), "armor/netherite/", "enameled_netherite_chestplate");
        leggingsItem(RubysItems.ENAMELED_NETHERITE_LEGGINGS.get(), "armor/netherite/", "enameled_netherite_leggings");
        bootsItem(RubysItems.ENAMELED_NETHERITE_BOOTS.get(), "armor/netherite/", "enameled_netherite_boots");

        helmetItem(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get(), "armor/netherite/", "enameled_netherite_helmet");
        chestplateItem(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get(), "armor/netherite/", "enameled_netherite_chestplate");
        leggingsItem(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get(), "armor/netherite/", "enameled_netherite_leggings");
        bootsItem(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get(), "armor/netherite/", "enameled_netherite_boots");
    }
}
