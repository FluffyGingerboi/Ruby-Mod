package ruby.fluffy.helpme.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

@SuppressWarnings("unchecked")
public class RubysHorseArmorRenderer extends RenderLayer<Horse, HorseModel<Horse>> {

    private final HorseModel armorModel;

    public RubysHorseArmorRenderer(RenderLayerParent<Horse, HorseModel<Horse>> parent, EntityModelSet modelSet) {
        super(parent);
        this.armorModel = new HorseModel(modelSet.bakeLayer(ModelLayers.HORSE_ARMOR));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Horse horse, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack stack = horse.getBodyArmorItem();
        if (!(stack.getItem() instanceof AnimalArmorItem armorItem))
            return;

        if (armorItem.getBodyType() != AnimalArmorItem.BodyType.EQUESTRIAN)
            return;

        this.getParentModel().copyPropertiesTo(this.armorModel);
        this.armorModel.prepareMobModel(horse, limbSwing, limbSwingAmount, partialTicks);
        this.armorModel.setupAnim(horse, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        int color = -1;
        if (stack.is(ItemTags.DYEABLE)) {
            color = FastColor.ARGB32.opaque(DyedItemColor.getOrDefault(stack, 0xFFFFFFFF));
        }

        renderArmorTexture(
                poseStack,
                buffer,
                packedLight,
                armorItem.getTexture(),
                color
        );

        if (armorItem.getOverlayTexture() != null) {
            renderArmorTexture(
                    poseStack,
                    buffer,
                    packedLight,
                    armorItem.getOverlayTexture(),
                    -1
            );
        }
    }


    private void renderArmorTexture(
            PoseStack poseStack,
            MultiBufferSource buffer,
            int light,
            ResourceLocation texture,
            int argbColor
    ) {
        VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(texture));

        int finalColor = argbColor == -1 ? 0xFFFFFFFF : argbColor;

        armorModel.renderToBuffer(
                poseStack,
                consumer,
                light,
                OverlayTexture.NO_OVERLAY,
                finalColor
        );
    }
}