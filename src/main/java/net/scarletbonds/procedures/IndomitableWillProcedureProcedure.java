package net.scarletbonds.procedures;

import net.scarletbonds.ScarletBondsMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class IndomitableWillProcedureProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency world for procedure IndomitableWillProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency entity for procedure IndomitableWillProcedure!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("scarlet_bonds:indomitable_will")))
						.isDone()
				: false) {
			if (entity.getPersistentData().getBoolean("Cooldown") == false) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity)
							.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) * 0.25));
				entity.getPersistentData().putBoolean("Cooldown", (true));
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						entity.getPersistentData().putBoolean("Cooldown", (false));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 6000);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You grew a second head and still lost? Skill issue."), (true));
			}
		}
	}
}
