package com.aitextras.datagen;

import com.aitextras.core.AITExtrasBlocks;
import dev.amble.ait.core.AITBlocks;
import dev.amble.ait.core.AITItems;
import dev.amble.ait.datagen.datagen_providers.AITRecipeProvider;
import dev.amble.ait.module.ModuleRegistry;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import static net.minecraft.data.server.recipe.RecipeProvider.conditionsFromItem;
import static net.minecraft.data.server.recipe.RecipeProvider.hasItem;

public class AITExtrasDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        genLang(pack);
        generateRecipes(pack);
    }

    public void generateRecipes(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            AITRecipeProvider provider = new AITRecipeProvider(output);

            ModuleRegistry.instance().iterator().forEachRemaining(module -> module.getDataGenerator().ifPresent(dataGenerator -> {
                dataGenerator.recipes(provider);
            }));


            provider.addShapedRecipe(ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, AITExtrasBlocks.EXTRAS_MONITOR_BLOCK, 1)
                    .pattern("DDD")
                    .pattern("DED")
                    .pattern("DCD")
                    .input('D', Items.DARK_OAK_PLANKS)
                    .input('C', Items.CHAIN).input('E', Items.ENDER_EYE)
                    .criterion(hasItem(Items.DARK_OAK_PLANKS), conditionsFromItem(Items.DARK_OAK_PLANKS))
                    .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                    .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE)));

            return provider;
        })));
    }

    private void genLang(FabricDataGenerator.Pack pack) {
        genEnglish(pack);
    }

    private void genEnglish(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
                    AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);

            provider.translateBlocks(AITBlocks.class);

                    //desktops
                    provider.addTranslation("desktop.ait-extras.axos", "Axos");
                    provider.addTranslation("desktop.ait-extras.cherryblossom", "CherryBlossom");
                    provider.addTranslation("desktop.ait-extras.definitive", "Definitive");
                    provider.addTranslation("desktop.ait-extras.exile", "Exile");
                    provider.addTranslation("desktop.ait-extras.industrial", "Industrial");
                    provider.addTranslation("desktop.ait-extras.tron", "Tron");
                    provider.addTranslation("desktop.ait-extras.war_games", "War Games");
                    provider.addTranslation("desktop.ait-extras.academic", "Academic");
                    provider.addTranslation("desktop.ait-extras.modern_victorian", "Modern Victorian");
                    provider.addTranslation("desktop.ait-extras.rebel", "Rebel");
                    provider.addTranslation("desktop.ait-extras.undercroft", "Undercroft");
                    provider.addTranslation("desktop.ait-extras.tardim", "Tardim");
                    provider.addTranslation("desktop.ait-extras.type_85", "Type 85");
                    provider.addTranslation("desktop.ait-extras.type_89", "Type 89");

                    //exteriors

                        //bookshelf
                    provider.addTranslation("exterior.ait-extras.bookshelf_birch", "Birch");
                    provider.addTranslation("exterior.ait-extras.bookshelf_cherry", "Cherry");
                    provider.addTranslation("exterior.ait-extras.bookshelf_dark_oak", "Dark Oak");
                    provider.addTranslation("exterior.ait-extras.bookshelf_jungle", "Jungle");
                    provider.addTranslation("exterior.ait-extras.bookshelf_mangrove", "Mangrove");
                    provider.addTranslation("exterior.ait-extras.bookshelf_oak", "Oak");
                    provider.addTranslation("exterior.ait-extras.bookshelf_spruce", "Spruce");

                        //modern box
                    provider.addTranslation("exterior.ait-extras.aperture_science", "Aperture");
                    provider.addTranslation("exterior.ait-extras.black_mesa", "Mesa");
                    provider.addTranslation("exterior.ait-extras.copper", "Copper");
                    provider.addTranslation("exterior.ait-extras.eleven_toyota", "Copper Toyota");
                    provider.addTranslation("exterior.ait-extras.eleven_toyota_alternate", "Copper Toyota (ALT)");
                    provider.addTranslation("exterior.ait-extras.coral_alternate", "Coral (ALT)");
                    provider.addTranslation("exterior.ait-extras.tokamak_eotd", "Tokamak (EOTD)");
                    provider.addTranslation("exterior.ait-extras.toyota_alternate", "Toyota (ALT)");
                    provider.addTranslation("exterior.ait-extras.toyota_memorial", "Memorial");
                    provider.addTranslation("exterior.ait-extras.yard", "73 Yards");

                        //classic box
                    provider.addTranslation("exterior.ait-extras.tango", "Tango");
                    provider.addTranslation("exterior.ait-extras.classic_cricketer", "Cricketer");
                    provider.addTranslation("exterior.ait-extras.classic_cricketer2", "Cricketer (ALT)");
                    provider.addTranslation("exterior.ait-extras.classic_happiness", "Happiness");
                    provider.addTranslation("exterior.ait-extras.classic_pilot", "Pilot");
                    provider.addTranslation("exterior.ait-extras.classic_percedent", "Percedent");
                    provider.addTranslation("exterior.ait-extras.classic_snowman", "Snowman");
                    provider.addTranslation("exterior.ait-extras.classic_victorian", "Victorian");
                    provider.addTranslation("exterior.ait-extras.classic_wanderlust", "Wanderlust");

                        //booth
                    provider.addTranslation("exterior.ait-extras.tinylink", "Tiny Link");

                        //ecto
                    provider.addTranslation("exterior.ait-extras.ecto", "Ecto");

                        //post box
                    provider.addTranslation("exterior.ait-extras.post_box", "Post Box");

                    //sonics
                    provider.addTranslation("sonic.ait-extras.cane", "Cane");
                    provider.addTranslation("sonic.ait-extras.fob_pink", "Fob (Pink)");
                    provider.addTranslation("sonic.ait-extras.fob_red", "Fob (Red)");
                    provider.addTranslation("sonic.ait-extras.fob_yellow", "Fob (Yellow)");

                    // Blocks
                    provider.addTranslation(AITExtrasBlocks.EXTRAS_MONITOR_BLOCK, "Victorian Monitor");

            return provider;
        })));
    }
}