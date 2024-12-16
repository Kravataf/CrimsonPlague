public static class ModelplaguedEndermanV1 extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm_r1;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_arm_r1;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_leg_r1;
	private final ModelRenderer right_leg_r2;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_leg_r1;
	private final ModelRenderer left_leg_r2;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public ModelplaguedEndermanV1() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -15.0F, 0.0F);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 6.0F, -1.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.2182F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 32, 16, -4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -15.0F, 0.0F);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, -2.0F, -2.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, -2.3998F, 0.0F, 0.0F);
		head_r1.cubeList.add(new ModelBox(head_r1, 32, 33, -4.0F, -4.0F, -8.0F, 8, 4, 8, 0.0F, false));

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.0F, 2.0F, -1.0F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 0.0436F, 0.0F, 0.0F);
		head_r2.cubeList.add(new ModelBox(head_r2, 0, 4, -4.0F, -4.0F, -8.0F, 8, 4, 8, 0.0F, false));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-5.0F, -13.0F, 0.0F);

		right_arm_r1 = new ModelRenderer(this);
		right_arm_r1.setRotationPoint(-0.2303F, -1.9087F, -1.4212F);
		right_arm.addChild(right_arm_r1);
		setRotationAngle(right_arm_r1, 0.0873F, 0.1309F, 0.0F);
		right_arm_r1.cubeList.add(new ModelBox(right_arm_r1, 56, 0, -1.0F, 0.0F, -1.0F, 2, 30, 2, 0.0F, false));

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.0F, -13.0F, 0.0F);

		left_arm_r1 = new ModelRenderer(this);
		left_arm_r1.setRotationPoint(0.0F, -2.0F, -1.0F);
		left_arm.addChild(left_arm_r1);
		setRotationAngle(left_arm_r1, 0.0F, 0.0F, -0.0873F);
		left_arm_r1.cubeList.add(new ModelBox(left_arm_r1, 56, 0, -1.0F, 0.0F, -1.0F, 2, 30, 2, 0.0F, true));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.0F, -6.0F, 0.0F);

		right_leg_r1 = new ModelRenderer(this);
		right_leg_r1.setRotationPoint(3.0F, 15.0F, -3.0F);
		right_leg.addChild(right_leg_r1);
		setRotationAngle(right_leg_r1, -0.2597F, -0.0338F, -0.1265F);
		right_leg_r1.cubeList.add(new ModelBox(right_leg_r1, 56, 15, -3.0F, -15.0F, -1.0F, 2, 15, 2, 0.0F, false));

		right_leg_r2 = new ModelRenderer(this);
		right_leg_r2.setRotationPoint(1.0F, 30.0F, 0.0F);
		right_leg.addChild(right_leg_r2);
		setRotationAngle(right_leg_r2, 0.1745F, 0.0F, 0.1309F);
		right_leg_r2.cubeList.add(new ModelBox(right_leg_r2, 56, 0, -3.0F, -15.0F, -1.0F, 2, 15, 2, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.0F, -6.0F, 0.0F);

		left_leg_r1 = new ModelRenderer(this);
		left_leg_r1.setRotationPoint(-2.0F, 16.0F, -3.0F);
		left_leg.addChild(left_leg_r1);
		setRotationAngle(left_leg_r1, -0.2182F, 0.0F, 0.0F);
		left_leg_r1.cubeList.add(new ModelBox(left_leg_r1, 56, 0, 1.0F, -15.0F, -1.0F, 2, 15, 2, 0.0F, true));

		left_leg_r2 = new ModelRenderer(this);
		left_leg_r2.setRotationPoint(-2.0F, 30.0F, 0.0F);
		left_leg.addChild(left_leg_r2);
		setRotationAngle(left_leg_r2, 0.1817F, 0.3875F, 0.081F);
		left_leg_r2.cubeList.add(new ModelBox(left_leg_r2, 56, 15, 1.0F, -15.0F, -1.0F, 2, 15, 2, 0.0F, true));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(10.0F, -25.0F, -12.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, 0.0F, -2.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 2.5307F, -0.7854F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 58, -1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-4.0F, -2.0F, 4.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.8762F, -0.7854F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 53, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-10.0F, 10.0F, 10.0F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.1177F, -1.0715F, -0.5673F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 46, -1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(10.0F, -25.0F, 7.0F);
		setRotationAngle(bone2, 0.0F, -1.5708F, 0.0F);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-3.0F, -1.0F, 3.0F);
		bone2.addChild(cube_r4);
		setRotationAngle(cube_r4, 1.9165F, -0.8768F, 0.9697F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 52, -1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-8.0F, -5.0F, 8.0F);
		bone2.addChild(cube_r5);
		setRotationAngle(cube_r5, 2.2166F, -0.7288F, -0.2352F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 53, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-10.0F, 10.0F, 10.0F);
		bone2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.1702F, -0.4427F, 0.082F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 46, -1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-9.0F, -25.0F, 7.0F);
		setRotationAngle(bone3, 0.0F, 3.1416F, 0.0F);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(1.0F, -6.0F, 0.0F);
		bone3.addChild(cube_r7);
		setRotationAngle(cube_r7, 2.4773F, -0.3084F, -0.0633F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 56, -1.0F, -6.0F, -1.0F, 2, 6, 2, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-5.0F, -4.0F, 5.0F);
		bone3.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.8941F, -0.8014F, -0.758F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 53, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-10.0F, 10.0F, 10.0F);
		bone3.addChild(cube_r9);
		setRotationAngle(cube_r9, 2.7802F, -0.0146F, -2.7485F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 46, -1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-9.0F, -25.0F, -12.0F);
		setRotationAngle(bone4, 0.0F, 1.5708F, 0.0F);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.0F, 0.0F, 0.0F);
		bone4.addChild(cube_r10);
		setRotationAngle(cube_r10, 2.7033F, -0.6853F, 0.4533F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 52, -1.0F, -10.0F, -1.5F, 2, 10, 2, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-5.0F, -4.0F, 5.0F);
		bone4.addChild(cube_r11);
		setRotationAngle(cube_r11, 2.3582F, -0.7158F, -0.3073F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 53, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-10.0F, 10.0F, 10.0F);
		bone4.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.4083F, -0.4724F, 0.1932F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 46, -1.0F, -16.0F, -1.0F, 2, 16, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		right_arm.render(f5);
		left_arm.render(f5);
		right_leg.render(f5);
		left_leg.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
		bone4.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}