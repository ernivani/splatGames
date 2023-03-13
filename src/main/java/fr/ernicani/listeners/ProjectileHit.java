package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
import fr.ernicani.manager.TeamState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit implements Listener {

    private GameManager gameManager;

    public ProjectileHit(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {
            Snowball snowball = (Snowball) event.getEntity();
            if (snowball.getShooter() instanceof Player) {
                Player player = (Player) snowball.getShooter();
                if (gameManager.getTeamState(player) == null) {
                    return;
                }
                if (event.getHitEntity() instanceof Player) {
                    Player hitPlayer = (Player) event.getHitEntity();
                    if (gameManager.getTeamState(player) == gameManager.getTeamState(hitPlayer)) {
                        event.setCancelled(true);
                        return;
                    }
                }
//                if (gameManager.getTeamState(player) == gameManager.getTeamState((Player) event.getHitEntity())) {
//                    return;
//                }
                Material teamColor = Material.BLUE_CONCRETE;
                if (gameManager.getTeamState(player) == TeamState.RED) {
                    teamColor = Material.RED_CONCRETE;
                }
                Block hitBlock = event.getHitBlock();
                if (hitBlock != null && hitBlock.getType()!= Material.BARRIER ) {
                    // Colorier le bloc touché
                    hitBlock.setType(teamColor);

                    // Colorier les autres blocs de surface touchant le bloc touché
                    World world = snowball.getWorld();
                    int radius = 2;
                    for (int x = -radius; x <= radius; x++) {
                        for (int y = -radius; y <= radius; y++) {
                            for (int z = -radius; z <= radius; z++) {
                                Block block = world.getBlockAt(hitBlock.getX() + x, hitBlock.getY() + y, hitBlock.getZ() + z);
                                if (block.getType().isSolid() && block.getY() == hitBlock.getY() + y) {
                                    block.setType(teamColor);
                                }
                            }
                        }
                    }
                } else if (event.getHitEntity() instanceof Player) {
                    Player player1 = (Player) event.getHitEntity();
                    player1.damage(7.0, (Entity) snowball.getShooter());
                }
            }
        }
    }

}