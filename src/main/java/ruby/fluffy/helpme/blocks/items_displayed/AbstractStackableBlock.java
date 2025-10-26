package ruby.fluffy.helpme.blocks.items_displayed;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public abstract class AbstractStackableBlock extends AbstractItemBlock {
   public static final IntegerProperty STACKS = IntegerProperty.create("stacks", 1, 4);

   public AbstractStackableBlock(Properties props) {
      super(props);
      this.registerDefaultState(
         (BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(WATERLOGGED, false))
            .setValue(STACKS, 1)
      );
   }

   @Override
   protected void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean check) {
      super.onRemove(state, world, pos, newState, check);
      if (state.getBlock() != newState.getBlock() && this.getStacks(state) > 1) {
         for (int i = 1; i < this.getStacks(state); i++) {
            Block.popResource(world, pos, this.getStackFor());
         }
      }
   }

   @Override
   protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{STACKS});
   }

   public int getStacks(BlockState state) {
      return (Integer)state.getValue(STACKS);
   }

   public BlockState getState(BlockState state) {
      return (BlockState)state.setValue(STACKS, this.getStacks(state) + 1);
   }

   public abstract int getMaxStackable();
}
