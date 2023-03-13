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
import org.bukkit.plugin.Plugin;

public class ProjectileHit implements Listener {

    private GameManager gameManager;
    private Plugin plugin;

    public ProjectileHit(GameManager gameManager) {
        this.gameManager = gameManager;
        this.plugin = gameManager.getPlugin();
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {
            Snowball snowball = (Snowball) event.getEntity();
            if (snowball.getShooter() instanceof Player) {
                Player player = (Player) snowball.getShooter();
                TeamState teamState = gameManager.getTeamState(player);
                if (teamState == null) {
                    return;
                }
<<<<<<< Updated upstream
//                if (gameManager.getTeamState(player) == gameManager.getTeamState((Player) event.getHitEntity())) {
//                    return;
//                }
                Material teamColor = Material.BLUE_CONCRETE;
                if (gameManager.getTeamState(player) == TeamState.RED) {
=======
                if (event.getHitEntity() instanceof Player) {
                    Player hitPlayer = (Player) event.getHitEntity();
                    TeamState hitPlayerTeamState = gameManager.getTeamState(hitPlayer);
                    if (hitPlayerTeamState != null && teamState == hitPlayerTeamState) {
                        event.setCancelled(true);
                        return;
                    }
                }
                Material teamColor;
                if (teamState == TeamState.RED) {
>>>>>>> Stashed changes
                    teamColor = Material.RED_CONCRETE;
                } else {
                    teamColor = Material.BLUE_CONCRETE;
                }
                player.sendMessage("vous etes dans l'equipe " + teamColor.name());
                Block hitBlock = event.getHitBlock();
                if (hitBlock != null && hitBlock.getType()!= Material.BARRIER ) {
                    // Colorier le bloc touché
                    hitBlock.setType(teamColor);

                    // Colorier les autres blocs de surface touchant le bloc touché
<<<<<<< Updated upstream
                    World world = snowball.getWorld();
                    int radius = 1;
                    for (int x = -radius; x <= radius; x++) {
                        for (int y = -radius; y <= radius; y++) {
                            for (int z = -radius; z <= radius; z++) {
                                Block block = world.getBlockAt(hitBlock.getX() + x, hitBlock.getY() + y, hitBlock.getZ() + z);
                                if (block.getType().isSolid() && block.getY() == hitBlock.getY() + y && block.getFace(hitBlock) != null) {
                                    block.setType(teamColor);
=======
                    int radius = 2;
                    World world = snowball.getWorld();
                    Bukkit.getScheduler().runTask(plugin, () -> {
                        for (int x = -radius; x <= radius; x++) {
                            for (int y = -radius; y <= radius; y++) {
                                for (int z = -radius; z <= radius; z++) {
                                    Block block = world.getBlockAt(hitBlock.getX() + x, hitBlock.getY() + y, hitBlock.getZ() + z);
                                    if (block.getType().isSolid() && block.getY() == hitBlock.getY() + y) {
                                        Bukkit.getScheduler().runTask(plugin, () -> {
                                            block.setType(teamColor);
                                        });
                                    }
>>>>>>> Stashed changes
                                }
                            }
                        }
                    });

                } else if (event.getHitEntity() instanceof Player) {
                    Player hitPlayer = (Player) event.getHitEntity();
                    hitPlayer.damage(7.0, (Entity) snowball.getShooter());
                }
            }
        }
    }
}
