package nl.thedutchruben.kitpvp.arenas.command.subcommands;

import nl.thedutchruben.kitpvp.KitPvp;
import nl.thedutchruben.kitpvp.arenas.objects.Arena;
import nl.thedutchruben.kitpvp.registery.commands.Command;
import nl.thedutchruben.kitpvp.registery.commands.SubCommand;
import nl.thedutchruben.kitpvp.utils.Colors;
import nl.thedutchruben.kitpvp.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCreateSubCommand extends SubCommand {
    public ArenaCreateSubCommand(Command command) {
        super(command, "create");
        setDescription("Create a arena");
        setUsage("/arena create <NAME>");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(args.length == 1){
            Arena arena = new Arena(KitPvp.getInstance().getArenaModule().getArenas().size() + 1);
            arena.setName(args[0]);
            KitPvp.getInstance().getStorageModule().getStorage().saveArena(arena);
            MessageUtil.sendMessage(commandSender, Colors.MESSAGE,"Arena " + Colors.HIGH_LIGHT.getChatColor() + " successfully" + Colors.MESSAGE.getChatColor() +" created!" ,true);

        }else{
            MessageUtil.sendMessage(commandSender, Colors.ERROR,"Wrong execution : " + getUsage(),true);
        }
    }
}
