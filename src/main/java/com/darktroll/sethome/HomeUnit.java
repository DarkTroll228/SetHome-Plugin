package com.darktroll.sethome;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class HomeUnit {
    private Player player;
    private Location location;
    private String name;
    private Material icon;

    public HomeUnit(Player player, Location location, String name, Material icon) {
        this.player = player;
        this.location = location;
        this.name = name;
        this.icon = icon;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getIcon() {
        return icon;
    }

    public void setIcon(Material icon) {
        this.icon = icon;
    }
}
