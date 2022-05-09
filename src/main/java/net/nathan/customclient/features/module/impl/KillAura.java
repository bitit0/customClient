package net.nathan.customclient.features.module.impl;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.nathan.customclient.features.module.Module;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class KillAura extends Module {

    private Entity target;

    public KillAura() {
        super("KillAura","Kill Aura.");
    }

    @Override
    protected void enable() {

    }

    @Override
    protected void disable() {

    }

    @Override
    public void tick() {

        double range = Math.pow(6, 2);

        Stream<Entity> stream = StreamSupport.stream(MinecraftClient.getInstance().world.getEntities().spliterator(), true)
                .filter(entity -> entity instanceof LivingEntity && ((LivingEntity) entity).getHealth() > 0)
                .filter(entity -> MinecraftClient.getInstance().player.squaredDistanceTo(entity) <= range)
                .filter(entity -> entity != MinecraftClient.getInstance().player);

        target = stream.findFirst().orElse(null);
        System.out.println(target);
        if (target == null) return;

        MinecraftClient.getInstance().interactionManager.attackEntity(MinecraftClient.getInstance().player, target);
        MinecraftClient.getInstance().player.swingHand(Hand.MAIN_HAND);
        target = null;

    }

    @Override
    public void renderWorld(MatrixStack stack) {

    }

    @Override
    public void renderHud() {

    }
}
