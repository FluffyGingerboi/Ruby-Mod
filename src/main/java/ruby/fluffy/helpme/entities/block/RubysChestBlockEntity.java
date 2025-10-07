package ruby.fluffy.helpme.entities.block;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import ruby.fluffy.helpme.blocks.bases.RubysBaseChestBlock;
import ruby.fluffy.helpme.registries.RubysBlocks;

public class RubysChestBlockEntity extends ChestBlockEntity {
    public RubysChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    public RubysChestBlockEntity(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState) {
        super(type, blockPos, blockState);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.ru3yy." + getBlock().woodType + "_chest");
    }

    public RubysBaseChestBlock getBlock() {
        return (RubysBaseChestBlock) getBlockState().getBlock();
    }

    public Container getContainer() {
        assert this.getLevel() != null;
        return ChestBlock.getContainer(
                this.getBlock(),
                this.getBlockState(),
                this.getLevel(),
                this.getBlockPos(),
                false
        );
    }
}
