package com.aitextras.client.renderers.decor;

import com.aitextras.AITExtras;
import com.aitextras.client.models.decor.CrystalModel;
import com.aitextras.core.blockentities.CrystalBlockEntity;
import com.aitextras.core.blockentities.CrystalMasterBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CrystalMasterRenderer<T extends CrystalMasterBlockEntity> implements BlockEntityRenderer<T> {

    public static final Identifier CRYSTAL_MASTER_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/crystal/master.png");
    public static final Identifier EMISSIVE_CRYSTAL_MASTER_TEXTURE = new Identifier(AITExtras.MOD_ID,
            "textures/blockentities/decor/crystal/master_emission.png");
    private final CrystalModel crystalModel;

    public CrystalMasterRenderer(BlockEntityRendererFactory.Context ctx) {
        this.crystalModel = new CrystalModel(CrystalModel.getTexturedModelData().createModel());
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

matrices.push();

        matrices.translate(0.5f, 1.5f, 0.5f);

        // Retrieve scale dynamically and apply it
        float scale = entity.getScale();
        matrices.scale(scale, scale, scale);

        this.crystalModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(CRYSTAL_MASTER_TEXTURE)), light, overlay, 1.0F,
                1.0F, 1.0F, 1.0F);
        this.crystalModel.render(matrices,
                vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentEmissive(EMISSIVE_CRYSTAL_MASTER_TEXTURE)),
                0xF000F00, overlay, 1.0F, 1.0F, 1.0F, 1.0F);

        matrices.pop();
    }
}