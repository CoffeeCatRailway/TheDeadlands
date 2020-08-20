package coffeecatrailway.tdeadlands.client.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// TODO: Biped
public class ColdMan extends EntityModel<Entity> {

	private final ModelRenderer Body;
	private final ModelRenderer Leftleg;
	private final ModelRenderer Leftlowerleg;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer Rightleg;
	private final ModelRenderer Leftlowerleg2;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer Spine;
	private final ModelRenderer Spine2;
	private final ModelRenderer Spine3;
	private final ModelRenderer Spine4;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone17;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftLowerArm;
	private final ModelRenderer MainFingers;
	private final ModelRenderer Thumb;
	private final ModelRenderer bone18;
	private final ModelRenderer RightArm;
	private final ModelRenderer RIght_Arm;
	private final ModelRenderer Main_FingersR;
	private final ModelRenderer ThumbR;
	private final ModelRenderer bone19;
	private final ModelRenderer Ribcage;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer Head;

	public ColdMan() {
		textureWidth = 37;
		textureHeight = 36;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -10.0F, -0.5F);
		setRotationAngle(Body, 0.6109F, 0.0F, 0.0F);
		

		Leftleg = new ModelRenderer(this);
		Leftleg.setRotationPoint(-3.0F, 14.0F, 1.5F);
		Body.addChild(Leftleg);
		setRotationAngle(Leftleg, -1.309F, 0.2618F, 0.0F);
		Leftleg.setTextureOffset(0, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		Leftlowerleg = new ModelRenderer(this);
		Leftlowerleg.setRotationPoint(0.0F, 12.0F, -0.9142F);
		Leftleg.addChild(Leftlowerleg);
		setRotationAngle(Leftlowerleg, 1.3963F, 0.0F, 0.0F);
		Leftlowerleg.setTextureOffset(0, 22).addBox(-1.0F, 1.0F, -1.0858F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Leftlowerleg.setTextureOffset(0, 25).addBox(-1.0F, 13.0F, -3.0858F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 13.0F, -3.0F);
		Leftlowerleg.addChild(bone11);
		setRotationAngle(bone11, -0.0873F, 0.0F, -0.1745F);
		bone11.setTextureOffset(16, 12).addBox(-1.6983F, -0.2688F, -3.9544F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(3.3017F, -1.2688F, -2.1186F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, -0.5236F, 0.1745F, 0.0F);
		bone12.setTextureOffset(0, 25).addBox(-5.0F, 1.75F, -3.8358F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.9142F);
		bone12.addChild(bone13);
		setRotationAngle(bone13, -0.1745F, 0.0F, 0.0F);
		bone13.setTextureOffset(0, 25).addBox(-2.0F, 2.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone13.setTextureOffset(0, 25).addBox(-5.0F, 2.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone13.setTextureOffset(0, 25).addBox(-3.5F, 2.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Rightleg = new ModelRenderer(this);
		Rightleg.setRotationPoint(3.0F, 14.0F, 1.5F);
		Body.addChild(Rightleg);
		setRotationAngle(Rightleg, -1.309F, -0.2618F, 0.0F);
		Rightleg.setTextureOffset(0, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		Leftlowerleg2 = new ModelRenderer(this);
		Leftlowerleg2.setRotationPoint(0.0F, 12.0F, -0.9142F);
		Rightleg.addChild(Leftlowerleg2);
		setRotationAngle(Leftlowerleg2, 1.3963F, 0.0F, 0.0F);
		Leftlowerleg2.setTextureOffset(0, 22).addBox(-1.0F, 1.0F, -1.0858F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Leftlowerleg2.setTextureOffset(0, 25).addBox(-1.0F, 13.0F, -3.0858F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(3.0F, 12.0F, -5.0F);
		Leftlowerleg2.addChild(bone14);
		setRotationAngle(bone14, -0.0873F, 0.0F, 0.1745F);
		bone14.setTextureOffset(16, 12).addBox(-5.0F, 1.0F, -1.8358F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, -0.5236F, 0.0F, 0.0F);
		bone15.setTextureOffset(0, 25).addBox(-5.0F, 1.75F, -3.8358F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 0.0F, 0.9142F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, -0.1745F, 0.0F, 0.0F);
		bone16.setTextureOffset(0, 25).addBox(-2.0F, 2.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone16.setTextureOffset(0, 25).addBox(-5.0F, 2.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone16.setTextureOffset(0, 25).addBox(-3.5F, 2.75F, -4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Spine = new ModelRenderer(this);
		Spine.setRotationPoint(0.0F, 13.0F, 2.5F);
		Body.addChild(Spine);
		setRotationAngle(Spine, 0.9599F, 0.0F, 0.0F);
		Spine.setTextureOffset(0, 5).addBox(-1.0F, -13.8155F, 10.9593F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Spine2 = new ModelRenderer(this);
		Spine2.setRotationPoint(0.0F, -9.8155F, 11.9593F);
		Spine.addChild(Spine2);
		setRotationAngle(Spine2, -0.1745F, 0.0F, 0.0F);
		Spine2.setTextureOffset(0, 5).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Spine3 = new ModelRenderer(this);
		Spine3.setRotationPoint(0.0F, 2.0F, -0.5F);
		Spine2.addChild(Spine3);
		setRotationAngle(Spine3, -0.2618F, 0.0F, 0.0F);
		Spine3.setTextureOffset(0, 5).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Spine3.setTextureOffset(30, 4).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Spine4 = new ModelRenderer(this);
		Spine4.setRotationPoint(0.0F, 0.0F, 0.0F);
		Spine3.addChild(Spine4);
		setRotationAngle(Spine4, -0.1745F, 0.0F, 0.0F);
		Spine4.setTextureOffset(0, 5).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Spine4.setTextureOffset(29, 3).addBox(-0.5F, 0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 3.0F, -1.0F);
		Spine4.addChild(bone);
		setRotationAngle(bone, -0.0873F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 5).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(28, 2).addBox(-0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 2.0F, -0.5F);
		bone.addChild(bone2);
		setRotationAngle(bone2, -0.1745F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 5).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(27, 1).addBox(-0.5F, -0.5F, 1.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 2.0F, 1.0F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, -0.0873F, 0.0F, 0.0F);
		bone3.setTextureOffset(0, 5).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone3.setTextureOffset(27, 1).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 2.0F, 0.0F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, -0.0873F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 5).addBox(-1.0F, -0.9924F, -1.1743F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(28, 2).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, -0.0873F, 0.0F, 0.0F);
		bone5.setTextureOffset(0, 5).addBox(-1.0F, 1.0076F, -1.1743F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone5.setTextureOffset(29, 3).addBox(-0.5F, 1.5F, 0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, -0.0873F, 0.0F, 0.0F);
		bone6.setTextureOffset(0, 5).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone6.setTextureOffset(30, 4).addBox(-0.5F, 3.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(-6.0F, -7.8155F, 9.9593F);
		Spine.addChild(bone17);
		

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(-2.0F, -1.0F, 0.5F);
		bone17.addChild(LeftArm);
		setRotationAngle(LeftArm, -1.2217F, 0.2618F, 0.3491F);
		LeftArm.setTextureOffset(0, 22).addBox(0.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		LeftLowerArm = new ModelRenderer(this);
		LeftLowerArm.setRotationPoint(1.0F, 12.0F, -1.0F);
		LeftArm.addChild(LeftLowerArm);
		setRotationAngle(LeftLowerArm, -0.9599F, 0.0F, -0.4363F);
		LeftLowerArm.setTextureOffset(0, 22).addBox(-0.5774F, -0.339F, -1.1688F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		LeftLowerArm.setTextureOffset(8, 22).addBox(0.4226F, 11.661F, -2.1688F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		LeftLowerArm.setTextureOffset(0, 24).addBox(0.4226F, 12.661F, -4.1688F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		LeftLowerArm.setTextureOffset(0, 24).addBox(0.4226F, 15.661F, -2.1688F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		LeftLowerArm.setTextureOffset(0, 24).addBox(0.4226F, 15.661F, -0.1688F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		LeftLowerArm.setTextureOffset(0, 24).addBox(0.4226F, 14.661F, 1.3312F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		MainFingers = new ModelRenderer(this);
		MainFingers.setRotationPoint(1.4226F, 18.661F, 0.8312F);
		LeftLowerArm.addChild(MainFingers);
		setRotationAngle(MainFingers, 0.0F, 0.0F, 0.5236F);
		MainFingers.setTextureOffset(0, 24).addBox(-1.3056F, -1.5946F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		MainFingers.setTextureOffset(0, 24).addBox(-0.3056F, -0.5946F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		MainFingers.setTextureOffset(0, 24).addBox(-0.3056F, -0.5946F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		Thumb = new ModelRenderer(this);
		Thumb.setRotationPoint(0.9226F, 13.161F, -4.1688F);
		LeftLowerArm.addChild(Thumb);
		setRotationAngle(Thumb, 0.0F, 0.7854F, 0.0F);
		Thumb.setTextureOffset(0, 24).addBox(-0.4063F, -0.5F, -0.4226F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(6.0F, -7.8155F, 9.9593F);
		Spine.addChild(bone18);
		

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(0.0F, 0.0F, -0.5F);
		bone18.addChild(RightArm);
		setRotationAngle(RightArm, -1.2217F, -0.1745F, -0.3491F);
		RightArm.setTextureOffset(0, 22).addBox(0.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		RIght_Arm = new ModelRenderer(this);
		RIght_Arm.setRotationPoint(1.0F, 11.0F, -1.0F);
		RightArm.addChild(RIght_Arm);
		setRotationAngle(RIght_Arm, -0.9599F, 0.0F, 0.4363F);
		RIght_Arm.setTextureOffset(0, 22).addBox(-1.4226F, -0.1581F, -0.5953F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		RIght_Arm.setTextureOffset(8, 22).addBox(-0.4226F, 11.8419F, -1.5953F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		RIght_Arm.setTextureOffset(0, 24).addBox(-0.4226F, 12.8419F, -3.5953F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		RIght_Arm.setTextureOffset(0, 24).addBox(-0.4226F, 15.8419F, -1.5953F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RIght_Arm.setTextureOffset(0, 24).addBox(-0.4226F, 15.8419F, 0.4047F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RIght_Arm.setTextureOffset(0, 24).addBox(-0.4226F, 14.8419F, 1.9047F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		Main_FingersR = new ModelRenderer(this);
		Main_FingersR.setRotationPoint(-0.4226F, 17.8419F, 1.4047F);
		RIght_Arm.addChild(Main_FingersR);
		setRotationAngle(Main_FingersR, 0.0F, 0.0F, 2.3562F);
		Main_FingersR.setTextureOffset(0, 24).addBox(-0.5F, -0.5F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Main_FingersR.setTextureOffset(0, 24).addBox(0.25F, -1.5F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Main_FingersR.setTextureOffset(0, 24).addBox(0.25F, -1.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		ThumbR = new ModelRenderer(this);
		ThumbR.setRotationPoint(0.0774F, 13.8419F, -3.5953F);
		RIght_Arm.addChild(ThumbR);
		setRotationAngle(ThumbR, 0.0F, 2.1817F, 0.0F);
		ThumbR.setTextureOffset(0, 24).addBox(-0.5F, -1.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, -7.8155F, 9.9593F);
		Spine.addChild(bone19);
		setRotationAngle(bone19, -0.9599F, 0.0F, 0.0F);
		

		Ribcage = new ModelRenderer(this);
		Ribcage.setRotationPoint(0.0F, -0.359F, -1.8103F);
		bone19.addChild(Ribcage);
		Ribcage.setTextureOffset(0, 19).addBox(-4.0F, 2.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 19).addBox(1.0F, 2.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 19).addBox(1.0F, 4.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 19).addBox(-4.0F, 4.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 27).addBox(-4.0F, 6.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 27).addBox(1.0F, 6.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 27).addBox(1.0F, 8.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 27).addBox(-3.0F, 8.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 27).addBox(-2.0F, 10.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Ribcage.setTextureOffset(0, 27).addBox(1.0F, 10.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ribcage.addChild(bone7);
		setRotationAngle(bone7, 0.0F, -0.6109F, 0.0F);
		bone7.setTextureOffset(0, 19).addBox(-3.5F, 2.0F, 3.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone7.setTextureOffset(0, 19).addBox(-3.5F, 4.0F, 3.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone7.setTextureOffset(0, 19).addBox(-3.0F, 6.0F, 4.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone7.setTextureOffset(0, 19).addBox(-1.0F, 8.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.0F, -0.6109F, 0.0F);
		bone8.setTextureOffset(0, 19).addBox(-1.0F, 2.0F, 4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone8.setTextureOffset(0, 19).addBox(-1.0F, 4.0F, 4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone8.setTextureOffset(0, 19).addBox(0.0F, 6.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		Ribcage.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 0.6109F, 0.0F);
		bone9.setTextureOffset(0, 19).addBox(1.5F, 2.0F, 3.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone9.setTextureOffset(5, 19).addBox(1.0F, 4.0F, 4.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone9.setTextureOffset(5, 19).addBox(1.0F, 6.0F, 4.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone9.setTextureOffset(5, 19).addBox(0.0F, 8.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 0.6109F, 0.0F);
		bone10.setTextureOffset(0, 19).addBox(0.0F, 2.0F, 4.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone10.setTextureOffset(0, 19).addBox(-1.0F, 4.0F, 5.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone10.setTextureOffset(0, 19).addBox(-1.0F, 6.0F, 5.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, -7.0F, 10.0F);
		Spine.addChild(bone20);
		setRotationAngle(bone20, -0.9599F, 0.0F, 0.0F);
		bone20.setTextureOffset(0, 19).addBox(-7.0F, -1.0F, -1.5F, 14.0F, 1.0F, 2.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 0.0F, 0.0F);
		Spine.addChild(bone21);
		setRotationAngle(bone21, -1.1345F, 0.0F, 0.0F);
		bone21.setTextureOffset(0, 19).addBox(-5.0F, 0.0F, -1.5F, 10.0F, 1.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -14.0F, 12.0F);
		Spine.addChild(Head);
		setRotationAngle(Head, -1.5708F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.5F, -7.0F, -8.0F, 9.0F, 8.0F, 9.0F, 0.0F, false);
		Head.setTextureOffset(0, 17).addBox(-2.5F, 1.0F, -8.0F, 5.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(25, 25).addBox(-3.5F, -4.0F, -7.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(25, 30).addBox(0.5F, -4.0F, -7.0F, 3.0F, 3.0F, 0.0F, 0.0F, false);
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