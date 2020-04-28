package nl.thedutchruben.kitpvp.player.objects;

import java.util.List;
import java.util.UUID;

public class KitPvpPlayer {
    private int id;
    private UUID uuid;
    private int kills;
    private int deaths;
    private List<Integer> unlockedKits;

    public int getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public List<Integer> getUnlockedKits() {
        return unlockedKits;
    }
}
