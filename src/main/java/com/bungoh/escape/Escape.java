package com.bungoh.escape;

import com.bungoh.escape.commands.AdminCommandManager;
import com.bungoh.escape.commands.BaseCommandManager;
import com.bungoh.escape.files.ConfigFile;
import com.bungoh.escape.files.DataFile;
import org.bukkit.plugin.java.JavaPlugin;

public final class Escape extends JavaPlugin {

    private static Escape plugin;

    @Override
    public void onEnable() {
        //Init Global Plugin Reference
        Escape.plugin = this;

        //Create File Managers
        new ConfigFile(this);
        new DataFile(this);

        //Register Commands
        getCommand("escape").setExecutor(new BaseCommandManager());
        getCommand("escapeadmin").setExecutor(new AdminCommandManager());
    }

    public static Escape getPlugin() {
        return plugin;
    }
}
