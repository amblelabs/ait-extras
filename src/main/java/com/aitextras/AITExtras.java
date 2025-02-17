package com.aitextras;

import com.aitextras.core.AITExtrasBlockEntityTypes;
import com.aitextras.core.AITExtrasBlocks;
import com.aitextras.core.AITExtrasItems;
import dev.amble.ait.core.AITSounds;
import dev.amble.ait.data.schema.exterior.category.BoothCategory;
import dev.amble.ait.data.schema.exterior.category.PoliceBoxCategory;
import dev.amble.ait.data.schema.exterior.variant.addon.AddonExterior;
import dev.amble.lib.container.RegistryContainer;
import net.fabricmc.api.ModInitializer;

public class AITExtras implements ModInitializer {

    public static final String MOD_ID = "ait-extras";
    public static AddonExterior ECTO;
    public static AddonExterior POSTBOX;



    @Override
    public void onInitialize() {
        registerAddonExteriors();
        RegistryContainer.register(AITExtrasItems.class, MOD_ID);
        RegistryContainer.register(AITExtrasBlocks.class, MOD_ID);
        RegistryContainer.register(AITExtrasBlockEntityTypes.class, MOD_ID);
    }

    private void registerAddonExteriors() {
        ECTO = new AddonExterior(PoliceBoxCategory.REFERENCE, MOD_ID, "ecto").register();
        ECTO.setDoor(new AddonExterior.Door(
                        ECTO, true, AITSounds.POLICE_BOX_DOOR_OPEN, AITSounds.POLICE_BOX_DOOR_CLOSE))
                .toDoor().register();

        POSTBOX = new AddonExterior(BoothCategory.REFERENCE, MOD_ID, "post_box").register();
        POSTBOX.setDoor(new AddonExterior.Door(
                        POSTBOX, false, net.minecraft.sound.SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN,
                        net.minecraft.sound.SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE))
                .toDoor().register();

    }


}
