package ruby.fluffy.helpme.utilites;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import ruby.fluffy.helpme.RubyMod;

import java.util.ArrayList;
import java.util.List;

public class RubysRecipeHelpers {

    public static List<JsonObject> RECIPES = new ArrayList<>();

    public static void createShapedRecipeJson(ArrayList<Character> keys, ArrayList<String> items, ArrayList<String> pattern, String output, int count) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shaped");
        JsonArray jsonArray = new JsonArray();
        for(String line : pattern){
            jsonArray.add(line);
        }
        json.add("pattern", jsonArray);

        JsonObject individualKey;
        JsonObject keyList = new JsonObject();

        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(items.get(i).startsWith("#") ? "tag" : "item", (ResourceLocation.parse(items.get(i))).toString());
            keyList.add(keys.get(i) + "", individualKey);
        }

        json.add("key", keyList);

        JsonObject result = new JsonObject();
        result.addProperty("id", (ResourceLocation.parse(output)).toString());
        result.addProperty("count", count);
        json.add("result", result);

        RECIPES.add(json);

    }

    @Deprecated
    public static void createShapedRecipeJson(ArrayList<Character> keys, ArrayList<String> items, ArrayList<String> type, ArrayList<String> pattern, String output, int count) {
        JsonObject json = new JsonObject();
        json.addProperty("type", "minecraft:crafting_shaped");
        JsonArray jsonArray = new JsonArray();
        for(String line : pattern){
            jsonArray.add(line);
        }
        json.add("pattern", jsonArray);

        JsonObject individualKey;
        JsonObject keyList = new JsonObject();

        for (int i = 0; i < keys.size(); ++i) {
            individualKey = new JsonObject();
            individualKey.addProperty(type.get(i), (ResourceLocation.parse(items.get(i))).toString());
            keyList.add(keys.get(i) + "", individualKey);
        }

        json.add("key", keyList);

        JsonObject result = new JsonObject();
        result.addProperty("id", (ResourceLocation.parse(output)).toString());
        result.addProperty("count", count);
        json.add("result", result);

        RECIPES.add(json);
    }
}
