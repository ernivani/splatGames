package fr.ernicani.listeners;

import fr.ernicani.Splatgames;
import fr.ernicani.manager.GameManager;
import org.bukkit.plugin.PluginManager;

public class ListenersHandle {

    public static void registerListeners(Splatgames plugin, GameManager gameManager) {
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new BlockBreakListener(gameManager), plugin);
        pm.registerEvents(new JoinListener(gameManager), plugin);
        pm.registerEvents(new LeaveListener(gameManager), plugin);
        pm.registerEvents(new onPlayerInteract(gameManager), plugin);
        pm.registerEvents(new ProjectileHit(gameManager), plugin);
        pm.registerEvents(new onPlayerChat(gameManager), plugin);
    }
}
