package ruby.fluffy.helpme.mixins;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.resources.language.LanguageInfo;
import net.minecraft.client.resources.language.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.HashMap;
import java.util.Map;

@Mixin({LanguageManager.class})
public class LanguageManagerMixin {
    @ModifyReturnValue(
            method = {"extractLanguages"},
            at = {@At("RETURN")}
    )
    private static Map<String, LanguageInfo> extractLanguages(Map<String, LanguageInfo> original) {
        HashMap<String, LanguageInfo> newMap = new HashMap<>(original);
        newMap.put("cat_us", new LanguageInfo("UwULand","Catlish :3", false));
        return ImmutableMap.copyOf(newMap);
    }
}