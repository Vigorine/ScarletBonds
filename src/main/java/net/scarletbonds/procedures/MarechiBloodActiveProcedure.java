package net.scarletbonds.procedures;

import net.scarletbonds.potion.BloodlustPotionEffect;
import net.scarletbonds.potion.BloodlossPotionEffect;
import net.scarletbonds.ScarletBondsMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class MarechiBloodActiveProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency world for procedure MarechiBloodActive!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency x for procedure MarechiBloodActive!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency y for procedure MarechiBloodActive!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency z for procedure MarechiBloodActive!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency entity for procedure MarechiBloodActive!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("scarlet_bonds:marechi_blood")))
						.isDone()
				: false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You cut yourself, releasing Marechi Blood"), (true));
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (40 / 2d), y - (40 / 2d), z - (40 / 2d), x + (40 / 2d), y + (40 / 2d), z + (40 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("scarlet_bonds:thrall_demon")))
									.isDone()
							: false) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(BloodlustPotionEffect.potion, (int) 200, (int) 0));
					}
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(BloodlossPotionEffect.potion, (int) 200, (int) 0));
		}
	}
}
