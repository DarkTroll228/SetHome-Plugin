package com.darktroll.sethome.tab;

import com.darktroll.sethome.managers.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeTabCompleter implements TabCompleter {
    private final PlayerManager playerManager = PlayerManager.getInstance();


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)) return null;
        Player player = (Player) sender;
        if(args.length == 1) {
            ArrayList<String> homes = new ArrayList<>();

            playerManager.getPlayers().get(player).getHomeList()
                    .stream()
                    .forEach(h -> homes.add(h.getName()));
            return homes;
        }

        return null;
    }
}
