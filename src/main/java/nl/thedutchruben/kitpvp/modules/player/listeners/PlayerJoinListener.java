package nl.thedutchruben.kitpvp.modules.player.listeners;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.player.KitPvpPlayer;
import nl.thedutchruben.kitpvp.modules.player.PlayerModule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {
    private final PlayerModule playerModule = KitPvp.getInstance().getPlayerModule();
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        KitPvpPlayer kitPvpPlayer = KitPvp.getInstance().getStorageModule().getStorage().loadPlayer(event.getPlayer().getUniqueId());
        playerModule.getKitPvpPlayers().put(event.getPlayer().getUniqueId(),kitPvpPlayer);
    }


}
