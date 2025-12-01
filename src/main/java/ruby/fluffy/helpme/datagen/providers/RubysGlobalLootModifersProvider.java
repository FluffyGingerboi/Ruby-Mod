package ruby.fluffy.helpme.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysItems;

import java.util.concurrent.CompletableFuture;

public class RubysGlobalLootModifersProvider extends GlobalLootModifierProvider {
    public RubysGlobalLootModifersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, RubyMod.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("raw_horse_meat_from_horses",
                new AddTableLootModifier(new LootItemCondition[]{
                        LootItem.lootTableItem(RubysItems.RAW_HORSE_MEAT.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))
                                .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                }));
    }
}