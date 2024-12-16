
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
public class EntityPlaguedSheep extends ElementsCrimsonPlague.ModElement {
	public static final int ENTITYID = 11;
	public static final int ENTITYID_RANGED = 12;
	public EntityPlaguedSheep(ElementsCrimsonPlague instance) {
		super(instance, 16);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class)
				.id(new ResourceLocation("crimsonplague", "plaguedsheep"), ENTITYID).name("plaguedsheep").tracker(64, 3, true).egg(-1, -1).build());
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
			return new RenderLiving(renderManager, new Modelplaguedsheep(), 0.6f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("crimsonplague:textures/plaguedheep2texture.png");
				}
			};
		});
	}
	public static class EntityCustom extends EntityMob {
		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1f);
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
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
		}
	}

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
}
