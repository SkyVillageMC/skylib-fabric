package hu.bendi.skylib.packet;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.PacketListener;

import java.io.IOException;

public class ServerClickButtonPacket implements Packet {

    @Override
    public void read(PacketByteBuf buf) throws IOException {

    }

    @Override
    public void write(PacketByteBuf buf) throws IOException {

    }

    @Override
    public void apply(PacketListener listener) {
        System.out.println("cucckatt");
    }
}
