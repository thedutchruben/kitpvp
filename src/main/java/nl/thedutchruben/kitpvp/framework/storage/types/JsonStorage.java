package nl.thedutchruben.kitpvp.framework.storage.types;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.Arena;
import nl.thedutchruben.kitpvp.framework.kits.Kit;
import nl.thedutchruben.kitpvp.framework.player.KitPvpPlayer;
import nl.thedutchruben.kitpvp.framework.storage.Storage;
import nl.thedutchruben.kitpvp.framework.storage.adabters.LocationAdabter;
import nl.thedutchruben.kitpvp.utils.FileManager;
import org.bukkit.Location;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonStorage extends Storage {
    private Gson gson;
    private FileManager fileManager = KitPvp.getInstance().getStorageModule().getFileManager();

    public JsonStorage(){
        gson = new GsonBuilder().registerTypeAdapter(Location.class,new LocationAdabter())
                .create();
    }

    @Override
    public String getStorageName() {
        return "JSON";
    }

    /**
     * Load a {@link KitPvpPlayer} from a {@link UUID}, if the player doesn't exist when fetching
     * from the storage the called method will generate a {@link KitPvpPlayer} with default values.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param uuid The {@link UUID} of the in-game player to retrieve the data for
     * @return a {@link KitPvpPlayer} with either default values or values retrieved from
     * the storage implementation
     * @see KitPvpPlayer
     * @see UUID
     * @since 1.0-SNAPSHOT
     */
    @Override
    public KitPvpPlayer loadPlayer(UUID uuid) {
        if(fileManager.getConfig("players/" +uuid.toString() +".json").get().get("data") != null){
            return gson.fromJson((JsonElement) fileManager.getConfig(uuid.toString() +".json").get().get("data"),KitPvpPlayer.class);
        }
        int id = 0;
        if(new File(KitPvp.getInstance().getDataFolder(),"players/").list() != null){
            id = new File(KitPvp.getInstance().getDataFolder(),"players/").list().length;
        }
        KitPvpPlayer kitPvpPlayer = new KitPvpPlayer(id+1,uuid);
        savePlayer(kitPvpPlayer);
        return kitPvpPlayer;
    }

    /**
     * Saves all the given {@link KitPvpPlayer} it's internal data to the storage,
     * such data may be player names, in-game kills / deaths, in-game bought kits etc.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param kitPvpPlayer the object that will be saved
     * @see KitPvpPlayer
     * @since 1.0-SNAPSHOT
     */
    @Override
    public void savePlayer(KitPvpPlayer kitPvpPlayer) {
        fileManager.getConfig("players/" +kitPvpPlayer.getUuid().toString() +".json").get().set("data",gson.toJson(kitPvpPlayer));
        fileManager.getConfig("players/" +kitPvpPlayer.getUuid().toString() +".json").save();
    }

    /**
     * Loads all the {@link Arena} objects from the storage, the implementation should make
     * sure to load all of them. This may be different for every implementation on how exactly this is handled.
     *
     * @return a {@link List<Arena>} with all found objects in the storage
     * @see Arena
     * @since 1.0-SNAPSHOT
     */
    @Override
    public List<Arena> loadArenas() {
        List<Arena> arrayList = new ArrayList<>();
        File dir = new File(KitPvp.getInstance().getDataFolder() + "/arenas/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                arrayList.add(gson.fromJson((JsonElement) fileManager.getConfig(child.getName()).get().get("data"),Arena.class));
            }
        }
        return arrayList;
    }

    /**
     * Saves the given {@link Arena} object to the storage.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param arena the object to save
     * @see Arena
     * @since 1.0-SNAPSHOT
     */
    @Override
    public void saveArena(Arena arena) {
        fileManager.getConfig("arenas/" +arena.getName() +".json").get().set("data",gson.toJson(arena));
        fileManager.getConfig("arenas/" +arena.getName() +".json").save();
    }

    /**
     * Loads all the {@link ArenaSign} objects from the storage, the implementation should make
     * sure to load all of them. This may be different for every implementation on how exactly this is handled.
     *
     * @return a {@link List<ArenaSign>} with all found objects in the storage
     * @see ArenaSign
     * @since 1.0-SNAPSHOT
     */
    @Override
    public List<ArenaSign> loadArenaSigns() {
        List<ArenaSign> arrayList = new ArrayList<>();
        File dir = new File(KitPvp.getInstance().getDataFolder() + "/arenassign/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                arrayList.add(gson.fromJson((JsonElement) fileManager.getConfig(child.getName()).get().get("data"),ArenaSign.class));
            }
        }
        return arrayList;
    }

    /**
     * Saves the given {@link ArenaSign} object to the storage.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param arenaSign the object to save
     * @see ArenaSign
     * @since 1.0-SNAPSHOT
     */
    @Override
    public void saveArenaSign(ArenaSign arenaSign) {
        fileManager.getConfig("arenassign/" +arenaSign.getSignId() +".json").get().set("data",gson.toJson(arenaSign));
        fileManager.getConfig("arenassign/" +arenaSign.getSignId() +".json").save();
    }

    /**
     * Loads all {@link Kit} objects from the storage.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @return a {@link List<Kit>} with all the {@link Kit} objects found by the
     * storage implementation
     * @see Kit
     * @since 1.0-SNAPSHOT
     */
    @Override
    public List<Kit> loadKits() {
        List<Kit> arrayList = new ArrayList<>();
        File dir = new File(KitPvp.getInstance().getDataFolder() + "/kits/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                arrayList.add(gson.fromJson((JsonElement) fileManager.getConfig(child.getName()).get().get("data"),Kit.class));
            }
        }
        return arrayList;
    }

    /**
     * Saves the given {@link Kit} to the storage, this will make sure that {@link Storage#loadKits()} will
     * load the given {@link Kit} after a restart of the application.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param kit the {@link Kit} to save to the storage
     * @see Kit
     * @since 1.0-SNAPSHOT
     */
    @Override
    public void saveKit(Kit kit) {
        fileManager.getConfig("kits/" +kit.getName() +".json").get().set("data",gson.toJson(kit));
        fileManager.getConfig("kits/" +kit.getName() +".json").save();
    }

    /**
     * Disconnect the data base connections
     */
    @Override
    public void disconnect() {

    }


}
