public static class ModelplaguedPlayerV1 extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_arm_r1;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm_r1;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_leg_r1;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_leg_r1;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;

	public ModelplaguedPlayerV1() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, 0.0F, 1.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.3927F, 0.0F, 0.0F);
		head_r1.cubeList.add(new ModelBox(head_r1, 0, 4, -4.0F, -4.0F, -4.0F, 8, 4, 8, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 12.0F, 0.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, -0.1309F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 16, 16, -4.0F, -12.0F, -2.0F, 8, 12, 4, 0.0F, false));

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);

		left_arm_r1 = new ModelRenderer(this);
		left_arm_r1.setRotationPoint(1.0F, 5.0F, 1.0F);
		left_arm.addChild(left_arm_r1);
		setRotationAngle(left_arm_r1, 0.0F, -0.1309F, 0.0F);
		left_arm_r1.cubeList.add(new ModelBox(left_arm_r1, 40, 16, -2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F, true));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-5.0F, 2.0F, 0.0F);

		right_arm_r1 = new ModelRenderer(this);
		right_arm_r1.setRotationPoint(-1.0F, 6.0F, 1.0F);
		right_arm.addChild(right_arm_r1);
		setRotationAngle(right_arm_r1, 0.0F, 0.1745F, 0.0F);
		right_arm_r1.cubeList.add(new ModelBox(right_arm_r1, 40, 16, -2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(1.9F, 12.0F, 0.0F);

		left_leg_r1 = new ModelRenderer(this);
		left_leg_r1.setRotationPoint(-1.9F, 12.0F, 0.0F);
		left_leg.addChild(left_leg_r1);
		setRotationAngle(left_leg_r1, 0.0F, -0.3927F, 0.0F);
		left_leg_r1.cubeList.add(new ModelBox(left_leg_r1, 0, 16, 0.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F, true));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-1.9F, 12.0F, 0.0F);

		right_leg_r1 = new ModelRenderer(this);
		right_leg_r1.setRotationPoint(1.9F, 12.0F, 0.0F);
		right_leg.addChild(right_leg_r1);
		setRotationAngle(right_leg_r1, 0.0497F, 0.1287F, 0.0497F);
		right_leg_r1.cubeList.add(new ModelBox(right_leg_r1, 0, 16, -4.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-16.0F, -32.0F, -5.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.664F, -0.7144F, 2.2533F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 44, -1.0F, -5.0F, -1.0F, 1, 5, 2, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-11.0F, -41.0F, -5.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0578F, -0.6389F, -2.7148F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 51, -1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-2.0F, -32.0F, -1.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3237F, 0.2609F, -0.6814F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 51, -1.0F, -14.0F, -1.0F, 2, 14, 2, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(17.0F, -29.0F, -7.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, 2.45F, -0.5056F, 0.9837F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 44, -1.0F, -5.0F, -1.0F, 1, 5, 2, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(12.0F, -37.0F, -2.0F);
		bb_main.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.549F, -0.2609F, 2.4602F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 51, -1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(3.0F, -32.0F, 0.0F);
		bb_main.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.1996F, -0.3638F, 1.0279F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 51, -1.0F, -11.0F, -1.0F, 2, 11, 2, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-2.0F, -27.0F, -1.0F);
		bb_main.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0873F, -0.1745F, -0.1047F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 55, -1.0F, -6.0F, -1.0F, 2, 6, 2, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(2.0F, -27.0F, -1.0F);
		bb_main.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.1309F, 0.0F, 0.3054F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 55, -1.0F, -6.0F, -1.0F, 2, 6, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		left_arm.render(f5);
		right_arm.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}