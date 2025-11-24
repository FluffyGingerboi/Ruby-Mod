package ruby.fluffy.helpme.recipes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import ruby.fluffy.helpme.registries.RubysRecipes;

public class FiringRecipe extends AbstractCookingRecipe {
    public FiringRecipe(String string, CookingBookCategory category, Ingredient ingredient, ItemStack itemStack, float f, int i) {
        super(RubysRecipes.FIRING.get(), string, category, ingredient, itemStack, f, i);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RubysRecipes.FIRING_SERIALIZER.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return super.getIngredients();
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
        ItemStack result = super.assemble(input, registries);

        // the actual input stack
        ItemStack inputStack = input.item();

        // Copy ALL components (replaces old NBT)
        result.applyComponents(inputStack.getComponents());

        return result;
    }
}
