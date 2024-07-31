package net.scarletbonds.procedures;

import net.scarletbonds.ScarletBondsMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class TotalConcentrationBreathingActiveProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency world for procedure TotalConcentrationBreathingActive!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency entity for procedure TotalConcentrationBreathingActive!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("scarlet_bonds:total_concentration_breathing")))
						.isDone()
				: false) {
			if (!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("scarlet_bonds:total_concentration_breathing_constant")))
							.isDone()
					: false)) {
				if (entity.getPersistentData().getBoolean("CooldownTCB") == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Total Concentration Breathing Activated"), (true));
					}
					if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("scarlet_bonds:hashira")))
									.isDone()
							: false) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/effect give @s kimetsunoyaiba:potion_demon_slayer_mark 15 4 true");
							}
						}
					} else if ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("scarlet_bonds:kinoe")))
									.isDone()
							: false)
							|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("scarlet_bonds:kinoe")))
											.isDone()
									: false)
							|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("scarlet_bonds:kinoe")))
											.isDone()
									: false)
							|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("scarlet_bonds:kinoe")))
											.isDone()
									: false)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/effect give @s kimetsunoyaiba:potion_demon_slayer_mark 15 3 true");
							}
						}
					} else {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/effect give @s kimetsunoyaiba:potion_demon_slayer_mark 15 2 true");
							}
						}
					}
					entity.getPersistentData().putBoolean("CooldownTCB", (true));
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
							entity.getPersistentData().putBoolean("CooldownTCB", (false));
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 900);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Total Concentration Breathing is on cooldown"), (true));
					}
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent("You already have the upgraded Total Concentration Breathing Constant"), (true));
				}
			}
		}
	}
}
