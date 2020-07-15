package nl.thedutchruben.kitpvp.modules.arenas.command.subcommands;

import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.framework.registery.commands.SubCommand;
import org.bukkit.command.CommandSender;

public class ArenaAddLocationSubCommand  extends SubCommand {
    public ArenaAddLocationSubCommand(Command command) {
        super(command, "addLocation");
        setDescription("Add a spawn location to a arena");
        setUsage("/arena addlocation <arena>");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {

    }
}
