package com.jjwngamer.disenchant.listeners;

import com.jjwngamer.disenchant.Disenchant;
import com.jjwngamer.disenchant.utils.GuiUtil;
import com.jjwngamer.disenchant.utils.Utils;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class OnClickListener implements Listener {
    private Disenchant main;
    public OnClickListener(Disenchant main){
        this.main = main;
    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        ItemStack item = event.getCurrentItem();
        Player player = (Player) event.getWhoClicked();
        if (!event.getView().getTitle().equals("§eDisenchant")) return;
        if (item == null || item.getType() == Material.AIR) return;

        String enchantName = item.getItemMeta().getDisplayName().toLowerCase();

        enchantName = enchantName.replaceAll("§[a-f0-9]", "");

        NamespacedKey enchantmentKey = new NamespacedKey("minecraft", enchantName);
        Enchantment enchantment = Enchantment.getByKey(enchantmentKey);

        if (enchantment != null) {
            player.getItemInHand().removeEnchantment(enchantment);
            player.sendMessage(Utils.color(main.getConfig().getString("remove-enchant")));
            if(player.getItemInHand().getEnchantments().isEmpty()){
                player.closeInventory();
                return;
            }
            GuiUtil.Gui(player);

        } else {
            player.sendMessage(Utils.color(main.getConfig().getString("fail-remove")));
        }
    }
}
