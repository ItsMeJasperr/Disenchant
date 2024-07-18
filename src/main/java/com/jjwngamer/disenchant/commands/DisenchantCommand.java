package com.jjwngamer.disenchant.commands;

import com.jjwngamer.disenchant.Disenchant;
import com.jjwngamer.disenchant.utils.GuiUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisenchantCommand implements CommandExecutor {
    private Disenchant main;
    public DisenchantCommand(Disenchant main){
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(!(sender instanceof Player)){
            System.out.println(main.getConfig().getString("no-console"));
            return true;
        }

        Player player = (Player) sender;
        GuiUtil.Gui(player);

        return false;
    }
}
