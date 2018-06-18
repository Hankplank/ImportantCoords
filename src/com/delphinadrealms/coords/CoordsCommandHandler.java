package com.delphinadrealms.coords;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class CoordsCommandHandler implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        StringBuilder messageToPrint = new StringBuilder();
        SQLManager sql = new SQLManager();
        ArrayList<CoordsObject> coords = sql.getCoordList();
        for (CoordsObject x: coords) {
            messageToPrint.append(x.getName() + " " + ChatColor.RED + x.getX() + " " + ChatColor.GREEN + x.getY()+ " " + ChatColor.BLUE + x.getZ() +"\n");
        }
        sender.sendMessage(messageToPrint.toString());
        return true;
    }
}
