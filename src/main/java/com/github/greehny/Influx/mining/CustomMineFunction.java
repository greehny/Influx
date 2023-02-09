package com.github.greehny.Influx.mining;

import com.github.greehny.Influx.InfluxMain;
import com.github.greehny.Influx.items.CustomItems;
import com.jeff_media.customblockdata.CustomBlockData;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomMineFunction implements Listener {

    CustomItems customItems = new CustomItems();
    @EventHandler
    public void onMine(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack itemHand = event.getItem();

        if (block == null) { return; }

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK || event.getHand() != EquipmentSlot.HAND) { return; }

        if (itemHand.getType() != Material.WOODEN_PICKAXE || itemHand.getType() != Material.STONE_PICKAXE || itemHand.getType() != Material.IRON_PICKAXE){
            return;
        }
        NamespacedKey key = new NamespacedKey(InfluxMain.getPlugin(InfluxMain.class), "influx-ore-lunarite");
        PersistentDataContainer customBlockData = new CustomBlockData(block, InfluxMain.getPlugin(InfluxMain.class));
        if (!customBlockData.has(key, PersistentDataType.STRING)){ return; }
        block.getWorld().dropItemNaturally(block.getLocation(), customItems.getLunarite());
        block.setType(Material.AIR);
    }

}
