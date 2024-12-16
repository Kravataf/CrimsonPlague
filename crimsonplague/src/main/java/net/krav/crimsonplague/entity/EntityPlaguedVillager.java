
package net.krav.crimsonplague.entity;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
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
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EnumCreatureType;
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
public class EntityPlaguedVillager extends ElementsCrimsonPlague.ModElement {
	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;
	public EntityPlaguedVillager(ElementsCrimsonPlague instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.entities.add(
				() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("crimsonplague", "plaguedvillager"), ENTITYID)
						.name("plaguedvillager").tracker(64, 3, true).egg(-1, -1).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityCustom.class, 20, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
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
			return new RenderLiving(renderManager, new ModelplaguedVillagerV2(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("crimsonplague:textures/plaguedvillagerexture2.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.95f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAnimal.class, false, false));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityVillager.class, false, false));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityCreeper.class, false, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityZombie.class, false, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, false, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntitySlime.class, false, false));
			this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntitySpider.class, false, false));
			this.targetTasks.addTask(10, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(11, new EntityAIAttackMelee(this, 1.2, true));
			this.tasks.addTask(12, new EntityAIFollow(this, (float) 1, 10, 5));
			this.tasks.addTask(13, new EntityAIBreakDoor(this));
			this.tasks.addTask(14, new EntityAIOpenDoor(this, true));
			this.tasks.addTask(15, new EntityAILeapAtTarget(this, (float) 1));
			this.tasks.addTask(16, new EntityAIWander(this, 0.8));
			this.tasks.addTask(17, new EntityAISwimming(this));
			this.tasks.addTask(18, new EntityAILookIdle(this));
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
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("crimsonplague:plaguedvillagerliving"));
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
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
		}
	}

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
}
