package com.jjwngamer.disenchant.Utils;

import com.jjwngamer.disenchant.Disenchant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiUtil {
    public static void Gui(Player player){
        Inventory gui = Bukkit.createInventory(null, 27, Utils.color("&eDisenchant"));

        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        if(itemInHand.getEnchantments().isEmpty()){
            player.sendMessage(Utils.color(Disenchant.getInsance().getConfig().getString("no-enchants")));
            return;
        }
        if (itemInHand.getType() != Material.AIR) {
            List<String> enchantList = new ArrayList<>();
            for (Enchantment enchantment : itemInHand.getEnchantments().keySet()) {
                enchantList.add(enchantment.getKey().getKey());
            }

            for (int i = 0; i < enchantList.size(); i++) {
                ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(Utils.color("&a" + enchantList.get(i)));
                item.setItemMeta(meta);
                gui.setItem(i + 11, item);
            }

            gui.setItem(9, itemInHand);
            player.openInventory(gui);
        } else {
            player.sendMessage(Utils.color(Disenchant.getInsance().getConfig().getString("no-item")));
        }
    }
}
