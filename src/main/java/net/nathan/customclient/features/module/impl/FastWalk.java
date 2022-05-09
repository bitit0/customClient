package net.nathan.customclient.features.module.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import net.nathan.customclient.features.module.Module;

public class FastWalk extends Module {

    public FastWalk() {
        super("FastWalk","move fast in x direction");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {

        Vec3d curPos = MinecraftClient.getInstance().player.getPos();
        MinecraftClient.getInstance().player.setPos(curPos.x+1, curPos.y, curPos.z);

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }

}
