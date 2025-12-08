package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RubysGlobalLootModifersProvider extends GlobalLootModifierProvider {
    public RubysGlobalLootModifersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, RubyMod.MOD_ID);
    }

    @Override
    protected void start() {
        ResourceKey<LootTable> INJECT_HORSE_MEAT = ResourceKey.create(
                Registries.LOOT_TABLE,
                ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "horse_meat")
        );

        ResourceKey<LootTable> INJECT_SQUID_MEAT = ResourceKey.create(
                Registries.LOOT_TABLE,
                ResourceLocation.fromNamespaceAndPath(RubyMod.MOD_ID, "squid_meat")
        );

        add("horse_meat_from_horses",
                new AddTableLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.fromNamespaceAndPath(
                                        "minecraft", "entities/horse")).build()
                        },
                        INJECT_HORSE_MEAT
                )
        );

        add("squid_meat_from_squids",
                new AddTableLootModifier(
                        new LootItemCondition[]{
                                LootTableIdCondition.builder(ResourceLocation.fromNamespaceAndPath(
                                        "minecraft", "entities/squid")).build()
                        },
                        INJECT_SQUID_MEAT
                )
        );
    }
}