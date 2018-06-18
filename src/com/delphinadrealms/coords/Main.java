package com.delphinadrealms.coords;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        SQLManager sql = new SQLManager();
        sql.setup();
        this.getCommand("coords").setExecutor(new CoordsCommandHandler());
        this.getCommand("addcoords").setExecutor(new addCoordsHandler());
        instance = this;
    }

    @Override
    public void onDisable() {
    }



}
