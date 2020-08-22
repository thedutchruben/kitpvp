package nl.thedutchruben.kitpvp.modules.arenas.command.arenasign.subcommands;

import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.framework.registery.commands.SubCommand;

public class CreateSignSubCommand extends SubCommand {
    public CreateSignSubCommand(Command command) {
        super(command, "create");
        setDescription("Create a sign to join a arena");
    }
}
