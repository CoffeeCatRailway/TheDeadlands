package coffeecatrailway.tdeadlands.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BindedOne extends EntityModel<Entity> {

	private final ModelRenderer Body;
	private final ModelRenderer Pelvis;
	private final ModelRenderer Leg3;
	private final ModelRenderer LowerLeg3;
	private final ModelRenderer Foot3;
	private final ModelRenderer Leg2;
	private final ModelRenderer LowerLeg2;
	private final ModelRenderer Foot2;
	private final ModelRenderer Leg1;
	private final ModelRenderer LowerLeg;
	private final ModelRenderer Foot;
	private final ModelRenderer Chest;
	private final ModelRenderer MidSpine;
	private final ModelRenderer Chain;
	private final ModelRenderer Chain3;
	private final ModelRenderer Chain4;
	private final ModelRenderer UpperSpine;
	private final ModelRenderer Heads;
	private final ModelRenderer Happy;
	private final ModelRenderer Sad;
	private final ModelRenderer Angry;
	private final ModelRenderer Fear;
	private final ModelRenderer Disgust;
	private final ModelRenderer Chains;
	private final ModelRenderer Chain1;
	private final ModelRenderer Chain2;

	public BindedOne() {
		textureWidth = 64;
		textureHeight = 71;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 12.0F, 2.0F);
		

		Pelvis = new ModelRenderer(this);
		Pelvis.setRotationPoint(0.0F, -1.366F, 0.366F);
		Body.addChild(Pelvis);
		Pelvis.setTextureOffset(36, 43).addBox(-5.0F, -0.5F, -3.866F, 10.0F, 1.0F, 4.0F, 0.0F, false);

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(3.0F, 0.366F, -2.366F);
		Pelvis.addChild(Leg3);
		setRotationAngle(Leg3, -1.309F, 2.9671F, 0.0F);
		Leg3.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		LowerLeg3 = new ModelRenderer(this);
		LowerLeg3.setRotationPoint(0.0F, 12.0F, 0.0F);
		Leg3.addChild(LowerLeg3);
		setRotationAngle(LowerLeg3, 2.0944F, 0.0F, 0.0F);
		LowerLeg3.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		Foot3 = new ModelRenderer(this);
		Foot3.setRotationPoint(0.0F, 12.0F, 0.0F);
		LowerLeg3.addChild(Foot3);
		setRotationAngle(Foot3, -0.7854F, 0.0F, 0.0F);
		Foot3.setTextureOffset(48, 37).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(3.0F, 0.366F, -2.366F);
		Pelvis.addChild(Leg2);
		setRotationAngle(Leg2, -1.309F, -0.6981F, 0.0F);
		Leg2.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		LowerLeg2 = new ModelRenderer(this);
		LowerLeg2.setRotationPoint(0.0F, 12.0F, 0.0F);
		Leg2.addChild(LowerLeg2);
		setRotationAngle(LowerLeg2, 2.0944F, 0.0F, 0.0F);
		LowerLeg2.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		Foot2 = new ModelRenderer(this);
		Foot2.setRotationPoint(0.0F, 12.0F, 0.0F);
		LowerLeg2.addChild(Foot2);
		setRotationAngle(Foot2, -0.7854F, 0.0F, 0.0F);
		Foot2.setTextureOffset(48, 37).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(-2.0F, 0.366F, -2.366F);
		Pelvis.addChild(Leg1);
		setRotationAngle(Leg1, -1.309F, 0.7854F, 0.0F);
		Leg1.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		LowerLeg = new ModelRenderer(this);
		LowerLeg.setRotationPoint(0.0F, 12.0F, 0.0F);
		Leg1.addChild(LowerLeg);
		setRotationAngle(LowerLeg, 2.0944F, 0.0F, 0.0F);
		LowerLeg.setTextureOffset(0, 48).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		Foot = new ModelRenderer(this);
		Foot.setRotationPoint(0.0F, 12.0F, 0.0F);
		LowerLeg.addChild(Foot);
		setRotationAngle(Foot, -0.7854F, 0.0F, 0.0F);
		Foot.setTextureOffset(0, 48).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		Chest = new ModelRenderer(this);
		Chest.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Chest);
		setRotationAngle(Chest, -0.5236F, 0.0F, 0.0F);
		Chest.setTextureOffset(32, 38).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		MidSpine = new ModelRenderer(this);
		MidSpine.setRotationPoint(0.0F, -8.0F, 0.0F);
		Chest.addChild(MidSpine);
		setRotationAngle(MidSpine, 0.5236F, 0.0F, 0.0F);
		MidSpine.setTextureOffset(32, 38).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		MidSpine.setTextureOffset(8, 48).addBox(-4.0F, -9.0F, -6.0F, 8.0F, 10.0F, 5.0F, 0.0F, false);

		Chain = new ModelRenderer(this);
		Chain.setRotationPoint(1.0F, -4.0F, 0.0F);
		MidSpine.addChild(Chain);
		

		Chain3 = new ModelRenderer(this);
		Chain3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Chain.addChild(Chain3);
		setRotationAngle(Chain3, 0.0F, 0.0F, -0.6981F);
		Chain3.setTextureOffset(32, 63).addBox(-6.0F, -3.0F, -4.0F, 11.0F, 3.0F, 5.0F, 0.0F, false);

		Chain4 = new ModelRenderer(this);
		Chain4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Chain.addChild(Chain4);
		setRotationAngle(Chain4, 0.0F, 0.0F, 0.7854F);
		Chain4.setTextureOffset(32, 63).addBox(-7.0F, -1.0F, -4.0F, 11.0F, 3.0F, 5.0F, 0.0F, false);

		UpperSpine = new ModelRenderer(this);
		UpperSpine.setRotationPoint(0.0F, -8.0F, 0.0F);
		MidSpine.addChild(UpperSpine);
		setRotationAngle(UpperSpine, 0.5236F, 0.0F, 0.0F);
		UpperSpine.setTextureOffset(0, 2).addBox(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		UpperSpine.setTextureOffset(24, 32).addBox(-6.0F, -6.0F, -2.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
		UpperSpine.setTextureOffset(0, 2).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		Heads = new ModelRenderer(this);
		Heads.setRotationPoint(5.0F, -7.2321F, -4.866F);
		UpperSpine.addChild(Heads);
		

		Happy = new ModelRenderer(this);
		Happy.setRotationPoint(-2.0F, -2.9641F, 5.5981F);
		Heads.addChild(Happy);
		setRotationAngle(Happy, 0.0F, -0.8727F, -0.4363F);
		Happy.setTextureOffset(0, 0).addBox(-4.0F, -3.8038F, -7.7321F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Sad = new ModelRenderer(this);
		Sad.setRotationPoint(-9.0F, -0.2321F, 3.3301F);
		Heads.addChild(Sad);
		setRotationAngle(Sad, -1.1345F, 0.5236F, -0.8727F);
		Sad.setTextureOffset(0, 16).addBox(-4.0F, -3.5359F, -7.4641F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Angry = new ModelRenderer(this);
		Angry.setRotationPoint(-10.0F, 1.866F, 3.7679F);
		Heads.addChild(Angry);
		setRotationAngle(Angry, 0.0F, 0.6109F, -0.5236F);
		Angry.setTextureOffset(32, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Fear = new ModelRenderer(this);
		Fear.setRotationPoint(1.0F, 5.7321F, 4.2679F);
		Heads.addChild(Fear);
		setRotationAngle(Fear, 0.2618F, -0.6981F, 0.0F);
		Fear.setTextureOffset(0, 32).addBox(-4.0F, -8.0F, -7.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Disgust = new ModelRenderer(this);
		Disgust.setRotationPoint(-5.0F, -2.0359F, 4.5981F);
		Heads.addChild(Disgust);
		setRotationAngle(Disgust, -0.5236F, 0.0F, 0.0F);
		Disgust.setTextureOffset(32, 16).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Chains = new ModelRenderer(this);
		Chains.setRotationPoint(-8.0F, -1.9019F, 2.8301F);
		Heads.addChild(Chains);
		

		Chain1 = new ModelRenderer(this);
		Chain1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Chains.addChild(Chain1);
		setRotationAngle(Chain1, 0.0F, 0.0F, 0.8727F);
		Chain1.setTextureOffset(26, 62).addBox(-4.8106F, -1.8543F, -3.0F, 13.0F, 3.0F, 6.0F, 0.0F, false);

		Chain2 = new ModelRenderer(this);
		Chain2.setRotationPoint(5.0F, 0.0F, 0.0F);
		Chains.addChild(Chain2);
		setRotationAngle(Chain2, 0.0F, 0.0F, 2.2689F);
		Chain2.setTextureOffset(28, 65).addBox(-3.0F, -3.0F, 0.0F, 15.0F, 3.0F, 3.0F, 0.0F, false);
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