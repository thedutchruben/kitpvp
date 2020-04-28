package nl.thedutchruben.kitpvp.arenas.objects;

import nl.thedutchruben.kitpvp.KitPvp;
import org.bukkit.Location;

import java.util.List;

public class Arena {
    private int id;
    private Location spawn;
    private List<Location> spawnLocations;

    public void save(){
        KitPvp.getInstance().getStorageModule().getStorage().saveArena(this);
    }
}
