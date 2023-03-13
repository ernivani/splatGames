package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.GameState;
import fr.ernicani.manager.TeamState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerDeath implements Listener {
    private GameManager gameManager;

    public PlayerDeath(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (gameManager.getTeamState(player) == null ) {
            return;
        }

        event.setDeathMessage(null);
        event.setDroppedExp(0);
        event.getDrops().clear();

        if (player.getHealth() == 0) {
            event.setKeepInventory(true);
            // respawn player instantly at the same location
            player.spigot().respawn();

            // set player's health to 20

        }
    }
}

