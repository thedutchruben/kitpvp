package nl.thedutchruben.kitpvp.modules.arenas.command;

import nl.thedutchruben.kitpvp.modules.arenas.command.subcommands.ArenaCreateSubCommand;
import nl.thedutchruben.kitpvp.modules.arenas.command.subcommands.ArenaListSubCommand;
import nl.thedutchruben.kitpvp.modules.arenas.command.subcommands.ArenaRemoveSubCommand;
import nl.thedutchruben.kitpvp.framework.registery.commands.Command;

public class ArenaCommand extends Command {
    public ArenaCommand() {
        super("arena", "arena");
        addSubCommand(new ArenaCreateSubCommand(this));
        addSubCommand(new ArenaListSubCommand(this));
        addSubCommand(new ArenaRemoveSubCommand(this));
        setDescription("Arena command");
    }

}