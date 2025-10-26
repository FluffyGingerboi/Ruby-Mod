package ruby.fluffy.helpme.items_displayed.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import ruby.fluffy.helpme.items_displayed.client.model.PillowModel;
import ruby.fluffy.helpme.items_displayed.entity.ItemPillow;

public class PillowRenderer extends LivingEntityRenderer<ItemPillow, PillowModel<ItemPillow>> {

    public PillowRenderer(Context context) {
        super(context, new PillowModel(context.bakeLayer(PillowModel.PILLOW)), 0.0F);
        this.addLayer(new PillowedItemLayer(this, context.getItemInHandRenderer()));
    }

    public ResourceLocation getTextureLocation(ItemPillow target) {
        return ResourceLocation.fromNamespaceAndPath("items_displayed", "textures/entity/jewelry_pillow/" + target.getColor() + "_jewelry_pillow.png");
    }

    protected boolean shouldShowName(ItemPillow target) {
        return false;
    }

    protected void setupRotations(ItemPillow target, PoseStack pose, float f1, float f2, float f3, float f4) {
        pose.mulPose(Axis.YP.rotationDegrees(180.0F - f2));
        float f = (float) (target.level().getGameTime() - target.lastHit) + f3;
        if (f < 5.0F) {
            pose.mulPose(Axis.YP.rotationDegrees(Mth.sin(f / 1.5F * (float) Math.PI) * 3.0F));
        }
    }
}
