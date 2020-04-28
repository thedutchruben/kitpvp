package nl.thedutchruben.kitpvp.arenas;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.registery.Module;

import java.util.List;

/**
 * Arena module to handle the arenas
 */
public class ArenaModule extends Module {
    private List<Arena> arenas;

    public void load() {
        //Load the arenas from the database
        arenas = KitPvp.getInstance().getStorageModule().getStorage().loadArenas();
    }

    public void unLoad() {
        arenas.clear();
    }

    /**
     * Get a list with the cashed arena's
     * @return A list with arena's
     */
    public List<Arena> getArenas() {
        return arenas;
    }
}
