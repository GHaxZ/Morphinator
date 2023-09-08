package me.ghaxz.morphinator.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class MorphinatorItem extends ItemStack {
    public static ItemStack create() {
        ItemStack item = new ItemStack(Material.NETHER_STAR);

        ItemMeta data = item.getItemMeta();
        data.setDisplayName("Morphinator");
        data.setLore(Collections.singletonList("The holy Morphinator, made by Doofenschmirtz himself."));

        item.setItemMeta(data);

        return item;
    }
}
