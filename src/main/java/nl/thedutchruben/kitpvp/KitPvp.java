package nl.thedutchruben.kitpvp;

import nl.thedutchruben.kitpvp.modules.arenas.ArenaModule;
import nl.thedutchruben.kitpvp.modules.kits.KitModule;
import nl.thedutchruben.kitpvp.modules.player.PlayerModule;
import nl.thedutchruben.kitpvp.modules.storage.StorageModule;
import nl.thedutchruben.kitpvp.utils.Settings;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvp extends JavaPlugin {
    private static KitPvp instance;
    private StorageModule storageModule;
    private ArenaModule arenaModule;
    private PlayerModule playerModule;
    private KitModule kitModule;

    private Metrics metrics;
    @Override
    public void onEnable() {
        instance = this;
         metrics = new Metrics(this, 7649);
        //Setup the storage module
        this.storageModule = new StorageModule();
        this.storageModule.load();

        //Setup player module
        this.playerModule = new PlayerModule();
        this.playerModule.load();

        //Setup the arena module
        this.arenaModule = new ArenaModule();
        this.arenaModule.load();

        //Setup kit module
        this.kitModule = new KitModule();
        this.kitModule.load();

        metrics.addCustomChart(new Metrics.SimplePie("database_types" , () ->  this.storageModule.getStorage().getStorageName()));
        metrics.addCustomChart(new Metrics.SimplePie("arena_amount" , () -> String.valueOf(this.arenaModule.getArenas().size())));
        metrics.addCustomChart(new Metrics.SimplePie("use_scoreboard" , () -> String.valueOf(Settings.scoreboard)));
        metrics.addCustomChart(new Metrics.SimplePie("use_custom_death_messages" , () -> String.valueOf(Settings.enableCustomDeathMessages)));
        metrics.addCustomChart(new Metrics.SimplePie("skip_death_screen" , () -> String.valueOf(Settings.skipDeathScreen)));


        System.out.println("-------------------[KitPvp]-----------------------");
        System.out.println("Thanks for using my plugin.");
        System.out.println("If you like the plugin feel free to donate.");
        System.out.println("https://www.patreon.com/thedutchruben");
        System.out.println("---------------------------------------------------");

    }


    @Override
    public void onDisable() {
        this.kitModule.unLoad();
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

    public KitModule getKitModule() {
        return kitModule;
    }
}
