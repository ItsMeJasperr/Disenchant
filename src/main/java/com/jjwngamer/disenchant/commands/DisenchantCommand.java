package com.jjwngamer.disenchant.commands;

import com.jjwngamer.disenchant.Utils.GuiUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisenchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(!(sender instanceof Player)){
            System.out.println("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        GuiUtil.Gui(player);

        return false;
    }
}
