package fr.ernicani.manager;

import fr.ernicani.utils.KitOne;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerManager {
    private GameManager gameManager;

    public PlayerManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void giveKits() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            giveKit(player);
        }
    }

    private void giveKit(Player player) {
        clearPlayer(player);
        KitOne.getKit(player);
    }

    public void clearPlayer(Player player) {
        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setSaturation(999999);
        player.setExp(0);
        player.setLevel(0);
    }
}
