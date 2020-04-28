package nl.thedutchruben.kitpvp.storage;

import nl.thedutchruben.kitpvp.registery.Module;

public class StorageModule extends Module {
    private Storage storage;
    public void load() {

    }

    public void unLoad() {

    }

    /**
     * Get the storage that is active
     * @return The Active storage
     */
    public Storage getStorage() {
        return storage;
    }
}
