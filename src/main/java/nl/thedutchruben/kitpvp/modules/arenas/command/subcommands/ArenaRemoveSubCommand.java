package nl.thedutchruben.kitpvp.modules.arenas.command.subcommands;

import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.framework.registery.commands.SubCommand;

public class ArenaRemoveSubCommand extends SubCommand {
    public ArenaRemoveSubCommand(Command command) {
        super(command, "remove");
        setDescription("Remove a arena");
    }
}
