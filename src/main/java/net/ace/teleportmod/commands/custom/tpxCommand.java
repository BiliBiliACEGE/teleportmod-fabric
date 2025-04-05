package net.ace.teleportmod.commands.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.ace.teleportmod.commands.CommandTemplate;
import net.minecraft.command.argument.Vec3ArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class tpxCommand implements CommandTemplate {
    @Override
    public void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("tpx")
                .then(CommandManager.argument("pos", Vec3ArgumentType.vec3())
                        .executes(this::execute)
                )
        );
    }

    private int execute(CommandContext<ServerCommandSource> ctx) {
        ServerPlayerEntity player = ctx.getSource().getPlayer();
        Vec3d pos = Vec3ArgumentType.getVec3(ctx, "pos");

        if (player == null) {
            ctx.getSource().sendError(Text.translatable("command.error.info"));
            return -1;
        }

        player.teleport(
                player.getServerWorld(),
                pos.x,
                pos.y,
                pos.z,
                player.getYaw(),
                player.getPitch()
        );

        // 使用格式化字符串移除括号
        String formattedPos = String.format("%.6f, %.6f, %.6f", pos.x, pos.y, pos.z);
        ctx.getSource().sendFeedback(() ->
                        Text.translatable("command.teleport.success.info",player.getName().getString(), formattedPos),
                false
        );
        return 1;
    }
}