package com.delphinadrealms.coords.commands;

import com.delphinadrealms.coords.objects.SQLManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DelCoords implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length <1) {
            sender.sendMessage("Must include a name ");
            return false;
        } else {
            SQLManager sql = new SQLManager();
            sql.removeCoords(args[0]);
            sender.sendMessage(ChatColor.RED + "It has been removed.");
        }
        return true;
    }
}
