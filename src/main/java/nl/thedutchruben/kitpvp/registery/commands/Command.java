package nl.thedutchruben.kitpvp.registery.commands;

import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * An abstract class witch can be implemented to create commands for this project
 *
 * @author Ruben
 * @since 1.0-SNAPSHOT
 */
public abstract class Command extends org.bukkit.command.Command implements TabCompleter {
    private final String commandPermissionPrefix = "kitpvp.command.";

    private List<SubCommand> subCommands;
    private boolean defaultList = true;

    /**
     * Default creating of the command
     * @param command The Command name
     * @param permission The name of the permission that wil be added after 'kitpvp.command.'
     */
    public Command(String command, String permission) {
        super(command);
        setPermission(commandPermissionPrefix + permission);
        this.subCommands = new ArrayList<>();
    }

    /**
     * Add a subcommand to the command
     * @param subCommand the sub command to be added
     */
    public void addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }

    /**
     * Executes the command, returning its success
     *
     * @param sender Source object which is executing this command
     * @param commandLabel The alias of the command used
     * @param args All arguments passed to the command, split via ' '
     * @return true if the command was successful, otherwise false
     */
    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (args.length <= 0) {
            if (defaultList) {
                for (SubCommand command : subCommands) {
                    for (String subCommandAlas : command.getAlias()) {
                        sender.sendMessage(Colors.HIGH_LIGHT.getChatColor() + commandLabel + Colors.MESSAGE.getChatColor() + " " + subCommandAlas + " - " + command.getDescription());
                        for (SubCommand subCommand : command.getSubCommands()) {
                            for (String subCommandAlass : subCommand.getAlias()) {

                                sender.sendMessage(Colors.HIGH_LIGHT.getChatColor() + commandLabel + Colors.MESSAGE.getChatColor() + " " + subCommand.getSubcommand() + "" + subCommandAlass + " - " + subCommand.getDescription());
                            }
                        }
                    }
                }
            } else {
                executeDefault(sender, args);
            }
        }
        Optional<SubCommand> subCommand = subCommands.stream().filter(subCommand1 -> subCommand1.getSubcommand().equalsIgnoreCase(args[0])).findAny();
        if (subCommand.isPresent()) {
            SubCommand subCommand1 = subCommand.get();
            if (sender.hasPermission(subCommand1.getPermission())) {
                subCommand1.execute(sender, Arrays.copyOfRange(args, 1, args.length));
            } else {
                MessageUtil.sendMessage((Player) sender, Colors.WARNING,"You dont have permission to do this!",true);

            }
        } else {
            if (defaultList) {
                for (SubCommand command : subCommands) {
                    MessageUtil.sendMessage((Player) sender, Colors.WARNING,commandLabel + " " + command.getCommand() +" - " + command.getDescription(),false);
                    if(!command.getSubcommand().isEmpty()){
                        sendInfo(sender,command);
                    }
                }
            } else {
                executeDefault(sender, args);
            }
        }
        return false;
    }

    /**
     * Send info about a sub command
     * @param sender The command sender
     * @param command One of the sub commands
     */
    public void sendInfo(CommandSender sender, SubCommand command){
        if(command.getSubCommands().isEmpty())return;
        for(SubCommand subCommand : command.getSubCommands()){
            for (String subCommandAlass : subCommand.getAlias()) {
                sender.sendMessage(Colors.HIGH_LIGHT.getChatColor() + subCommand.getCommand().getName() + Colors.MESSAGE.getChatColor() + " " + subCommand.getSubcommand() + "" + subCommandAlass + " - " + subCommand.getDescription());
            }
            sendInfo(sender,subCommand);
        }
    }

    /**
     * Set if the command send the default list
     * @param defaultList
     */
    public void setDefaultList(boolean defaultList) {
        this.defaultList = defaultList;
    }

    /**
     * If the defaultList is false then the command wil execute the executeDefault method
     * @param commandSender the command sender of the command
     * @param args the args that is given by the commandsender
     */
    public void executeDefault(CommandSender commandSender, String[] args){
    }

    /**
     * Executed on tab completion for this command, returning a list of
     * options the player can tab through.
     *
     * @param sender Source object which is executing this command
     * @param alias the alias being used
     * @param args All arguments passed to the command, split via ' '
     * @return a list of tab-completions for the specified arguments. This
     *     will never be null. List may be immutable.
     * @throws IllegalArgumentException if sender, alias, or args is null
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        List<String> commands = new ArrayList<>();
        for (SubCommand subCommand : subCommands) {
            for (String subCommandAlias : subCommand.getAlias()) {
                if(subCommandAlias.startsWith(Arrays.toString(args))){
                    commands.add(subCommandAlias);
                }
            }
        }
        return commands;
    }
}