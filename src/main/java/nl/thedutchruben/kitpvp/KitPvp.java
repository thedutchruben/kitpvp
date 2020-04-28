package nl.thedutchruben.kitpvp;

import nl.thedutchruben.kitpvp.storage.StorageModule;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {
    private static KitPvp instance;
    private StorageModule storageModule;

    @Override
    public void onEnable() {
        this.instance = this;
        this.storageModule = new StorageModule();
        this.storageModule.load();
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
