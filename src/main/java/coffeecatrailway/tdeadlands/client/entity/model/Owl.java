package coffeecatrailway.tdeadlands.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// TODO: Look at parrot
public class Owl extends EntityModel<Entity> {

	private final ModelRenderer Lowerbody;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Body;
	private final ModelRenderer Leftwing;
	private final ModelRenderer Rightwing;
	private final ModelRenderer Tail;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer Head;
	private final ModelRenderer Beak;

	public Owl() {
		textureWidth = 44;
		textureHeight = 24;

		Lowerbody = new ModelRenderer(this);
		Lowerbody.setRotationPoint(0.0F, 19.0F, 0.0F);
		Lowerbody.setTextureOffset(24, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, 5.0F, 0.0F);
		Lowerbody.addChild(LeftLeg);
		LeftLeg.setTextureOffset(24, 8).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(32, 8).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(32, 8).addBox(-3.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(32, 8).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(36, 8).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(0.0F, 5.0F, 0.0F);
		Lowerbody.addChild(RightLeg);
		RightLeg.setTextureOffset(24, 8).addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(32, 8).addBox(2.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(32, 8).addBox(0.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(32, 8).addBox(0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(36, 8).addBox(0.0F, -4.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Lowerbody.addChild(Body);
		setRotationAngle(Body, 0.8727F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 11).addBox(-3.0F, -5.0F, -2.5F, 6.0F, 8.0F, 5.0F, 0.0F, false);

		Leftwing = new ModelRenderer(this);
		Leftwing.setRotationPoint(-3.0F, -4.0F, 0.0F);
		Body.addChild(Leftwing);
		Leftwing.setTextureOffset(22, 13).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Leftwing.setTextureOffset(22, 14).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		Leftwing.setTextureOffset(22, 15).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		Leftwing.setTextureOffset(22, 15).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		Leftwing.setTextureOffset(22, 17).addBox(-1.0F, 0.0F, 1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Leftwing.setTextureOffset(22, 19).addBox(-1.0F, 1.0F, 2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Rightwing = new ModelRenderer(this);
		Rightwing.setRotationPoint(3.0F, -4.0F, 0.0F);
		Body.addChild(Rightwing);
		Rightwing.setTextureOffset(26, 13).addBox(0.0F, -1.0F, -2.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Rightwing.setTextureOffset(26, 14).addBox(0.0F, -1.0F, -1.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		Rightwing.setTextureOffset(26, 15).addBox(0.0F, 0.0F, -3.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		Rightwing.setTextureOffset(26, 15).addBox(0.0F, -1.0F, 0.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		Rightwing.setTextureOffset(26, 17).addBox(0.0F, 0.0F, 1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		Rightwing.setTextureOffset(26, 19).addBox(0.0F, 1.0F, 2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 3.0F, 2.5F);
		Body.addChild(Tail);
		Tail.setTextureOffset(18, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, false);
		Tail.setTextureOffset(18, 3).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -5.0F, -0.5F);
		Body.addChild(bone);
		setRotationAngle(bone, -0.7854F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(Head);
		setRotationAngle(Head, -0.0873F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);

		Beak = new ModelRenderer(this);
		Beak.setRotationPoint(0.0F, -2.0F, -2.5F);
		Head.addChild(Beak);
		setRotationAngle(Beak, -0.6981F, 0.0F, 0.0F);
		Beak.setTextureOffset(0, 0).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Lowerbody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}