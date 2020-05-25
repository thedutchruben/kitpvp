package nl.thedutchruben.kitpvp.player.objects;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.UUID;

public class KitPvpPlayer {
    @SerializedName("_id")
    private int id;
    private UUID uuid;
    private int kills;
    private int deaths;
    private List<Integer> unlockedKits;

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

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

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
