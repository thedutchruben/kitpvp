package nl.thedutchruben.kitpvp.framework.arenas;

import nl.thedutchruben.kitpvp.KitPvp;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

/**
 * Arena is the location where the players fight
 */
public class Arena {
    private static final Random random = new Random();

    private int id;
    private String name;
    private boolean kitSelectOnJoin;
    private Location spawn;
    private List<Location> spawnLocations;
    private transient List<Player> playersInArea;

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
     * Get if the user need te select the kit before joining the area
     * @return
     */
    public boolean isKitSelectOnJoin() {
        return kitSelectOnJoin;
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
     * Get a spawn location from the location's
     * @return a random location to spawn to
     */
    public Location getRandomSpawnLocation() {
        return spawnLocations.get(random.nextInt(spawnLocations.size()));
    }

    /**
     * Get all the players in the area
     * @return a {@link List} with the players in the {@link Arena}
     */
    public List<Player> getPlayersInArea() {
        return playersInArea;
    }

    /**
     * Set if the user's 
     * @param kitSelectOnJoin
     */
    public void setKitSelectOnJoin(boolean kitSelectOnJoin) {
        this.kitSelectOnJoin = kitSelectOnJoin;
    }

    /**
     * Save the arena
     */
    public void save(){
        KitPvp.getInstance().getStorageModule().getStorage().saveArena(this);
    }
}
