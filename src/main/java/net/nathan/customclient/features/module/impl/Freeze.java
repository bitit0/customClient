package net.nathan.customclient.features.module.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.nathan.customclient.features.module.Module;

public class Freeze extends Module {

    public Freeze() {
        super("Freeze","Freezes you in the air");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {
        MinecraftClient.getInstance().player.setVelocity(0,0,0);
    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
