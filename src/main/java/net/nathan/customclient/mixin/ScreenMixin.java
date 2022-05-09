package net.nathan.customclient.mixin;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.nathan.customclient.features.command.Command;
import net.nathan.customclient.features.command.CommandRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.Locale;

@Mixin(Screen.class)
public class ScreenMixin {

    @Inject(method="sendMessage(Ljava/lang/String;Z)V",at=@At("HEAD"),cancellable = true)
    public void sendMessage(String message, boolean toHud, CallbackInfo ci) {
        System.out.println("User sent "+message+" to the server.");
        if (message.startsWith(".")) {
            MinecraftClient.getInstance().inGameHud.getChatHud().addToMessageHistory(message);
            ci.cancel();

            String messageWithoutPrefix = message.substring(1);
            String[] cmdAndArgs = messageWithoutPrefix.split(" +");
            String command = cmdAndArgs[0].toLowerCase();
            String[] args = Arrays.copyOfRange(cmdAndArgs,1,cmdAndArgs.length);

            Command toExecute = CommandRegistry.getInstance().getByAlias(command);
            if (toExecute == null) {
                MinecraftClient.getInstance().player.sendMessage(Text.of("Unknown command."),false);
            } else toExecute.execute(args);

            //MinecraftClient.getInstance().player.sendMessage(Text.of("You ran "+command+" with "+Arrays.toString(args)+" as arguments"),false);
        }


    }


}
