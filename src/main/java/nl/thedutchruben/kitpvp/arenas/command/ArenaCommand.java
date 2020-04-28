package nl.thedutchruben.kitpvp.arenas.command;

import nl.thedutchruben.kitpvp.arenas.command.subcommands.ArenaCreateSubCommand;
import nl.thedutchruben.kitpvp.arenas.command.subcommands.ArenaListSubCommand;
import nl.thedutchruben.kitpvp.arenas.command.subcommands.ArenaRemoveSubCommand;
import nl.thedutchruben.kitpvp.registery.commands.Command;

public class ArenaCommand extends Command {
    public ArenaCommand() {
        super("arena", "arena");
        addSubCommand(new ArenaCreateSubCommand(this));
        addSubCommand(new ArenaListSubCommand(this));
        addSubCommand(new ArenaRemoveSubCommand(this));
        setDescription("Arena command");
    }

}