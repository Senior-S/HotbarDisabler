package com.seniors.hotbardisabler.hotbardisabler.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HotbarTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1){
            List<String> suggestions = new ArrayList<>();
            suggestions.add("enable");
            suggestions.add("disable");

            return suggestions;
        }

        return null;
    }
}
