package nl.thedutchruben.kitpvp.storage.types;

import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.kits.object.Kit;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import nl.thedutchruben.kitpvp.storage.Storage;

import java.util.List;
import java.util.UUID;

public class SqlLiteStorage extends Storage {


    /**
     * Load the player from uuid if the player doesn't exist they wil create the player
     *
     * @param uuid The UUID of the player
     * @return The kitPvpPlayer of the loaded player
     */
    public KitPvpPlayer loadPlayer(UUID uuid) {
        return null;
    }

    /**
     * Save the player in the database
     *
     * @param kitPvpPlayer the player that needs to be saved
     */
    public void savePlayer(KitPvpPlayer kitPvpPlayer) {

    }

    /**
     * Load all the arena's from the database
     *
     * @return A list of all the arenas that are stored in the database
     */
    public List<Arena> loadArenas() {
        return null;
    }

    /**
     * Save the arena in the database
     *
     * @param arena the arena that needs to be saved
     */
    public void saveArena(Arena arena) {

    }

    /**
     * Load the kits from the database
     *
     * @return A list with all the kits that are stored in the database
     */
    public List<Kit> loadKits() {
        return null;
    }

    /**
     * Save the kit in the database
     *
     * @param kit The kit that needs to be saved
     */
    public void saveKit(Kit kit) {

    }
}
