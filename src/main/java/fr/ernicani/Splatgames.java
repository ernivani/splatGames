package fr.ernicani;

import fr.ernicani.commands.LobbySet;
import fr.ernicani.commands.MenuCommand;
import fr.ernicani.commands.StartCommand;
import fr.ernicani.listeners.*;
import fr.ernicani.manager.GameManager;
<<<<<<< HEAD
<<<<<<< Updated upstream
import org.bukkit.configuration.file.FileConfiguration;
=======
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
>>>>>>> Stashed changes
=======
>>>>>>> 42628a502e206566fece4bae96ad138796417841
import org.bukkit.plugin.java.JavaPlugin;

public final class Splatgames extends JavaPlugin {

    private GameManager gameManager;
    private static Splatgames plugin;





    @Override
    public void onEnable() {
        super.onEnable();

        this.gameManager = new GameManager(this);

<<<<<<< HEAD
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
=======

        ListenersHandle.registerListeners(this, gameManager);





>>>>>>> 42628a502e206566fece4bae96ad138796417841


        getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("setlobby").setExecutor(new LobbySet(gameManager));
        getCommand("menu").setExecutor(new MenuCommand(gameManager));


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
