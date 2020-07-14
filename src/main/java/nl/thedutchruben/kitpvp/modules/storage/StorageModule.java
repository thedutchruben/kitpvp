package nl.thedutchruben.kitpvp.modules.storage;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.registery.Module;
import nl.thedutchruben.kitpvp.framework.storage.Storage;
import nl.thedutchruben.kitpvp.framework.storage.exeptions.StorageTypeNotValidException;
import nl.thedutchruben.kitpvp.framework.storage.types.MongoDBStorage;
import nl.thedutchruben.kitpvp.framework.storage.types.MysqlStorage;
import nl.thedutchruben.kitpvp.framework.storage.types.JsonStorage;
import nl.thedutchruben.kitpvp.utils.FileManager;
import nl.thedutchruben.kitpvp.utils.Settings;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Arrays;

public class StorageModule extends Module {
    private Storage storage;
    private FileManager fileManager = new FileManager(KitPvp.getInstance());

    /**
     * @throws StorageTypeNotValidException throws a exception when the storage method doesn't exist
     */
    public void load() {
        createConfig();
        loadSettings();
        switch (fileManager.getConfig("database.yml").get().getString("database")){
            case "json":
                storage = new JsonStorage();
                return;
            case "msyql":
                storage = new MysqlStorage();
                return;
            case "mongo":
                storage = new MongoDBStorage();
                return;
            default:
                try {
                    throw new StorageTypeNotValidException(fileManager.getConfig("database.yml").get().getString("database"));
                } catch (StorageTypeNotValidException e) {
                    e.printStackTrace();
                }
        }
    }

    public void unLoad() {
        this.storage.disconnect();
    }

    /**
     * Get the storage that is active
     * @since 1.0-Snapshot
     * @return The Active storage
     */
    public Storage getStorage() {
        return storage;
    }

    public void createConfig(){
        FileManager.Config config = fileManager.getConfig("database.yml");
        FileConfiguration fileConfiguration = config.get();
        fileConfiguration.addDefault("database","json");
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

        FileManager.Config config2 = fileManager.getConfig("config.yml");
        FileConfiguration fileConfiguration2 = config2.get();
        fileConfiguration2.addDefault("skip-death-screen",true);
        fileConfiguration2.addDefault("custom-death-messages.enabled",true);
        fileConfiguration2.addDefault("custom-death-messages.messages",Arrays.asList("Player died","Player died again"));
        fileConfiguration2.addDefault("scoreboard",true);
        config2.copyDefaults(true).save();

        FileManager.Config config3 = fileManager.getConfig("scoreboard.json");
        FileConfiguration fileConfiguration3 = config3.get();
        fileConfiguration3.addDefault("scoreboard.title","KitPvp");
        fileConfiguration3.addDefault("scoreboard.lines", Arrays.asList(
                "Kills :",
                "<KILLS>",
                "",
                "Deaths :",
                "<DEATHS>",
                "",
                "KD :",
                "<KD>",
                ""
        ));
        config3.copyDefaults(true).save();
    }

    public void loadSettings(){
        FileManager.Config config2 = fileManager.getConfig("config.yml");
        FileConfiguration fileConfiguration2 = config2.get();
        Settings.skipDeathScreen = fileConfiguration2.getBoolean("skip-death-screen");
        Settings.enableCustomDeathMessages = fileConfiguration2.getBoolean("custom-death-messages.enabled");
        Settings.customDeathMessages = fileConfiguration2.getStringList("custom-death-messages.messages");
        Settings.scoreboard = fileConfiguration2.getBoolean("scoreboard");

    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
