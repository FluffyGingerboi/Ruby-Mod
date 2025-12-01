package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.items.*;
import ruby.fluffy.helpme.items.bases.*;
import ruby.fluffy.helpme.items.food.RubysCookedHorseFoodItem;
import ruby.fluffy.helpme.items.food.RubysCookedSquidFoodItem;
import ruby.fluffy.helpme.items.food.RubysRawHorseFoodItem;
import ruby.fluffy.helpme.items.food.RubysRawSquidFoodItem;

public class RubysItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, RubyMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS_CHESTS = DeferredRegister.createItems(RubyMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RubyMod.MOD_ID);

    public static final DeferredHolder<Item, Item> ENAMELED_CHAIN_HELMET = REGISTRY.register("enameled_chainmail_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_CHAIN_CHESTPLATE = REGISTRY.register("enameled_chainmail_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_CHAIN_LEGGINGS = REGISTRY.register("enameled_chainmail_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_CHAIN_BOOTS = REGISTRY.register("enameled_chainmail_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_IRON_HELMET = REGISTRY.register("enameled_iron_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_IRON_CHESTPLATE = REGISTRY.register("enameled_iron_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_IRON_LEGGINGS = REGISTRY.register("enameled_iron_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_IRON_BOOTS = REGISTRY.register("enameled_iron_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_GOLD_HELMET = REGISTRY.register("enameled_golden_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_GOLD_CHESTPLATE = REGISTRY.register("enameled_golden_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_GOLD_LEGGINGS = REGISTRY.register("enameled_golden_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_GOLD_BOOTS = REGISTRY.register("enameled_golden_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_DIAMOND_HELMET = REGISTRY.register("enameled_diamond_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_DIAMOND_CHESTPLATE = REGISTRY.register("enameled_diamond_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_DIAMOND_LEGGINGS = REGISTRY.register("enameled_diamond_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_DIAMOND_BOOTS = REGISTRY.register("enameled_diamond_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_NETHERITE_HELMET = REGISTRY.register("enameled_netherite_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_NETHERITE_CHESTPLATE = REGISTRY.register("enameled_netherite_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_NETHERITE_LEGGINGS = REGISTRY.register("enameled_netherite_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> ENAMELED_NETHERITE_BOOTS = REGISTRY.register("enameled_netherite_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(5))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_CHAIN_HELMET = REGISTRY.register("fired_enameled_chainmail_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_CHAIN_CHESTPLATE = REGISTRY.register("fired_enameled_chainmail_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_CHAIN_LEGGINGS = REGISTRY.register("fired_enameled_chainmail_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_CHAIN_BOOTS = REGISTRY.register("fired_enameled_chainmail_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_CHAIN, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_IRON_HELMET = REGISTRY.register("fired_enameled_iron_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_IRON_CHESTPLATE = REGISTRY.register("fired_enameled_iron_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_IRON_LEGGINGS = REGISTRY.register("fired_enameled_iron_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_IRON_BOOTS = REGISTRY.register("fired_enameled_iron_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_IRON, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(15))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_GOLD_HELMET = REGISTRY.register("fired_enameled_golden_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(7))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_GOLD_CHESTPLATE = REGISTRY.register("fired_enameled_golden_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(7))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_GOLD_LEGGINGS = REGISTRY.register("fired_enameled_golden_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(7))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_GOLD_BOOTS = REGISTRY.register("fired_enameled_golden_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_GOLD, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(7))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_DIAMOND_HELMET = REGISTRY.register("fired_enameled_diamond_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(33))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_DIAMOND_CHESTPLATE = REGISTRY.register("fired_enameled_diamond_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(33))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_DIAMOND_LEGGINGS = REGISTRY.register("fired_enameled_diamond_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(33))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_DIAMOND_BOOTS = REGISTRY.register("fired_enameled_diamond_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_DIAMOND, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(33))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_NETHERITE_HELMET = REGISTRY.register("fired_enameled_netherite_helmet",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.HELMET,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_NETHERITE_CHESTPLATE = REGISTRY.register("fired_enameled_netherite_chestplate",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_NETHERITE_LEGGINGS = REGISTRY.register("fired_enameled_netherite_leggings",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_NETHERITE_BOOTS = REGISTRY.register("fired_enameled_netherite_boots",
            () -> new RubysBaseEnameledArmorItem(RubysArmorMaterials.FIRED_ENAMELED_NETHERITE, RubysBaseEnameledArmorItem.Type.BOOTS,
                    new Item.Properties().durability(RubysBaseEnameledArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> ENAMELED_IRON_HORSE_ARMOR = REGISTRY.register("enameled_iron_horse_armor",
            () -> new RubysBaseEnameledHorseArmorItem(RubysArmorMaterials.ENAMELED_IRON, RubysBaseEnameledHorseArmorItem.BodyType.EQUESTRIAN, true,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> ENAMELED_GOLD_HORSE_ARMOR = REGISTRY.register("enameled_gold_horse_armor",
            () -> new RubysBaseEnameledHorseArmorItem(RubysArmorMaterials.ENAMELED_GOLD, RubysBaseEnameledHorseArmorItem.BodyType.EQUESTRIAN, true,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> ENAMELED_DIAMOND_HORSE_ARMOR = REGISTRY.register("enameled_diamond_horse_armor",
            () -> new RubysBaseEnameledHorseArmorItem(RubysArmorMaterials.ENAMELED_DIAMOND, RubysBaseEnameledHorseArmorItem.BodyType.EQUESTRIAN, true,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_IRON_HORSE_ARMOR = REGISTRY.register("fired_enameled_iron_horse_armor",
            () -> new RubysBaseEnameledHorseArmorItem(RubysArmorMaterials.FIRED_ENAMELED_IRON, RubysBaseEnameledHorseArmorItem.BodyType.EQUESTRIAN, true,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_GOLD_HORSE_ARMOR = REGISTRY.register("fired_enameled_gold_horse_armor",
            () -> new RubysBaseEnameledHorseArmorItem(RubysArmorMaterials.FIRED_ENAMELED_GOLD, RubysBaseEnameledHorseArmorItem.BodyType.EQUESTRIAN, true,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_DIAMOND_HORSE_ARMOR = REGISTRY.register("fired_enameled_diamond_horse_armor",
            () -> new RubysBaseEnameledHorseArmorItem(RubysArmorMaterials.FIRED_ENAMELED_DIAMOND, RubysBaseEnameledHorseArmorItem.BodyType.EQUESTRIAN, true,
                    new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> ENAMELED_IRON_SWORD = REGISTRY.register("enameled_iron_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.WOOD,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.WOOD, 1, -2.4F))));

    public static final DeferredHolder<Item, Item> ENAMELED_GOLD_SWORD = REGISTRY.register("enameled_gold_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.WOOD,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.WOOD, 1, -2.4F))));

    public static final DeferredHolder<Item, Item> ENAMELED_DIAMOND_SWORD = REGISTRY.register("enameled_diamond_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.WOOD,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.WOOD, 1, -2.4F))));

    public static final DeferredHolder<Item, Item> ENAMELED_NETHERITE_SWORD = REGISTRY.register("enameled_netherite_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.WOOD,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.WOOD, 1, -2.4F))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_IRON_SWORD = REGISTRY.register("fired_enameled_iron_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.IRON,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.IRON, 3, -2.4F))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_GOLD_SWORD = REGISTRY.register("fired_enameled_gold_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.GOLD,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.GOLD, 3, -2.4F))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_DIAMOND_SWORD = REGISTRY.register("fired_enameled_diamond_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.DIAMOND,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.DIAMOND, 3, -2.4F))));

    public static final DeferredHolder<Item, Item> FIRED_ENAMELED_NETHERITE_SWORD = REGISTRY.register("fired_enameled_netherite_sword",
            () -> new RubysBaseEnameledSwordItem(Tiers.NETHERITE,
                    new Item.Properties().attributes(RubysBaseEnameledSwordItem.createAttributes(Tiers.NETHERITE, 3, -2.4F))));

    public static final DeferredHolder<Item,Item> PERIOD_LANTERN = block(RubysBlocks.PERIOD_LANTERN);
    public static final DeferredHolder<Item,Item> PURPUR_LANTERN = block(RubysBlocks.PURPUR_LANTERN);
    public static final DeferredHolder<Item,Item> YELLER_LANTERN = block(RubysBlocks.YELLER_LANTERN);
    public static final DeferredHolder<Item,Item> BLUE_LANTERN = block(RubysBlocks.BLUE_LANTERN);
    public static final DeferredHolder<Item,Item> ORANG_LANTERN = block(RubysBlocks.ORANG_LANTERN);
    public static final DeferredHolder<Item,Item> GREN_LANTERN = block(RubysBlocks.GREN_LANTERN);
    public static final DeferredHolder<Item,Item> LIT_BLUE_LANTERN = block(RubysBlocks.LIT_BLUE_LANTERN);
    public static final DeferredHolder<Item,Item> LIT_GREYPE_LANTERN = block(RubysBlocks.LIT_GREYPE_LANTERN);
    public static final DeferredHolder<Item,Item> GREYPE_LANTERN = block(RubysBlocks.GREYPE_LANTERN);
    public static final DeferredHolder<Item,Item> BLOOCK_LANTERN = block(RubysBlocks.BLOOCK_LANTERN);
    public static final DeferredHolder<Item,Item> LIM_LANTERN = block(RubysBlocks.LIM_LANTERN);
    public static final DeferredHolder<Item,Item> NYAN_LANTERN = block(RubysBlocks.NYAN_LANTERN);
    public static final DeferredHolder<Item,Item> MAGENTER_LANTERN = block(RubysBlocks.MAGENTER_LANTERN);
    public static final DeferredHolder<Item,Item> POO_LANTERN = block(RubysBlocks.POO_LANTERN);
    public static final DeferredHolder<Item,Item> PINKY_LANTERN = block(RubysBlocks.PINKY_LANTERN);

    public static final DeferredHolder<Item,Item> POPPY_BLOCK = block(RubysBlocks.POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> COMPACTED_POPPY_BLOCK = block(RubysBlocks.COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> DOUBLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.DOUBLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> TRIPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.TRIPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> QUADRUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.QUADRUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> QUINTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.QUINTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> SEXTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.SEXTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> SEPTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.SEPTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> OCTUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.OCTUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> NONUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.NONUPLE_COMPACTED_POPPY_BLOCK);
    public static final DeferredHolder<Item,Item> DECUPLE_COMPACTED_POPPY_BLOCK = block(RubysBlocks.DECUPLE_COMPACTED_POPPY_BLOCK);

    public static final DeferredHolder<Item,Item> FLOWERING_OAK_LEAVES = block(RubysBlocks.FLOWERING_OAK_LEAVES);

    public static final DeferredHolder<Item,Item> FLOWERING_OAK_SAPLING = block(RubysBlocks.FLOWERING_OAK_SAPLING);

    public static final DeferredItem<BlockItem> BLUE_WHITE_WILDFLOWERS = ITEMS.registerSimpleBlockItem(RubysBlocks.BLUE_WHITE_WILDFLOWERS);
    public static final DeferredItem<BlockItem> PURPLE_WHITE_WILDFLOWERS = ITEMS.registerSimpleBlockItem(RubysBlocks.PURPLE_WHITE_WILDFLOWERS);

    public static final DeferredHolder<Item,Item> DIRT_SLAB = block(RubysBlocks.DIRT_SLAB);
    public static final DeferredHolder<Item,Item> GRASS_SLAB = block(RubysBlocks.GRASS_SLAB);
    public static final DeferredHolder<Item,Item> GRAVEL_SLAB = block(RubysBlocks.GRAVEL_SLAB);
    public static final DeferredHolder<Item,Item> SAND_SLAB = block(RubysBlocks.SAND_SLAB);

    public static final DeferredHolder<Item,Item> LOG_STAIRS = block(RubysBlocks.LOG_STAIRS);

    public static final DeferredHolder<Item,Item> BLOOCK_PIGMENT = REGISTRY.register("bloock_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> GREYPE_PIGMENT = REGISTRY.register("greype_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> LIT_GREYPE_PIGMENT = REGISTRY.register("lit_greype_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> WIT_PIGMENT = REGISTRY.register("wit_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> PERIOD_PIGMENT = REGISTRY.register("period_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> ORANG_PIGMENT = REGISTRY.register("orang_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> YELLER_PIGMENT = REGISTRY.register("yeller_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> GREN_PIGMENT = REGISTRY.register("gren_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> LIM_PIGMENT = REGISTRY.register("lim_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> BLUE_PIGMENT = REGISTRY.register("blue_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> LIT_BLUE_PIGMENT = REGISTRY.register("lit_blue_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> NYAN_PIGMENT = REGISTRY.register("nyan_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> PURPUR_PIGMENT = REGISTRY.register("purpur_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> MAGENTER_PIGMENT = REGISTRY.register("magenter_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> PINKY_PIGMENT = REGISTRY.register("pinky_pigment", RubysBaseItem::new);
    public static final DeferredHolder<Item,Item> POO_PIGMENT = REGISTRY.register("poo_pigment", RubysBaseItem::new);

    public static final DeferredHolder<Item,Item> MORTAR_AND_PESTLE = REGISTRY.register("mortar_and_pestle", RubysBasePersistentItem::new);
    public static final DeferredHolder<Item,Item> SCRAPER = REGISTRY.register("scraper", RubysBasePersistentItem::new);
    public static final DeferredHolder<Item,Item> SAW = REGISTRY.register("saw", SawItem::new);
    public static final DeferredHolder<Item,Item> ENAMEL = REGISTRY.register("enamel", RubysBaseItem::new);

    public static final DeferredHolder<Item,Item> RAW_SQUID_MEAT = REGISTRY.register("raw_squid_meat", RubysRawSquidFoodItem::new);
    public static final DeferredHolder<Item,Item> COOKED_SQUID_MEAT = REGISTRY.register("cooked_squid_meat", RubysCookedSquidFoodItem::new);
    public static final DeferredHolder<Item,Item> RAW_HORSE_MEAT = REGISTRY.register("raw_horse_meat", RubysRawHorseFoodItem::new);
    public static final DeferredHolder<Item,Item> COOKED_HORSE_MEAT = REGISTRY.register("cooked_horse_meat", RubysCookedHorseFoodItem::new);

    public static final DeferredItem<BlockItem> CHERRY_CHEST = registerItem("cherry", RubysBlocks.CHERRY_CHEST);
    public static final DeferredItem<BlockItem> SPRUCE_CHEST = registerItem("spruce", RubysBlocks.SPRUCE_CHEST);

    public static final DeferredHolder<Item,Item> KILN = block(RubysBlocks.KILN);

    public static void registerItems(IEventBus modBus) {
        ITEMS_CHESTS.register(modBus);
    }

    public static DeferredItem<BlockItem> registerItem(String name, DeferredBlock<Block> block) {
        return ITEMS_CHESTS.register(name + "_chest", ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    private static Properties createBaseProps(String name) {
        return new Properties();
    }

    private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static DeferredHolder<Item, Item> doubleBlock(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(
                block.getId().getPath(),
                () -> new DoubleHighBlockItem(block.get(), new Item.Properties())
        );
    }
}
