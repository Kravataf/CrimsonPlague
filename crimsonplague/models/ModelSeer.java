public static class ModelSeer extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public ModelSeer() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -4.0F, -3.3F);
		setRotationAngle(head, -0.5672F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.471F, -3.3409F, 8, 8, 8, 0.0F, false));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 4.8F, 3.6F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.309F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 16, -4.0F, -2.0F, -7.0F, 8, 2, 8, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 6.0F, -1.8F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.3054F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 0, 26, -4.0F, -5.0F, -2.0F, 8, 11, 4, 0.0F, false));

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.0F, 2.0F, 0.0F);
		left_arm.cubeList.add(new ModelBox(left_arm, 24, 26, -1.0F, -2.0F, -5.5F, 2, 22, 4, 0.0F, false));

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-5.0F, 2.0F, -3.5F);
		right_arm.cubeList.add(new ModelBox(right_arm, 32, 0, -1.0F, -2.0F, -2.0F, 2, 22, 4, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(1.9F, 12.0F, 0.0F);
		left_leg.cubeList.add(new ModelBox(left_leg, 36, 26, -1.9F, -1.0F, -2.0F, 4, 13, 4, 0.0F, false));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		right_leg.cubeList.add(new ModelBox(right_leg, 0, 41, -2.1F, -1.0F, -2.0F, 4, 13, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		left_arm.render(f5);
		right_arm.render(f5);
		left_leg.render(f5);
		right_leg.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}