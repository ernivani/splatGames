package fr.ernicani.listeners;

import fr.ernicani.Splatgames;
import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.GameState;
import fr.ernicani.manager.PlayerManager;
import fr.ernicani.manager.TeamState;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

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
        event.setJoinMessage("§a" + player.getName() + "§7 a rejoint la partie");
        Bukkit.broadcastMessage("état de la partie : "+gameManager.getGameState().toString() + " " + GameState.LOBBY.toString());



        player.sendMessage(gameManager.getGameState() != GameState.LOBBY ? "§cLa partie est en cours" : "§aLa partie n'est pas en cours");
        if (gameManager.getGameState() == GameState.LOBBY) {
            player.setGameMode(GameMode.SURVIVAL);
            player.teleport(gameManager.getLobbyLocation());
        } else {
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(gameManager.getLobbyLocation());
        }


        gameManager.setTeamState(TeamState.NONE,player);

        player.sendMessage(gameManager.getTeamState(player).toString());

    }



}
