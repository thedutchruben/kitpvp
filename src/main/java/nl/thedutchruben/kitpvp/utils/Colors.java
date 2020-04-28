package nl.thedutchruben.kitpvp.utils;

import org.bukkit.ChatColor;

public enum Colors {

    ERROR(ChatColor.DARK_RED),
    WARNING(ChatColor.RED),
    HIGH_LIGHT(ChatColor.GOLD),
    MESSAGE(ChatColor.WHITE);

    private ChatColor chatColor;

    Colors(ChatColor chatColor) {
        this.chatColor = chatColor;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }
}
