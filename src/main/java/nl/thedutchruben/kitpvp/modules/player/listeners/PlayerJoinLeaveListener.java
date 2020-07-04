package nl.thedutchruben.kitpvp.player.listeners;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.player.PlayerModule;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveListener implements Listener {
    private final PlayerModule playerModule = KitPvp.getInstance().getPlayerModule();
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        KitPvpPlayer kitPvpPlayer = KitPvp.getInstance().getStorageModule().getStorage().loadPlayer(event.getPlayer().getUniqueId());
        playerModule.getKitPvpPlayers().put(event.getPlayer().getUniqueId(),kitPvpPlayer);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        KitPvpPlayer kitPvpPlayer = playerModule.getKitPvpPlayers().get(event.getPlayer().getUniqueId());
        KitPvp.getInstance().getStorageModule().getStorage().savePlayer(kitPvpPlayer);
        playerModule.getKitPvpPlayers().remove(event.getPlayer().getUniqueId());
    }
}
