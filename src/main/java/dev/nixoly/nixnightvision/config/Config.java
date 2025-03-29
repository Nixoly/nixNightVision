package dev.nixoly.nixnightvision.config;

import dev.nixoly.nixnightvision.NixNightVision;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Config {

    private final NixNightVision plugin;
    private FileConfiguration config;
    private final File configFile;

    public Config(NixNightVision plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        setupConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void reloadAll() {
        try {
            this.config = YamlConfiguration.loadConfiguration(configFile);
            plugin.getLogger().info("Configuration successfully reloaded.");
        } catch (Exception e) {
            plugin.getLogger().severe("Error while reloading configuration: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void setupConfig() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }
        if (!configFile.exists()) {
            plugin.saveResource("config.yml", false);
        }
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }
}