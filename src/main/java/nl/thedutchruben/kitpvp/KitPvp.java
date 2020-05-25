package nl.thedutchruben.kitpvp;

import nl.thedutchruben.kitpvp.arenas.ArenaModule;
import nl.thedutchruben.kitpvp.player.PlayerModule;
import nl.thedutchruben.kitpvp.storage.StorageModule;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {
    private static KitPvp instance;
    private StorageModule storageModule;
    private ArenaModule arenaModule;
    private PlayerModule playerModule;

    private Metrics metrics;
    @Override
    public void onEnable() {
        this.instance = this;
         metrics = new Metrics(this, 7649);
        //Setup the storage module
        this.storageModule = new StorageModule();
        this.storageModule.load();

        //Setup the arena module
        this.arenaModule = new ArenaModule();
        this.arenaModule.load();

        //Setup player module
        this.playerModule = new PlayerModule();
        this.playerModule.load();

        metrics.addCustomChart(new Metrics.SimplePie("database_types" , () ->  this.storageModule.getStorage().getStorageName()));
    }


    @Override
    public void onDisable() {
        this.playerModule.unLoad();
        this.arenaModule.unLoad();
        this.storageModule.unLoad();
    }

    public static KitPvp getInstance() {
        return instance;
    }

    public StorageModule getStorageModule() {
        return storageModule;
    }

    public ArenaModule getArenaModule() {
        return arenaModule;
    }

    public PlayerModule getPlayerModule() {
        return playerModule;
    }
}
