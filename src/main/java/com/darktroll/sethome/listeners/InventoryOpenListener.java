package com.darktroll.sethome.listeners;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.managers.PlayerManager;
import com.darktroll.sethome.ui.HomeListUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static com.darktroll.sethome.utilities.Utility.compareInventories;

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
}
