package nl.thedutchruben.kitpvp.arenas.objects;

import nl.thedutchruben.kitpvp.KitPvp;
import org.bukkit.Location;

import java.util.List;

public class Arena {
    private int id;
    private Location spawn;
    private List<Location> spawnLocations;

    public int getId() {
        return id;
    }

    public Location getSpawn() {
        return spawn;
    }

    public List<Location> getSpawnLocations() {
        return spawnLocations;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public void addLocation(Location location){
        this.spawnLocations.add(location);
    }

    public void save(){
        KitPvp.getInstance().getStorageModule().getStorage().saveArena(this);
    }
}
