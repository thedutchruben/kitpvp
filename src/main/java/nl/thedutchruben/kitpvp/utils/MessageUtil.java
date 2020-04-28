package nl.thedutchruben.kitpvp.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtil {
    private static String PREFIX = "[KitPvp]";

    public static void sendMessage(CommandSender player, Colors colors, String message, boolean prefix){
        if (prefix){
            player.sendMessage(PREFIX + colors.getChatColor() + message);
        }else{
            player.sendMessage(colors.getChatColor() + message);

        }
    }



    public static void sendMessage(CommandSender player, Colors colors, String message, boolean prefix, Replacement... replacements){
        String messages = colors.getChatColor() + message;
        for (String s : message.split(" ")) {
            for (Replacement replacement : replacements) {
                if(s.equalsIgnoreCase(replacement.getKey())){
                    s.replace(s, Colors.HIGH_LIGHT.getChatColor() + replacement.getReplacement()+ colors.getChatColor());
                }
            }
        }
        if(prefix){
            player.sendMessage(PREFIX + messages);
        }else{
            player.sendMessage(messages);

        }

    }
}
