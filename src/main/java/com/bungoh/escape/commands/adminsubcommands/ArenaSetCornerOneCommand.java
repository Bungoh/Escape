package com.bungoh.escape.commands.adminsubcommands;

import com.bungoh.escape.commands.SubCommand;
import com.bungoh.escape.files.ConfigFile;
import com.bungoh.escape.files.DataFile;
import com.bungoh.escape.utils.Messages;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ArenaSetCornerOneCommand extends SubCommand {

    @Override
    public String getName() {
        return "setcorner1";
    }

    @Override
    public String getDescription() {
        return "Sets the first corner of the Arena's region";
    }

    @Override
    public String getSyntax() {
        return "/escapeadmin setcorner1 [arena name]";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length == 2) {
            String arenaName = args[1];
            Messages message = DataFile.setArenaCornerOne(arenaName, player.getLocation());

            switch (message) {
                case ARENA_DOES_NOT_EXIST:
                case ARENA_NOT_EDITABLE:
                case ARENA_CORNER_ONE_SET:
                    player.sendMessage(ConfigFile.getMessage(message.getPath()));
                    break;
                default:
                    player.sendMessage(ConfigFile.getMessage(Messages.UNEXPECTED_ERROR.getPath()));
            }
        } else {
            player.sendMessage(ChatColor.RED + "Invalid usage! Use " + getSyntax());
        }
    }
}
