package net.scarletbonds.procedures;

import net.scarletbonds.ScarletBondsMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

public class LoseRankOnDeathProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
			Entity entity = event.getPlayer();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", entity.getPosX());
			dependencies.put("y", entity.getPosY());
			dependencies.put("z", entity.getPosZ());
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("endconquered", event.isEndConquered());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ScarletBondsMod.LOGGER.warn("Failed to load dependency entity for procedure LoseRankOnDeath!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/say hello");
			}
		}
		if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("scarlet_bonds:kinoe")))
						.isDone()
				: false) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/advancement revoke @s only scarlet_bonds:kinoe");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/advancement grant @s only scarlet_bonds:hinoto ");
				}
			}
		} else {
			if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("scarlet_bonds:kinoto")))
							.isDone()
					: false) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"/advancement revoke @s only scarlet_bonds:kinoto");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"/advancement grant @s only scarlet_bonds:hinoe ");
					}
				}
			} else {
				if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("scarlet_bonds:hinoe")))
								.isDone()
						: false) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"/advancement revoke @s only scarlet_bonds:hinoe");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"/advancement grant @s only scarlet_bonds:hinoto ");
						}
					}
				} else {
					if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("scarlet_bonds:hinoto")))
									.isDone()
							: false) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/advancement revoke @s only scarlet_bonds:hinoto");
							}
						}
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/advancement grant @s only scarlet_bonds:tsuchinoe");
							}
						}
					} else {
						if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("scarlet_bonds:tsuchinoe")))
										.isDone()
								: false) {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager().handleCommand(
											_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
											"/advancement revoke @s only scarlet_bonds:tsuchinoe");
								}
							}
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent.world.getServer() != null) {
									_ent.world.getServer().getCommandManager().handleCommand(
											_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
											"/advancement grant @s only scarlet_bonds:tsuchinoto ");
								}
							}
						} else {
							if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("scarlet_bonds:tsuchinoto")))
											.isDone()
									: false) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												"/advancement revoke @s only scarlet_bonds:tsuchinoto");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										_ent.world.getServer().getCommandManager().handleCommand(
												_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
												"/advancement grant @s only scarlet_bonds:tsuchinoe ");
									}
								}
							} else {
								if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("scarlet_bonds:kanoe")))
												.isDone()
										: false) {
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/advancement revoke @s only scarlet_bonds:kanoe");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager().handleCommand(
													_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
													"/advancement grant @s only scarlet_bonds:kanoto ");
										}
									}
								} else {
									if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
											? ((ServerPlayerEntity) entity).getAdvancements()
													.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
															.getAdvancement(new ResourceLocation("scarlet_bonds:kanoto")))
													.isDone()
											: false) {
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												_ent.world.getServer().getCommandManager().handleCommand(
														_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
														"/advancement revoke @s only scarlet_bonds:kanoto");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												_ent.world.getServer().getCommandManager().handleCommand(
														_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
														"/advancement grant @s only scarlet_bonds:mizunoe");
											}
										}
									} else {
										if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
												? ((ServerPlayerEntity) entity).getAdvancements()
														.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																.getAdvancement(new ResourceLocation("scarlet_bonds:mizunoe")))
														.isDone()
												: false) {
											{
												Entity _ent = entity;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/advancement revoke @s only scarlet_bonds:mizunoe");
												}
											}
											{
												Entity _ent = entity;
												if (!_ent.world.isRemote && _ent.world.getServer() != null) {
													_ent.world.getServer().getCommandManager().handleCommand(
															_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
															"/advancement grant @s only scarlet_bonds:mizunoto ");
												}
											}
										} else {
											if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
													? ((ServerPlayerEntity) entity).getAdvancements()
															.getProgress(
																	((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																			.getAdvancement(new ResourceLocation("scarlet_bonds:apex_demon")))
															.isDone()
													: false) {
												{
													Entity _ent = entity;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/advancement revoke @s only scarlet_bonds:apex_demon");
													}
												}
												{
													Entity _ent = entity;
													if (!_ent.world.isRemote && _ent.world.getServer() != null) {
														_ent.world.getServer().getCommandManager().handleCommand(
																_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																"/advancement grant @s only scarlet_bonds:twin_horned_demon");
													}
												}
											} else {
												if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
														? ((ServerPlayerEntity) entity).getAdvancements()
																.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																		.getAdvancementManager()
																		.getAdvancement(new ResourceLocation("scarlet_bonds:twin_horned_demon")))
																.isDone()
														: false) {
													{
														Entity _ent = entity;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/advancement revoke @s only scarlet_bonds:twin_horned_demon");
														}
													}
													{
														Entity _ent = entity;
														if (!_ent.world.isRemote && _ent.world.getServer() != null) {
															_ent.world.getServer().getCommandManager().handleCommand(
																	_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																	"/advancement grant @s only scarlet_bonds:horned_demon");
														}
													}
												} else {
													if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
															? ((ServerPlayerEntity) entity).getAdvancements()
																	.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																			.getAdvancementManager()
																			.getAdvancement(new ResourceLocation("scarlet_bonds:horned_demon")))
																	.isDone()
															: false) {
														{
															Entity _ent = entity;
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/advancement revoke @s only scarlet_bonds:horned_demon");
															}
														}
														{
															Entity _ent = entity;
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/advancement grant @s only scarlet_bonds:ravager_demon");
															}
														}
													} else {
														if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																? ((ServerPlayerEntity) entity).getAdvancements()
																		.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																				.getAdvancementManager()
																				.getAdvancement(new ResourceLocation("scarlet_bonds:ravager_demon")))
																		.isDone()
																: false) {
															{
																Entity _ent = entity;
																if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																	_ent.world.getServer().getCommandManager().handleCommand(
																			_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																			"/advancement revoke @s only scarlet_bonds:ravager_demon");
																}
															}
															{
																Entity _ent = entity;
																if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																	_ent.world.getServer().getCommandManager().handleCommand(
																			_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																			"/advancement grant @s only scarlet_bonds:hunter_demon_ii ");
																}
															}
														} else {
															if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																	? ((ServerPlayerEntity) entity).getAdvancements()
																			.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																					.getAdvancementManager().getAdvancement(
																							new ResourceLocation("scarlet_bonds:hunter_demon_ii")))
																			.isDone()
																	: false) {
																{
																	Entity _ent = entity;
																	if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																		_ent.world.getServer().getCommandManager().handleCommand(
																				_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																				"/advancement revoke @s only scarlet_bonds:hunter_demon_ii");
																	}
																}
																{
																	Entity _ent = entity;
																	if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																		_ent.world.getServer().getCommandManager().handleCommand(
																				_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																				"/advancement grant @s only scarlet_bonds:hunter_demon ");
																	}
																}
															} else {
																if (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																		? ((ServerPlayerEntity) entity).getAdvancements()
																				.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																						.getAdvancementManager().getAdvancement(
																								new ResourceLocation("scarlet_bonds:hunter_demon")))
																				.isDone()
																		: false) {
																	{
																		Entity _ent = entity;
																		if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																			_ent.world.getServer().getCommandManager().handleCommand(
																					_ent.getCommandSource().withFeedbackDisabled()
																							.withPermissionLevel(4),
																					"/advancement revoke @s only scarlet_bonds:hunter_demon");
																		}
																	}
																	{
																		Entity _ent = entity;
																		if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																			_ent.world.getServer().getCommandManager().handleCommand(
																					_ent.getCommandSource().withFeedbackDisabled()
																							.withPermissionLevel(4),
																					"/advancement grant @s only scarlet_bonds:feral_demon_ii ");
																		}
																	}
																} else {
																	if (((entity instanceof ServerPlayerEntity)
																			&& (entity.world instanceof ServerWorld))
																					? ((ServerPlayerEntity) entity).getAdvancements().getProgress(
																							((MinecraftServer) ((ServerPlayerEntity) entity).server)
																									.getAdvancementManager()
																									.getAdvancement(new ResourceLocation(
																											"scarlet_bonds:feral_demon_ii")))
																							.isDone()
																					: false) {
																		{
																			Entity _ent = entity;
																			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																				_ent.world.getServer().getCommandManager().handleCommand(
																						_ent.getCommandSource().withFeedbackDisabled()
																								.withPermissionLevel(4),
																						"/advancement revoke @s only scarlet_bonds:feral_demon_ii");
																			}
																		}
																		{
																			Entity _ent = entity;
																			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																				_ent.world.getServer().getCommandManager().handleCommand(
																						_ent.getCommandSource().withFeedbackDisabled()
																								.withPermissionLevel(4),
																						"/advancement grant @s only scarlet_bonds:feral_demon");
																			}
																		}
																	} else {
																		if (((entity instanceof ServerPlayerEntity)
																				&& (entity.world instanceof ServerWorld))
																						? ((ServerPlayerEntity) entity).getAdvancements().getProgress(
																								((MinecraftServer) ((ServerPlayerEntity) entity).server)
																										.getAdvancementManager()
																										.getAdvancement(new ResourceLocation(
																												"scarlet_bonds:feral_demon")))
																								.isDone()
																						: false) {
																			{
																				Entity _ent = entity;
																				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																					_ent.world.getServer().getCommandManager().handleCommand(
																							_ent.getCommandSource().withFeedbackDisabled()
																									.withPermissionLevel(4),
																							"/advancement revoke @s only scarlet_bonds:feral_demon");
																				}
																			}
																			{
																				Entity _ent = entity;
																				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																					_ent.world.getServer().getCommandManager().handleCommand(
																							_ent.getCommandSource().withFeedbackDisabled()
																									.withPermissionLevel(4),
																							"/advancement grant @s only scarlet_bonds:thrall_demon_ii ");
																				}
																			}
																		} else {
																			if (((entity instanceof ServerPlayerEntity)
																					&& (entity.world instanceof ServerWorld))
																							? ((ServerPlayerEntity) entity).getAdvancements()
																									.getProgress(
																											((MinecraftServer) ((ServerPlayerEntity) entity).server)
																													.getAdvancementManager()
																													.getAdvancement(
																															new ResourceLocation(
																																	"scarlet_bonds:thrall_demon_ii")))
																									.isDone()
																							: false) {
																				{
																					Entity _ent = entity;
																					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																						_ent.world.getServer().getCommandManager().handleCommand(
																								_ent.getCommandSource().withFeedbackDisabled()
																										.withPermissionLevel(4),
																								"/advancement revoke @s only scarlet_bonds:thrall_demon_ii");
																					}
																				}
																				{
																					Entity _ent = entity;
																					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																						_ent.world.getServer().getCommandManager().handleCommand(
																								_ent.getCommandSource().withFeedbackDisabled()
																										.withPermissionLevel(4),
																								"/advancement grant @s only scarlet_bonds:thrall_demon ");
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
