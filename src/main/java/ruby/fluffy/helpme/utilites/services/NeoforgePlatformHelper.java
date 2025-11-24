package ruby.fluffy.helpme.utilites.services;

import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import java.nio.file.Path;

public class NeoforgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    @Override
    public boolean isClientEnv() {
        return FMLEnvironment.dist.isClient();
    }
}
