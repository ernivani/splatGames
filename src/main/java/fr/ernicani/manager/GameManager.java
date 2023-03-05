package fr.ernicani.manager;

import fr.ernicani.Splatgames;
import fr.ernicani.task.GameStartCountdownTask;
import org.bukkit.Bukkit;

public class GameManager {

    private final Splatgames plugin;
    public GameState gameState = GameState.LOBBY;
    private BlockManager blockManager;
    private PlayerManager playerManager;

    private GameStartCountdownTask gameStartCountdownTask;

    public GameManager(Splatgames plugin) {
        this.plugin = plugin;

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
                this.gameStartCountdownTask.runTaskTimer(plugin, 0, 20);
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

    public GameState getGameState() {
        return gameState;
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
