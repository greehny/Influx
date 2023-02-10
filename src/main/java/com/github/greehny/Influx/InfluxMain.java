package com.github.greehny.Influx;

import com.github.greehny.Influx.customblocks.WorldCustomBlock;
import com.github.greehny.Influx.mining.CustomMineFunction;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class InfluxMain extends JavaPlugin {
    private File customConfigFile;
    private FileConfiguration customConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        createCustomConfig();
        getServer().getPluginManager().registerEvents(new CustomMineFunction(this), this);
        getServer().getPluginManager().registerEvents(new WorldCustomBlock(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveCustomConfig();
    }

    //gets the custom config values
    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    //saves the config values to config file
    public void saveCustomConfig(){
        try {
            customConfig.save(customConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //checks to see if there is a config file called trampledata.yml, creates if no, then loads
    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "nodelocations.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("nodelocations.yml", false);
        }
        customConfig = YamlConfiguration.loadConfiguration(customConfigFile);
    }
}
