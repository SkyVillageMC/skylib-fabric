package hu.bendi.skylib.client.gui;

import hu.bendi.skylib.packet.ServerClickButtonPacket;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.awt.*;

public class TestGui extends Screen {

    public TestGui() {
        super(new LiteralText("Teszt gui").formatted(Formatting.AQUA));
        this.addButton(new ButtonWidget(0, 0, 100, 50, new LiteralText("Teszt gomb"), button -> {
            System.out.println("Teszt cucc izé");
            ClientSidePacketRegistry.INSTANCE.sendToServer(new ServerClickButtonPacket());
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.fillGradient(matrices, 0, 0, this.width, this.height, Color.BLUE.getRGB(), Color.RED.getRGB());
        MinecraftClient.getInstance().getItemRenderer().renderInGui(new ItemStack(Items.COMPASS),30, 30);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        ClientSidePacketRegistry.INSTANCE.sendToServer(new Identifier("skylib","btn"), new PacketByteBuf(Unpooled.buffer()));
        return false;
    }

    @Override
    public void renderBackground(MatrixStack matrices) {
        super.renderBackground(matrices);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
