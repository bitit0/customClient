package net.nathan.customclient.features.module.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.nathan.customclient.features.module.Module;

public class BoatFly extends Module {


    public BoatFly() {
        super("BoatFly","BoatFly hack.");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {

        MinecraftClient client = MinecraftClient.getInstance();

        if (client.player != null && client.player.hasVehicle()) {
            Entity vehicle = client.player.getVehicle();
            Vec3d velocity = vehicle.getVelocity();
            double motionY = client.options.jumpKey.isPressed() ? 0.3 : 0;
            vehicle.setVelocity(new Vec3d(velocity.x, motionY, velocity.z));
        }

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
