package nl.thedutchruben.kitpvp.framework.arenas;

import nl.thedutchruben.kitpvp.KitPvp;
import org.bukkit.Location;

import java.util.List;

/**
 * Arena is the location where the players fight
 */
public class Arena {
    private int id;
    private String name;
    private Location spawn;
    private List<Location> spawnLocations;

    /**
     * Default constructor of the Arena
     * @param id the id of the arena
     */
    public Arena(int id) {
        this.id = id;
    }

    /**
     * Get the id of the arena
     * @return id of the arena
     */
    public int getId() {
        return id;
    }

    /**
     * Get the name of the arena
     * @return the name of the arena
     */
    public String getName() {
        return name;
    }

    /**
     * Get the spawn location
     * @return the spawn location
     */
    public Location getSpawn() {
        return spawn;
    }

    /**
     * Get a list with the spawn location's
     * @return a list with spawn location's
     */
    public List<Location> getSpawnLocations() {
        return spawnLocations;
    }

    /**
     * Set the name of the arena
     * @param name the name what wil be set for the arena
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the main spawn location of the arena
     * @param spawn the location object where the main spawn wil be
     */
    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    /**
     * Add a location to the spawn list
     * @param location the location object that wil be added to the spawn locations
     */
    public void addLocation(Location location){
        this.spawnLocations.add(location);
    }

    /**
     * Remove a location from the spawn list
     * @param location the location object that wil be removed from the spawn locations
     */
    public void removeSpawnLocation(Location location){
        this.spawnLocations.remove(location);
    }

    /**
     * Save the arena
     */
    public void save(){
        KitPvp.getInstance().getStorageModule().getStorage().saveArena(this);
    }
}
