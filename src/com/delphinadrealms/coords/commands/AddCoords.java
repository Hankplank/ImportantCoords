package com.delphinadrealms.coords.commands;

import com.delphinadrealms.coords.objects.SQLManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Scanner;

public class AddCoords implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            SQLManager sql = new SQLManager();
            Player player = (Player)sender;
            Location loc = player.getLocation();
            sql.addCoords(args[0], Math.floor(loc.getX()), Math.floor(loc.getY()), Math.floor(loc.getZ()));
            return true;
        }
        if (args.length < 4 || args.length > 4) {
            sender.sendMessage("Please include a name, x coord, y coord, and z coord");
            return false;
        } else {
            SQLManager sql = new SQLManager();
            double xCord = 0;
            double yCord =0;
            double zCord =0;
            for (int i=1;i < 4; i++) {
                Scanner scanner = new Scanner(args[i]);
                if (i==1)
                    xCord = scanner.nextDouble();
                if (i==2)
                    yCord = scanner.nextDouble();
                if (i==3)
                    zCord = scanner.nextDouble();
            }
            sql.addCoords(args[0], xCord, yCord, zCord);

        }
        return true;
    }
}
