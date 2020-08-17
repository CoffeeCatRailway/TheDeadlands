// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer Backrightleg;
	private final ModelRenderer Backleftleg;
	private final ModelRenderer Frontleftleg;
	private final ModelRenderer Frontrightleg;
	private final ModelRenderer Neck;
	private final ModelRenderer Head;
	private final ModelRenderer RightHorn;
	private final ModelRenderer bone3;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer LeftHorn;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;

	public custom_model() {
		textureWidth = 55;
		textureHeight = 29;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 9.0F, 0.0F);
		Body.setTextureOffset(0, 11).addBox(-6.0F, -6.0F, 2.0F, 12.0F, 11.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(3, 14).addBox(-6.0F, -7.0F, -8.0F, 12.0F, 11.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(5, 16).addBox(-6.0F, -6.0F, -4.0F, 12.0F, 11.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(9, 15).addBox(-4.0F, -6.0F, -11.0F, 8.0F, 10.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(9, 15).addBox(-4.0F, -5.0F, -14.0F, 8.0F, 9.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(3, 14).addBox(-6.0F, -5.0F, -2.0F, 12.0F, 11.0F, 4.0F, 0.0F, false);

		Backrightleg = new ModelRenderer(this);
		Backrightleg.setRotationPoint(3.0F, 5.0F, 5.0F);
		Body.addChild(Backrightleg);
		Backrightleg.setTextureOffset(39, 14).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		Backrightleg.setTextureOffset(31, 7).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		Backrightleg.setTextureOffset(16, 19).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		Backleftleg = new ModelRenderer(this);
		Backleftleg.setRotationPoint(-3.0F, 5.0F, 5.0F);
		Body.addChild(Backleftleg);
		Backleftleg.setTextureOffset(39, 14).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		Backleftleg.setTextureOffset(31, 7).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		Backleftleg.setTextureOffset(12, 14).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		Frontleftleg = new ModelRenderer(this);
		Frontleftleg.setRotationPoint(-3.0F, 5.0F, -5.0F);
		Body.addChild(Frontleftleg);
		Frontleftleg.setTextureOffset(39, 14).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		Frontleftleg.setTextureOffset(31, 7).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		Frontleftleg.setTextureOffset(3, 14).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		Frontrightleg = new ModelRenderer(this);
		Frontrightleg.setRotationPoint(3.0F, 5.0F, -5.0F);
		Body.addChild(Frontrightleg);
		Frontrightleg.setTextureOffset(39, 14).addBox(-2.0F, 8.0F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		Frontrightleg.setTextureOffset(31, 7).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		Frontrightleg.setTextureOffset(10, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 0.0F, -12.0F);
		Body.addChild(Neck);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 3.0F, -1.0F);
		Neck.addChild(Head);
		setRotationAngle(Head, 0.8727F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(18, 0).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(29, 0).addBox(-6.0F, -3.0F, 2.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(30, 0).addBox(3.0F, -3.0F, 2.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		RightHorn = new ModelRenderer(this);
		RightHorn.setRotationPoint(4.0F, -5.0F, 1.0F);
		Head.addChild(RightHorn);
		RightHorn.setTextureOffset(37, 0).addBox(-4.0F, 0.0F, -2.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, -1.0F);
		RightHorn.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 1.0472F);
		bone3.setTextureOffset(24, 6).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.0F, 2.0F, 1.0F);
		bone3.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.0F, -0.4363F);
		bone.setTextureOffset(24, 6).addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(3.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.0F, -1.2217F);
		bone2.setTextureOffset(24, 6).addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		LeftHorn = new ModelRenderer(this);
		LeftHorn.setRotationPoint(-4.0F, -5.0F, 1.0F);
		Head.addChild(LeftHorn);
		setRotationAngle(LeftHorn, 0.0F, 3.1416F, 0.0F);
		LeftHorn.setTextureOffset(37, 0).addBox(-4.0F, 0.0F, -1.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, -1.0F);
		LeftHorn.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, 1.0472F);
		bone4.setTextureOffset(24, 6).addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, 2.0F, 1.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -0.4363F);
		bone5.setTextureOffset(24, 6).addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(3.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0F, -1.2217F);
		bone6.setTextureOffset(24, 6).addBox(0.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
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