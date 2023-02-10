package com.github.greehny.Influx.mining;

import com.github.greehny.Influx.InfluxMain;
import com.github.greehny.Influx.items.CustomItems;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class CustomMineFunction implements Listener {
    private InfluxMain influxMain;
    public CustomMineFunction(InfluxMain influxMain) {
        this.influxMain = influxMain;
    }

    CustomItems customItems = new CustomItems();

    @EventHandler
    public void onMine(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        Player player = event.getPlayer();
        ItemStack itemHand = player.getItemInHand();

        if (block == null) { return; }
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK || event.getHand() != EquipmentSlot.HAND) { return; }
        if (itemHand.getType() != Material.IRON_PICKAXE) { return; }
        if (block.getType() != Material.GOLD_ORE) { return; }
        if (!influxMain.getCustomConfig().contains("nodes.ore." + block.getX() + "-" + block.getY() + "-" + block.getZ())) { return; }
        if (!influxMain.getCustomConfig().getString("nodes.ore." + block.getX() + "-" + block.getY() + "-" + block.getZ() + ".oretype").equals("lunarite-ore")) {return;}
        influxMain.saveCustomConfig();
        player.getInventory().addItem(customItems.getLunarite());
        block.setType(Material.BEDROCK);

       BukkitTask regen = new BukkitRunnable() {
            @Override
            public void run() {
                block.setType(Material.GOLD_ORE);
            }
        }.runTaskLater(influxMain, 20L * 10L);
    }

    @EventHandler
    public void onCustomBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (influxMain.getCustomConfig().contains("nodes.ore." + block.getX() + "-" + block.getY() + "-" + block.getZ())) {
            influxMain.getCustomConfig().set("nodes.ore." + block.getX() + "-" + block.getY() + "-" + block.getZ(), null);
            influxMain.saveCustomConfig();
        }
    }
}
