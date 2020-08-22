package nl.thedutchruben.kitpvp.framework.storage;

import nl.thedutchruben.kitpvp.framework.arenas.Arena;
import nl.thedutchruben.kitpvp.framework.arenas.ArenaSign;
import nl.thedutchruben.kitpvp.framework.kits.Kit;
import nl.thedutchruben.kitpvp.framework.player.KitPvpPlayer;

import java.util.List;
import java.util.UUID;

/**
 * An abstract class which can be implemented to create a storage for the data in this project,
 * such data may be player names, in-game kills / deaths, in-game bought kits etc.
 * <p>
 * An implementation holds responsibility for saving / loading certain data, this may be
 * from a local file storage to a database such as MySql. The choice which implementation
 * will be used lies in the hands of the user of this project.
 *
 * @author Ruben
 * @author Thom
 * @since 1.0-SNAPSHOT
 */
public abstract class Storage {

    public abstract String getStorageName();

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
    public abstract KitPvpPlayer loadPlayer(UUID uuid);

    /**
     * Saves all the given {@link KitPvpPlayer} it's internal data to the storage,
     * such data may be player names, in-game kills / deaths, in-game bought kits etc.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param kitPvpPlayer the object that will be saved
     * @see KitPvpPlayer
     * @since 1.0-SNAPSHOT
     */
    public abstract void savePlayer(KitPvpPlayer kitPvpPlayer);

    /**
     * Loads all the {@link Arena} objects from the storage, the implementation should make
     * sure to load all of them. This may be different for every implementation on how exactly this is handled.
     *
     * @return a {@link List<Arena>} with all found objects in the storage
     * @see Arena
     * @since 1.0-SNAPSHOT
     */
    public abstract List<Arena> loadArenas();

    /**
     * Saves the given {@link Arena} object to the storage.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param arena the object to save
     * @see Arena
     * @since 1.0-SNAPSHOT
     */
    public abstract void saveArena(Arena arena);

    /**
     * Loads all the {@link ArenaSign} objects from the storage, the implementation should make
     * sure to load all of them. This may be different for every implementation on how exactly this is handled.
     *
     * @return a {@link List<ArenaSign>} with all found objects in the storage
     * @see ArenaSign
     * @since 1.0-SNAPSHOT
     */
    public abstract List<ArenaSign> loadArenaSigns();

    /**
     * Saves the given {@link ArenaSign} object to the storage.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param arenaSign the object to save
     * @see ArenaSign
     * @since 1.0-SNAPSHOT
     */
    public abstract void saveArenaSign(ArenaSign arenaSign);

    /**
     * Loads all {@link Kit} objects from the storage.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @return a {@link List<Kit>} with all the {@link Kit} objects found by the
     * storage implementation
     * @see Kit
     * @since 1.0-SNAPSHOT
     */
    public abstract List<Kit> loadKits();

    /**
     * Saves the given {@link Kit} to the storage, this will make sure that {@link Storage#loadKits()} will
     * load the given {@link Kit} after a restart of the application.
     * This may be different for every implementation on how exactly this is handled.
     *
     * @param kit the {@link Kit} to save to the storage
     * @see Kit
     * @since 1.0-SNAPSHOT
     */
    public abstract void saveKit(Kit kit);

    /**
     * Disconnect the data base connections
     */
    public abstract void disconnect();
}
