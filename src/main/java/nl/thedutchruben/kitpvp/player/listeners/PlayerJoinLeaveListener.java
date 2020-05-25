package nl.thedutchruben.kitpvp.player.listeners;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.player.objects.KitPvpPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        KitPvp.getInstance().getStorageModule().getStorage().loadPlayer(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        KitPvpPlayer kitPvpPlayer = new KitPvpPlayer();
        kitPvpPlayer.setUuid(event.getPlayer().getUniqueId());
        KitPvp.getInstance().getStorageModule().getStorage().savePlayer(kitPvpPlayer);
    }
}
