package ruby.fluffy.helpme.blocks.bases;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import ruby.fluffy.helpme.entities.RubysChestBlockEntity;
import ruby.fluffy.helpme.registries.RubysBlocks;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public class RubysBaseChestBlock extends ChestBlock {
    public DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> NAME_RETRIEVER = new DoubleBlockCombiner.Combiner<>() {
        public Optional<MenuProvider> acceptDouble(ChestBlockEntity chestBlockEntity, ChestBlockEntity chestBlockEntity2) {
            final Container container = new CompoundContainer(chestBlockEntity, chestBlockEntity2);
            return Optional.of(new MenuProvider() {
                @Nullable
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    if (chestBlockEntity.canOpen(player) && chestBlockEntity2.canOpen(player)) {
                        chestBlockEntity.unpackLootTable(inventory.player);
                        chestBlockEntity2.unpackLootTable(inventory.player);
                        return ChestMenu.sixRows(id, inventory, container);
                    } else {
                        return null;
                    }
                }

                public Component getDisplayName() {
                    if (chestBlockEntity.hasCustomName()) {
                        return chestBlockEntity.getDisplayName();
                    } else {
                        return chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() :
                                Component.translatable("container.lolmcv." + woodType + "_chestDouble");
                    }
                }
            });
        }

        public Optional<MenuProvider> acceptSingle(ChestBlockEntity chestBlockEntity) {
            return Optional.of(chestBlockEntity);
        }

        public Optional<MenuProvider> acceptNone() {
            return Optional.empty();
        }
    };

    public final String woodType;

    public RubysBaseChestBlock(MapColor colour, String chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(colour), () -> RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get());
        this.woodType = chestType;
    }

    public RubysBaseChestBlock(MapColor colour, SoundType sound, String chestType) {
        super(Properties.ofFullCopy(Blocks.CHEST).mapColor(colour).sound(sound), () -> RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get());
        this.woodType = chestType;
    }

    public RubysBaseChestBlock(BlockBehaviour.Properties properties, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier, String chestType) {
        super(properties, supplier);
        this.woodType = chestType;
    }

    @Override
    public @NotNull BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RubysChestBlockEntity(pos, state);
    }

    @Override
    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return this.combine(state, level, pos, false)
                .apply(NAME_RETRIEVER).orElse(null);
    }
}
