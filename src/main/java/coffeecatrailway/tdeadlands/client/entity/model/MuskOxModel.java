package coffeecatrailway.tdeadlands.client.entity.model;

import coffeecatrailway.tdeadlands.common.entity.MuskOxEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class MuskOxModel extends QuadrupedModel<MuskOxEntity>
{
    private final ModelRenderer head;
    private final ModelRenderer leftHornSeg1;
    private final ModelRenderer leftHornSeg2;
    private final ModelRenderer leftHornSeg3;
    private final ModelRenderer rightHornSeg1;
    private final ModelRenderer rightHornSeg2;
    private final ModelRenderer rightHornSeg3;

    public MuskOxModel()
    {
        super(12, 0f, false, 8f, 6f, 2f, 2f, 24);
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.body = new ModelRenderer(this);
        this.body.setRotationPoint(0f, 9f, 0f);
        this.body.rotateAngleX = 0f;
        this.body.setTextureOffset(0, 11).addBox(-6f, -6f, 2f, 12f, 11f, 7f, 0f, false);
        this.body.setTextureOffset(3, 14).addBox(-6f, -5f, -2f, 12f, 11f, 4f, 0f, false);
        this.body.setTextureOffset(5, 16).addBox(-6f, -6f, -4f, 12f, 11f, 2f, 0f, false);
        this.body.setTextureOffset(3, 14).addBox(-6f, -7f, -8f, 12f, 11f, 4f, 0f, false);
        this.body.setTextureOffset(9, 15).addBox(-4f, -6f, -11f, 8f, 10f, 3f, 0f, false);
        this.body.setTextureOffset(9, 15).addBox(-4f, -5f, -14f, 8f, 9f, 3f, 0f, false);

        this.legBackRight = new ModelRenderer(this);
        this.legBackRight.setRotationPoint(3f, 14f, 5f);
        this.legBackRight.setTextureOffset(39, 14).addBox(-2f, 8f, -2f, 4f, 2f, 4f, 0f, false);
        this.legBackRight.setTextureOffset(31, 7).addBox(-1.5f, 4f, -1.5f, 3f, 5f, 3f, 0f, false);
        this.legBackRight.setTextureOffset(16, 19).addBox(-2f, -1f, -2f, 4f, 5f, 4f, 0f, false);

        this.legBackLeft = new ModelRenderer(this);
        this.legBackLeft.setRotationPoint(-3f, 14f, 5f);
        this.legBackLeft.setTextureOffset(39, 14).addBox(-2f, 8f, -2f, 4f, 2f, 4f, 0f, false);
        this.legBackLeft.setTextureOffset(31, 7).addBox(-1.5f, 4f, -1.5f, 3f, 5f, 3f, 0f, false);
        this.legBackLeft.setTextureOffset(12, 14).addBox(-2f, -1f, -2f, 4f, 5f, 4f, 0f, false);

        this.legFrontLeft = new ModelRenderer(this);
        this.legFrontLeft.setRotationPoint(-3f, 14f, -5f);
        this.legFrontLeft.setTextureOffset(39, 14).addBox(-2f, 8f, -2f, 4f, 2f, 4f, 0f, false);
        this.legFrontLeft.setTextureOffset(31, 7).addBox(-1.5f, 4f, -1.5f, 3f, 5f, 3f, 0f, false);
        this.legFrontLeft.setTextureOffset(3, 14).addBox(-2f, -1f, -2f, 4f, 5f, 4f, 0f, false);

        this.legFrontRight = new ModelRenderer(this);
        this.legFrontRight.setRotationPoint(3f, 14f, -5f);
        this.legFrontRight.setTextureOffset(39, 14).addBox(-2f, 8f, -2f, 4f, 2f, 4f, 0f, false);
        this.legFrontRight.setTextureOffset(31, 7).addBox(-1.5f, 4f, -1.5f, 3f, 5f, 3f, 0f, false);
        this.legFrontRight.setTextureOffset(10, 16).addBox(-2f, -1f, -2f, 4f, 5f, 4f, 0f, false);

        this.headModel = new ModelRenderer(this);
        this.headModel.setRotationPoint(0f, 9.5f, -12f);

        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0f, .5f, -3f);
        this.head.setTextureOffset(0, 0).addBox(-3f, -4f, -3f, 6f, 5f, 6f, 0f, false);
        this.head.setTextureOffset(18, 0).addBox(-2f, -2f, -6f, 4f, 3f, 3f, 0f, false);
        this.head.setTextureOffset(29, 0).addBox(-6f, -3f, 2f, 3f, 1f, 2f, 0f, false);
        this.head.setTextureOffset(30, 0).addBox(3f, -3f, 2f, 3f, 1f, 2f, 0f, false);
        this.head.setTextureOffset(37, 0).addBox(-4f, -5f, -1f, 8f, 2f, 3f, 0f, false);
        this.headModel.addChild(this.head);

        this.leftHornSeg1 = new ModelRenderer(this);
        this.leftHornSeg1.setRotationPoint(4f, -5f, 0f);
        this.leftHornSeg1.rotateAngleZ = 1.0472f;
        this.leftHornSeg1.setTextureOffset(24, 6).addBox(0f, 0f, 0f, 3f, 2f, 2f, 0f, false);
        this.head.addChild(this.leftHornSeg1);

        this.leftHornSeg2 = new ModelRenderer(this);
        this.leftHornSeg2.setRotationPoint(3f, 2f, 1f);
        this.leftHornSeg2.rotateAngleZ = -.4363f;
        this.leftHornSeg2.setTextureOffset(24, 6).addBox(0f, -2f, -1f, 3f, 2f, 2f, 0f, false);
        this.leftHornSeg1.addChild(this.leftHornSeg2);

        this.leftHornSeg3 = new ModelRenderer(this);
        this.leftHornSeg3.setRotationPoint(3f, 0f, 0f);
        this.leftHornSeg3.rotateAngleZ = -1.2217f;
        this.leftHornSeg3.setTextureOffset(24, 6).addBox(0f, -2f, -1f, 3f, 2f, 2f, 0f, false);
        this.leftHornSeg2.addChild(this.leftHornSeg3);

        this.rightHornSeg1 = new ModelRenderer(this);
        this.rightHornSeg1.setRotationPoint(-4f, -5f, 2f);
        this.rightHornSeg1.rotateAngleX = 3.1416f;
        this.rightHornSeg1.rotateAngleZ = 2.0944f;
        this.rightHornSeg1.setTextureOffset(24, 6).addBox(0f, 0f, 0f, 3f, 2f, 2f, 0f, false);
        this.head.addChild(this.rightHornSeg1);

        this.rightHornSeg2 = new ModelRenderer(this);
        this.rightHornSeg2.setRotationPoint(3f, 2f, 1f);
        this.rightHornSeg2.rotateAngleZ = -.4363f;
        this.rightHornSeg2.setTextureOffset(24, 6).addBox(0f, -2f, -1f, 3f, 2f, 2f, 0f, false);
        this.rightHornSeg1.addChild(this.rightHornSeg2);

        this.rightHornSeg3 = new ModelRenderer(this);
        this.rightHornSeg3.setRotationPoint(3f, 0f, 0f);
        this.rightHornSeg3.rotateAngleZ = -1.2217f;
        this.rightHornSeg3.setTextureOffset(24, 6).addBox(0f, -2f, -1f, 3f, 2f, 2f, 0f, false);
        this.rightHornSeg2.addChild(this.rightHornSeg3);
    }

    @Override
    public void setRotationAngles(MuskOxEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.body.rotateAngleX = 0f;
    }
}