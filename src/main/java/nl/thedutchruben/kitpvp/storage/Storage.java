package nl.thedutchruben.kitpvp.storage;

import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;

import java.util.List;
import java.util.UUID;

/**
 * Default's of the storage methots
 */
public abstract class Storage {

    public abstract KitPvpPlayer loadPlayer(UUID uuid);

    public abstract void savePlayer(KitPvpPlayer kitPvpPlayer);

    public abstract List<Arena> loadArenas();

    public abstract void saveArena(Arena arena);

    public abstract void saveKit(Object kit);

    public abstract List<Object> loadKits();
}
