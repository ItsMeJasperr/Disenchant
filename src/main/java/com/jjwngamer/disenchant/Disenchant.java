package com.jjwngamer.disenchant;

import com.jjwngamer.disenchant.Listeners.OnClickListener;
import com.jjwngamer.disenchant.commands.DisenchantCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Disenchant extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("disenchant").setExecutor(new DisenchantCommand());
        Bukkit.getPluginManager().registerEvents(new OnClickListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
