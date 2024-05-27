package com.forcedVignette.gyu29.mixins;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class VignetteMixin {
    @Inject(method = "updateRenderer", at = @At("RETURN"))
    private void forceVignette(CallbackInfo ci) {
        EntityRenderer renderer = (EntityRenderer) (Object) this;
        renderer.vignetteBrightness = 0.5f; // Adjust this value to change the vignette intensity
    }
}