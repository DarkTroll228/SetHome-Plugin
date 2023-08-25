package com.darktroll.sethome.utilities;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.managers.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Utility {

    public static boolean homeSearch(Player player, String name) {
        PlayerManager manager = PlayerManager.getInstance();
        for (HomeUnit unit : manager.getPlayers().get(player).getHomeList()) {
            if (unit.getName().equals(name)) return true;
        }
        return false;
    }

    public static boolean compareInventories(Inventory inv1, Inventory inv2) {
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
