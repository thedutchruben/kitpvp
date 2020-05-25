package nl.thedutchruben.kitpvp.player;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.player.listeners.PlayerJoinLeaveListener;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import nl.thedutchruben.kitpvp.registery.Module;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class PlayerModule extends Module {
    private List<String> deathMessages;
    private Map<UUID,KitPvpPlayer> kitPvpPlayers;

    public void load() {
        this.kitPvpPlayers = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinLeaveListener(), KitPvp.getInstance());
        deathMessages = KitPvp.getInstance().getStorageModule().getFileManager().getConfig("config.yml").get().getStringList("custom-death-messages.messages");

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

    public List<String> getDeathMessages() {
        return deathMessages;
    }
}
