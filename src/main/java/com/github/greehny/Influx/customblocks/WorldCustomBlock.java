package com.github.greehny.Influx.customblocks;

import com.github.greehny.Influx.InfluxMain;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.naming.Name;

public class WorldCustomBlock implements Listener {

    @EventHandler
    public void setPlacedToLunarite(BlockPlaceEvent event){
        Block block = event.getBlockPlaced();
        ItemStack item = event.getItemInHand();
        ItemMeta meta = item.getItemMeta();

        if (item.getAmount() == 0) {return;}
        NamespacedKey key = new NamespacedKey(InfluxMain.getPlugin(InfluxMain.class), "influx-raw-lunarite");
        PersistentDataContainer container = meta.getPersistentDataContainer();

        if(container.has(key, PersistentDataType.STRING)){
            CustomBlocks customBlocks = new CustomBlocks();
            customBlocks.createCustomBlock(block, "influx-ore-lunarite");
        }
    }
}
