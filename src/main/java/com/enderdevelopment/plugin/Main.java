package com.enderdevelopment.plugin;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExhaustionEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    private Enchantment lungeEnchantment;

    @Override
    public void onEnable() {
        lungeEnchantment = Registry.ENCHANTMENT.get(NamespacedKey.minecraft("lunge"));
        if (lungeEnchantment == null) {
            getLogger().severe("The Lunge enchantment is unavailable on this server version.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onExhaustion(EntityExhaustionEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (!isLungeSpear(player.getInventory().getItemInMainHand())
                && !isLungeSpear(player.getInventory().getItemInOffHand())) {
            return;
        }
        event.setCancelled(true);
    }

    private boolean isLungeSpear(ItemStack item) {
        if (item == null || item.getType() != Material.SPEAR) {
            return false;
        }
        return item.getItemMeta() != null && item.getItemMeta().hasEnchant(lungeEnchantment);
    }
}
