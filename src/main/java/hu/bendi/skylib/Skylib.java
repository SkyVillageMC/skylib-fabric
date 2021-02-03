package hu.bendi.skylib;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import static net.minecraft.server.command.CommandManager.literal;

public class Skylib implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerSidePacketRegistry.INSTANCE.register(new Identifier("skylib","btn"), (context, buffer) -> {
            if (context.getPlayer() instanceof ServerPlayerEntity) {
                System.out.println("cuccizé2");
                PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                buf.writeBoolean(false);
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(context.getPlayer(), new Identifier("skylib","gui"), buf);
            }
        });
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(literal("gui").executes(context -> {
            PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
            buf.writeBoolean(true);
            ServerSidePacketRegistry.INSTANCE.sendToPlayer(context.getSource().getPlayer(), new Identifier("skylib","gui"), buf);
            return 1;
        })));
    }
}
