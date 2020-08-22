package nl.thedutchruben.kitpvp.framework.arenas;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.exeptions.ArenaNotFoundException;
import nl.thedutchruben.kitpvp.framework.player.KitPvpPlayer;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.Optional;

/**
 * Arena sign is for the player to join a arena
 * @author Ruben de Roos
 * @version 1.0.0
 *
 */
public class ArenaSign {
    private int signId;
    private Location location;
    private int arenaId;


    /**
     * Default constructor for the sign with the arena option
     * @param signId Id of the sign
     * @param location Location where the sign is
     * @param arena Arena to join
     */
    public ArenaSign(int signId, Location location, Arena arena) {
        this.signId = signId;
        this.location = location;
        this.arenaId = arena.getId();
    }

    /**
     * Default constructor for the sign
     * @param signId Id of the sign
     * @param location Location where the sign is
     * @param arenaId Id of the area to join
     */
    public ArenaSign(int signId, Location location, int arenaId) {
        this.signId = signId;
        this.location = location;
        this.arenaId = arenaId;
    }

    /**
     * Get the sign id
     * @return the is of the sign
     */
    public int getSignId() {
        return signId;
    }

    /**
     * Set's the sign id
     * @param signId the id for the sign
     */
    public void setSignId(int signId) {
        this.signId = signId;
    }

    /**
     * Get the location of the sign
     * @return the sign's location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Set the location of the sign
     * @param location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public Optional<Arena> getArena(){
        return KitPvp.getInstance().getArenaModule().getArenas().stream().filter(arena -> arena.getId() == getArenaId()).findAny();
    }

    public void onClick(Player player) throws ArenaNotFoundException {
        KitPvpPlayer kitPvpPlayer = KitPvp.getInstance().getPlayerModule().getKitPvpPlayers().get(player.getUniqueId());
        if(getArena().isPresent()){
            Arena arena = getArena().get();
            kitPvpPlayer.setCurrentArena(arena);
            arena.getPlayersInArea().add(player);
            player.teleport(arena.getRandomSpawnLocation(), PlayerTeleportEvent.TeleportCause.PLUGIN);
        }else{
            MessageUtil.sendMessage(player, Colors.ERROR,"Something whent wrong while pressing the sign",false);
            throw new ArenaNotFoundException(getArenaId(),player.getUniqueId());
        }

    }

}
