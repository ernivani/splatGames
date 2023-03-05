package fr.ernicani.utils;

import fr.ernicani.Splatgames;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class KitOne {



    public static ItemStack getKit() {
        ItemStack stick = new ItemStack(Material.STICK, 1);
        ItemMeta meta = stick.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§6Splatstick");

        PersistentDataContainer data = meta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(Splatgames.getPlugin(), "splatstick");
        data.set(key, PersistentDataType.STRING, "1");


        stick.setItemMeta(meta);



        return stick;
    }
}
