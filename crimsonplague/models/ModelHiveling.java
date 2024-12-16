public static class ModelHiveling extends ModelBase {
	private final ModelRenderer spawnling;
	private final ModelRenderer llegs_r1;
	private final ModelRenderer llegs_r2;

	public ModelHiveling() {
		textureWidth = 32;
		textureHeight = 32;

		spawnling = new ModelRenderer(this);
		spawnling.setRotationPoint(0.0F, 22.0F, -2.0F);
		spawnling.cubeList.add(new ModelBox(spawnling, 0, 0, -3.0F, -2.0F, -2.0F, 5, 4, 8, 0.0F, false));

		llegs_r1 = new ModelRenderer(this);
		llegs_r1.setRotationPoint(-4.0F, 2.0F, 0.0F);
		spawnling.addChild(llegs_r1);
		setRotationAngle(llegs_r1, 0.0F, 0.0F, 0.48F);
		llegs_r1.cubeList.add(new ModelBox(llegs_r1, 16, 12, 0.2F, -2.0F, -2.0F, 0, 2, 8, 0.0F, false));

		llegs_r2 = new ModelRenderer(this);
		llegs_r2.setRotationPoint(3.0F, 2.0F, 0.0F);
		spawnling.addChild(llegs_r2);
		setRotationAngle(llegs_r2, 0.0F, 0.0F, -0.48F);
		llegs_r2.cubeList.add(new ModelBox(llegs_r2, 0, 12, -0.2F, -2.0F, -2.0F, 0, 2, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		spawnling.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}