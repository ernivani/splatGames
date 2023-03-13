package fr.ernicani.manager;

import fr.ernicani.Splatgames;
import fr.ernicani.task.GameStartCountdownTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
>>>>>>> Stashed changes
=======
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
>>>>>>> 42628a502e206566fece4bae96ad138796417841

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameManager {

    private final Splatgames plugin;
    public GameState gameState = GameState.LOBBY;

    public TeamState teamState = TeamState.NONE;


    private BlockManager blockManager;
    private PlayerManager playerManager;

    private GameStartCountdownTask gameStartCountdownTask;
    private FileConfiguration config;

    private List<String> redTeam = new ArrayList<>();
    private List<String> blueTeam = new ArrayList<>();


    public GameManager(Splatgames plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();

        this.blockManager = new BlockManager(this);
        this.playerManager = new PlayerManager(this);
    }



    public void setGameState(GameState gameState) {
        if (this.gameState == GameState.ACTIVE && gameState == GameState.STARTING) return;
        if (this.gameState == gameState) return;
        this.gameState = gameState;
        switch (gameState) {
            case LOBBY:
                //todo: start the lobby
                Bukkit.broadcastMessage("The game is in lobby!");
                this.gameStartCountdownTask = new GameStartCountdownTask(this,10);
                break;
            case VOTING:
                //todo: start the voting
                break;
            case STARTING:
                //todo: start the game
                Bukkit.broadcastMessage("The game is starting!");
                this.gameStartCountdownTask = new GameStartCountdownTask(this,31);
                this.gameStartCountdownTask.runTaskTimer(plugin,0,20);
                break;
            case ACTIVE:
                //todo: while the game is running
//                if (this.gameStartCountdownTask != null) {this.gameStartCountdownTask.cancel();}
                getPlayerManager().giveKits();
                Bukkit.broadcastMessage("The game is running!");
                break;
            case ENDING:
                //todo: end the game and let winners win and losers lose and stuff like that
                break;
            case RESETTING:
                //todo: reset the game
                break;
            case RESTARTING:
                //todo: restart all the process
                break;
        }
    }

    public void cleanup() {
    }

    public TeamState getTeamState() {
        return teamState;
    }
    public GameState getGameState() {
        return gameState;
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public Location getLobbyLocation() {
        // get the location of the lobby from the config file
        double x = config.getDouble("lobby.x");
        double y = config.getDouble("lobby.y");
        double z = config.getDouble("lobby.z");
        String worldName = config.getString("lobby.world");
        return new Location(Bukkit.getWorld(worldName), x, y, z);
    }

    public void setLobbyLocation(Location location) {
        // set in the config gile the location of the lobby
        config.set("lobby.x", location.getX());
        config.set("lobby.y", location.getY());
        config.set("lobby.z", location.getZ());
        config.set("lobby.world", location.getWorld().getName());
        plugin.saveConfig();


    }

    public void setTeamState(TeamState teamState, Player player) {
        String displayName = player.getName();
        String prefix;
        switch (teamState) {
            case NONE:
                if (redTeam.contains(player.getName())) {
                    redTeam.remove(player.getName());
                } else {
                    blueTeam.remove(player.getName());
                }
                player.sendMessage("You are now in no team!");
                prefix = "";
                break;
            case RED:
                redTeam.remove(player.getName());
                blueTeam.remove(player.getName());
                redTeam.add(player.getName());
                displayName = ChatColor.RED + player.getName();
                player.sendMessage("You are now in the red team!");
                prefix = ChatColor.RED + "[red] ";
                break;
            case BLUE:
                redTeam.remove(player.getName());
                blueTeam.remove(player.getName());
                blueTeam.add(player.getName());
                displayName = ChatColor.BLUE + player.getName();
                player.sendMessage("You are now in the blue team!");
                prefix = ChatColor.BLUE + "[blue] ";
                break;
            default:
                prefix = "";
                break;
        }
        player.setPlayerListName(prefix + displayName);
        this.teamState = teamState;
    }



    public TeamState getTeamState(Player player) {
        if (redTeam.contains(player.getName())) {
            return TeamState.RED;
        } else if (blueTeam.contains(player.getName())) {
            return TeamState.BLUE;
        } else {
            return TeamState.NONE;
        }
    }

<<<<<<< HEAD
<<<<<<< Updated upstream
=======
    public void openTeamSelector(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Team selector");
        ItemStack redTeamItem = new ItemStack(Material.RED_BANNER);
        ItemMeta redTeamItemMeta = redTeamItem.getItemMeta();
        redTeamItemMeta.setDisplayName(ChatColor.RED + "Red team");
        redTeamItem.setItemMeta(redTeamItemMeta);
        ItemStack blueTeamItem = new ItemStack(Material.BLUE_BANNER);
        ItemMeta blueTeamItemMeta = blueTeamItem.getItemMeta();
        blueTeamItemMeta.setDisplayName(ChatColor.BLUE + "Blue team");
        blueTeamItem.setItemMeta(blueTeamItemMeta);
        ItemStack noneTeamItem = new ItemStack(Material.WHITE_BANNER);
        ItemMeta noneTeamItemMeta = noneTeamItem.getItemMeta();
        noneTeamItemMeta.setDisplayName(ChatColor.WHITE + "No team");
        noneTeamItem.setItemMeta(noneTeamItemMeta);
=======
    public void openTeamSelector(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 27, "Team selector");
        ItemStack redTeamItem = new ItemStack(Material.RED_WOOL);
        ItemStack blueTeamItem = new ItemStack(Material.BLUE_WOOL);
        ItemStack noneTeamItem = new ItemStack(Material.GRAY_WOOL);
>>>>>>> 42628a502e206566fece4bae96ad138796417841
        inventory.setItem(10, redTeamItem);
        inventory.setItem(11, noneTeamItem);
        inventory.setItem(12, blueTeamItem);
        player.openInventory(inventory);
    }


    public void removePlayer(Player player) {
        if (redTeam.contains(player.getName())) {
            redTeam.remove(player.getName());
        } else blueTeam.remove(player.getName());
    }


    public Plugin getPlugin() {
        return plugin;
    }
<<<<<<< HEAD
>>>>>>> Stashed changes
=======
>>>>>>> 42628a502e206566fece4bae96ad138796417841

}
