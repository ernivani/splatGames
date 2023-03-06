package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onPlayerChat implements Listener {


    private GameManager gameManager;

    public onPlayerChat(GameManager gameManager) {
        this.gameManager = gameManager;
    }


    @EventHandler
    public void onMessageSend(AsyncPlayerChatEvent event) {
        if (gameManager.getTeamState(event.getPlayer()) == null) {
            return;
        }
        event.setFormat(gameManager.getTeamState(event.getPlayer()).getChatColor() + event.getPlayer().getName() + " §f: " + event.getMessage());
    }
}
