package net.krav.crimsonplague.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.krav.crimsonplague.ElementsCrimsonPlague;

@ElementsCrimsonPlague.ModElement.Tag
public class ProcedureOrganEaten extends ElementsCrimsonPlague.ModElement {
	public ProcedureOrganEaten(ElementsCrimsonPlague instance) {
		super(instance, 18);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OrganEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) 200, (int) 2));
	}
}
