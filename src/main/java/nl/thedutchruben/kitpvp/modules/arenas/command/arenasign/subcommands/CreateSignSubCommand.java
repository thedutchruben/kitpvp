package nl.thedutchruben.kitpvp.modules.arenas.command.arenasign.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.Arena;
import nl.thedutchruben.kitpvp.framework.arenas.ArenaSign;
import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.framework.registery.commands.SubCommand;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;

public class CreateSignSubCommand extends SubCommand {
    public CreateSignSubCommand(Command command) {
        super(command, "create");
        setDescription("Create a sign to join a arena");
        setUsage("<arenaId>");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(args.length == 1){
            ArenaSign arenaSign = new ArenaSign();

            MessageUtil.sendMessage(commandSender, Colors.MESSAGE,"Arena " + Colors.HIGH_LIGHT.getChatColor() + " successfully" + Colors.MESSAGE.getChatColor() +" created!" ,true);

        }else{
            MessageUtil.sendMessage(commandSender, Colors.ERROR,"Wrong execution : " + getUsage(),true);
        }
    }
}
