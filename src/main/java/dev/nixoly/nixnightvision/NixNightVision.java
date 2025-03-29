package dev.nixoly.nixnightvision;

import dev.nixoly.nixnightvision.events.giveNightVision;
import dev.nixoly.nixnightvision.utils.Expansion;
import dev.nixoly.nixnightvision.commands.NightVisionTabCompleter;
import dev.nixoly.nixnightvision.config.Config;
import dev.nixoly.nixnightvision.commands.NightVisionCommand;
import dev.nixoly.nixnightvision.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NixNightVision extends JavaPlugin implements Listener {

    private MessageUtils messageUtils;
    private Config configManager;
    private final giveNightVision nightVisionHandler = new giveNightVision();

    @Override
    public void onEnable() {
        this.configManager = new Config(this);
        this.messageUtils = new MessageUtils(this);
        this.getCommand("nightvision").setExecutor(new NightVisionCommand(this));
        this.getCommand("nightvision").setTabCompleter(new NightVisionTabCompleter());
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new Expansion(this).register();
            getLogger().info("PlaceholderAPI detected. Expansion registered!");
        } else {
            getLogger().warning("PlaceholderAPI not found! Placeholders will not work.");
        }
        getServer().getPluginManager().registerEvents(this, this);

        getLogger().info("NightVision plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NightVision plugin disabled!");
    }

    public Config getConfigManager() {
        return configManager;
    }

    public MessageUtils getMessageUtils() {
        return messageUtils;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        boolean onJoinNightVisionEnabled = configManager.getConfig().getBoolean("on-join-nightvision", false);
        if (onJoinNightVisionEnabled) {
            nightVisionHandler.giveNightVision(event.getPlayer());
        }
    }
}