package nl.thedutchruben.kitpvp.framework.registery;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Default module setup
 */
public abstract class Module {
    private static List<Command> commands = new ArrayList<>();
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
        try {
            final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register("kitpvp", command);
            System.out.println("Register command : " + command.getName());
            commands.add(command);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static List<Command> getCommands() {
        return commands;
    }
}
