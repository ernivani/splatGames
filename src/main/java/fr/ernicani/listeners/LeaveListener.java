package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    private GameManager gameManager;

    public LeaveListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        gameManager.removePlayer(event.getPlayer());
        event.setQuitMessage("§c" + event.getPlayer().getName() + "§7 a quitté la partie.");

    }


}
