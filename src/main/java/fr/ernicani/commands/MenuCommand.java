package fr.ernicani.commands;

import fr.ernicani.manager.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MenuCommand implements CommandExecutor {

    private GameManager gameManager;

    public MenuCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player p = (Player) commandSender;

        gameManager.openTeamSelector(p);
        return true;
    }
}
