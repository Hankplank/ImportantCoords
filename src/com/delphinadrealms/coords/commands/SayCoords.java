package com.delphinadrealms.coords.commands;

import com.delphinadrealms.coords.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SayCoords implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Location playersLocation = ((Player) sender).getLocation();
            for (Player player: Main.getInstance().getServer().getOnlinePlayers()) {
                player.sendMessage(((Player) sender).getDisplayName() + " has the coordinates of: " + ChatColor.RED + playersLocation.getX() + " " + ChatColor.GREEN + playersLocation.getY() + " " + ChatColor.BLUE + playersLocation.getZ());
            }
            return true;
        } else {
            sender.sendMessage("You need to be a player to use this command!");
            return false;
        }

    }
}
