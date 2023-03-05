package fr.ernicani.task;

import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class GameStartCountdownTask extends BukkitRunnable {

    private GameManager gameManager;
    public GameStartCountdownTask(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    private int timeLeft = 31;

    @Override
    public void run() {
        timeLeft--;
        if (timeLeft <= 0) {
            Bukkit.getServer().getOnlinePlayers().forEach(player -> player.sendTitle("§a§lGOOO!", "", 0, 20, 0));
            gameManager.setGameState(GameState.ACTIVE);
            cancel();
            return;
        }
    if (timeLeft <= 5) {
        Bukkit.getServer().getOnlinePlayers().forEach(player -> player.sendTitle("§4§l" + timeLeft + " secondes!", "", 0, 20, 0));
    }

    switch (timeLeft) {
        case 30:
        case 20:
        case 10:
            Bukkit.broadcastMessage("§a§lLa partie commence dans §e§l"+ timeLeft + " secondes!");
            break;
    }

    }


}
