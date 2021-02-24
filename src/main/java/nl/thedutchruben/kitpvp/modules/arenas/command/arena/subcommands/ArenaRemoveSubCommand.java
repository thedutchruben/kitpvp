package nl.thedutchruben.kitpvp.modules.arenas.command.arena.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;

public class ArenaRemoveSubCommand extends SubCommand {
    public ArenaRemoveSubCommand(Command command) {
        super(command, "remove");
        setDescription("Remove a arena");
        setUsage("/arena remove <arena>");
    }


    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(args.length == 1){
            if(KitPvp.getInstance().getArenaModule().getArenas().removeIf(arena -> arena.getName().equalsIgnoreCase(args[0]))){
                MessageUtil.sendMessage(commandSender,Colors.MESSAGE,"Successfully removed the area",true);
            }else{
                MessageUtil.sendMessage(commandSender,Colors.MESSAGE,"There is no area named " + args[0],true);
            }
        }else{
            MessageUtil.sendMessage(commandSender, Colors.ERROR,"Wrong execution : " + getUsage(),true);

        }
    }
}
