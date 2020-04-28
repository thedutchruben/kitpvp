package nl.thedutchruben.kitpvp.storage.types;

import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.kits.object.Kit;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import nl.thedutchruben.kitpvp.storage.Storage;

import java.util.List;
import java.util.UUID;

public class YamlStorage extends Storage {


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
        return null;
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
        return null;
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
        return null;
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

    }
}
