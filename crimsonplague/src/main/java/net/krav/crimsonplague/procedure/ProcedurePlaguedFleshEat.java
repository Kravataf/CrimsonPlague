package net.krav.crimsonplague.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.krav.crimsonplague.ElementsCrimsonPlague;

@ElementsCrimsonPlague.ModElement.Tag
public class ProcedurePlaguedFleshEat extends ElementsCrimsonPlague.ModElement {
	public ProcedurePlaguedFleshEat(ElementsCrimsonPlague instance) {
		super(instance, 6);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlaguedFleshEat!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WITHER, (int) 200, (int) 3));
	}
}
