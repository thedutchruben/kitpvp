package nl.thedutchruben.kitpvp;

import nl.thedutchruben.kitpvp.arenas.ArenaModule;
import nl.thedutchruben.kitpvp.storage.StorageModule;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {
    private static KitPvp instance;
    private StorageModule storageModule;
    private ArenaModule arenaModule;

    @Override
    public void onEnable() {
        this.instance = this;

        //Setup the storage module
        this.storageModule = new StorageModule();
        this.storageModule.load();

        //Setup the arena module
        this.arenaModule = new ArenaModule();
        this.arenaModule.load();

    }


    @Override
    public void onDisable() {
        this.storageModule.unLoad();
        this.arenaModule.unLoad();
    }

    public static KitPvp getInstance() {
        return instance;
    }

    public StorageModule getStorageModule() {
        return storageModule;
    }
}
