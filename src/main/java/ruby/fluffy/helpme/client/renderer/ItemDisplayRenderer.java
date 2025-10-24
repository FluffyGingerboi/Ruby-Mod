package ruby.fluffy.helpme.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import ruby.fluffy.helpme.client.model.ItemDisplayModel;
import ruby.fluffy.helpme.entity.ItemDisplay;
import ruby.fluffy.helpme.registries.RubysBlocks;
import ruby.fluffy.helpme.registries.RubysModels;

public class ItemDisplayRenderer extends LivingEntityRenderer<ItemDisplay, ItemDisplayModel<ItemDisplay>> {
    public ItemDisplayRenderer(Context context) {
        super(context, new ItemDisplayModel(context.bakeLayer(RubysModels.DISPLAY)), 0.0F);
        this.addLayer(new DisplayedItemLayer(this, context.getItemInHandRenderer()));
    }

    public ResourceLocation getTextureLocation(ItemDisplay target) {
        return ResourceLocation.fromNamespaceAndPath("items_displayed", "textures/entity/item_display.png");
    }

    protected boolean shouldShowName(ItemDisplay target) {
        return false;
    }

    protected void setupRotations(ItemDisplay target, PoseStack pose, float f1, float f2, float f3, float f4) {
        pose.mulPose(Axis.YP.rotationDegrees(180.0F - f2));
        float f = (float)(target.level().getGameTime() - target.lastHit) + f3;
        if (f < 5.0F) {
            pose.mulPose(Axis.YP.rotationDegrees(Mth.sin(f / 1.5F * (float) Math.PI) * 3.0F));
        }
    }
}
