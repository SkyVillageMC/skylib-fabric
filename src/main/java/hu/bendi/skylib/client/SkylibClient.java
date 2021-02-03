package hu.bendi.skylib.client;

import hu.bendi.skylib.client.gui.TestGui;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SkylibClient implements ClientModInitializer {

    public static final Screen TEST_GUI = new TestGui();

    @Override
    public void onInitializeClient() {
        ClientSidePacketRegistry.INSTANCE.register(new Identifier("skylib","gui"), (context, buffer) -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            boolean a = buffer.getBoolean(0);
            if (a) mc.openScreen(TEST_GUI);
            else {
                if (mc.currentScreen != null) mc.currentScreen.onClose();
                mc.openScreen(null);
            }
        });
    }
}
