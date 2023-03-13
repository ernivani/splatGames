<<<<<<< HEAD
package fr.ernicani.utils;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.util.Vector;

public class LaunchSnowball {

    public void Pompe(Player player) {
        int numSnowballs = 1;
        double spread = 0;
        for (int i = 0; i < numSnowballs; i++) {

            Snowball snowball = player.launchProjectile(Snowball.class);
            Vector direction = player.getLocation().getDirection();
            direction.setX(direction.getX());
            direction.setY(direction.getY());
            direction.setZ(direction.getZ());
            snowball.setVelocity(direction.multiply(2));
            snowball.setShooter(player);
            snowball.setCustomName("snowball");
            snowball.setCustomNameVisible(false);
            snowball.setFallDistance(100);

        }
    }



}
=======
package fr.ernicani.utils;

import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.util.Vector;

public class LaunchSnowball {

    public void Pompe(Player player) {
        int numSnowballs = 3;
        double spread = 0.3;
        for (int i = 0; i < numSnowballs; i++) {

            Snowball snowball = player.launchProjectile(Snowball.class);
            Vector direction = player.getLocation().getDirection();
            direction.setX(direction.getX() + (Math.random() - 0.5) * spread);
            direction.setY(direction.getY() + (Math.random() - 0.5) * spread);
            direction.setZ(direction.getZ() + (Math.random() - 0.5) * spread);
            snowball.setVelocity(direction.multiply(2));
            snowball.setShooter(player);
            snowball.setCustomName("snowball");
            snowball.setCustomNameVisible(false);
            snowball.setFallDistance(100);

        }
    }

}
>>>>>>> 42628a502e206566fece4bae96ad138796417841
