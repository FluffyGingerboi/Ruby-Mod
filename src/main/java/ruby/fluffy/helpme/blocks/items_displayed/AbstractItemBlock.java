package ruby.fluffy.helpme.blocks.items_displayed;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;
import ruby.fluffy.helpme.utilites.BlockAssociations;

public abstract class AbstractItemBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public AbstractItemBlock(Properties props) {
        super(props);
        this.registerDefaultState(
                (BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(WATERLOGGED, false)
        );
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isFaceSturdy(world, pos.below(), Direction.UP);
    }

    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player) {
        return this.getStackFor();
    }

    public String getDescriptionId() {
        return this.getStackFor().getDescriptionId();
    }

    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blok, BlockPos poz, boolean bool) {
        super.neighborChanged(state, world, pos, blok, poz, bool);
        if (!world.isClientSide() && !this.canSurvive(state, world, pos)) {
            Block.dropResources(state, world, pos, null);
            world.removeBlock(pos, true);
        }
    }

    protected void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean check) {
        super.onRemove(state, world, pos, newState, check);
        if (state.getBlock() != newState.getBlock()) {
            Block.popResource(world, pos, this.getStackFor());
        }
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState updateShape(BlockState state, Direction face, BlockState faceState, LevelAccessor world, BlockPos pos, BlockPos poz) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(state, face, faceState, world, pos, poz);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return (BlockState)((BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())).setValue(WATERLOGGED, flag);
    }

    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, WATERLOGGED});
    }

    public ItemStack getStackFor() {
        return new ItemStack(BlockAssociations.getItemFor(this));
    }
}

