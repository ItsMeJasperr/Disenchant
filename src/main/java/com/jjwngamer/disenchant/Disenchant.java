package com.jjwngamer.disenchant;

import com.jjwngamer.disenchant.listeners.OnClickListener;
import com.jjwngamer.disenchant.commands.DisenchantCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Disenchant extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("disenchant").setExecutor(new DisenchantCommand(this));
        Bukkit.getPluginManager().registerEvents(new OnClickListener(this), this);
    }
}
