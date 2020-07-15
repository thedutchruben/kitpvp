package nl.thedutchruben.kitpvp.framework.registery.commands;

import nl.thedutchruben.kitpvp.utils.Colors;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public abstract class SubCommand {
    private Command command;
    private String subcommand;
    private String permission;
    private List<String> alias;
    private String usage;
    private String description = Colors.WARNING.getChatColor() + "No description";
    private List<SubCommand> subCommands = new ArrayList<>();

    public SubCommand(Command command, String subcommand) {
        this.command = command;
        this.subcommand = subcommand;
        this.permission = command.getPermission() + "." +subcommand;
        alias = new ArrayList<>();
        alias.add(subcommand);
    }


    public Command getCommand() {
        return command;
    }

    public String getSubcommand() {
        return subcommand;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAlias() {
        return alias;
    }

    public String getUsage() {
        return usage;
    }

    public String getDescription() {
        return description;
    }

    public List<SubCommand> getSubCommands() {
        return subCommands;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addAlias(String subcommand) {
        alias.add(subcommand);
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public void execute(CommandSender commandSender, String[] args){

    }
}
