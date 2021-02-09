package nl.thedutchruben.kitpvp.modules.arenas;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.Arena;
import nl.thedutchruben.kitpvp.framework.registery.Module;
import nl.thedutchruben.kitpvp.modules.arenas.command.arena.ArenaCommand;
import nl.thedutchruben.kitpvp.modules.arenas.listeners.SignInteractListener;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.logging.Level;

/**
 * Arena module to handle the arenas
 */
public class ArenaModule extends Module {
    private List<Arena> arenas;
    private List<ArenaSign> arenaSigns;
    public void load() {
        //Load the arenas from the database
        arenas = KitPvp.getInstance().getStorageModule().getStorage().loadArenas();
        Bukkit.getLogger().log(Level.INFO,arenas.size() + " arena's loaded");

        //Register the command
        registerCommand(new ArenaCommand());

        //Register the listeners
        Bukkit.getPluginManager().registerEvents(new SignInteractListener(),KitPvp.getInstance());
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

    /**
     * Get a list with all the arena sign's in the server
     * @return the list with arena signs
     */
    public List<ArenaSign> getArenaSigns() {
        return arenaSigns;
    }
}
