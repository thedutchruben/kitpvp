package nl.thedutchruben.kitpvp.registery;

/**
 * Default module setup
 */
public abstract class Module {

    /**
     * Loading of the module
     * This wil be called in the onEnable of the plugin
     */
    public abstract void load();

    /**
     * Unloading of the module
     * This wil be called in the onDisable of the plugin
     */
    public abstract void unLoad();

}
