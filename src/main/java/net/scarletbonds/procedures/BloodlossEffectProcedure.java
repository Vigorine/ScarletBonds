package net.scarletbonds.procedures;

import net.scarletbonds.ScarletBondsMod;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

public class BloodlossEffectProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency entity for procedure BloodlossEffect!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.DRYOUT, (float) 75);
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"effect give @s minecraft:wither 10 0 true");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"effect give @s kimetsunoyaiba:regeneration_inhibition 10 10 true");
			}
		}
	}
}
