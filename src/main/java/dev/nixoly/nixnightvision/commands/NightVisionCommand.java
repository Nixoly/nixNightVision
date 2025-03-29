package dev.nixoly.nixnightvision.commands;

import dev.nixoly.nixnightvision.NixNightVision;
import dev.nixoly.nixnightvision.events.giveNightVision;
import dev.nixoly.nixnightvision.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class NightVisionCommand implements CommandExecutor {

    private final NixNightVision plugin;
    private final MessageUtils messageUtils;
    private final giveNightVision nightVisionHandler;

    public NightVisionCommand(NixNightVision plugin) {
        this.plugin = plugin;
        this.messageUtils = plugin.getMessageUtils();
        this.nightVisionHandler = new giveNightVision();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("help")) {
            if (!sender.hasPermission("nightvision.help")) {
                sendMessage(sender, "no-permission");
                return true;
            }
            return displayHelpMessage(sender);
        }

        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("nightvision.reload")) {
                sendMessage(sender, "no-permission");
                return true;
            }
            return handleReload(sender);
        }

        if (args.length == 1) {
            if (!sender.hasPermission("nightvision.player")) {
                sendMessage(sender, "no-permission");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                return togglePlayerNightVision(target, sender, sender.getName());
            } else {
                sendMessage(sender, "night-vision-error-no-player", "PLAYER", args[0]);
                return true;
            }
        }

        if (args.length == 0 && sender instanceof Player) {
            if (!sender.hasPermission("nightvision.use")) {
                sendMessage(sender, "no-permission");
                return true;
            }

            return togglePlayerNightVision((Player) sender, sender, null);
        }

        sendMessage(sender, "invalid-command");
        return true;
    }

    private boolean displayHelpMessage(CommandSender sender) {
        for (String line : messageUtils.getStringList("help-message")) {
            sender.sendMessage(line);
        }
        return true;
    }

    private boolean handleReload(CommandSender sender) {
        if (sender.hasPermission("nightvision.reload")) {
            long startTime = System.nanoTime();
            plugin.getConfigManager().reloadAll();
            long durationMs = (System.nanoTime() - startTime) / 1_000_000;
            HashMap<String, String> placeholders = new HashMap<>();
            placeholders.put("ms", String.valueOf(durationMs));
            sendMessage(sender, "plugin-reloaded", placeholders);

            return true;
        }

        sendMessage(sender, "no-permission");
        return true;
    }

    private boolean togglePlayerNightVision(Player target, CommandSender toggler, String admin) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put("PLAYER", target.getName());
        if (admin != null) placeholders.put("ADMIN", admin);

        if (target.hasPotionEffect(org.bukkit.potion.PotionEffectType.NIGHT_VISION)) {
            target.removePotionEffect(org.bukkit.potion.PotionEffectType.NIGHT_VISION);
            sendMessage(target, "notification-disabled");
            if (admin != null) sendMessage(toggler, "admin-toggle-confirmation-disabled", placeholders);
        } else {
            nightVisionHandler.giveNightVision(target);
            sendMessage(target, "notification-enabled");
            if (admin != null) sendMessage(toggler, "admin-toggle-confirmation-enabled", placeholders);
        }
        return true;
    }

    private void sendMessage(CommandSender sender, String key) {
        sender.sendMessage(messageUtils.getMessage(key, new HashMap<>()));
    }

    private void sendMessage(CommandSender sender, String key, String placeholderKey, String placeholderValue) {
        HashMap<String, String> placeholders = new HashMap<>();
        placeholders.put(placeholderKey, placeholderValue);
        sender.sendMessage(messageUtils.getMessage(key, placeholders));
    }

    private void sendMessage(CommandSender sender, String key, HashMap<String, String> placeholders) {
        sender.sendMessage(messageUtils.getMessage(key, placeholders));
    }
}