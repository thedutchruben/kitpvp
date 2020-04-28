package nl.thedutchruben.kitpvp;

import nl.thedutchruben.kitpvp.storage.StorageModule;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {
    private static KitPvp instance;
    private StorageModule storageModule;

    @Override
    public void onEnable() {
        instance = this;
        storageModule = new StorageModule();
        storageModule.load();
    }


    @Override
    public void onDisable() {
        storageModule.unLoad();
    }

    public static KitPvp getInstance() {
        return instance;
    }

    public StorageModule getStorageModule() {
        return storageModule;
    }
}
