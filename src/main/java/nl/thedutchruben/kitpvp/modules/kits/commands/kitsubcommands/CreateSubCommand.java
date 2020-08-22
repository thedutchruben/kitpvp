package nl.thedutchruben.kitpvp.modules.kits.commands.kitsubcommands;

import nl.thedutchruben.kitpvp.framework.registery.commands.Command;
import nl.thedutchruben.kitpvp.framework.registery.commands.SubCommand;
import org.bukkit.command.CommandSender;

public class CreateSubCommand extends SubCommand {
    public CreateSubCommand(Command command, String subcommand) {
        super(command, subcommand);
        setDescription("Create a kit");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        super.execute(commandSender, args);
    }
}
