
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackMelee;
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
public class EntityPlaguedPig extends ElementsCrimsonPlague.ModElement {
	public static final int ENTITYID = 3;
	public static final int ENTITYID_RANGED = 4;
	public EntityPlaguedPig(ElementsCrimsonPlague instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("crimsonplague", "plaguedpig"), ENTITYID).name("plaguedpig").tracker(64, 3, true).egg(-1, -1).build());
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
			return new RenderLiving(renderManager, new ModelplaguedPigV3(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("crimsonplague:textures/plaguedig4texture.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 5;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true, false));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, true, false));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityVillager.class, true, false));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityEnderman.class, true, false));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(7, new EntityAIAttackMelee(this, 1.2, true));
			this.tasks.addTask(8, new EntityAIOpenDoor(this, false));
			this.tasks.addTask(9, new EntityAIWander(this, 1));
			this.tasks.addTask(10, new EntityAILookIdle(this));
			this.tasks.addTask(11, new EntityAISwimming(this));
			this.tasks.addTask(12, new EntityAILeapAtTarget(this, (float) 0.8));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("crimsonplague:parasite_explode1"));
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
		}
	}

	public static class ModelplaguedPigV3 extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer leg1;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg4;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		public ModelplaguedPigV3() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 11.0F, 2.0F);
			setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 28, 8, -5.0F, -10.0F, -7.0F, 10, 6, 8, 0.0F, false));
			body.cubeList.add(new ModelBox(body, 28, 8, -5.0F, -4.0F, -7.0F, 10, 10, 8, 0.0F, false));
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 12.0F, -6.0F);
			head.cubeList.add(new ModelBox(head, 12, 23, -5.0F, -6.0F, -6.0F, 3, 5, 4, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 50, 0, 2.0F, -6.0F, -6.0F, 3, 5, 4, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -4.0F, -8.0F, 8, 8, 8, 0.0F, false));
			head.cubeList.add(new ModelBox(head, 16, 16, -2.0F, 0.0F, -9.0F, 4, 3, 1, 0.0F, false));
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-3.0F, 18.0F, 7.0F);
			leg1.cubeList.add(new ModelBox(leg1, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(3.0F, 18.0F, 7.0F);
			leg2.cubeList.add(new ModelBox(leg2, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-3.0F, 18.0F, -5.0F);
			leg3.cubeList.add(new ModelBox(leg3, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(3.0F, 18.0F, -5.0F);
			leg4.cubeList.add(new ModelBox(leg4, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, false));
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(1.0F, -19.0F, 6.0F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.6981F, 0.0F, 0.0F);
			cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 50, -4.0F, -10.0F, -1.0F, 6, 10, 4, 0.0F, false));
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(1.0F, -13.0F, 0.0F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.5672F, 0.0F, 0.0F);
			cube_r2.cubeList.add(new ModelBox(cube_r2, 40, 50, -4.0F, -10.0F, -1.0F, 6, 10, 4, 0.0F, false));
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(3.0F, -26.0F, 0.0F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.4003F, -0.1176F, 0.1293F);
			cube_r3.cubeList.add(new ModelBox(cube_r3, 24, 51, -1.0F, -2.0F, -5.0F, 2, 2, 6, 0.0F, false));
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-2.0F, -26.0F, 1.0F);
			bb_main.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.6981F, 0.6109F, 0.0F);
			cube_r4.cubeList.add(new ModelBox(cube_r4, 24, 51, -1.0F, -2.0F, -5.0F, 2, 2, 6, 0.0F, false));
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-2.0F, -27.0F, 0.0F);
			bb_main.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.4943F, 0.2316F, -0.1231F);
			cube_r5.cubeList.add(new ModelBox(cube_r5, 22, 51, -1.0F, -2.0F, -6.0F, 2, 1, 7, 0.0F, false));
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, -27.0F, 0.0F);
			bb_main.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.4363F, 0.0F, 0.0F);
			cube_r6.cubeList.add(new ModelBox(cube_r6, 24, 51, -1.0F, -2.0F, -5.0F, 2, 2, 6, 0.0F, false));
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(1.0F, -27.0F, 0.0F);
			bb_main.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.6621F, -0.1176F, 0.1293F);
			cube_r7.cubeList.add(new ModelBox(cube_r7, 24, 51, -1.0F, -2.0F, -5.0F, 2, 2, 6, 0.0F, false));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			head.render(f5);
			leg1.render(f5);
			leg2.render(f5);
			leg3.render(f5);
			leg4.render(f5);
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
}
