package fr.ernicani.commands;

import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {
    private GameManager gameManager;

    public StartCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        gameManager.setGameState(GameState.STARTING);
        return true;
    }
}
