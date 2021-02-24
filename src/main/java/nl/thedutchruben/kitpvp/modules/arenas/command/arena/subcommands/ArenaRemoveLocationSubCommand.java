package nl.thedutchruben.kitpvp.modules.arenas.command.arena.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ArenaRemoveLocationSubCommand extends SubCommand{
    public ArenaRemoveLocationSubCommand(Command command) {
        super(command, "removelocation");
        setDescription("Add a spawn location to a arena");
        setUsage("/arena removelocation <arena>");

    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ConsoleCommandSender) return;
        if(args.length == 1){
            KitPvp.getInstance().getArenaModule().getArenas().stream().filter(arena -> arena.getName().equalsIgnoreCase(args[0])).findFirst().ifPresentOrElse(arena -> {
               if(arena.getSpawnLocations().contains(((Player)commandSender).getLocation())){
                   arena.getSpawnLocations().remove(((Player)commandSender).getLocation());
                   MessageUtil.sendMessage(commandSender,
                           Colors.MESSAGE,"Location removed to the arena spawn's",true);
               }else{
                   MessageUtil.sendMessage(commandSender,
                           Colors.MESSAGE,"This location is not found by this arena",true);
               }

            },() -> MessageUtil.sendMessage(commandSender,
                    Colors.WARNING,args[0] + " is not a arena!",true));
        }else{
            MessageUtil.sendMessage(commandSender, Colors.ERROR,"Wrong execution : " + getUsage(),true);
        }
    }
}
