package nl.thedutchruben.kitpvp.utils;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;

public class MessageUtil {
    private static final String PREFIX = "[KitPvp]";

    public static void sendMessage(CommandSender player, Colors colors, String message, boolean prefix){
        if (prefix){
            player.sendMessage(PREFIX + colors.getChatColor() + message);
        }else{
            player.sendMessage(colors.getChatColor() + message);

        }
    }

    public static void sendMessage(CommandSender player, Colors colors, BaseComponent message, boolean prefix){
        if (prefix){
            BaseComponent baseComponent = new TextComponent();
            baseComponent.addExtra(PREFIX);
            baseComponent.setColor(colors.getChatColor());
            baseComponent.addExtra(message);
            player.spigot().sendMessage(baseComponent);
        }else{
            message.setColor(colors.getChatColor());
            player.spigot().sendMessage(message);

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
