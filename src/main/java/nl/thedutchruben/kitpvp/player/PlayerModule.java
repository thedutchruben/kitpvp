package nl.thedutchruben.kitpvp.player;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.player.listeners.PlayerJoinLeaveListener;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import nl.thedutchruben.kitpvp.registery.Module;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class PlayerModule extends Module {
    private Map<UUID,KitPvpPlayer> kitPvpPlayers;

    public void load() {
        this.kitPvpPlayers = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinLeaveListener(), KitPvp.getInstance());

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            KitPvpPlayer kitPvpPlayer = KitPvp.getInstance().getStorageModule().getStorage().loadPlayer(onlinePlayer.getUniqueId());
            getKitPvpPlayers().put(onlinePlayer.getUniqueId(),kitPvpPlayer);
        }
    }

    public void unLoad() {
        this.kitPvpPlayers.forEach((uuid, kitPvpPlayer) -> KitPvp.getInstance().getStorageModule().getStorage().savePlayer(kitPvpPlayer));
    }


    public Map<UUID, KitPvpPlayer> getKitPvpPlayers() {
        return kitPvpPlayers;
    }

}
