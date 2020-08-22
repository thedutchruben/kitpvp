package nl.thedutchruben.kitpvp.modules.kits.commands;

import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.modules.kits.commands.kitsubcommands.CreateSubCommand;

public class KitCommand extends Command {
    /**
     * Default creating of the command
     *
     */
    public KitCommand() {
        super("kit", "kit");

        addSubCommand(new CreateSubCommand(this,"create"));
    }

}
