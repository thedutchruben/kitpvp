package nl.thedutchruben.kitpvp.modules.arenas.command.arena.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public class ArenaAddLocationSubCommand  extends SubCommand implements TabCompleter {
    public ArenaAddLocationSubCommand(Command command) {
        super(command, "addLocation");
        setDescription("Add a spawn location to a arena");
        setUsage("/arena addlocation <arena>");

    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ConsoleCommandSender) return;
        if(args.length == 1){
            KitPvp.getInstance().getArenaModule().getArenas().stream().filter(arena -> arena.getName().equalsIgnoreCase(args[0])).findFirst().ifPresentOrElse(arena -> {
                arena.getSpawnLocations().add(((Player)commandSender).getLocation());
                MessageUtil.sendMessage(commandSender,
                        Colors.MESSAGE,"Location added to the areana spawn's",true);
            },() -> MessageUtil.sendMessage(commandSender,
                    Colors.WARNING,args[0] + " is not a arena!",true));
        }else{
            MessageUtil.sendMessage(commandSender, Colors.ERROR,"Wrong execution : " + getUsage(),true);

        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {
        return null;
    }
}
