// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class SnowMaiden extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer MiddleBody;
	private final ModelRenderer Chest;
	private final ModelRenderer boobsbecausewhythefucknot;
	private final ModelRenderer Head;
	private final ModelRenderer Hair;
	private final ModelRenderer Hairstrings;
	private final ModelRenderer LeftArm;
	private final ModelRenderer Leftlowerarm;
	private final ModelRenderer Knife;
	private final ModelRenderer RightArm;
	private final ModelRenderer Leftlowerarm2;
	private final ModelRenderer legs;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Rightlowerleg;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Leftlowerleg;

	public SnowMaiden() {
		textureWidth = 145;
		textureHeight = 40;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 11.0F, 0.0F);
		body.setTextureOffset(26, 33).addBox(-4.0F, -3.75F, -2.0F, 8.0F, 3.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(84, 31).addBox(-4.5F, -4.5F, -2.5F, 9.0F, 4.0F, 5.0F, 0.0F, false);

		MiddleBody = new ModelRenderer(this);
		MiddleBody.setRotationPoint(0.0F, -4.0F, 0.0F);
		body.addChild(MiddleBody);
		MiddleBody.setTextureOffset(46, 30).addBox(-3.0F, -2.75F, -2.0F, 6.0F, 3.0F, 4.0F, 0.0F, false);
		MiddleBody.setTextureOffset(87, 13).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 2.0F, 5.0F, 0.0F, false);

		Chest = new ModelRenderer(this);
		Chest.setRotationPoint(0.0F, -3.0F, 0.0F);
		MiddleBody.addChild(Chest);
		Chest.setTextureOffset(83, 0).addBox(-4.5F, -6.5F, -2.5F, 9.0F, 7.0F, 5.0F, 0.0F, false);
		Chest.setTextureOffset(62, 23).addBox(-4.0F, -6.75F, -2.0F, 8.0F, 7.0F, 4.0F, 0.0F, false);

		boobsbecausewhythefucknot = new ModelRenderer(this);
		boobsbecausewhythefucknot.setRotationPoint(0.0F, -3.0F, -2.0F);
		Chest.addChild(boobsbecausewhythefucknot);
		setRotationAngle(boobsbecausewhythefucknot, -0.2618F, 0.0F, 0.0F);
		boobsbecausewhythefucknot.setTextureOffset(74, 29).addBox(-3.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		boobsbecausewhythefucknot.setTextureOffset(74, 29).addBox(1.0F, -1.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		boobsbecausewhythefucknot.setTextureOffset(87, 34).addBox(-4.0F, -1.75F, -0.75F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -8.0F, 0.0F);
		Chest.addChild(Head);
		Head.setTextureOffset(0, 1).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(1.0F, -4.0F, -3.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(32, 0).addBox(-4.5F, -8.5F, -4.5F, 9.0F, 10.0F, 9.0F, 0.0F, false);
		Head.setTextureOffset(0, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Hair = new ModelRenderer(this);
		Hair.setRotationPoint(0.0F, 1.0F, 0.0F);
		Head.addChild(Hair);
		Hair.setTextureOffset(17, 11).addBox(-4.45F, -8.65F, -4.2F, 0.0F, 9.0F, 8.0F, 0.0F, false);
		Hair.setTextureOffset(17, 11).addBox(4.4F, -8.65F, -4.24F, 0.0F, 9.0F, 8.0F, 0.0F, false);
		Hair.setTextureOffset(8, 17).addBox(3.5F, -8.0F, -4.24F, 1.0F, 8.0F, 0.0F, 0.0F, false);
		Hair.setTextureOffset(0, 17).addBox(-4.45F, -8.0F, -4.24F, 1.0F, 8.0F, 0.0F, 0.0F, false);
		Hair.setTextureOffset(33, 19).addBox(-4.0F, -8.65F, 4.25F, 8.0F, 9.0F, 0.0F, 0.0F, false);
		Hair.setTextureOffset(0, 17).addBox(-4.0F, -9.0F, -4.25F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		Hairstrings = new ModelRenderer(this);
		Hairstrings.setRotationPoint(0.0F, -7.0F, -2.0F);
		Chest.addChild(Hairstrings);
		setRotationAngle(Hairstrings, -0.4363F, 0.0F, 0.0F);
		Hairstrings.setTextureOffset(4, 25).addBox(1.0F, 0.25F, -0.1F, 2.0F, 7.0F, 0.0F, 0.0F, false);
		Hairstrings.setTextureOffset(0, 25).addBox(-3.0F, 0.25F, -0.1F, 2.0F, 7.0F, 0.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(-5.0F, -6.0F, 0.0F);
		Chest.addChild(LeftArm);
		setRotationAngle(LeftArm, -2.2689F, 0.6109F, -0.2618F);
		LeftArm.setTextureOffset(87, 9).addBox(-2.0F, -1.25F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		LeftArm.setTextureOffset(74, 23).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leftlowerarm = new ModelRenderer(this);
		Leftlowerarm.setRotationPoint(0.0F, 6.0F, 0.0F);
		LeftArm.addChild(Leftlowerarm);
		setRotationAngle(Leftlowerarm, -1.5708F, -0.0873F, 0.0F);
		Leftlowerarm.setTextureOffset(88, 2).addBox(-2.0F, -1.25F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		Leftlowerarm.setTextureOffset(74, 23).addBox(-1.5F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		Knife = new ModelRenderer(this);
		Knife.setRotationPoint(0.0F, 6.0F, 0.0F);
		Leftlowerarm.addChild(Knife);
		Knife.setTextureOffset(7, 37).addBox(-0.5F, 1.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Knife.setTextureOffset(4, 34).addBox(-0.5F, 0.5F, 4.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		Knife.setTextureOffset(0, 36).addBox(-0.5F, 0.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Knife.setTextureOffset(24, 0).addBox(-0.5F, 1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Knife.setTextureOffset(74, 25).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(5.0F, -6.0F, 0.0F);
		Chest.addChild(RightArm);
		setRotationAngle(RightArm, 0.0F, 0.4363F, -0.7854F);
		RightArm.setTextureOffset(87, 10).addBox(-1.0F, -1.25F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		RightArm.setTextureOffset(74, 23).addBox(-0.9F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		Leftlowerarm2 = new ModelRenderer(this);
		Leftlowerarm2.setRotationPoint(0.0F, 6.0F, 0.0F);
		RightArm.addChild(Leftlowerarm2);
		setRotationAngle(Leftlowerarm2, -0.8727F, 0.5236F, 0.0F);
		Leftlowerarm2.setTextureOffset(88, 2).addBox(-1.0F, -1.25F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, false);
		Leftlowerarm2.setTextureOffset(74, 23).addBox(-0.9F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		Leftlowerarm2.setTextureOffset(74, 24).addBox(-1.0F, 6.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 10.0F, 0.0F);
		legs.setTextureOffset(114, 21).addBox(-4.5F, 0.0F, -2.5F, 9.0F, 14.0F, 5.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(2.0F, 0.0F, 0.0F);
		legs.addChild(RightLeg);
		RightLeg.setTextureOffset(69, 0).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		Rightlowerleg = new ModelRenderer(this);
		Rightlowerleg.setRotationPoint(0.0F, 7.0F, -1.0F);
		RightLeg.addChild(Rightlowerleg);
		Rightlowerleg.setTextureOffset(69, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
		Rightlowerleg.setTextureOffset(67, 27).addBox(-1.0F, 6.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(-2.0F, 0.0F, 0.0F);
		legs.addChild(LeftLeg);
		LeftLeg.setTextureOffset(69, 0).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		Leftlowerleg = new ModelRenderer(this);
		Leftlowerleg.setRotationPoint(0.0F, 7.0F, -1.0F);
		LeftLeg.addChild(Leftlowerleg);
		Leftlowerleg.setTextureOffset(69, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 4.0F, 0.0F, false);
		Leftlowerleg.setTextureOffset(66, 27).addBox(-2.0F, 6.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		legs.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}