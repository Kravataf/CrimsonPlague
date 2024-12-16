public static class Modelplaguedsheep extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer rotation;
	private final ModelRenderer rotation_r1;
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer leg1;
	private final ModelRenderer leg1_r1;
	private final ModelRenderer leg2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer leg2_r1;
	private final ModelRenderer leg3;
	private final ModelRenderer cube_r2;
	private final ModelRenderer leg3_r1;
	private final ModelRenderer leg4;
	private final ModelRenderer cube_r3;
	private final ModelRenderer leg4_r1;
	private final ModelRenderer leftarm;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer rightarm;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;

	public Modelplaguedsheep() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 5.0F, 2.0F);

		rotation = new ModelRenderer(this);
		rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(rotation);
		setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);

		rotation_r1 = new ModelRenderer(this);
		rotation_r1.setRotationPoint(0.0F, -2.0F, -4.0F);
		rotation.addChild(rotation_r1);
		setRotationAngle(rotation_r1, 0.0F, 3.1416F, 0.0F);
		rotation_r1.cubeList.add(new ModelBox(rotation_r1, 28, 8, -4.0F, -8.0F, -3.0F, 8, 16, 6, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, -8.0F);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(0.0F, 2.0F, 0.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.7854F, 0.0F, -3.1416F);
		head_r1.cubeList.add(new ModelBox(head_r1, 36, 33, -3.0F, -3.0F, -4.0F, 6, 3, 8, 0.0F, false));

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.0F, 8.0F, -2.0F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, -0.5672F, 0.0F, -3.1416F);
		head_r2.cubeList.add(new ModelBox(head_r2, 0, 0, -3.0F, -3.0F, -4.0F, 6, 3, 8, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-3.0F, 12.0F, 7.0F);

		leg1_r1 = new ModelRenderer(this);
		leg1_r1.setRotationPoint(-2.0F, -1.0F, -6.0F);
		leg1.addChild(leg1_r1);
		setRotationAngle(leg1_r1, 0.0F, 0.0F, 0.3491F);
		leg1_r1.cubeList.add(new ModelBox(leg1_r1, 0, 16, -2.0F, -6.0F, 4.0F, 4, 12, 4, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(3.0F, 12.0F, 7.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(2.0F, 12.0F, 0.0F);
		leg2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2182F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 54, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		leg2_r1 = new ModelRenderer(this);
		leg2_r1.setRotationPoint(2.0F, -1.0F, -6.0F);
		leg2.addChild(leg2_r1);
		setRotationAngle(leg2_r1, 0.0F, 0.0F, -0.3491F);
		leg2_r1.cubeList.add(new ModelBox(leg2_r1, 0, 16, -2.0F, -6.0F, 4.0F, 4, 12, 4, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.0F, 12.0F, -5.0F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.0F, 12.0F, 0.0F);
		leg3.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2182F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 54, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		leg3_r1 = new ModelRenderer(this);
		leg3_r1.setRotationPoint(-2.0F, -1.0F, 6.0F);
		leg3.addChild(leg3_r1);
		setRotationAngle(leg3_r1, 0.0F, 0.0F, 0.3491F);
		leg3_r1.cubeList.add(new ModelBox(leg3_r1, 0, 16, -2.0F, -6.0F, -8.0F, 4, 12, 4, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(3.0F, 12.0F, -5.0F);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.0F, 12.0F, 0.0F);
		leg4.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.2182F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 54, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));

		leg4_r1 = new ModelRenderer(this);
		leg4_r1.setRotationPoint(2.0F, -1.0F, 6.0F);
		leg4.addChild(leg4_r1);
		setRotationAngle(leg4_r1, 0.0F, 0.0F, -0.3491F);
		leg4_r1.cubeList.add(new ModelBox(leg4_r1, 0, 16, -2.0F, -6.0F, -8.0F, 4, 12, 4, 0.0F, false));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(11.0F, 1.0F, 0.0F);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftarm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.5672F, 0.0F, 2.6616F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 52, -1.0F, -8.0F, -0.5F, 2, 8, 2, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-6.0F, -3.0F, 3.0F);
		leftarm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3491F, 0.0F, 2.0071F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 52, -1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-9.0F, 6.0F, 0.0F);
		leftarm.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.2618F, 0.0F, 0.3927F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 52, -1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F, false));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(7.0F, 1.0F, 0.0F);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-18.0F, -3.0F, 1.0F);
		rightarm.addChild(cube_r7);
		setRotationAngle(cube_r7, 1.0845F, -0.1546F, -2.5804F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 52, -1.0F, -8.0F, -0.5F, 2, 8, 2, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-12.0F, -3.0F, 3.0F);
		rightarm.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.3295F, -0.1172F, -1.6776F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 52, -1.0F, -8.0F, -1.0F, 2, 8, 2, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-9.0F, 6.0F, 0.0F);
		rightarm.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.2618F, 0.0F, -0.3927F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 52, -1.0F, -10.0F, -1.0F, 2, 10, 2, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(0.0F, -8.0F, -14.0F);
		bb_main.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.8727F, 0.0F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 3, 56, -1.0F, -2.0F, -5.0F, 2, 2, 6, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, -10.0F, -8.0F);
		bb_main.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.2618F, 0.0F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 1, 54, -1.0F, -2.0F, -7.0F, 2, 2, 8, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-5.0F, 0.0F, 7.0F);
		bb_main.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.2182F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 54, -1.0F, -9.0F, -1.0F, 2, 9, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		leftarm.render(f5);
		rightarm.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}