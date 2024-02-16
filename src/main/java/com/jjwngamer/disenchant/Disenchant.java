package com.jjwngamer.disenchant;

import com.jjwngamer.disenchant.Listeners.OnClickListener;
import com.jjwngamer.disenchant.commands.DisenchantCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Disenchant extends JavaPlugin {

    private static Disenchant instance;


    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("disenchant").setExecutor(new DisenchantCommand());
        Bukkit.getPluginManager().registerEvents(new OnClickListener(), this);
    }
    public static Disenchant getInsance(){
        return instance;
    }
}
