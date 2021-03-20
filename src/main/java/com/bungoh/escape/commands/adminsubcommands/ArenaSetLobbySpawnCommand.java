package com.bungoh.escape.commands.adminsubcommands;

import com.bungoh.escape.commands.SubCommand;
import com.bungoh.escape.files.DataFile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ArenaSetLobbySpawnCommand extends SubCommand {

    @Override
    public String getName() {
        return "setlobby";
    }

    @Override
    public String getDescription() {
        return "Set the lobby location for the Arena";
    }

    @Override
    public String getSyntax() {
        return "/escapeadmin setlobby [arena name]";
    }

    @Override
    public void perform(Player player, String[] args) {

        if (args.length == 2) {
            String arenaName = args[1];

            switch (DataFile.setArenaLobbySpawn(arenaName, player.getLocation())) {
                case 0:
                    player.sendMessage(ChatColor.RED + "That arena does not exist!");
                    break;
                case 1:
                    player.sendMessage(ChatColor.RED + "You can't do that. The arena is currently in the ready state.");
                    break;
                case 2:
                    player.sendMessage(ChatColor.GREEN + "The arena lobby location was successfully set!");
                    break;
                default:
                    player.sendMessage(ChatColor.RED + "An unexpected error occurred when adding a spawn location.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Invalid usage! Use " + getSyntax());
        }

    }

}
