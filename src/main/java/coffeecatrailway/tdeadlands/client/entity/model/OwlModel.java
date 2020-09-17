package coffeecatrailway.tdeadlands.client.entity.model;

import coffeecatrailway.tdeadlands.common.entity.OwlEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class OwlModel extends EntityModel<OwlEntity>
{
    private final ModelRenderer lowerBody;
    private final ModelRenderer leftLeg;
    private final ModelRenderer rightLeg;
    private final ModelRenderer body;
    private final ModelRenderer leftWing;
    private final ModelRenderer rightWing;
    private final ModelRenderer tail;
    private final ModelRenderer head;
    private final ModelRenderer beak;

    public OwlModel()
    {
        this.textureWidth = 44;
        this.textureHeight = 24;

        this.lowerBody = new ModelRenderer(this);
        this.lowerBody.setRotationPoint(0f, 19f, 0f);
        this.lowerBody.setTextureOffset(24, 0).addBox(-3f, 0f, -2f, 6f, 4f, 4f, 0f, false);

        this.leftLeg = new ModelRenderer(this);
        this.leftLeg.setRotationPoint(0f, 5f, 0f);
        this.leftLeg.setTextureOffset(24, 8).addBox(-2f, -1f, -1f, 2f, 1f, 2f, 0f, false);
        this.leftLeg.setTextureOffset(32, 8).addBox(-1f, -1f, -2f, 1f, 1f, 1f, 0f, false);
        this.leftLeg.setTextureOffset(32, 8).addBox(-3f, -1f, -2f, 1f, 1f, 1f, 0f, false);
        this.leftLeg.setTextureOffset(32, 8).addBox(-1f, -1f, 1f, 1f, 1f, 1f, 0f, false);
        this.leftLeg.setTextureOffset(36, 8).addBox(-1f, -4f, 0f, 1f, 3f, 1f, 0f, false);
        this.lowerBody.addChild(this.leftLeg);

        this.rightLeg = new ModelRenderer(this);
        this.rightLeg.setRotationPoint(0f, 5f, 0f);
        this.rightLeg.setTextureOffset(24, 8).addBox(0f, -1f, -1f, 2f, 1f, 2f, 0f, false);
        this.rightLeg.setTextureOffset(32, 8).addBox(2f, -1f, -2f, 1f, 1f, 1f, 0f, false);
        this.rightLeg.setTextureOffset(32, 8).addBox(0f, -1f, -2f, 1f, 1f, 1f, 0f, false);
        this.rightLeg.setTextureOffset(32, 8).addBox(0f, -1f, 1f, 1f, 1f, 1f, 0f, false);
        this.rightLeg.setTextureOffset(36, 8).addBox(0f, -4f, 0f, 1f, 3f, 1f, 0f, false);
        this.lowerBody.addChild(this.rightLeg);

        this.body = new ModelRenderer(this);
        this.body.setRotationPoint(0f, 0f, 0f);
        this.body.rotateAngleX = .8727f;
        this.body.setTextureOffset(0, 11).addBox(-3f, -5f, -2.5f, 6f, 8f, 5f, 0f, false);
        this.lowerBody.addChild(this.body);

        this.leftWing = new ModelRenderer(this);
        this.leftWing.setRotationPoint(-3f, -4f, 0f);
        this.leftWing.setTextureOffset(22, 13).addBox(-1f, -1f, -2f, 1f, 10f, 1f, 0f, false);
        this.leftWing.setTextureOffset(22, 14).addBox(-1f, -1f, -1f, 1f, 9f, 1f, 0f, false);
        this.leftWing.setTextureOffset(22, 15).addBox(-1f, 0f, -3f, 1f, 8f, 1f, 0f, false);
        this.leftWing.setTextureOffset(22, 15).addBox(-1f, -1f, 0f, 1f, 8f, 1f, 0f, false);
        this.leftWing.setTextureOffset(22, 17).addBox(-1f, 0f, 1f, 1f, 6f, 1f, 0f, false);
        this.leftWing.setTextureOffset(22, 19).addBox(-1f, 1f, 2f, 1f, 4f, 1f, 0f, false);
        this.body.addChild(this.leftWing);

        this.rightWing = new ModelRenderer(this);
        this.rightWing.setRotationPoint(3f, -4f, 0f);
        this.rightWing.setTextureOffset(26, 13).addBox(0f, -1f, -2f, 1f, 10f, 1f, 0f, false);
        this.rightWing.setTextureOffset(26, 14).addBox(0f, -1f, -1f, 1f, 9f, 1f, 0f, false);
        this.rightWing.setTextureOffset(26, 15).addBox(0f, 0f, -3f, 1f, 8f, 1f, 0f, false);
        this.rightWing.setTextureOffset(26, 15).addBox(0f, -1f, 0f, 1f, 8f, 1f, 0f, false);
        this.rightWing.setTextureOffset(26, 17).addBox(0f, 0f, 1f, 1f, 6f, 1f, 0f, false);
        this.rightWing.setTextureOffset(26, 19).addBox(0f, 1f, 2f, 1f, 4f, 1f, 0f, false);
        this.body.addChild(this.rightWing);

        this.tail = new ModelRenderer(this);
        this.tail.setRotationPoint(0f, 3f, 2.5f);
        this.tail.setTextureOffset(18, 0).addBox(-2f, 0f, 0f, 4f, 3f, 0f, 0f, false);
        this.tail.setTextureOffset(18, 3).addBox(-1f, 3f, 0f, 2f, 2f, 0f, 0f, false);
        this.body.addChild(this.tail);

        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0f, -5f, -.5f);
        this.head.rotateAngleX = -.8727f;
        this.head.setTextureOffset(0, 0).addBox(-3f, -5f, -3f, 6f, 5f, 6f, 0f, false);
        this.body.addChild(this.head);

        this.beak = new ModelRenderer(this);
        this.beak.setRotationPoint(0f, -2f, -2.5f);
        this.beak.rotateAngleX = -.6981f;
        this.beak.setTextureOffset(0, 0).addBox(-.5f, .5f, -.5f, 1f, 1f, 1f, 0f, false);
        this.head.addChild(this.beak);
    }

    @Override
    public void setRotationAngles(OwlEntity owl, float limbSwing, float limbSwingAmount, float wingFlap, float netHeadYaw, float headPitch)
    {
        this.lowerBody.rotateAngleX = 0f;
        this.lowerBody.rotationPointY = 19f;
        this.body.rotateAngleX = .8727f;
        this.body.rotationPointX = 0f;
        this.body.rotationPointY = 0f;

        this.rightLeg.rotateAngleX = 0f;
        this.rightLeg.rotationPointY = 5f;
        this.rightLeg.rotationPointZ = 0f;
        this.leftLeg.rotateAngleX = 0f;
        this.leftLeg.rotationPointY = 5f;
        this.leftLeg.rotationPointZ = 0f;

        this.rightWing.rotateAngleX = 0f;
        this.rightWing.rotateAngleZ = 0f;
        this.rightWing.rotationPointX = 3f;
        this.rightWing.rotationPointY = -4f;
        this.leftWing.rotateAngleX = 0f;
        this.leftWing.rotateAngleZ = 0f;
        this.leftWing.rotationPointX = -3f;
        this.leftWing.rotationPointY = -4f;

        this.tail.rotateAngleX = 0f;
        this.tail.rotationPointX = 0f;
        this.tail.rotationPointY = 3F;

        this.head.rotateAngleX = -.8727f + headPitch * ((float) Math.PI / 180f);
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180f);
        this.head.rotateAngleZ = 0f;
        this.head.rotationPointX = 0f;
        this.head.rotationPointY = -5f;

        this.beak.rotateAngleX = -.6981f;

        switch (getOwlState(owl))
        {
            case FLYING:
                this.lowerBody.rotateAngleX += Math.PI / 8f;
                this.lowerBody.rotationPointY += -wingFlap;
                this.body.rotateAngleX -= Math.PI / 8f;

                this.rightLeg.rotateAngleX += .6981317f;
                this.rightLeg.rotationPointY += 1.5f;
                this.rightLeg.rotationPointZ += 1.5f;

                this.leftLeg.rotateAngleX += .6981317f;
                this.leftLeg.rotationPointY += 1.5f;
                this.leftLeg.rotationPointZ += 1.5f;

                this.rightWing.rotateAngleX = (float) -(Math.PI / 8f);
                this.rightWing.rotateAngleZ = (float) (-(Math.PI / 5f) + wingFlap);
                this.leftWing.rotateAngleX = (float) -(Math.PI / 8f);
                this.leftWing.rotateAngleZ = (float) (Math.PI / 5f - wingFlap);

                this.beak.rotateAngleX += MathHelper.sin(wingFlap * .75f) * .2f;
                break;
            case SITTING:
                this.lowerBody.rotationPointY = 20f;
                this.body.rotateAngleX -= Math.PI / 8f;

                this.tail.rotateAngleX += Math.PI / 6f;

                this.head.rotateAngleX += Math.PI / 8f;
                break;
            case PARTYING:
                Minecraft mc = Minecraft.getInstance();
                float ticksExisted = owl.ticksExisted + (mc.isGamePaused() ? mc.renderPartialTicksPaused : mc.getRenderPartialTicks());
                float f = MathHelper.cos(ticksExisted);
                float f1 = MathHelper.sin(ticksExisted);
                this.body.rotationPointX = f;
                this.body.rotationPointY += f1;

                this.leftWing.rotateAngleZ = -0.0873F - wingFlap;
                this.leftWing.rotationPointX += f;
                this.leftWing.rotationPointY += f1;
                this.rightWing.rotateAngleZ = 0.0873F + wingFlap;
                this.rightWing.rotationPointX += f;
                this.rightWing.rotationPointY += f1;

                this.tail.rotationPointX += f;
                this.tail.rotationPointY += f1;

                this.head.rotationPointX += f;
                this.head.rotationPointY += f1;
                this.head.rotateAngleY = 0f;
                this.head.rotateAngleZ = MathHelper.sin(ticksExisted) * 0.4F;
                break;
            case STANDING:
            default:
                this.rightLeg.rotateAngleX += MathHelper.cos(limbSwing * .6662f + (float) Math.PI) * 1.4f * limbSwingAmount;
                this.leftLeg.rotateAngleX += MathHelper.cos(limbSwing * .6662f) * 1.4f * limbSwingAmount;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha)
    {
        lowerBody.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    private static State getOwlState(OwlEntity owl)
    {
        if (owl.isPartying())
            return State.PARTYING;
        else if (owl.isSitting())
            return State.SITTING;
        else
            return owl.isFlying() ? State.FLYING : State.STANDING;
    }

    @OnlyIn(Dist.CLIENT)
    public enum State
    {
        FLYING,
        STANDING,
        SITTING,
        PARTYING
    }
}