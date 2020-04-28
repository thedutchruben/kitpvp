package nl.thedutchruben.kitpvp.storage.types;

import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.kits.object.Kit;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import nl.thedutchruben.kitpvp.storage.Storage;

import java.util.List;
import java.util.UUID;

public class MongoDBStorage extends Storage {


    public KitPvpPlayer loadPlayer(UUID uuid) {
        return null;
    }

    public void savePlayer(KitPvpPlayer kitPvpPlayer) {

    }

    public List<Arena> loadArenas() {
        return null;
    }

    public void saveArena(Arena arena) {

    }

    public void saveKit(Kit kit) {

    }

    public List<Kit> loadKits() {
        return null;
    }
}
