package nl.thedutchruben.kitpvp.modules.arenas.listeners;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.exeptions.ArenaNotFoundException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class SignInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        //Checks if the user right clicks a block
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            //Check if the block is a sign
            if(event.getClickedBlock().getType().name().contains("SIGN")){
                //Filter to find if there is a arena sign on that location
                KitPvp.getInstance().getArenaModule().getArenaSigns().stream().filter(arenaSign -> arenaSign.getLocation() != null)
                        .filter(arenaSign -> arenaSign.getLocation() == event.getClickedBlock().getLocation()).
                        findAny().ifPresent(arenaSign -> {
                            //Execute the onClick to join the arena
                    try {
                        arenaSign.onClick(event.getPlayer());
                    } catch (ArenaNotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }
}
