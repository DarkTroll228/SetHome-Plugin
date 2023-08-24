package com.darktroll.sethome.cmd;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.decorator.GamePlayer;
import com.darktroll.sethome.managers.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HomeTeleportCommand implements CommandExecutor {

    private PlayerManager manager = PlayerManager.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) sender.sendMessage("Only for players");
        if(args.length < 1) return false;
        Player player = (Player) sender;
        GamePlayer gamePlayer = manager.getPlayers().get(player);

        HomeUnit homeUnit = gamePlayer.getHomeByName(args[0]);
        player.teleport(homeUnit.getLocation());
        return true;
    }
}
