package nl.thedutchruben.kitpvp.modules.player;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.player.KitPvpPlayer;
import nl.thedutchruben.kitpvp.framework.registery.Module;
import nl.thedutchruben.kitpvp.modules.player.listeners.PlayerDeathListener;
import nl.thedutchruben.kitpvp.modules.player.listeners.PlayerJoinListener;
import nl.thedutchruben.kitpvp.modules.player.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerModule extends Module {
    private Map<UUID,KitPvpPlayer> kitPvpPlayers;

    public void load() {
        this.kitPvpPlayers = new HashMap<>();

        //register listeners
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), KitPvp.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), KitPvp.getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), KitPvp.getInstance());

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            KitPvpPlayer kitPvpPlayer = KitPvp.getInstance().getStorageModule().getStorage().loadPlayer(onlinePlayer.getUniqueId());
            getKitPvpPlayers().put(onlinePlayer.getUniqueId(),kitPvpPlayer);
        }
    }

    public void unLoad() {
        this.kitPvpPlayers.forEach((uuid, kitPvpPlayer) -> KitPvp.getInstance().getStorageModule().getStorage().savePlayer(kitPvpPlayer));
        this.kitPvpPlayers.clear();
    }


    public Map<UUID, KitPvpPlayer> getKitPvpPlayers() {
        return kitPvpPlayers;
    }

}
