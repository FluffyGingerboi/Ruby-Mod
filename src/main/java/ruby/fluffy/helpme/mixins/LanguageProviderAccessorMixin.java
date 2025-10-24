package ruby.fluffy.helpme.mixins;

import net.neoforged.neoforge.common.data.LanguageProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin({LanguageProvider.class})
public interface LanguageProviderAccessorMixin {
    @Accessor("data")
    Map<String, String> getData();
}
