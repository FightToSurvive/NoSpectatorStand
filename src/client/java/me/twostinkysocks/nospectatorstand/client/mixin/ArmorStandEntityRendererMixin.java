package me.twostinkysocks.nospectatorstand.client.mixin;

import me.twostinkysocks.nospectatorstand.client.NoSpectatorStandClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.ArmorStandEntityRenderer;
import net.minecraft.client.render.entity.state.ArmorStandEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorStandEntityRenderer.class)
public abstract class ArmorStandEntityRendererMixin {

    @Inject(at = @At("HEAD"), method = "getRenderLayer(Lnet/minecraft/client/render/entity/state/ArmorStandEntityRenderState;ZZZ)Lnet/minecraft/client/render/RenderLayer;", cancellable = true)
    protected void getRenderLayer(ArmorStandEntityRenderState armorStandEntityRenderState, boolean showBody, boolean translucent, boolean showOutline, CallbackInfoReturnable<RenderLayer> cir) {
        if(NoSpectatorStandClient.enabled && translucent) {
            cir.setReturnValue(null);
        }
    }
}