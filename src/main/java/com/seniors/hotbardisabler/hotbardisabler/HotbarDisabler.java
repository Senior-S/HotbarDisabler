package com.seniors.hotbardisabler.hotbardisabler;

import com.seniors.hotbardisabler.hotbardisabler.commands.Hotbar;
import com.seniors.hotbardisabler.hotbardisabler.commands.HotbarTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class HotbarDisabler extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("hotbar").setExecutor(new Hotbar());
        getCommand("hotbar").setTabCompleter(new HotbarTabCompleter());

        getServer().getLogger().info("Plugin loaded correctly.");
        getServer().getLogger().info("<<SSPlugins>>");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("<<SSPlugins>>");
    }
}
