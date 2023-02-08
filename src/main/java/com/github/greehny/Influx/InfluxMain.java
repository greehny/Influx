package com.github.greehny.Influx;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InfluxMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("START UP.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
