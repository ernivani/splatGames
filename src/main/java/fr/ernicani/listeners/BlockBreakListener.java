package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakListener implements Listener {

    private GameManager gameManager;

    public BlockBreakListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent event) {
        if (!gameManager.getBlockManager().canBreak(event.getBlock())) {
            event.setCancelled(true);
        }else {
            //todo: faire un timer qui respawn le dans 10 secondes
            Bukkit.broadcastMessage("Le bloc a été cassé");
        }
    }
}
