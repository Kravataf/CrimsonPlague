
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
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
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
public class EntityPlaguedHuman extends ElementsCrimsonPlague.ModElement {
	public static final int ENTITYID = 9;
	public static final int ENTITYID_RANGED = 10;
	public EntityPlaguedHuman(ElementsCrimsonPlague instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("crimsonplague", "plaguedhuman"), ENTITYID).name("plaguedhuman").tracker(64, 3, true).egg(-1, -1).build());
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
			return new RenderLiving(renderManager, new ModelplaguedPlayerV1(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("crimsonplague:textures/parasyteplayerexture.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.8f);
			experienceValue = 0;
			this.isImmuneToFire = false;
			setNoAI(!true);
		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();
			this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.2, true));
			this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAnimal.class, false, false));
			this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false, false));
			this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
			this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityVillager.class, false, false));
			this.targetTasks.addTask(7, new EntityAINearestAttackableTarget(this, EntityCreeper.class, false, false));
			this.targetTasks.addTask(8, new EntityAINearestAttackableTarget(this, EntityZombie.class, false, false));
			this.targetTasks.addTask(9, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, false, false));
			this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntitySlime.class, false, false));
			this.targetTasks.addTask(11, new EntityAINearestAttackableTarget(this, EntitySpider.class, false, false));
			this.tasks.addTask(12, new EntityAISwimming(this));
			this.tasks.addTask(13, new EntityAIWander(this, 1));
			this.tasks.addTask(14, new EntityAIBreakDoor(this));
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
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10D);
		}
	}

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
}
