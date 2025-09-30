package ruby.fluffy.helpme.blocks;

import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Supplier;

public class CherryChestBlock extends ChestBlock {
    public CherryChestBlock(BlockBehaviour.Properties properties) {
        super(properties, () -> BlockEntityType.CHEST);
    }
}
