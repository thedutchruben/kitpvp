package nl.thedutchruben.kitpvp.framework.arenas.exeptions;

import java.util.UUID;

public class ArenaNotFoundException extends Exception{
    private final int arenaID;
    private final UUID playerUUID;


    public ArenaNotFoundException(int arenaID, UUID playerUUID) {
        this.arenaID = arenaID;
        this.playerUUID = playerUUID;
    }

    @Override
    public void printStackTrace() {
        System.out.println("PlayerUUID = " + playerUUID);
        System.out.println("ArenaID = " + arenaID);
        System.out.println("The arena with the id is not found");
        super.printStackTrace();
    }
}
