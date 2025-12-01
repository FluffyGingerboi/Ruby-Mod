package ruby.fluffy.helpme.registries;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;

import java.util.EnumMap;
import java.util.List;

public class RubysArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, RubyMod.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENAMELED_CHAIN = ARMOR_MATERIALS.register(
            "enameled_chain", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
            }), 9,
                    SoundEvents.ARMOR_EQUIP_CHAIN, () ->
                    Ingredient.of(Items.AIR),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_chainmail"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_chainmail"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENAMELED_IRON = ARMOR_MATERIALS.register(
            "enameled_iron", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
            }), 0,
                    SoundEvents.ARMOR_EQUIP_IRON, () ->
                    Ingredient.of(Items.AIR),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_iron"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_iron"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENAMELED_GOLD = ARMOR_MATERIALS.register(
            "enameled_golden", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
            }), 0,
                    SoundEvents.ARMOR_EQUIP_GOLD, () ->
                    Ingredient.of(Items.AIR),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_golden"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_golden"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENAMELED_DIAMOND = ARMOR_MATERIALS.register(
            "enameled_diamond", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
            }), 0,
                    SoundEvents.ARMOR_EQUIP_DIAMOND, () ->
                    Ingredient.of(Items.AIR),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_diamond"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_diamond"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ENAMELED_NETHERITE = ARMOR_MATERIALS.register(
            "enameled_netherite", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 1);
                map.put(ArmorItem.Type.CHESTPLATE, 1);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 1);
            }), 0,
                    SoundEvents.ARMOR_EQUIP_NETHERITE, () ->
                    Ingredient.of(Items.AIR),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_netherite"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_netherite"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FIRED_ENAMELED_CHAIN = ARMOR_MATERIALS.register(
            "fired_enameled_chain", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }), 12,
                    SoundEvents.ARMOR_EQUIP_CHAIN, () ->
                    Ingredient.of(Items.IRON_INGOT),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_chainmail"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_chainmail"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FIRED_ENAMELED_IRON = ARMOR_MATERIALS.register(
            "fired_enameled_iron", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 5);
            }), 9,
                    SoundEvents.ARMOR_EQUIP_IRON, () ->
                    Ingredient.of(Items.IRON_INGOT),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_iron"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_iron"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FIRED_ENAMELED_GOLD = ARMOR_MATERIALS.register(
            "fired_enameled_golden", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 7);
            }), 25,
                    SoundEvents.ARMOR_EQUIP_GOLD, () ->
                    Ingredient.of(Items.GOLD_INGOT),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_golden"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_golden"), "_overlay", true)),
                    0.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FIRED_ENAMELED_DIAMOND = ARMOR_MATERIALS.register(
            "fired_enameled_diamond", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 10,
                    SoundEvents.ARMOR_EQUIP_DIAMOND, () ->
                    Ingredient.of(Items.DIAMOND),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_diamond"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_diamond"), "_overlay", true)),
                    2.0F, 0.0F)
    );

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FIRED_ENAMELED_NETHERITE = ARMOR_MATERIALS.register(
            "fired_enameled_netherite", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }), 15,
                    SoundEvents.ARMOR_EQUIP_NETHERITE, () ->
                    Ingredient.of(Items.NETHERITE_INGOT),
                    List.of(
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_netherite"), "", true),
                            new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID,"enameled_netherite"), "_overlay", true)),
                    3.0F, 0.1F)
    );
}
