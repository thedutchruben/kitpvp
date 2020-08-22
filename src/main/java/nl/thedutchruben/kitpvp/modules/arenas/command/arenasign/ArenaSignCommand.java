package nl.thedutchruben.kitpvp.modules.arenas.command.arenasign;

import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.modules.arenas.command.arenasign.subcommands.CreateSignSubCommand;

public class ArenaSignCommand extends Command {
    /**
     * Default creating of the command
     *
     * The Command name
     * The name of the permission that wil be added after 'kitpvp.command.'
     */
    public ArenaSignCommand() {
        super("arenasign", "arenasign");
        addSubCommand(new CreateSignSubCommand(this));
    }
}
