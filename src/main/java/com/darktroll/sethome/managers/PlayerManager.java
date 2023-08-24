package com.darktroll.sethome.managers;

import com.darktroll.sethome.decorator.GamePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerManager {
    private static final PlayerManager instance = new PlayerManager();
    private HashMap<Player, GamePlayer> players = new HashMap<>();

    public static PlayerManager getInstance() {
        return instance;
    }

    public HashMap<Player, GamePlayer> getPlayers() {
        return players;
    }
}
