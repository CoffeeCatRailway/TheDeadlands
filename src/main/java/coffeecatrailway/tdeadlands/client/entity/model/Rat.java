package coffeecatrailway.tdeadlands.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// TODO: QuadrupedModel
public class Rat extends EntityModel<Entity> {

	private final ModelRenderer Body;
	private final ModelRenderer Lowbody;
	private final ModelRenderer Upperbody;
	private final ModelRenderer Head;
	private final ModelRenderer Tail;
	private final ModelRenderer bone;

	public Rat() {
		textureWidth = 40;
		textureHeight = 9;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(11, 0).addBox(-2.5F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(11, 0).addBox(1.5F, -1.0F, 2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Lowbody = new ModelRenderer(this);
		Lowbody.setRotationPoint(0.0F, -2.0F, 4.0F);
		Body.addChild(Lowbody);
		Lowbody.setTextureOffset(18, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		Upperbody = new ModelRenderer(this);
		Upperbody.setRotationPoint(0.0F, 0.0F, -3.0F);
		Lowbody.addChild(Upperbody);
		Upperbody.setTextureOffset(19, 0).addBox(-2.5F, -2.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		Upperbody.setTextureOffset(11, 0).addBox(1.0F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Upperbody.setTextureOffset(11, 0).addBox(-2.0F, 1.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -5.0F);
		Upperbody.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 6).addBox(-3.0F, -3.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(5, 6).addBox(1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -2.0F, 6.0F);
		Body.addChild(Tail);
		setRotationAngle(Tail, -0.4363F, 0.0F, 0.0F);
		Tail.setTextureOffset(14, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 3.0F);
		Tail.addChild(bone);
		setRotationAngle(bone, 0.4363F, 0.0F, 0.0F);
		bone.setTextureOffset(14, 0).addBox(-0.5F, -0.0261F, -0.8191F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(16, 1).addBox(-0.5F, -0.0261F, 2.1809F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}