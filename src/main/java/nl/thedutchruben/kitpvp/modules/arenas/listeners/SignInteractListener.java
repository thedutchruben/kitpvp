package nl.thedutchruben.kitpvp.modules.arenas.listeners;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.exeptions.ArenaNotFoundException;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Locale;


public class SignInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        //Checks if the user right clicks a block
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            //Check if the block is a sign
            if(event.getClickedBlock().getType().name().contains("SIGN")){
                //Check if the sign is for joining areas
                if(((Sign)event.getClickedBlock().getState()).getLine(0).equalsIgnoreCase("[AREA]")){
                    switch (((Sign)event.getClickedBlock().getState()).getLine(1)){
                        case "[MENU]":
                            //todo OPEN MENU
                        default:
                            KitPvp.getInstance().getArenaModule().getArenas().stream().filter(arena -> arena.getName().toLowerCase(Locale.ROOT).equalsIgnoreCase(arena.getName().toLowerCase(Locale.ROOT))).findFirst().ifPresent(arena -> {
                                event.getPlayer().teleport(arena.getRandomSpawnLocation());
                            });
                    }
                }
            }
        }
    }
}
