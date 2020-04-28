package nl.thedutchruben.kitpvp.arenas.command.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.registery.commands.Command;
import nl.thedutchruben.kitpvp.registery.commands.SubCommand;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;

public class ArenaListSubCommand extends SubCommand {
    public ArenaListSubCommand(Command command) {
        super(command, "list");
        setDescription("Get a list with arenas");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        MessageUtil.sendMessage(commandSender, Colors.MESSAGE,"-----------["+Colors.HIGH_LIGHT +"ARENAS "+Colors.MESSAGE+"]-----------",false);
        for (Arena arena : KitPvp.getInstance().getArenaModule().getArenas()) {
            MessageUtil.sendMessage(commandSender, Colors.MESSAGE,"Id : " + arena.getId() + ", Name: " + arena.getName(),false);

        }
    }
}
