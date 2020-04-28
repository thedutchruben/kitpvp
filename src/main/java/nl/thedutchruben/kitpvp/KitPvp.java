package nl.thedutchruben.kitpvp;

import nl.thedutchruben.kitpvp.storage.StorageModule;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {
    private StorageModule storageModule;

    @Override
    public void onEnable() {
        storageModule = new StorageModule();
        storageModule.load();
    }


    @Override
    public void onDisable() {
        storageModule.unLoad();
    }

    public StorageModule getStorageModule() {
        return storageModule;
    }
}
