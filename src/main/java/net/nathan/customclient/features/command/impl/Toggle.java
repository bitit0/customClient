package net.nathan.customclient.features.command.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.nathan.customclient.features.command.Command;
import net.nathan.customclient.features.module.Module;
import net.nathan.customclient.features.module.ModuleRegistry;

public class Toggle extends Command {

    public Toggle() {
        super("Toggle", "toggles modules", "toggle", "t", "enable", "disable");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("No module name."),false);
        }
        Module toToggle = ModuleRegistry.getInstance().getByName(String.join(" ",args));
        if (toToggle == null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Invalid module name."),false);
            return;
        }
        toToggle.setEnabled(!toToggle.isEnabled());
        System.out.println(toToggle.getName()+":enabled  "+!toToggle.isEnabled()+" ->  "+toToggle.isEnabled());

    }

}
