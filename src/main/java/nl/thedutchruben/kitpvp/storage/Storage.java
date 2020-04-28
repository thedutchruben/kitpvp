package nl.thedutchruben.kitpvp.storage;

import java.util.UUID;

public abstract class Storage {

    public abstract void loadPlayer(UUID uuid);

    public abstract void savePlayer(UUID uuid);

    public abstract void loadArenas();

    public abstract void saveArena();
}
