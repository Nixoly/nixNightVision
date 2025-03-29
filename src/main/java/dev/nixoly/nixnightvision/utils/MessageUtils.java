package dev.nixoly.nixnightvision.utils;

import dev.nixoly.nixnightvision.NixNightVision;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageUtils {

    private final NixNightVision plugin;

    public MessageUtils(NixNightVision plugin) {
        this.plugin = plugin;
    }

    public String format(String message, Map<String, String> placeholders) {
        if (message == null || message.isEmpty()) return "";
        placeholders.put("PREFIX", ChatColor.translateAlternateColorCodes('&', plugin.getConfigManager().getConfig().getString("prefix", "")));
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            String placeholderKey = "{" + entry.getKey() + "}";
            String replacementValue = entry.getValue();
            message = message.replace(placeholderKey, replacementValue != null ? replacementValue : "");
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String getMessage(String key, Map<String, String> placeholders) {
        String rawMessage = plugin.getConfigManager().getConfig().getString("messages." + key, "");
        return format(rawMessage, placeholders);
    }

    public List<String> getStringList(String key) {
        List<String> rawList = plugin.getConfigManager().getConfig().getStringList("messages." + key);
        List<String> coloredList = new ArrayList<>();
        for (String line : rawList) {
            coloredList.add(ChatColor.translateAlternateColorCodes('&', line));
        }
        return coloredList;
    }

    public static String colorize(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }
}