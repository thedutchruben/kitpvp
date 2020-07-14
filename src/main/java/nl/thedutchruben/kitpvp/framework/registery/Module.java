package nl.thedutchruben.kitpvp.framework.registery;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;

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


    /**
     * Regiser a plugin to the server
     * @param command
     */
    public void registerCommand(Command command){
        SimplePluginManager spm = (SimplePluginManager) KitPvp.getInstance().getServer()
                .getPluginManager();

        Field f = null;
        try {
            f = SimplePluginManager.class.getDeclaredField("commandMap");

            f.setAccessible(true);
            SimpleCommandMap scm;

            scm = (SimpleCommandMap) f.get(spm);
            System.out.println("Register command : " + command.getName());
            scm.register("kitpvp", command);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
