package ruby.fluffy.helpme.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.recipes.UndyeingRecipe;
import ruby.fluffy.helpme.recipes.FiringRecipe;

public class RubysRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, RubyMod.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, RubyMod.MOD_ID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<FiringRecipe>> FIRING =
            TYPES.register("firing", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "firing";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FiringRecipe>> FIRING_SERIALIZER =
            SERIALIZERS.register("firing", () -> new SimpleCookingSerializer<>(FiringRecipe::new, 100));

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<UndyeingRecipe>> COPYING_SHAPELESS =
            SERIALIZERS.register("undye_item", UndyeingRecipe.Serializer::new);
}
