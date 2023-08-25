package com.darktroll.sethome.listeners;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.managers.PlayerManager;
import com.darktroll.sethome.ui.HomeListUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryOpenListener implements Listener {

    private final PlayerManager playerManager = PlayerManager.getInstance();

    @EventHandler
    public void onInventoryOpen(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        HomeListUI ui = playerManager.getPlayer(player).getHomeListUI();
        if(!(compareInventories(event.getInventory(), ui.getInventory()))) return;
        if (event.getCurrentItem() == null) {
            event.setCancelled(true);
            return;
        }
        HomeUnit home = playerManager.getPlayer(player).getHomeByName(event.getCurrentItem().getItemMeta().getDisplayName());
        if (home == null) {
            event.setCancelled(true);
            return;
        }
        if (event.getClick().isLeftClick()) player.teleport(home.getLocation());
        if (event.getClick().isRightClick()) {

        }
        if (!(event.getClick().isRightClick() && event.getClick().isLeftClick())) event.setCancelled(true);
        event.setCancelled(true);

    }

    public boolean compareInventories(Inventory inv1, Inventory inv2) {
        if (inv1.getSize() != inv2.getSize()) {
            return false;
        }
        for (int i = 0; i < inv1.getSize(); i++) {
            ItemStack item1 = inv1.getItem(i);
            ItemStack item2 = inv2.getItem(i);
            if (item1 == null && item2 == null) {
                continue;
            }
            if (item1 == null || item2 == null) {
                return false;
            }
            if (!item1.equals(item2)) {
                return false;
            }
        }
        return true;
    }
}
