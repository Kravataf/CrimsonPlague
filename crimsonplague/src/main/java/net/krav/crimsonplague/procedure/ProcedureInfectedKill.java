package net.krav.crimsonplague.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.Entity;

import net.krav.crimsonplague.entity.EntityPlaguedVillager;
import net.krav.crimsonplague.entity.EntityPlaguedSheep;
import net.krav.crimsonplague.entity.EntityPlaguedPig;
import net.krav.crimsonplague.entity.EntityPlaguedHuman;
import net.krav.crimsonplague.entity.EntityPlaguedEnderman;
import net.krav.crimsonplague.ElementsCrimsonPlague;

@ElementsCrimsonPlague.ModElement.Tag
public class ProcedureInfectedKill extends ElementsCrimsonPlague.ModElement {
	public ProcedureInfectedKill(ElementsCrimsonPlague instance) {
		super(instance, 2);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure InfectedKill!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure InfectedKill!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure InfectedKill!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure InfectedKill!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure InfectedKill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((entity instanceof EntityPlayer)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPlaguedHuman.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
		if ((entity instanceof EntityPlayerMP)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPlaguedHuman.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
		if ((entity instanceof EntityPig)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPlaguedPig.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
		if ((entity instanceof EntitySheep)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPlaguedSheep.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
		if ((entity instanceof EntityVillager)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPlaguedVillager.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
		if ((entity instanceof EntityEnderman)) {
			if (!world.isRemote) {
				Entity entityToSpawn = new EntityPlaguedEnderman.EntityCustom(world);
				if (entityToSpawn != null) {
					entityToSpawn.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0.0F);
					world.spawnEntity(entityToSpawn);
				}
			}
		}
	}
}
