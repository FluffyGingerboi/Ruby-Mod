package ruby.fluffy.helpme.items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.neoforged.neoforge.common.ModConfigSpec.Builder;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ModConfigSpec;

public abstract class AbstractEntityItem extends Item {
    public AbstractEntityItem(Properties props) {
        super(props);
    }

    public InteractionResult useOn(UseOnContext context) {
        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.FAIL;
        } else {
            Level world = context.getLevel();
            BlockPlaceContext place = new BlockPlaceContext(context);
            BlockPos pos = place.getClickedPos();
            ItemStack stack = context.getItemInHand();
            Vec3 v = Vec3.atBottomCenterOf(pos);
            AABB nums = this.getType().getDimensions().makeBoundingBox(v.x(), v.y(), v.z());
            if (world.noCollision(null, nums) && world.getEntities(null, nums).isEmpty()) {
                if (world instanceof ServerLevel lvl) {
                    LivingEntity target = (LivingEntity)this.getType()
                            .create(lvl, EntityType.createDefaultStackConfig(lvl, stack, context.getPlayer()), pos, MobSpawnType.SPAWN_EGG, true, true);
                    if (target == null) {
                        return InteractionResult.FAIL;
                    }

                    target.moveTo(target.getX(), target.getY(), target.getZ());
                    float r = (Integer) ROTATION.get();
                    float rot = Mth.floor((Mth.wrapDegrees(context.getRotation() - 180.0F) + 22.5F) / r) * r;
                    target.setYRot(rot);
                    target.setYBodyRot(rot);
                    target.setYHeadRot(rot);
                    target.yRotO = rot;
                    target.yBodyRotO = rot;
                    target.yHeadRotO = rot;
                    lvl.addFreshEntityWithPassengers(target);
                    world.playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.ARMOR_STAND_PLACE, SoundSource.BLOCKS, 0.75F, 0.8F);
                    target.gameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());
                }

                stack.shrink(1);
                return InteractionResult.sidedSuccess(world.isClientSide);
            } else {
                return InteractionResult.FAIL;
            }
        }
    }

    public static final Builder BUILDER = new Builder();
    public static final ModConfigSpec.IntValue ROTATION = BUILDER.comment("The rotation of the item display.").defineInRange("Display-Rotation", 45, 5, 90);

    public abstract EntityType<? extends LivingEntity> getType();
}

