package dev.nixoly.nixnightvision.utils;

import dev.nixoly.nixnightvision.NixNightVision;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Expansion extends PlaceholderExpansion {

    private final NixNightVision plugin;

    public Expansion(NixNightVision plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "nightvision";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Nixoly";
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return null;
        }

        if (params.equalsIgnoreCase("status")) {
            boolean hasNightVision = player.hasPotionEffect(org.bukkit.potion.PotionEffectType.NIGHT_VISION);
            String statusKey = hasNightVision ? "enabled" : "disabled";
            String rawValue = plugin.getConfigManager().getConfig().getString("formats.status-placeholder-format." + statusKey, statusKey);
            return MessageUtils.colorize(rawValue);
        }

        return null;
    }
}