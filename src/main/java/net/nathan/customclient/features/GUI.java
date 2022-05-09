package net.nathan.customclient.features;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.awt.*;

public class GUI extends Screen {

    public GUI() {
        super(Text.of("GUI"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {

        MinecraftClient client = MinecraftClient.getInstance();

        this.textRenderer.draw(matrices, "NClient", (float) 5, 5, 0xFFFFFF);
        DrawableHelper.fill(matrices, 5, 25, 100, 50, Color.RED.getRGB());
        super.render(matrices, mouseX, mouseY, delta);


    }
}
