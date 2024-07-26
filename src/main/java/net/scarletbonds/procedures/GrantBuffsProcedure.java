package net.scarletbonds.procedures;

import net.scarletbonds.ScarletBondsMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class GrantBuffsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency entity for procedure GrantBuffs!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("scarlet_bonds:mizunoto")))
						.isDone()
				: false) {
			MizunotoBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
		} else {
			if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("scarlet_bonds:mizunoe")))
							.isDone()
					: false) {
				MizunoeBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			} else {
				if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("scarlet_bonds:kanoto")))
								.isDone()
						: false) {
					KanotoBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
							(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				} else {
					if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("scarlet_bonds:kanoe")))
									.isDone()
							: false) {
						KanoeBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
					} else {
						if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("scarlet_bonds:tsuchinoto")))
										.isDone()
								: false) {
							TsuchinotoBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
									(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						} else {
							if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("scarlet_bonds:tsuchinoe")))
											.isDone()
									: false) {
								TsuchinoeBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							} else {
								if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("scarlet_bonds:hinoto")))
												.isDone()
										: false) {
									HinotoBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
								} else {
									if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
											? ((ServerPlayerEntity) entity).getAdvancements()
													.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
															.getAdvancement(new ResourceLocation("scarlet_bonds:hinoe")))
													.isDone()
											: false) {
										HinoeBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
												.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
									} else {
										if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
												? ((ServerPlayerEntity) entity).getAdvancements()
														.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																.getAdvancement(new ResourceLocation("scarlet_bonds:kinoto")))
														.isDone()
												: false) {
											KinotoBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
													.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
										} else {
											if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
													? ((ServerPlayerEntity) entity).getAdvancements()
															.getProgress(
																	((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																			.getAdvancement(new ResourceLocation("scarlet_bonds:kinoe")))
															.isDone()
													: false) {
												KinoeBuffsProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
														.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
