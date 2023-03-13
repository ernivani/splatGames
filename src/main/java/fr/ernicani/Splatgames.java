package fr.ernicani;

import fr.ernicani.commands.LobbySet;
import fr.ernicani.commands.StartCommand;
import fr.ernicani.listeners.BlockBreakListener;
import fr.ernicani.listeners.JoinListener;
import fr.ernicani.listeners.onPlayerInteract;
import fr.ernicani.listeners.ProjectileHit;
import fr.ernicani.manager.GameManager;
<<<<<<< Updated upstream
import org.bukkit.configuration.file.FileConfiguration;
=======
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
>>>>>>> Stashed changes
import org.bukkit.plugin.java.JavaPlugin;

public final class Splatgames extends JavaPlugin {

    private GameManager gameManager;
    private static Splatgames plugin;


    @Override
    public void onEnable() {
        super.onEnable();

        this.gameManager = new GameManager(this);

<<<<<<< Updated upstream
        getServer().getPluginManager().registerEvents(new BlockBreakListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new JoinListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new onPlayerInteract(gameManager), this);
        getServer().getPluginManager().registerEvents(new ProjectileHit(gameManager), this);
=======

        ListenersHandle.registerListeners(this, gameManager);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setGameMode(GameMode.SURVIVAL);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setSaturation(999999);
            player.setExp(0);
            player.setLevel(0);
            player.getInventory().clear();
            player.setInvulnerable(false);
        }

>>>>>>> Stashed changes


        getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("setlobby").setExecutor(new LobbySet(gameManager));


        //todo: load the config file


        getLogger().info("Splatgames is enabled");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        gameManager.cleanup();

        getLogger().info("Splatgames is disabled");
    }


    public static Splatgames getPlugin() {
        return plugin;
    }
}
