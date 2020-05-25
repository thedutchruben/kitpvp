package nl.thedutchruben.kitpvp.storage;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.kits.object.Kit;
import nl.thedutchruben.kitpvp.player.listeners.PlayerJoinLeaveListener;
import nl.thedutchruben.kitpvp.registery.Module;
import nl.thedutchruben.kitpvp.storage.types.MongoDBStorage;
import nl.thedutchruben.kitpvp.storage.types.MysqlStorage;
import nl.thedutchruben.kitpvp.storage.types.SqlLiteStorage;
import nl.thedutchruben.kitpvp.storage.types.YamlStorage;
import nl.thedutchruben.kitpvp.utils.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class StorageModule extends Module {
    private Storage storage;
    private FileManager fileManager = new FileManager(KitPvp.getInstance());
    public void load() {
        createConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinLeaveListener(),KitPvp.getInstance());
        switch (fileManager.getConfig("database.yml").get().getString("database")){
            case "yaml":
                storage = new YamlStorage();
                return;
            case "msyql":
                storage = new MysqlStorage();
                return;
            case "mongo":
                storage = new MongoDBStorage();
                return;
            case "sqllite":
                storage = new SqlLiteStorage();
                return;
        }
    }

    public void unLoad() {

    }

    /**
     * Get the storage that is active
     * @return The Active storage
     */
    public Storage getStorage() {
        return storage;
    }

    public void createConfig(){
        FileManager.Config config = fileManager.getConfig("database.yml");
        FileConfiguration fileConfiguration = config.get();
        fileConfiguration.addDefault("database","yaml");
        fileConfiguration.addDefault("mysql.hostname","localhost");
        fileConfiguration.addDefault("mysql.port",3306);
        fileConfiguration.addDefault("mysql.user","kitpvp");
        fileConfiguration.addDefault("mysql.password","password");
        fileConfiguration.addDefault("mysql.database","kitpvp");

        fileConfiguration.addDefault("mongo.hostname","localhost");
        fileConfiguration.addDefault("mongo.port",3306);
        fileConfiguration.addDefault("mongo.user","kitpvp");
        fileConfiguration.addDefault("mongo.password","password");
        fileConfiguration.addDefault("mongo.database","kitpvp");
        config.copyDefaults(true).save();
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
