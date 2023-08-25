package com.darktroll.sethome.listeners;

import com.darktroll.sethome.decorator.GamePlayer;
import com.darktroll.sethome.managers.PlayerManager;
import com.darktroll.sethome.ui.HomeListUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinLeaveEvent implements Listener {

    private final PlayerManager manager = PlayerManager.getInstance();

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        GamePlayer gamePlayer = new GamePlayer(player);
        HomeListUI ui = new HomeListUI(gamePlayer);

        manager.addPlayer(gamePlayer);
        manager.getPlayer(player).setHomeListUI(ui);
    }

    public void PlayerLeaveEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        manager.getPlayers().remove(player);
    }

}
