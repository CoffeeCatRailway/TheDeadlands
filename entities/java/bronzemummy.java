// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer MainBody;
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer hat;
	private final ModelRenderer Arms;
	private final ModelRenderer Rightarm;
	private final ModelRenderer Leftarm;
	private final ModelRenderer Shield;
	private final ModelRenderer Rightleg;
	private final ModelRenderer RightLowerLeg;
	private final ModelRenderer Leftleg;
	private final ModelRenderer Leftlowerleg;

	public custom_model() {
		textureWidth = 102;
		textureHeight = 60;

		MainBody = new ModelRenderer(this);
		MainBody.setRotationPoint(0.0F, 7.0F, 0.0F);
		

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		MainBody.addChild(Body);
		Body.setTextureOffset(28, 17).addBox(-5.5F, -13.0F, -2.0F, 11.0F, 8.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(28, 29).addBox(-4.5F, -5.0F, -2.0F, 9.0F, 5.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(0, 16).addBox(-4.0F, -12.0F, -1.5F, 8.0F, 12.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -14.0F, 0.0F);
		Body.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 16).addBox(-3.5F, -6.5F, -3.5F, 7.0F, 7.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(7, 16).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, -3.0F, 1.0F);
		Head.addChild(hat);
		setRotationAngle(hat, 0.0F, 0.0F, 0.7854F);
		hat.setTextureOffset(32, 0).addBox(-1.0F, -7.0F, -2.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		hat.setTextureOffset(40, 0).addBox(-8.0F, -7.0F, -2.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		hat.setTextureOffset(32, 9).addBox(-7.0F, -1.0F, -2.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		hat.setTextureOffset(32, 13).addBox(-7.0F, -8.0F, -2.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		Arms = new ModelRenderer(this);
		Arms.setRotationPoint(-4.0F, -12.0F, 0.0F);
		Body.addChild(Arms);
		

		Rightarm = new ModelRenderer(this);
		Rightarm.setRotationPoint(9.0F, 1.0F, 0.0F);
		Arms.addChild(Rightarm);
		setRotationAngle(Rightarm, -0.6981F, -0.5236F, 0.0F);
		Rightarm.setTextureOffset(0, 16).addBox(0.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		Rightarm.setTextureOffset(0, 45).addBox(-0.5F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		Rightarm.setTextureOffset(16, 51).addBox(-0.25F, -2.0F, -2.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);
		Rightarm.setTextureOffset(0, 16).addBox(-6.0F, 6.0F, -1.5F, 8.0F, 2.0F, 3.0F, 0.0F, false);
		Rightarm.setTextureOffset(30, 45).addBox(-6.5F, 5.5F, -2.0F, 9.0F, 3.0F, 4.0F, 0.0F, false);

		Leftarm = new ModelRenderer(this);
		Leftarm.setRotationPoint(-1.0F, 1.0F, 0.0F);
		Arms.addChild(Leftarm);
		setRotationAngle(Leftarm, -0.6981F, 0.5236F, 0.0F);
		Leftarm.setTextureOffset(0, 16).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, false);
		Leftarm.setTextureOffset(14, 36).addBox(-3.5F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		Leftarm.setTextureOffset(0, 31).addBox(-3.75F, -2.0F, -2.5F, 4.0F, 4.0F, 5.0F, 0.0F, false);
		Leftarm.setTextureOffset(0, 16).addBox(-2.0F, 6.0F, -1.5F, 8.0F, 2.0F, 3.0F, 0.0F, false);
		Leftarm.setTextureOffset(30, 38).addBox(-2.5F, 5.5F, -2.0F, 9.0F, 3.0F, 4.0F, 0.0F, false);

		Shield = new ModelRenderer(this);
		Shield.setRotationPoint(0.0F, 11.0F, 0.0F);
		Arms.addChild(Shield);
		Shield.setTextureOffset(50, 0).addBox(-3.0F, -14.0F, -9.5F, 14.0F, 11.0F, 1.0F, 0.0F, false);
		Shield.setTextureOffset(54, 12).addBox(-2.0F, -3.0F, -9.5F, 12.0F, 7.0F, 1.0F, 0.0F, false);
		Shield.setTextureOffset(58, 20).addBox(-1.0F, 4.0F, -9.5F, 10.0F, 4.0F, 1.0F, 0.0F, false);

		Rightleg = new ModelRenderer(this);
		Rightleg.setRotationPoint(3.0F, 0.0F, 0.0F);
		MainBody.addChild(Rightleg);
		Rightleg.setTextureOffset(0, 17).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		Rightleg.setTextureOffset(80, 25).addBox(-3.0F, -3.0F, -2.5F, 5.0F, 10.0F, 5.0F, 0.0F, false);

		RightLowerLeg = new ModelRenderer(this);
		RightLowerLeg.setRotationPoint(0.0F, 8.0F, 0.0F);
		Rightleg.addChild(RightLowerLeg);
		RightLowerLeg.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		RightLowerLeg.setTextureOffset(80, 0).addBox(-3.0F, -4.0F, -3.0F, 5.0F, 11.0F, 6.0F, 0.0F, false);
		RightLowerLeg.setTextureOffset(0, 16).addBox(-2.0F, 7.75F, -4.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		RightLowerLeg.setTextureOffset(78, 51).addBox(-2.5F, 7.0F, -4.5F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		Leftleg = new ModelRenderer(this);
		Leftleg.setRotationPoint(-2.0F, 0.0F, 0.0F);
		MainBody.addChild(Leftleg);
		Leftleg.setTextureOffset(0, 17).addBox(-2.5F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		Leftleg.setTextureOffset(60, 25).addBox(-3.0F, -3.0F, -2.5F, 5.0F, 10.0F, 5.0F, 0.0F, false);

		Leftlowerleg = new ModelRenderer(this);
		Leftlowerleg.setRotationPoint(-1.0F, 8.0F, 0.0F);
		Leftleg.addChild(Leftlowerleg);
		Leftlowerleg.setTextureOffset(0, 16).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		Leftlowerleg.setTextureOffset(58, 40).addBox(-2.0F, -4.0F, -3.0F, 5.0F, 11.0F, 6.0F, 0.0F, false);
		Leftlowerleg.setTextureOffset(0, 16).addBox(-1.0F, 7.75F, -4.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		Leftlowerleg.setTextureOffset(78, 51).addBox(-1.5F, 7.0F, -4.5F, 4.0F, 2.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		MainBody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}