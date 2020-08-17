// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer Spine;
	private final ModelRenderer SpineMid;
	private final ModelRenderer Neck;
	private final ModelRenderer headbase;
	private final ModelRenderer Head;
	private final ModelRenderer jaw;
	private final ModelRenderer Ribcage;
	private final ModelRenderer leftbase;
	private final ModelRenderer Leftarm;
	private final ModelRenderer Leftlowerarm;
	private final ModelRenderer lefthand;
	private final ModelRenderer rightbase;
	private final ModelRenderer RIghtarm;
	private final ModelRenderer rightlowerarm;
	private final ModelRenderer righthand;
	private final ModelRenderer Leftleg;
	private final ModelRenderer Leftlowerleg;
	private final ModelRenderer leftfoot;
	private final ModelRenderer Rightleg;
	private final ModelRenderer rightlowerleg;
	private final ModelRenderer rightfoot;

	public custom_model() {
		textureWidth = 85;
		textureHeight = 40;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 4.0F, 6.0F);
		Body.setTextureOffset(0, 25).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(9, 33).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 1.0F, 4.0F, 0.0F, false);

		Spine = new ModelRenderer(this);
		Spine.setRotationPoint(0.0F, -5.0F, 0.0F);
		Body.addChild(Spine);
		setRotationAngle(Spine, 0.2618F, 0.0F, 0.0F);
		Spine.setTextureOffset(0, 25).addBox(-1.0F, -5.2588F, -1.9659F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		SpineMid = new ModelRenderer(this);
		SpineMid.setRotationPoint(0.0F, -5.0F, 0.0F);
		Spine.addChild(SpineMid);
		setRotationAngle(SpineMid, 0.2618F, 0.0F, 0.0F);
		SpineMid.setTextureOffset(0, 25).addBox(-1.0F, -5.5F, -1.866F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		SpineMid.setTextureOffset(8, 30).addBox(-5.0F, -3.5F, -0.866F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, -8.0F, 0.0F);
		SpineMid.addChild(Neck);
		setRotationAngle(Neck, 0.2618F, 0.0F, 0.0F);
		Neck.setTextureOffset(0, 25).addBox(-1.0F, -0.8093F, -2.4836F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		headbase = new ModelRenderer(this);
		headbase.setRotationPoint(0.0F, 0.0F, 0.0F);
		Neck.addChild(headbase);
		setRotationAngle(headbase, -0.7854F, 0.0F, 0.0F);
		

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 1.0F, -0.7765F);
		headbase.addChild(Head);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -7.1022F, -9.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-3.0F, -4.1022F, -8.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-1.0F, -2.1022F, -8.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(1.0F, -4.1022F, -8.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(-1.25F, -0.4022F, -8.9F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(0.25F, -0.4022F, -8.9F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(1.75F, -0.4022F, -8.9F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(-2.75F, -0.4022F, -8.9F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 1).addBox(3.9F, -0.5022F, -5.25F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 1).addBox(3.9F, -0.5022F, -7.75F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 1).addBox(-3.9F, -0.5022F, -5.25F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 1).addBox(-3.9F, -0.5022F, -6.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 1).addBox(3.9F, -0.5022F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 1).addBox(-3.9F, -0.5022F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(45, 18).addBox(-4.5F, -7.5F, -9.2235F, 9.0F, 13.0F, 9.0F, 0.0F, false);

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(0.0F, 0.3978F, 0.0F);
		Head.addChild(jaw);
		setRotationAngle(jaw, 0.2618F, 0.0F, 0.0F);
		jaw.setTextureOffset(0, 16).addBox(-4.0F, -0.6736F, -8.9848F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		jaw.setTextureOffset(0, 2).addBox(-1.25F, -0.9736F, -8.8848F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 2).addBox(0.25F, -0.9736F, -8.8848F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 2).addBox(1.75F, -0.9736F, -8.8848F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 2).addBox(-4.0F, -0.9736F, -8.8848F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 2).addBox(3.0F, -0.9736F, -8.8848F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		jaw.setTextureOffset(0, 1).addBox(-3.9F, -1.0736F, -8.9848F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jaw.setTextureOffset(0, 1).addBox(3.9F, -1.0736F, -8.9848F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jaw.setTextureOffset(0, 1).addBox(3.9F, -1.0736F, -6.4848F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		jaw.setTextureOffset(0, 1).addBox(-3.9F, -1.0736F, -7.7348F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		Ribcage = new ModelRenderer(this);
		Ribcage.setRotationPoint(0.0F, 0.0F, 0.0F);
		SpineMid.addChild(Ribcage);
		setRotationAngle(Ribcage, -0.1745F, 0.0F, 0.0F);
		Ribcage.setTextureOffset(32, 0).addBox(-4.0F, -1.342F, -4.9397F, 8.0F, 7.0F, 4.0F, 0.0F, false);
		Ribcage.setTextureOffset(49, 20).addBox(-4.5F, -4.5F, -5.5F, 9.0F, 12.0F, 7.0F, 0.0F, false);

		leftbase = new ModelRenderer(this);
		leftbase.setRotationPoint(-4.0F, -3.0F, 0.0F);
		SpineMid.addChild(leftbase);
		setRotationAngle(leftbase, -0.5236F, 0.0F, 0.0F);
		

		Leftarm = new ModelRenderer(this);
		Leftarm.setRotationPoint(-1.0F, 1.0F, 1.0F);
		leftbase.addChild(Leftarm);
		setRotationAngle(Leftarm, 0.0F, 0.0F, 0.6109F);
		Leftarm.setTextureOffset(37, 27).addBox(-1.0946F, -1.6504F, -1.8251F, 2.0F, 10.0F, 2.0F, 0.0F, false);
		Leftarm.setTextureOffset(64, 1).addBox(-1.4084F, -2.1569F, -2.5402F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		Leftlowerarm = new ModelRenderer(this);
		Leftlowerarm.setRotationPoint(0.0F, 8.0F, -1.0F);
		Leftarm.addChild(Leftlowerarm);
		setRotationAngle(Leftlowerarm, -0.4363F, 0.0F, -0.3491F);
		Leftlowerarm.setTextureOffset(37, 27).addBox(-0.9779F, 0.0F, -0.8776F, 2.0F, 10.0F, 2.0F, 0.0F, false);
		Leftlowerarm.setTextureOffset(60, 26).addBox(-1.9491F, 0.1118F, -1.66F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(-0.0038F, 9.5883F, 0.2185F);
		Leftlowerarm.addChild(lefthand);
		setRotationAngle(lefthand, 0.0F, 0.0F, -0.3491F);
		lefthand.setTextureOffset(35, 34).addBox(-1.4386F, -0.5137F, -2.1452F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 0.4863F, -3.1452F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 2.4863F, -2.1452F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 2.4863F, -0.6452F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 1.4863F, 0.8548F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 3.4863F, 0.8548F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 4.4863F, -0.6452F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 4.4863F, -2.1452F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lefthand.setTextureOffset(35, 34).addBox(-0.4386F, 0.4863F, -4.1452F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		rightbase = new ModelRenderer(this);
		rightbase.setRotationPoint(6.0F, -3.0F, 0.0F);
		SpineMid.addChild(rightbase);
		setRotationAngle(rightbase, -0.5236F, 0.0F, 0.0F);
		

		RIghtarm = new ModelRenderer(this);
		RIghtarm.setRotationPoint(-1.0F, 1.0F, 1.0F);
		rightbase.addChild(RIghtarm);
		setRotationAngle(RIghtarm, 0.0F, 0.0F, -0.6109F);
		RIghtarm.setTextureOffset(37, 27).addBox(-1.0946F, -1.6504F, -1.8251F, 2.0F, 10.0F, 2.0F, 0.0F, false);
		RIghtarm.setTextureOffset(61, 25).addBox(-1.4084F, -2.1569F, -2.5402F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		rightlowerarm = new ModelRenderer(this);
		rightlowerarm.setRotationPoint(0.0F, 8.0F, -1.0F);
		RIghtarm.addChild(rightlowerarm);
		setRotationAngle(rightlowerarm, -0.4363F, 0.0F, 0.3491F);
		rightlowerarm.setTextureOffset(37, 27).addBox(-0.9779F, 0.0F, -0.8776F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		righthand = new ModelRenderer(this);
		righthand.setRotationPoint(-0.0038F, 9.5883F, 0.2185F);
		rightlowerarm.addChild(righthand);
		setRotationAngle(righthand, 0.0F, 0.0F, 0.5236F);
		righthand.setTextureOffset(35, 34).addBox(-0.8576F, 0.0015F, -2.1452F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(0.1424F, 1.0015F, -3.1452F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(0.1424F, 3.0015F, -2.1452F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(0.1424F, 3.0015F, -0.6452F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(0.1424F, 2.0015F, 0.8548F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(-0.8576F, 4.0015F, 0.8548F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(-0.8576F, 5.0015F, -0.6452F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(-0.8576F, 5.0015F, -2.1452F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		righthand.setTextureOffset(35, 34).addBox(-0.8576F, 1.0015F, -4.1452F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Leftleg = new ModelRenderer(this);
		Leftleg.setRotationPoint(-2.0F, 1.1456F, -1.3434F);
		Body.addChild(Leftleg);
		setRotationAngle(Leftleg, -0.6109F, 0.5236F, 0.0F);
		Leftleg.setTextureOffset(8, 24).addBox(-1.0F, -0.1456F, -0.6566F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		Leftlowerleg = new ModelRenderer(this);
		Leftlowerleg.setRotationPoint(2.0F, 10.0F, 0.0F);
		Leftleg.addChild(Leftlowerleg);
		setRotationAngle(Leftlowerleg, 0.6981F, 0.0F, 0.0F);
		Leftlowerleg.setTextureOffset(8, 24).addBox(-3.0F, -0.1456F, -0.6566F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		leftfoot = new ModelRenderer(this);
		leftfoot.setRotationPoint(-2.0F, 10.0F, 0.0F);
		Leftlowerleg.addChild(leftfoot);
		setRotationAngle(leftfoot, -0.0873F, 0.0F, 0.0F);
		leftfoot.setTextureOffset(33, 36).addBox(-1.0F, -0.1456F, -1.6566F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		leftfoot.setTextureOffset(8, 36).addBox(-1.0F, -0.1456F, -4.6566F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		leftfoot.setTextureOffset(8, 36).addBox(1.0F, -0.1456F, -5.6566F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		leftfoot.setTextureOffset(8, 36).addBox(-1.5F, -0.1456F, -4.6566F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		leftfoot.setTextureOffset(8, 36).addBox(-1.5F, -0.1456F, -5.6566F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Rightleg = new ModelRenderer(this);
		Rightleg.setRotationPoint(2.0F, 1.1456F, -1.3434F);
		Body.addChild(Rightleg);
		setRotationAngle(Rightleg, -0.6109F, -0.5236F, 0.0F);
		Rightleg.setTextureOffset(8, 24).addBox(-1.0F, -0.1456F, -0.6566F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		rightlowerleg = new ModelRenderer(this);
		rightlowerleg.setRotationPoint(2.0F, 10.0F, 0.0F);
		Rightleg.addChild(rightlowerleg);
		setRotationAngle(rightlowerleg, 0.6981F, 0.0F, 0.0F);
		rightlowerleg.setTextureOffset(8, 24).addBox(-3.0F, -0.1456F, -0.6566F, 2.0F, 10.0F, 2.0F, 0.0F, false);

		rightfoot = new ModelRenderer(this);
		rightfoot.setRotationPoint(-2.0F, 10.0F, 0.0F);
		rightlowerleg.addChild(rightfoot);
		setRotationAngle(rightfoot, -0.0873F, 0.0F, 0.0F);
		rightfoot.setTextureOffset(33, 36).addBox(-1.0F, -0.1456F, -1.6566F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		rightfoot.setTextureOffset(8, 36).addBox(-1.0F, -0.1456F, -4.6566F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		rightfoot.setTextureOffset(8, 36).addBox(-1.0F, -0.1456F, -5.6566F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightfoot.setTextureOffset(8, 36).addBox(1.5F, -0.1456F, -4.6566F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightfoot.setTextureOffset(8, 36).addBox(0.5F, -0.1456F, -5.6566F, 2.0F, 1.0F, 1.0F, 0.0F, false);
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