package me.twostinkysocks.nospectatorstand.client.mixin;

import me.twostinkysocks.nospectatorstand.client.NoSpectatorStandClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ArmorStandArmorEntityModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ArmorStandArmorEntityModel.class)
public abstract class ArmorStandArmorEntityModelMixin extends BipedEntityModel<ArmorStandEntity> {

    public ArmorStandArmorEntityModelMixin(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        if(!NoSpectatorStandClient.enabled || alpha == 1.0) {
            super.render(matrices, vertices, light, overlay, red, green, blue, alpha);
        }
    }
}