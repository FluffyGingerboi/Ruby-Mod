package ruby.fluffy.helpme.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SawItem extends Item {

    public SawItem() {
        super(new Properties()
                .rarity(Rarity.COMMON)
                .stacksTo(1)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        BlockState stripped = AxeItem.getAxeStrippingState(state);
        if (stripped == null) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            if (state.hasProperty(RotatedPillarBlock.AXIS)) {
                stripped = stripped.setValue(RotatedPillarBlock.AXIS,
                        state.getValue(RotatedPillarBlock.AXIS));
            }

            level.setBlock(pos, stripped, 11);
            level.playSound(null,pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1f, 1f);
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack itemStack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack.copy();
    }
}
