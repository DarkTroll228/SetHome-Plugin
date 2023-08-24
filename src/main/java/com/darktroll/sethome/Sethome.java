package com.darktroll.sethome;

import com.darktroll.sethome.cmd.HomeListCommand;
import com.darktroll.sethome.cmd.HomeTeleportCommand;
import com.darktroll.sethome.cmd.SetHomeCommand;
import com.darktroll.sethome.listeners.InventoryOpenListener;
import com.darktroll.sethome.listeners.PlayerJoinLeaveEvent;
import com.darktroll.sethome.listeners.ServerReloadListener;
import com.darktroll.sethome.tab.HomeTabCompleter;
import com.darktroll.sethome.ui.HomeListUI;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sethome extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryOpenListener(), this);
        getServer().getPluginManager().registerEvents(new ServerReloadListener(), this);

        getCommand("sethome").setExecutor(new SetHomeCommand());
        getCommand("home").setExecutor(new HomeTeleportCommand());
        getCommand("home").setTabCompleter(new HomeTabCompleter());
        getCommand("homes").setExecutor(new HomeListCommand());
    }

    @Override
    public void onDisable() {

    }
}
