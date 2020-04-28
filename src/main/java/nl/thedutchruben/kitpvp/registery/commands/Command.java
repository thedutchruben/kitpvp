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

public abstract class Command extends org.bukkit.command.Command implements TabCompleter {

    private final String commandPermissionPrefix = "kitpvp.command.";

    private List<SubCommand> subCommands;

    private boolean defaultList = true;

    public Command(String command, String permission) {
        super(command);
        setPermission(commandPermissionPrefix + permission);
        this.subCommands = new ArrayList<>();
    }

    public void addSubCommand(SubCommand subCommand) {
        subCommands.add(subCommand);
    }

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

    public void sendInfo(CommandSender sender, SubCommand command){
        if(command.getSubCommands().isEmpty())return;
        for(SubCommand subCommand : command.getSubCommands()){
            for (String subCommandAlass : subCommand.getAlias()) {
                sender.sendMessage(Colors.HIGH_LIGHT.getChatColor() + subCommand.getCommand().getName() + Colors.MESSAGE.getChatColor() + " " + subCommand.getSubcommand() + "" + subCommandAlass + " - " + subCommand.getDescription());
            }
            sendInfo(sender,subCommand);
        }
    }

    public void setDefaultList(boolean defaultList) {
        this.defaultList = defaultList;
    }

    public void executeDefault(CommandSender commandSender, String[] args){
    }

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