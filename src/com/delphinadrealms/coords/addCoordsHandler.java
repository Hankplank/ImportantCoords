package com.delphinadrealms.coords;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Scanner;

public class addCoordsHandler implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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
