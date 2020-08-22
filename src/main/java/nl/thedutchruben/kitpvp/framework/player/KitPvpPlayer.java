package nl.thedutchruben.kitpvp.framework.player;

import com.google.gson.annotations.SerializedName;
import nl.thedutchruben.kitpvp.framework.arenas.Arena;
import nl.thedutchruben.kitpvp.framework.kits.Kit;

import java.util.List;
import java.util.UUID;

public class KitPvpPlayer {
    @SerializedName("_id")
    private int id;
    private UUID uuid;
    private int kills;
    private int deaths;
    private List<Integer> unlockedKits;
    private transient Kit activeKit;
    private transient Arena currentArena;
    public KitPvpPlayer(int id,UUID uuid) {
        this.id = id;
        this.uuid = uuid;
    }

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

    public void setActiveKit(Kit activeKit) {
        this.activeKit = activeKit;
    }

    public Kit getActiveKit() {
        return activeKit;
    }

    public void setCurrentArena(Arena currentArena) {
        this.currentArena = currentArena;
    }

    public Arena getCurrentArena() {
        return currentArena;
    }
}
