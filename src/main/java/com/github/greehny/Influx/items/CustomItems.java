package com.github.greehny.Influx.items;

import com.github.greehny.Influx.InfluxMain;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class CustomItems {

    private ItemStack createCustomItem(Material material, String itemKey, String name, String... lore){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(InfluxMain.getPlugin(InfluxMain.class), itemKey);
        PersistentDataContainer container = meta.getPersistentDataContainer();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        List<String> lores = new ArrayList<String>();
        for (String s : lore){
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        container.set(key, PersistentDataType.STRING, itemKey);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getPick(){
        return createCustomItem(Material.IRON_PICKAXE, "influx-pick", "&fIron Pickaxe", "&7Just an ordinary Iron Pick.");
    }

}
