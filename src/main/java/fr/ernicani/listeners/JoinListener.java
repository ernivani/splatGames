package fr.ernicani.listeners;

import fr.ernicani.Splatgames;
import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private GameManager gameManager;

    public JoinListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("");
        Player player = event.getPlayer();
        gameManager.getPlayerManager().clearPlayer(player);

    }


}
