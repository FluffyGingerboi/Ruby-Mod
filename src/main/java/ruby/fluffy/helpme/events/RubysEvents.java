package ruby.fluffy.helpme.events;

import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.entity.player.BonemealEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import ruby.fluffy.helpme.configs.SlabsConfig;
import ruby.fluffy.helpme.datagen.providers.RubysEnchantsProvider;
import ruby.fluffy.helpme.datagen.providers.RubysRecipesProvider;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysTags;
import ruby.fluffy.helpme.utilites.RubysConfig;
import ruby.fluffy.helpme.utilites.RubysRecipeData;
import ruby.fluffy.helpme.utilites.RubysRecipeHelpers;

@EventBusSubscriber
public class RubysEvents {

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK,
                RubysBlocks.MORE_CHEST_BLOCK_ENTITY.get(),
                (be, context) -> new InvWrapper(be.getContainer())
        );
    }


    @SubscribeEvent
    public static void onBoneableFlowers(BonemealEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;
        Player player = event.getPlayer();
        if (player == null) return;

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (!state.is(BlockTags.FLOWERS)) return;
        event.setCanceled(true);

        ItemStack drop = new ItemStack(state.getBlock().asItem());
        ItemEntity entity = new ItemEntity(
                level,
                pos.getX() + 0.5,
                pos.getY() + 1.0,
                pos.getZ() + 0.5,
                drop
        );
        level.addFreshEntity(entity);

        ItemStack boneMeal = event.getStack();
        if (!player.isCreative()) {
            boneMeal.shrink(1);
        }

        level.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
        player.swing(InteractionHand.MAIN_HAND, true);
        for (int i = 0; i < 12; ++i) {
            double dx = level.random.nextGaussian() * 0.02;
            double dy = level.random.nextGaussian() * 0.02;
            double dz = level.random.nextGaussian() * 0.02;
            double x = pos.getX() + 0.5 + (level.random.nextDouble() - 0.5);
            double y = pos.getY() + 0.5 + (level.random.nextDouble() - 0.5);
            double z = pos.getZ() + 0.5 + (level.random.nextDouble() - 0.5);
            level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 1, dx, dy, dz, 0.05);
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer target)) return;
        ServerLevel level = target.serverLevel();

        ItemStack leggings = target.getItemBySlot(EquipmentSlot.LEGS);
        if (leggings.isEmpty()) return;

        Holder<Enchantment> pantsOffHolder = level.registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolderOrThrow(RubysEnchantsProvider.PANTS_OFF);

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(pantsOffHolder, leggings);
        if (enchantLevel <= 0) return;

        for (ServerPlayer observer : level.players()) {
            if (observer == target) continue;

            if (isLookingAt(observer, target, 20.0)) {
                unequipLeggings(target, leggings);
                break;
            }
        }
    }

    private static boolean isLookingAt(ServerPlayer observer, net.minecraft.world.entity.LivingEntity target, double range) {
        Vec3 eyePos = observer.getEyePosition(1.0F);
        Vec3 lookVec = observer.getLookAngle();
        Vec3 end = eyePos.add(lookVec.scale(range));
        AABB targetBox = target.getBoundingBox().inflate(0.5);

        return targetBox.clip(eyePos, end).isPresent();
    }

    private static void unequipLeggings(ServerPlayer player, ItemStack legsStack) {
        player.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);

        ItemStack hand = player.getMainHandItem();
        if (!hand.isEmpty()) {
            player.drop(hand.copy(), false);
            player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
        }

        player.setItemInHand(InteractionHand.MAIN_HAND, legsStack.copy());
    }

    public static void init() {
        RubysConfig.init("slabstoblocks", SlabsConfig.class);

        for (int i = 0; i < SlabsConfig.slabBlockList.size(); i++) {
            String current = SlabsConfig.slabBlockList.get(i);
            String[] set = ((current).replaceAll("\\s","")).split(",");
            if (current.contains("-")){
                RubysRecipeHelpers.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(String.valueOf(ResourceLocation.parse(set[0]))),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "##"
                        ),
                        String.valueOf(ResourceLocation.parse(set[1])), 1);
            } else if (current.contains("/")) {
                RubysRecipeHelpers.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(String.valueOf(ResourceLocation.parse(set[0]))),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "# ",
                                " #"
                        ),
                        String.valueOf(ResourceLocation.parse(set[1])), 1);
            } else {
                RubysRecipeHelpers.createShapedRecipeJson(
                        Lists.newArrayList(
                                '#'
                        ),
                        Lists.newArrayList(String.valueOf(ResourceLocation.parse(set[0]))),
                        Lists.newArrayList("item"),
                        Lists.newArrayList(
                                "#",
                                "#"
                        ),
                        String.valueOf(ResourceLocation.parse(set[1])), 1);
            }
        }
    }
}
