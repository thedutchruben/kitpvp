package nl.thedutchruben.kitpvp.storage;

import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.kits.object.Kit;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;

import java.util.List;
import java.util.UUID;

/**
 * Default's of the storage methods
 */
public abstract class Storage {

    /**
     * Load the player from uuid if the player doesn't exist they wil create the player
     * @param uuid The UUID of the player
     * @return The kitPvpPlayer of the loaded player
     */
    public abstract KitPvpPlayer loadPlayer(UUID uuid);

    /**
     * Save the player in the database
     * @param kitPvpPlayer the player that needs to be saved
     */
    public abstract void savePlayer(KitPvpPlayer kitPvpPlayer);

    /**
     * Load all the arena's from the database
     * @return A list of all the arenas that are stored in the database
     */
    public abstract List<Arena> loadArenas();

    /**
     * Save the arena in the database
     * @param arena the arena that needs to be saved
     */
    public abstract void saveArena(Arena arena);

    /**
     * Load the kits from the database
     * @return A list with all the kits that are stored in the database
     */
    public abstract List<Kit> loadKits();

    /**
     * Save the kit in the database
     * @param kit The kit that needs to be saved
     */
    public abstract void saveKit(Kit kit);
}
