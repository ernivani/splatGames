package fr.ernicani;

import fr.ernicani.commands.LobbySet;
import fr.ernicani.commands.MenuCommand;
import fr.ernicani.commands.StartCommand;
import fr.ernicani.listeners.*;
import fr.ernicani.manager.GameManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Splatgames extends JavaPlugin {

    private GameManager gameManager;
    private static Splatgames plugin;


    @Override
    public void onEnable() {
        super.onEnable();

        this.gameManager = new GameManager(this);

        getServer().getPluginManager().registerEvents(new BlockBreakListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new JoinListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new onPlayerInteract(gameManager), this);
        getServer().getPluginManager().registerEvents(new ProjectileHit(gameManager), this);


        getCommand("start").setExecutor(new StartCommand(gameManager));
        getCommand("setlobby").setExecutor(new LobbySet(gameManager));
        //getCommand("menu").setExecutor(new MenuCommand(gameManager));


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
