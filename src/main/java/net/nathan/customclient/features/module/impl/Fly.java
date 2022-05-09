package net.nathan.customclient.features.module.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.nathan.customclient.features.module.Module;

public class Fly extends Module {

    int toggle = 0;
    int MAX_SPEED = 3;
    double FALL_SPEED = -0.04;
    double acceleration = 0.1;


    public Fly() {
        super("Fly","Fly hack.");
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

        if (client.player != null) {
            boolean jumpPressed = client.options.jumpKey.isPressed();
            boolean forwardPressed = client.options.forwardKey.isPressed();
            boolean leftPressed = client.options.leftKey.isPressed();
            boolean rightPressed = client.options.rightKey.isPressed();
            boolean backPressed = client.options.backKey.isPressed();

            Entity object = client.player;
            if (client.player.hasVehicle()) {
                object = client.player.getVehicle();
            }

            Vec3d velocity = object.getVelocity();
            Vec3d newVelocity = new Vec3d(velocity.x, -FALL_SPEED, velocity.z);

            if (jumpPressed) {

                if (forwardPressed) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration);
                }
                if (leftPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(3.1415927F/2) ;
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if (rightPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(-3.1415927F/2) ;
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if (backPressed) {
                    newVelocity = client.player.getRotationVector().negate().multiply(acceleration);
                }
                if (forwardPressed && leftPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(3.1415927F/4) ;
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if (forwardPressed && rightPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(-3.1415927F/4) ;
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if (backPressed && leftPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(3.1415927F/4 * 3) ;
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }
                if (backPressed && rightPressed && !client.player.hasVehicle()) {
                    newVelocity = client.player.getRotationVector().multiply(acceleration).rotateY(-3.1415927F/4 * 3) ;
                    newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z);
                }

                newVelocity = new Vec3d(newVelocity.x, (toggle == 0 && newVelocity.y>FALL_SPEED) ? FALL_SPEED : newVelocity.y, newVelocity.z);
                object.setVelocity(newVelocity);

                if (forwardPressed || leftPressed || rightPressed || backPressed) {
                    if (acceleration < MAX_SPEED) {
                        acceleration += 0.1;
                    } else if (acceleration > 0.2) {
                        acceleration -= 0.2;
                    }
                }

                if (toggle == 0 || newVelocity.y <= -0.04) {
                    toggle = 40;
                }
                toggle--;

            }

        }

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
