package com.darktroll.sethome.decorator;

import com.darktroll.sethome.HomeUnit;
import com.darktroll.sethome.ui.HomeListUI;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GamePlayer {
    private final Player player;
    private final ArrayList<HomeUnit> homeList = new ArrayList<>();
    private HomeListUI homeListUI;

    public GamePlayer(Player player) {
        this.player = player;
    }

    public ArrayList<HomeUnit> getHomeList() {
        return homeList;
    }

    public HomeUnit getHomeByName(String name) {
        for (HomeUnit home: homeList) {
            if(home.getName().equals(name)) return home;
        }
        return null;
    }

    public void setHomeListUI(HomeListUI homeListUI) {
        this.homeListUI = homeListUI;
    }

    public HomeListUI getHomeListUI() {
        return homeListUI;
    }

}
