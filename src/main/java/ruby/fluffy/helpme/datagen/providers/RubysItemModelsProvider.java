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

        helmetItem(RubysItems.ENAMELED_CHAIN_HELMET.get(), "armor/chainmail/", "enameled_chainmail_helmet", "enameled_chainmail_helmet_overlay");
        chestplateItem(RubysItems.ENAMELED_CHAIN_CHESTPLATE.get(), "armor/chainmail/", "enameled_chainmail_chestplate", "enameled_chainmail_chestplate_overlay");
        leggingsItem(RubysItems.ENAMELED_CHAIN_LEGGINGS.get(), "armor/chainmail/", "enameled_chainmail_leggings", "enameled_chainmail_leggings_overlay");
        bootsItem(RubysItems.ENAMELED_CHAIN_BOOTS.get(), "armor/chainmail/", "enameled_chainmail_boots", "enameled_chainmail_boots_overlay");

        helmetItem(RubysItems.FIRED_ENAMELED_CHAIN_HELMET.get(), "armor/chainmail/", "enameled_chainmail_helmet", "enameled_chainmail_helmet_overlay");
        chestplateItem(RubysItems.FIRED_ENAMELED_CHAIN_CHESTPLATE.get(), "armor/chainmail/", "enameled_chainmail_chestplate", "enameled_chainmail_chestplate_overlay");
        leggingsItem(RubysItems.FIRED_ENAMELED_CHAIN_LEGGINGS.get(), "armor/chainmail/", "enameled_chainmail_leggings", "enameled_chainmail_helmet_overlay");
        bootsItem(RubysItems.FIRED_ENAMELED_CHAIN_BOOTS.get(), "armor/chainmail/", "enameled_chainmail_boots", "enameled_chainmail_boots_overlay");

        helmetItem(RubysItems.ENAMELED_IRON_HELMET.get(), "armor/iron/", "enameled_iron_helmet", "enameled_iron_helmet_overlay");
        chestplateItem(RubysItems.ENAMELED_IRON_CHESTPLATE.get(), "armor/iron/", "enameled_iron_chestplate", "enameled_iron_chestplate_overlay");
        leggingsItem(RubysItems.ENAMELED_IRON_LEGGINGS.get(), "armor/iron/", "enameled_iron_leggings", "enameled_iron_leggings_overlay");
        bootsItem(RubysItems.ENAMELED_IRON_BOOTS.get(), "armor/iron/", "enameled_iron_boots", "enameled_iron_boots_overlay");

        helmetItem(RubysItems.FIRED_ENAMELED_IRON_HELMET.get(), "armor/iron/", "enameled_iron_helmet", "enameled_iron_helmet_overlay");
        chestplateItem(RubysItems.FIRED_ENAMELED_IRON_CHESTPLATE.get(), "armor/iron/", "enameled_iron_chestplate", "enameled_iron_chestplate_overlay");
        leggingsItem(RubysItems.FIRED_ENAMELED_IRON_LEGGINGS.get(), "armor/iron/", "enameled_iron_leggings", "enameled_iron_helmet_overlay");
        bootsItem(RubysItems.FIRED_ENAMELED_IRON_BOOTS.get(), "armor/iron/", "enameled_iron_boots", "enameled_iron_boots_overlay");

        helmetItem(RubysItems.ENAMELED_GOLD_HELMET.get(), "armor/golden/", "enameled_golden_helmet", "enameled_golden_helmet_overlay");
        chestplateItem(RubysItems.ENAMELED_GOLD_CHESTPLATE.get(), "armor/golden/", "enameled_golden_chestplate", "enameled_golden_chestplate_overlay");
        leggingsItem(RubysItems.ENAMELED_GOLD_LEGGINGS.get(), "armor/golden/", "enameled_golden_leggings", "enameled_golden_leggings_overlay");
        bootsItem(RubysItems.ENAMELED_GOLD_BOOTS.get(), "armor/golden/", "enameled_golden_boots", "enameled_golden_boots_overlay");

        helmetItem(RubysItems.FIRED_ENAMELED_GOLD_HELMET.get(), "armor/golden/", "enameled_golden_helmet", "enameled_golden_helmet_overlay");
        chestplateItem(RubysItems.FIRED_ENAMELED_GOLD_CHESTPLATE.get(), "armor/golden/", "enameled_golden_chestplate", "enameled_golden_chestplate_overlay");
        leggingsItem(RubysItems.FIRED_ENAMELED_GOLD_LEGGINGS.get(), "armor/golden/", "enameled_golden_leggings", "enameled_golden_helmet_overlay");
        bootsItem(RubysItems.FIRED_ENAMELED_GOLD_BOOTS.get(), "armor/golden/", "enameled_golden_boots", "enameled_golden_boots_overlay");

        helmetItem(RubysItems.ENAMELED_DIAMOND_HELMET.get(), "armor/diamond/", "enameled_diamond_helmet", "enameled_diamond_helmet_overlay");
        chestplateItem(RubysItems.ENAMELED_DIAMOND_CHESTPLATE.get(), "armor/diamond/", "enameled_diamond_chestplate", "enameled_diamond_chestplate_overlay");
        leggingsItem(RubysItems.ENAMELED_DIAMOND_LEGGINGS.get(), "armor/diamond/", "enameled_diamond_leggings", "enameled_diamond_leggings_overlay");
        bootsItem(RubysItems.ENAMELED_DIAMOND_BOOTS.get(), "armor/diamond/", "enameled_diamond_boots", "enameled_diamond_boots_overlay");

        helmetItem(RubysItems.FIRED_ENAMELED_DIAMOND_HELMET.get(), "armor/diamond/", "enameled_diamond_helmet", "enameled_diamond_helmet_overlay");
        chestplateItem(RubysItems.FIRED_ENAMELED_DIAMOND_CHESTPLATE.get(), "armor/diamond/", "enameled_diamond_chestplate", "enameled_diamond_chestplate_overlay");
        leggingsItem(RubysItems.FIRED_ENAMELED_DIAMOND_LEGGINGS.get(), "armor/diamond/", "enameled_diamond_leggings", "enameled_diamond_helmet_overlay");
        bootsItem(RubysItems.FIRED_ENAMELED_DIAMOND_BOOTS.get(), "armor/diamond/", "enameled_diamond_boots", "enameled_diamond_boots_overlay");

        helmetItem(RubysItems.ENAMELED_NETHERITE_HELMET.get(), "armor/netherite/", "enameled_netherite_helmet", "enameled_netherite_helmet_overlay");
        chestplateItem(RubysItems.ENAMELED_NETHERITE_CHESTPLATE.get(), "armor/netherite/", "enameled_netherite_chestplate", "enameled_netherite_chestplate_overlay");
        leggingsItem(RubysItems.ENAMELED_NETHERITE_LEGGINGS.get(), "armor/netherite/", "enameled_netherite_leggings", "enameled_netherite_leggings_overlay");
        bootsItem(RubysItems.ENAMELED_NETHERITE_BOOTS.get(), "armor/netherite/", "enameled_netherite_boots", "enameled_netherite_boots_overlay");

        helmetItem(RubysItems.FIRED_ENAMELED_NETHERITE_HELMET.get(), "armor/netherite/", "enameled_netherite_helmet", "enameled_netherite_helmet_overlay");
        chestplateItem(RubysItems.FIRED_ENAMELED_NETHERITE_CHESTPLATE.get(), "armor/netherite/", "enameled_netherite_chestplate", "enameled_netherite_chestplate_overlay");
        leggingsItem(RubysItems.FIRED_ENAMELED_NETHERITE_LEGGINGS.get(), "armor/netherite/", "enameled_netherite_leggings", "enameled_netherite_helmet_overlay");
        bootsItem(RubysItems.FIRED_ENAMELED_NETHERITE_BOOTS.get(), "armor/netherite/", "enameled_netherite_boots", "enameled_netherite_boots_overlay");
    }
}
