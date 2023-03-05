package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class onPlayerInteract implements Listener {

    private GameManager gameManager;

    public onPlayerInteract(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        assert item != null;
        if (item.getType().name().contains("STICK")) {
            Snowball snowball = player.launchProjectile(Snowball.class);
            snowball.setVelocity(player.getLocation().getDirection().multiply(2));
            snowball.setShooter(player);
            snowball.setCustomName("snowball");

        }
    }
}
