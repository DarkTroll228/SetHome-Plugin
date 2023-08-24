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

    // Инвентарь должен создаваться сразу при подключении игрока и сохраняться у игрока,
    // а далее при необходимости добавления нового предмета, он будет обновляться

    public HomeListUI(GamePlayer player) {
        this.inventory = Bukkit.createInventory(this, 27, ChatColor.AQUA + "Homes");
        this.homeList = player.getHomeList();
//        init();
        player.setHomeListUI(this);
    }

//    private void init() {
//        if (homeList == null) return;
//        for (HomeUnit home:
//             homeList) {
//            ItemStack item = new ItemStack(home.getIcon(), 1);
//            ItemMeta itemMeta = item.getItemMeta();
//            itemMeta.setDisplayName(home.getName());
//            item.setItemMeta(itemMeta);
//
//            inventory.addItem(item);
//        }
//    }

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
