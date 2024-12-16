public static class ModelplaguedVillagerV2 extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer nose;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer arms;
	private final ModelRenderer mirrored_r1;
	private final ModelRenderer arms_r1;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_leg_r1;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_leg_r1;

	public ModelplaguedVillagerV2() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 3.0F);
		setRotationAngle(head, -1.0908F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 32, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.51F, false));

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, -2.0F, 0.0F);
		head.addChild(nose);
		nose.cubeList.add(new ModelBox(nose, 24, 0, -1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 3.0F, 2.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, -0.5236F, 0.0F, 0.0F);
		body_r1.cubeList.add(new ModelBox(body_r1, 16, 20, -4.0F, -4.0F, -3.0F, 8, 8, 6, 0.0F, false));

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(0.0F, 10.0F, 0.0F);
		body.addChild(body_r2);
		setRotationAngle(body_r2, 0.2182F, 0.0F, 0.0F);
		body_r2.cubeList.add(new ModelBox(body_r2, 10, 38, -4.0F, -2.0F, -3.0F, 8, 4, 6, 0.0F, false));

		arms = new ModelRenderer(this);
		arms.setRotationPoint(0.0F, 2.95F, -1.05F);

		mirrored_r1 = new ModelRenderer(this);
		mirrored_r1.setRotationPoint(6.0F, 6.0F, 1.0F);
		arms.addChild(mirrored_r1);
		setRotationAngle(mirrored_r1, 0.0F, 0.0F, -0.1745F);
		mirrored_r1.cubeList.add(new ModelBox(mirrored_r1, 44, 22, -2.0F, -5.0F, -2.0F, 4, 10, 4, 0.0F, true));

		arms_r1 = new ModelRenderer(this);
		arms_r1.setRotationPoint(-6.0F, 7.0F, 1.0F);
		arms.addChild(arms_r1);
		setRotationAngle(arms_r1, 0.0F, 0.0F, 0.2618F);
		arms_r1.cubeList.add(new ModelBox(arms_r1, 44, 22, -2.0F, -5.0F, -2.0F, 4, 10, 4, 0.0F, false));

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);

		right_leg_r1 = new ModelRenderer(this);
		right_leg_r1.setRotationPoint(2.0F, 12.0F, 0.0F);
		right_leg.addChild(right_leg_r1);
		setRotationAngle(right_leg_r1, 0.0F, -0.1309F, 0.0F);
		right_leg_r1.cubeList.add(new ModelBox(right_leg_r1, 0, 22, -4.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);

		left_leg_r1 = new ModelRenderer(this);
		left_leg_r1.setRotationPoint(-2.0F, 12.0F, 0.0F);
		left_leg.addChild(left_leg_r1);
		setRotationAngle(left_leg_r1, 0.1309F, 0.2182F, 0.0F);
		left_leg_r1.cubeList.add(new ModelBox(left_leg_r1, 0, 22, 0.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		arms.render(f5);
		right_leg.render(f5);
		left_leg.render(f5);
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