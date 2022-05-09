package net.nathan.customclient.features.module.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.nathan.customclient.features.GUI;
import net.nathan.customclient.features.module.Module;


public class OpenGUI extends Module {


    public OpenGUI() {
        super("OpenGUI", "Opens the GUI");
    }

    @Override
    public void enable() {

    }

    public void disable() {

    }

    public void tick() {

        MinecraftClient client = MinecraftClient.getInstance();

        setEnabled(false);
        client.setScreen(new GUI());

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }


}
