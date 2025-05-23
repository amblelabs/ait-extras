package com.aitextras.core.blockentities;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;


public class SunDialBlockEntity extends BlockEntity {

    public SunDialBlockEntity(BlockPos pos, BlockState state) {
        super(AITExtrasBlockEntityTypes.SUN_DIAL_BLOCK_ENTITY_TYPE, pos, state);
    }

    public float getScale() {
        return 1;
    }
}

