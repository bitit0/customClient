package net.nathan.customclient.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.nathan.customclient.features.module.Module;
import net.nathan.customclient.features.module.ModuleRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Inject(method="tick",at=@At("HEAD"))
    public void preTick(CallbackInfo ci) {
        for (Module module : ModuleRegistry.getInstance().getAll()) {
            if (module.isEnabled()) module.tick();
        }
    }

}
