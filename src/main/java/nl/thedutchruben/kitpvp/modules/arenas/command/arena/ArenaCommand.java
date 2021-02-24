package nl.thedutchruben.kitpvp.modules.arenas.command.arena;

import nl.thedutchruben.kitpvp.modules.arenas.command.arena.subcommands.*;

public class ArenaCommand extends Command {
    public ArenaCommand() {
        super("arena", "arena");
        addSubCommand(new ArenaCreateSubCommand(this));
        addSubCommand(new ArenaListSubCommand(this));
        addSubCommand(new ArenaRemoveSubCommand(this));
        addSubCommand(new ArenaAddLocationSubCommand(this));
        addSubCommand(new ArenaRemoveLocationSubCommand(this));
        setDescription("Arena command");
    }

}