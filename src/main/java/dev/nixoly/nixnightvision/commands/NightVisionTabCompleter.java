package dev.nixoly.nixnightvision.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NightVisionTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> suggestions = new ArrayList<>();

        if (args.length == 1) {
            if (sender.hasPermission("nightvision.help")) {
                suggestions.add("help");
            }
            if (sender.hasPermission("nightvision.reload")) {
                suggestions.add("reload");
            }
            if (sender.hasPermission("nightvision.player")) {
                for (Player player : sender.getServer().getOnlinePlayers()) {
                    suggestions.add(player.getName());
                }
            }
        }
        String currentInput = args[args.length - 1].toLowerCase();
        suggestions.removeIf(s -> !s.toLowerCase().startsWith(currentInput));
        Collections.sort(suggestions);

        return suggestions;
    }
}