package com.darktroll.sethome.listeners;

import com.darktroll.sethome.Sethome;
import com.darktroll.sethome.decorator.GamePlayer;
import com.darktroll.sethome.managers.PlayerManager;
import com.darktroll.sethome.ui.HomeListUI;
import io.papermc.paper.event.server.ServerResourcesReloadedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class ServerReloadListener implements Listener {

    private final PlayerManager playerManager = PlayerManager.getInstance();

    @EventHandler
    public void onServerReload(ServerResourcesReloadedEvent event) {
        for (Player player: Bukkit.getOnlinePlayers()) {
            GamePlayer gamePlayer = new GamePlayer(player);
            HomeListUI ui = new HomeListUI(gamePlayer);
            player.sendMessage("nsasdsad");
            if(playerManager.getPlayers().get(gamePlayer) == null) continue;
            playerManager.getPlayers().put(player, gamePlayer);
            playerManager.getPlayers().get(player).setHomeListUI(ui);
        }
    }

}
