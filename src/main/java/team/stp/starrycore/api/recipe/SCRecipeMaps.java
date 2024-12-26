package team.stp.starrycore.api.recipe;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class SCRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> SUCC = new RecipeMap<>(
            "succ",
            2, 8, 2, 2,
            new SimpleRecipeBuilder(),
            false
    );

}
