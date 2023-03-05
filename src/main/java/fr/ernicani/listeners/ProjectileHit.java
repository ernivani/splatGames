package fr.ernicani.listeners;

import fr.ernicani.manager.GameManager;
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
            Block hitBlock = event.getHitBlock();
            if (hitBlock != null && hitBlock.getType() != Material.RED_WOOL) {
                // Colorier le bloc touché
                hitBlock.setType(Material.RED_WOOL);

                // Colorier les autres blocs de surface touchant le bloc touché
                World world = snowball.getWorld();
                int radius = 1;
                for (int x = -radius; x <= radius; x++) {
                    for (int y = -radius; y <= radius; y++) {
                        for (int z = -radius; z <= radius; z++) {
                            Block block = world.getBlockAt(hitBlock.getX() + x, hitBlock.getY() + y, hitBlock.getZ() + z);
                            if (block.getType().isSolid() && block.getY() == hitBlock.getY() + y && block.getFace(hitBlock) != null) {
                                block.setType(Material.RED_WOOL);
                            }
                        }
                    }
                }
            }
            else if (event.getHitEntity() instanceof Player) {
                Player player = (Player) event.getHitEntity();
                player.damage(7.0, (Entity) snowball.getShooter());
            }
        }
    }






}
