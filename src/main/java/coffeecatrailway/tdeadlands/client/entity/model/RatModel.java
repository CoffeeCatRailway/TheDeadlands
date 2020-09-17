package coffeecatrailway.tdeadlands.client.entity.model;

import coffeecatrailway.tdeadlands.common.entity.RatEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author ManWithoutTaste
 * Made with Blockbench 3.5.4
 */
@OnlyIn(Dist.CLIENT)
public class RatModel extends EntityModel<RatEntity>
{
    private final ModelRenderer body;
    private final ModelRenderer frontLeftLeg;
    private final ModelRenderer frontRightLeg;
    private final ModelRenderer backLeftLeg;
    private final ModelRenderer backRightLeg;
    private final ModelRenderer tail;
    private final ModelRenderer tailEnd;
    private final ModelRenderer head;

    public RatModel()
    {
        this.textureWidth = 40;
        this.textureHeight = 16;

        this.body = new ModelRenderer(this);
        this.body.setRotationPoint(0f, 23f, 3f);
        this.body.setTextureOffset(18, 0).addBox(-3f, -4f, -2f, 6f, 4f, 5f, 0f, false);
        this.body.setTextureOffset(19, 0).addBox(-2.5f, -3f, -7f, 5f, 3f, 5f, 0f, false);

        this.frontLeftLeg = new ModelRenderer(this);
        this.frontLeftLeg.setRotationPoint(1.5F, 0.0F, -4.5F);
        this.frontLeftLeg.setTextureOffset(11, 0).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        this.body.addChild(this.frontLeftLeg);

        this.frontRightLeg = new ModelRenderer(this);
        this.frontRightLeg.setRotationPoint(-1.5F, 0.0F, -4.5F);
        this.frontRightLeg.setTextureOffset(11, 0).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        this.body.addChild(this.frontRightLeg);

        this.backLeftLeg = new ModelRenderer(this);
        this.backLeftLeg.setRotationPoint(2f, 23f, 3.5f);
        this.backLeftLeg.setTextureOffset(11, 0).addBox(-.5f, 0f, -1.5f, 1f, 1f, 2f, 0f, false);

        this.backRightLeg = new ModelRenderer(this);
        this.backRightLeg.setRotationPoint(-2f, 23f, 3.5f);
        this.backRightLeg.setTextureOffset(11, 0).addBox(-.5f, 0f, -1.5f, 1f, 1f, 2f, 0f, false);

        this.tail = new ModelRenderer(this);
        this.tail.setRotationPoint(0f, -1f, 3f);
        this.tail.rotateAngleX = -0.4363f;
        this.tail.setTextureOffset(14, 0).addBox(-0.5f, 0f, 0f, 1f, 1f, 3f, 0f, false);
        this.body.addChild(this.tail);

        this.tailEnd = new ModelRenderer(this);
        this.tailEnd.setRotationPoint(0f, 1.0883f, 2.9901f);
        this.tailEnd.rotateAngleX = 0.4363f;
        this.tailEnd.setTextureOffset(14, 0).addBox(-0.5f, -1.0758f, 0.0463f, 1f, 1f, 3f, 0f, false);
        this.tailEnd.setTextureOffset(16, 1).addBox(-0.5f, -1.0758f, 3.0463f, 1f, 1f, 2f, 0f, false);
        this.tail.addChild(this.tailEnd);

        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0.0F, -1.0F, -7.0F);
        this.head.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
        this.head.setTextureOffset(5, 6).addBox(1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        this.head.setTextureOffset(0, 6).addBox(-3.0F, -3.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        this.body.addChild(this.head);
    }

    @Override
    public void setRotationAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        float aggressiveAngle = entity.isAggressive() ? -((float) Math.PI / 5f) : 0f;
        body.rotateAngleX = aggressiveAngle;

        this.frontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount - aggressiveAngle;
        this.frontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount - aggressiveAngle;

        this.backLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
        this.backRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;

        this.tail.rotateAngleX = -aggressiveAngle;
        this.tail.rotateAngleY = MathHelper.sin(ageInTicks * .4f) * .5f;
        this.tailEnd.rotateAngleY = -MathHelper.cos(ageInTicks * .4f) * .25f;

        this.head.rotateAngleX = headPitch * ((float) Math.PI / 180f) - aggressiveAngle;
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180f);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        backRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
}