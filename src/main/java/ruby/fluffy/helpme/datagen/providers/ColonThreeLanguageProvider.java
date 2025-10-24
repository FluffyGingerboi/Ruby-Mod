package ruby.fluffy.helpme.datagen.providers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforgespi.language.IModInfo;
import ruby.fluffy.helpme.RubyMod;
import ruby.fluffy.helpme.registries.RubysBlocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ColonThreeLanguageProvider extends LanguageProvider {
    private static final Gson GSON = new Gson();

    public ColonThreeLanguageProvider(PackOutput output) {
        // We use minecraft as the namespace because languages are global
        super(output, "minecraft", "cat_us");
    }

    @Override
    protected void addTranslations() {
        Map<String, String> translations = new LinkedHashMap<>();

        // 🔍 Iterate through all loaded mods
        for (IModInfo modInfo : ModList.get().getMods()) {
            String modid = modInfo.getModId();
            try {
                // Locate the mod's en_us.json if it exists
                Path langPath = modInfo.getOwningFile().getFile()
                        .findResource("assets/" + modid + "/lang/en_us.json");

                if (langPath != null && Files.exists(langPath)) {
                    try (BufferedReader reader = Files.newBufferedReader(langPath, StandardCharsets.UTF_8)) {
                        JsonObject json = GSON.fromJson(reader, JsonObject.class);
                        if (json != null) {
                            for (Map.Entry<String, com.google.gson.JsonElement> entry : json.entrySet()) {
                                if (entry.getValue().isJsonPrimitive()) {
                                    String key = entry.getKey();
                                    String value = entry.getValue().getAsString();
                                    translations.put(key, value + " :3");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("[CatlishLang] Failed to read lang file for mod " + modid + ": " + e.getMessage());
            }
        }

        // Add language metadata (so it appears in the language menu)
        translations.put("language.name", "Catlish :3");
        translations.put("language.code", "cat_us");
        translations.put("language.region", "UwUland");
        translations.put("language.bidirectional", "false");

        // Write all keys into the datagen output
        for (Map.Entry<String, String> entry : translations.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }

        System.out.println("[CatlishLang] Generated Catlish translations: " + translations.size());
    }

    @Override
    public String getName() {
        return "Catlish :3 Language Provider";
    }
}