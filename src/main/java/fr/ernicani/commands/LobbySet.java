package fr.ernicani.commands;

import fr.ernicani.manager.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbySet implements CommandExecutor {
    private GameManager gameManager;

    public LobbySet(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player p = (Player) sender;
        gameManager.setLobbyLocation(p.getLocation());
        return true;
    }

}
