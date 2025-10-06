package ruby.fluffy.helpme.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.blocks.bases.RubysBaseChestBlock;

@Mixin(ChestRenderer.class)
public class ChestRendererMixin {

    @WrapOperation(method = "getMaterial", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/Sheets;chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;"))
    private Material getChestMaterial(BlockEntity blockEntity, ChestType chestType, boolean bl, Operation<Material> original) {
        if (blockEntity.getBlockState().getBlock() instanceof RubysBaseChestBlock moreChestBlock && !bl) {
            return chooseZaMaterial(chestType, getZaChestPath(moreChestBlock.woodType + "_left"),
                    getZaChestPath(moreChestBlock.woodType + "_right"), getZaChestPath(moreChestBlock.woodType));
        }
        return original.call(blockEntity, chestType, bl);
    }

    @Unique
    private static Material getZaChestPath(String path) {
        return new Material(Sheets.CHEST_SHEET, RubyMod.id("entity/chest/" + path));
    }

    @Unique
    private static Material chooseZaMaterial(ChestType type, Material left, Material right, Material single) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };

    }
}
