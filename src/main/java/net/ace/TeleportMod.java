package net.ace;

import net.ace.teleportmod.commands.ModCommands;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class TeleportMod implements ModInitializer {
	public static final String MOD_ID = "teleport-mod";

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registry, env) -> {
			ModCommands.registerCommands(dispatcher); // 统一触发所有命令注册
		});
	}
}