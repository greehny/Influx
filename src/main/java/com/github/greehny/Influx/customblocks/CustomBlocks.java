package com.github.greehny.Influx.customblocks;

import com.github.greehny.Influx.InfluxMain;
import com.jeff_media.customblockdata.CustomBlockData;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomBlocks {

    public void createCustomBlock(Block block, String itemKey){
        PersistentDataContainer customBlockData = new CustomBlockData(block, InfluxMain.getPlugin(InfluxMain.class));
        NamespacedKey key = new NamespacedKey(InfluxMain.getPlugin(InfluxMain.class), itemKey);
        customBlockData.set(key, PersistentDataType.STRING, itemKey);
    }
}
