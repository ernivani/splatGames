package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.GameState;
import fr.ernicani.manager.TeamState;
import fr.ernicani.utils.LaunchSnowball;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class onPlayerInteract implements Listener {

    private GameManager gameManager;
    private LaunchSnowball launchSnowball;

    public onPlayerInteract(GameManager gameManager) {
        this.gameManager = gameManager;
        this.launchSnowball = new LaunchSnowball();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() == null) {
            return;
        }
        Player player = event.getPlayer();
        ItemStack item = event.getItem();


        if (item.getType().name().contains("COMPASS")) {
            gameManager.openTeamSelector(player);
        }



        if (gameManager.getGameState() != GameState.ACTIVE) {
            return;
        }
        if (gameManager.getTeamState(player) == TeamState.NONE) {
            return;
        }
        if (item.getType().name().contains("STICK")) {
<<<<<<< HEAD

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

=======
            launchSnowball.Pompe(player);
>>>>>>> 42628a502e206566fece4bae96ad138796417841
        }
    }

    //todo: when the user click on the inventory
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
                        break;
                    case 11:
                        gameManager.setTeamState(TeamState.NONE,player);
                        break;
                    case 12:
                        gameManager.setTeamState(TeamState.BLUE,player);
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
