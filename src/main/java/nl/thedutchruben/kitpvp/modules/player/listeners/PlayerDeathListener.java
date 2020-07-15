package nl.thedutchruben.kitpvp.modules.player.listeners;

import nl.thedutchruben.kitpvp.utils.Settings;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        if(Settings.skipDeathScreen){
            event.getEntity().spigot().respawn();
        }
    }
}
