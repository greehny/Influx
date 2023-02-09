package com.github.greehny.Influx;

import com.github.greehny.Influx.mining.CustomMineFunction;
import org.bukkit.plugin.java.JavaPlugin;

public final class InfluxMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CustomMineFunction(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
