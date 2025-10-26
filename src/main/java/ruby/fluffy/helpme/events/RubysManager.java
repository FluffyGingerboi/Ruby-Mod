package ruby.fluffy.helpme.events;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import ruby.fluffy.helpme.registries.RubysTags;
import ruby.fluffy.helpme.utilites.BlockAssociations;

public class RubysManager {

    public static Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1.0)
                .add(Attributes.ATTACK_DAMAGE, 0.0)
                .add(Attributes.ARMOR, 0.0)
                .add(Attributes.MOVEMENT_SPEED, 0.0)
                .add(Attributes.FOLLOW_RANGE, 0.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    public static void placeItem(Player player, Level world, BlockHitResult rez, boolean check) {
        InteractionHand handy = check ? InteractionHand.MAIN_HAND : InteractionHand.OFF_HAND;
        ItemStack stack = player.getItemInHand(handy);
        if (world instanceof ServerLevel lvl && stack.is(RubysTags.DISPLAYABLE)) {
            BlockPos pos = rez.getBlockPos();
                Block targetx = BlockAssociations.getBlockFor(stack.getItem());
                if (targetx.asItem().useOn(new UseOnContext(player, handy, rez)) != InteractionResult.FAIL) {
                    lvl.playSound(
                            null,
                            pos.above(),
                            targetx.defaultBlockState().getSoundType(world, pos.above(), player).getPlaceSound(),
                            SoundSource.BLOCKS,
                            1.0F,
                            (float)(0.8F + Math.random() * 0.2)
                    );
                    player.swing(handy, true);
                }
            }
        }
    }

