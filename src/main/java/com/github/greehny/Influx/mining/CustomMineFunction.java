package com.github.greehny.Influx.mining;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CustomMineFunction implements Listener {
    @EventHandler
    public void onMine(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack itemHand = event.getItem();

        if (itemHand.getType() != Material.WOODEN_PICKAXE){
            return;
        }

    }

}
