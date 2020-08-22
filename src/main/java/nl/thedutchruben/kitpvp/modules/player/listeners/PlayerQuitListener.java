package nl.thedutchruben.kitpvp.modules.player.listeners;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.player.KitPvpPlayer;
import nl.thedutchruben.kitpvp.modules.player.PlayerModule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    private final PlayerModule playerModule = KitPvp.getInstance().getPlayerModule();

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        KitPvpPlayer kitPvpPlayer = playerModule.getKitPvpPlayers().get(event.getPlayer().getUniqueId());
        KitPvp.getInstance().getStorageModule().getStorage().savePlayer(kitPvpPlayer);
        playerModule.getKitPvpPlayers().remove(event.getPlayer().getUniqueId());
    }
}
