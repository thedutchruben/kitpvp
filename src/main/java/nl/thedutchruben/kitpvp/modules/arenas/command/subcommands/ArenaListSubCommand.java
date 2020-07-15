package nl.thedutchruben.kitpvp.modules.arenas.command.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.framework.arenas.Arena;
import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.framework.registery.commands.SubCommand;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;

public class ArenaListSubCommand extends SubCommand {
    public ArenaListSubCommand(Command command) {
        super(command, "list");
        setDescription("Get a list with arenas");
        setUsage("/arena list");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        MessageUtil.sendMessage(commandSender, Colors.MESSAGE,"-----------["+Colors.HIGH_LIGHT.getChatColor() +"ARENAS "+Colors.MESSAGE.getChatColor()+"]-----------",false);
        for (Arena arena : KitPvp.getInstance().getArenaModule().getArenas()) {
            MessageUtil.sendMessage(commandSender, Colors.MESSAGE,"Id : " + arena.getId() + ", Name: " + arena.getName(),false);
        }
    }
}
