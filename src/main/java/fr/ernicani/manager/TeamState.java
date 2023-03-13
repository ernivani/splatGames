package fr.ernicani.manager;


import org.bukkit.ChatColor;

public enum TeamState {
    RED, BLUE, NONE;

    public ChatColor getChatColor() {
        switch (this) {
            case RED:
                return ChatColor.RED;
            case BLUE:
                return ChatColor.BLUE;
            default:
                return ChatColor.WHITE;
        }
    }
}