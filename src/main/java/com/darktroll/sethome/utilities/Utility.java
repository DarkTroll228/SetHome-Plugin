package com.darktroll.sethome.utilities;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.managers.PlayerManager;
import org.bukkit.entity.Player;

public class Utility {

    public static boolean homeSearch(Player player, String name) {
        PlayerManager manager = PlayerManager.getInstance();
        for (HomeUnit unit : manager.getPlayers().get(player).getHomeList()) {
            if (unit.getName().equals(name)) return true;
        }
        return false;
    }

}
