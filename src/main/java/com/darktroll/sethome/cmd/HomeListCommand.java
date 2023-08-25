package com.darktroll.sethome.cmd;

import com.darktroll.sethome.decorator.GamePlayer;
import com.darktroll.sethome.managers.PlayerManager;
import com.darktroll.sethome.ui.HomeListUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeListCommand implements CommandExecutor {

    private final PlayerManager playerManager = PlayerManager.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) sender.sendMessage("Only for players");
        if(!(args.length < 1)) return false;
        Player player = (Player) sender;

        GamePlayer gamePlayer = playerManager.getPlayer(player);
//        GamePlayer gamePlayer = playerManager.getPlayers().get(player);
        HomeListUI ui = gamePlayer.getHomeListUI();
        player.openInventory(ui.getInventory());

        return true;
    }
}
