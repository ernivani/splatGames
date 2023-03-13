package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.GameState;
import fr.ernicani.manager.TeamState;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerInteract implements Listener {

    private GameManager gameManager;

    public onPlayerInteract(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) {
            return;
        }
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (gameManager.getTeamState(player) == TeamState.NONE) {
            return;
        }

        if (gameManager.getGameState() != GameState.ACTIVE) {
            return;
        }

        if (item.getType().name().contains("STICK")) {

<<<<<<< Updated upstream
            Snowball snowball = player.launchProjectile(Snowball.class);
            snowball.setVelocity(player.getLocation().getDirection().multiply(2));
            snowball.setShooter(player);
            snowball.setCustomName("snowball");
=======
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event)  {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getInventory();
        if (inventory.getType() == InventoryType.CHEST && inventory.getType().name().equals("CHEST")) {
            InventoryView inventoryView = event.getView();
            if (inventoryView.getTitle().equals("Team selector")) {
                event.setCancelled(true);
                switch (event.getSlot()) {
                    case 10:
                        gameManager.setTeamState(TeamState.RED,player);
                        inventoryView.close();
                        break;
                    case 11:
                        gameManager.setTeamState(TeamState.NONE,player);
                        inventoryView.close();
                        break;
                    case 12:
                        gameManager.setTeamState(TeamState.BLUE,player);
                        inventoryView.close();
                        break;
                    default:
                        break;
                }
            }
        }
>>>>>>> Stashed changes

        }
    }
}
