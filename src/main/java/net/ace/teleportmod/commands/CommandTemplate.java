package net.ace.teleportmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;

public interface CommandTemplate {
    void register(CommandDispatcher<ServerCommandSource> dispatcher); // 所有命令类必须实现注册方法
}