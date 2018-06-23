package com.delphinadrealms.coords;

import com.delphinadrealms.coords.commands.Coords;
import com.delphinadrealms.coords.commands.AddCoords;
import com.delphinadrealms.coords.commands.DelCoords;
import com.delphinadrealms.coords.objects.SQLManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        SQLManager sql = new SQLManager();
        sql.setup();
        this.getCommand("coords").setExecutor(new Coords());
        this.getCommand("addcoords").setExecutor(new AddCoords());
        this.getCommand("delcoords").setExecutor(new DelCoords());
        instance = this;
    }

    @Override
    public void onDisable() {
    }

    public static Main getInstance() {
        return instance;
    }


}
