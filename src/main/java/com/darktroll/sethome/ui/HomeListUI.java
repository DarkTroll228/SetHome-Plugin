package com.darktroll.sethome.ui;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.decorator.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeListUI implements InventoryHolder {
    private final ArrayList<HomeUnit> homeList;
    private final Inventory inventory;

    public HomeListUI(GamePlayer player) {
        this.inventory = Bukkit.createInventory(this, 27, ChatColor.AQUA + "Homes");
        this.homeList = player.getHomeList();
        player.setHomeListUI(this);
    }

    public void update(HomeUnit home) {
        ItemStack item = new ItemStack(home.getIcon(), 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(home.getName());

        item.setItemMeta(meta);
        inventory.addItem(item);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return this.inventory;
    }

}
