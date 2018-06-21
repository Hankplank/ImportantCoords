package com.delphinadrealms.coords.commands;

import com.delphinadrealms.coords.objects.CoordsObject;
import com.delphinadrealms.coords.objects.SQLManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class Coords implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        StringBuilder messageToPrint = new StringBuilder();
        SQLManager sql = new SQLManager();
        ArrayList<CoordsObject> coords = sql.getCoordList();
        int pageNumber;
        if (args.length > 0) {
            try {
                pageNumber = Integer.parseInt(args[0]);
                System.out.println(pageNumber);
            } catch (NumberFormatException e) {
                pageNumber = 1;
            }
        } else {
            pageNumber = 1;
        }
        if (pageNumber == 1) {
            messageToPrint.append(ChatColor.GOLD + "------ Page 1 ------\n");
            for (int i=0;i<8;i++) {
                messageToPrint.append(ChatColor.WHITE + coords.get(i).getName() + " " + ChatColor.RED + coords.get(i).getX() + " " + ChatColor.GREEN + coords.get(i).getY()+ " " + ChatColor.BLUE + coords.get(i).getZ() +"\n");
            }
            messageToPrint.append(ChatColor.GOLD + "------ End of Page 1 ------\n");
        } else {
            messageToPrint.append(String.format(ChatColor.GOLD + "------ Page %s ------\n", Integer.toString(pageNumber)));
            int starting = 0;
            switch (pageNumber) {
                case 2:
                    starting =8;
                    break;
                case 3:
                    starting = 16;
                    break;
                case 4:
                    starting = 24;
                    break;
                case 5:
                    starting = 32;
                    break;
                case 6:
                    starting = 40;
                    break;
                case 7:
                    starting = 48;
                    break;
                default:
                    starting = 0;
                    break;
            }

            for (int i=starting; i < starting+8; i++) {
                try {
                    messageToPrint.append(ChatColor.WHITE + coords.get(i).getName() + " " + ChatColor.RED + coords.get(i).getX() + " " + ChatColor.GREEN + coords.get(i).getY()+ " " + ChatColor.BLUE + coords.get(i).getZ() +"\n");
                } catch (IndexOutOfBoundsException e) {
                    break;
                }

            }
            messageToPrint.append(String.format(ChatColor.GOLD + "------ End of Page %s ------\n", Integer.toString(pageNumber)));
        }
        sender.sendMessage(messageToPrint.toString());
        return true;
    }
}
