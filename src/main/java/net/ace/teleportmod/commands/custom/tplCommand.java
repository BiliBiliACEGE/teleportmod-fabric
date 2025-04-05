package net.ace.teleportmod.commands.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.ace.teleportmod.commands.CommandTemplate;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class tplCommand implements CommandTemplate {
    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("tpl")
                .then(CommandManager.argument("target", EntityArgumentType.player())
                        .executes(this::execute)
                ));
    }

    private int execute(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerPlayerEntity player = ctx.getSource().getPlayer();
        ServerPlayerEntity target = EntityArgumentType.getPlayer(ctx, "target");

        if (player == null) {
            ctx.getSource().sendError(Text.translatable("command.error.info"));
            return -1;
        }

        player.teleport(target.getServerWorld(), target.getX(), target.getY(), target.getZ(), target.getYaw(), target.getPitch());
        ctx.getSource().sendFeedback(() -> Text.translatable("command.teleport.success.info",target.getName().getString(),player.getName().getString()), false);
        return 1;
    }
}