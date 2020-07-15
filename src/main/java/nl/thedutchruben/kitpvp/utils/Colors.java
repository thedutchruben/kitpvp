package nl.thedutchruben.kitpvp.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.awt.*;

public enum Colors {

    ERROR(ChatColor.DARK_RED,ChatColor.DARK_RED),
    WARNING(ChatColor.RED, net.md_5.bungee.api.ChatColor.of(Color.ORANGE)),
    HIGH_LIGHT(ChatColor.GOLD,ChatColor.GOLD),
    MESSAGE(ChatColor.WHITE,ChatColor.WHITE);

    private net.md_5.bungee.api.ChatColor chatColor;
    private net.md_5.bungee.api.ChatColor oneDotSixTeenColor;
    Colors(ChatColor chatColor, net.md_5.bungee.api.ChatColor oneDotSixTeenColor) {
        this.chatColor = chatColor;
        this.oneDotSixTeenColor = oneDotSixTeenColor;
    }

    public net.md_5.bungee.api.ChatColor getChatColor() {
        System.out.println(Bukkit.getVersion());
        if(Bukkit.getVersion().contains("1.16")){
            return oneDotSixTeenColor;
        }
        return chatColor;
    }
}
