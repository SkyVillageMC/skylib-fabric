package hu.bendi.skylib.packet;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.PacketListener;

import java.io.IOException;

public class ClientOpenGuiPacket implements Packet {

    private boolean a;

    public ClientOpenGuiPacket(boolean a) {
        this.a = a;
    }

    @Override
    public void read(PacketByteBuf buf) throws IOException {
        a = buf.readBoolean();
    }

    @Override
    public void write(PacketByteBuf buf) throws IOException {
        buf.writeBoolean(a);
    }

    @Override
    public void apply(PacketListener listener) {
        System.out.println("asdddddcuccizé");
        //listener.getConnection().disconnect(new LiteralText("asd").formatted(Formatting.AQUA));
    }
}
