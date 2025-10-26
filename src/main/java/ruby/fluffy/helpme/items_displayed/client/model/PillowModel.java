package ruby.fluffy.helpme.items_displayed.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;

public class PillowModel<T extends Entity> extends EntityModel<T> implements ArmedModel {

    public static final ModelLayerLocation PILLOW = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("items_displayed", "pillow"), "main");
    private final ModelPart root;

    public PillowModel(ModelPart root) {
        this.root = root;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        main.addOrReplaceChild(
                "stick1",
                CubeListBuilder.create().texOffs(4, 13).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.5F, -3.0F, 3.75F, 1.5708F, 0.0F, -1.5708F)
        );
        main.addOrReplaceChild(
                "stick2",
                CubeListBuilder.create().texOffs(4, 13).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(3.5F, -3.0F, 3.75F, 1.5708F, 0.0F, -1.5708F)
        );
        main.addOrReplaceChild(
                "stick3",
                CubeListBuilder.create().texOffs(0, 13).addBox(-7.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-4.5F, 0.0F, 3.25F, 0.0F, -1.5708F, 0.0F)
        );
        main.addOrReplaceChild(
                "stick4",
                CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(4.0F, -0.5F, 0.25F, 0.0F, -1.5708F, 3.1416F)
        );
        main.addOrReplaceChild(
                "pillow",
                CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.0F, -0.0F, 10.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, -4.3F, 0.3927F, 0.0F, 0.0F)
        );
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(T display, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
    }

    public void translateToHand(HumanoidArm Arm, PoseStack poseStack) {
    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
