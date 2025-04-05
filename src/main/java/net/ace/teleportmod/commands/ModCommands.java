package net.ace.teleportmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.ace.teleportmod.commands.custom.tplCommand;
import net.ace.teleportmod.commands.custom.tpxCommand;
import net.minecraft.server.command.ServerCommandSource;
import java.util.ArrayList;
import java.util.List;

public class ModCommands {
    // 存储所有命令实例
    private static final List<CommandTemplate> COMMANDS = new ArrayList<>();

    // 初始化注册所有命令
    static {
        COMMANDS.add(new tplCommand());
        COMMANDS.add(new tpxCommand());
        // 添加新命令只需在此处实例化
    }

    // 统一注册入口
    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
        COMMANDS.forEach(command -> command.register(dispatcher));
        System.out.println("模组指令注册");
    }
}