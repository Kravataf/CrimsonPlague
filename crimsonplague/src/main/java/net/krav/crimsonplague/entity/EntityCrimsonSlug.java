
package net.krav.crimsonplague.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelBase;

import net.krav.crimsonplague.procedure.ProcedureInfectedKill;
import net.krav.crimsonplague.item.ItemPlaguedFlesh;
import net.krav.crimsonplague.ElementsCrimsonPlague;

import java.util.Iterator;
import java.util.ArrayList;

@ElementsCrimsonPlague.ModElement.Tag
public class EntityCrimsonSlug extends ElementsCrimsonPlague.ModElement {
	public static final int ENTITYID = 5;
	public static final int ENTITYID_RANGED = 6;
	public EntityCrimsonSlug(ElementsCrimsonPlague instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("crimsonplague", "lurker"), ENTITYID).name("lurker").tracker(64, 3, true).egg(-1, -1).build());
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new ModelLurkerV1(), 0.8f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("crimsonplague:textures/lurker1texture.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.8f, 0.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(ItemPlaguedFlesh.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onKillEntity(EntityLivingBase entity) {
			super.onKillEntity(entity);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ProcedureInfectedKill.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	public static class ModelLurkerV1 extends ModelBase {
		private final ModelRenderer tail;
		private final ModelRenderer body5;
		private final ModelRenderer body6;
		private final ModelRenderer mainbody;
		private final ModelRenderer body2;
		private final ModelRenderer body3;
		private final ModelRenderer fl;
		private final ModelRenderer leg2;
		private final ModelRenderer leg4;
		private final ModelRenderer fr;
		private final ModelRenderer leg6;
		private final ModelRenderer leg1;
		private final ModelRenderer br;
		private final ModelRenderer leg3;
		private final ModelRenderer leg5;
		private final ModelRenderer bl;
		private final ModelRenderer leg7;
		private final ModelRenderer leg8;
		public ModelLurkerV1() {
			textureWidth = 64;
			textureHeight = 32;
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 22.0F, 6.0F);
			setRotationAngle(tail, 0.7854F, 0.0F, 0.0F);
			tail.cubeList.add(new ModelBox(tail, 23, 19, -1.0F, -2.0F, -1.0F, 2, 2, 5, 0.0F, false));
			body5 = new ModelRenderer(this);
			body5.setRotationPoint(0.0F, 1.0F, 3.0F);
			tail.addChild(body5);
			setRotationAngle(body5, 1.3963F, 0.0F, 0.0F);
			body5.cubeList.add(new ModelBox(body5, 23, 19, -1.0F, -1.0F, 2.0F, 2, 2, 5, 0.0F, false));
			body6 = new ModelRenderer(this);
			body6.setRotationPoint(0.0F, 3.0F, 6.0F);
			body5.addChild(body6);
			setRotationAngle(body6, 1.3963F, 0.0F, 0.0F);
			body6.cubeList.add(new ModelBox(body6, 23, 19, -1.0F, 0.0F, 2.0F, 2, 1, 5, 0.0F, false));
			mainbody = new ModelRenderer(this);
			mainbody.setRotationPoint(0.0F, 22.0F, -7.0F);
			setRotationAngle(mainbody, 0.3491F, 0.0F, 0.0F);
			mainbody.cubeList.add(new ModelBox(mainbody, 23, 19, -1.0F, 0.0F, -1.0F, 2, 2, 5, 0.0F, false));
			body2 = new ModelRenderer(this);
			body2.setRotationPoint(0.0F, 2.0F, 4.0F);
			mainbody.addChild(body2);
			setRotationAngle(body2, -0.1745F, 0.0F, 0.0F);
			body2.cubeList.add(new ModelBox(body2, 23, 19, -1.0F, -2.0F, -1.0F, 2, 2, 5, 0.0F, false));
			body3 = new ModelRenderer(this);
			body3.setRotationPoint(0.0F, 0.0F, 4.0F);
			body2.addChild(body3);
			setRotationAngle(body3, -0.48F, 0.0F, 0.0F);
			body3.cubeList.add(new ModelBox(body3, 23, 19, -1.0F, -2.0F, -1.0F, 2, 2, 5, 0.0F, false));
			fl = new ModelRenderer(this);
			fl.setRotationPoint(1.0F, 23.0F, -8.0F);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(0.0F, 0.0F, 0.0F);
			fl.addChild(leg2);
			setRotationAngle(leg2, -1.2195F, 0.0378F, -0.387F);
			leg2.cubeList.add(new ModelBox(leg2, 24, 20, 3.5322F, -3.0137F, -1.2382F, 1, 1, 5, 0.0F, false));
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(1.0F, -2.0F, 3.0F);
			fl.addChild(leg4);
			setRotationAngle(leg4, -1.2044F, -0.335F, 0.8443F);
			leg4.cubeList.add(new ModelBox(leg4, 24, 20, -0.433F, -0.2547F, -2.8708F, 1, 1, 5, 0.0F, true));
			fr = new ModelRenderer(this);
			fr.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg6 = new ModelRenderer(this);
			leg6.setRotationPoint(-2.0F, -3.0F, -5.0F);
			fr.addChild(leg6);
			setRotationAngle(leg6, -1.3428F, 0.5444F, -0.9342F);
			leg6.cubeList.add(new ModelBox(leg6, 24, 20, -0.433F, -0.2547F, -2.8708F, 1, 1, 5, 0.0F, false));
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-1.0F, -2.0F, -7.0F);
			fr.addChild(leg1);
			setRotationAngle(leg1, -1.2018F, -0.0356F, 0.3263F);
			leg1.cubeList.add(new ModelBox(leg1, 24, 20, -4.0F, -2.0F, -1.0F, 1, 1, 5, 0.0F, false));
			br = new ModelRenderer(this);
			br.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-2.0F, -3.0F, -2.0F);
			br.addChild(leg3);
			setRotationAngle(leg3, -2.1729F, -1.3885F, -0.5798F);
			leg3.cubeList.add(new ModelBox(leg3, 24, 20, -0.433F, -0.2547F, -2.8708F, 1, 1, 5, 0.0F, false));
			leg5 = new ModelRenderer(this);
			leg5.setRotationPoint(-1.0F, -3.0F, -3.0F);
			br.addChild(leg5);
			setRotationAngle(leg5, -1.4598F, -0.0214F, 0.1961F);
			leg5.cubeList.add(new ModelBox(leg5, 24, 20, -4.0F, -2.0F, -1.0F, 1, 1, 5, 0.0F, false));
			bl = new ModelRenderer(this);
			bl.setRotationPoint(0.0F, 24.0F, 0.0F);
			leg7 = new ModelRenderer(this);
			leg7.setRotationPoint(2.0F, -3.0F, -2.0F);
			bl.addChild(leg7);
			setRotationAngle(leg7, -1.7671F, 1.3859F, 0.8228F);
			leg7.cubeList.add(new ModelBox(leg7, 24, 20, -0.433F, -0.2547F, -2.8708F, 1, 1, 5, 0.0F, false));
			leg8 = new ModelRenderer(this);
			leg8.setRotationPoint(8.0F, -5.0F, -3.0F);
			bl.addChild(leg8);
			setRotationAngle(leg8, -1.4653F, -0.0887F, -0.3815F);
			leg8.cubeList.add(new ModelBox(leg8, 24, 20, -4.0F, -2.0F, -1.0F, 1, 1, 5, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			tail.render(f5);
			mainbody.render(f5);
			fl.render(f5);
			fr.render(f5);
			br.render(f5);
			bl.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.fl.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.bl.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.fr.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.br.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
