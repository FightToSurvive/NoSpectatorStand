package me.twostinkysocks.nospectatorstand.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class NoSpectatorStandClient implements ClientModInitializer {

    private static KeyBinding keyBinding;

    public static boolean enabled = true;

    @Override
    public void onInitializeClient() {
        keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Toggle Invisible Armor Stand Rendering",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                "NoSpectatorStand"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(keyBinding.wasPressed()) {
                enabled = !enabled;
                if(enabled) {
                    client.player.sendMessage(Text.of("Disabled invisible stand rendering"), false);
                } else {
                    client.player.sendMessage(Text.of("Enabled invisible stand rendering"), false);
                }
            }
        });
    }
}
