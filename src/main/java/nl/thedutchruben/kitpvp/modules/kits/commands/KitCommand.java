package nl.thedutchruben.kitpvp.modules.kits.commands;

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
