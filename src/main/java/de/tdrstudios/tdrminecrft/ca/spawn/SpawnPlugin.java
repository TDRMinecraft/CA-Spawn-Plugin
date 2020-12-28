package de.tdrstudios.tdrminecrft.ca.spawn;

import de.tdrstudios.tdrminecrft.ca.spawn.commands.commands.SetSpawnCommand;
import de.tdrstudios.tdrminecrft.ca.spawn.commands.commands.SpawnCommand;
import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class SpawnPlugin extends JavaPlugin {

    private static JavaPlugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        setPlugin(this);
        ConfigUtils.registerAllConfigurations();
        Prefix.register();
        Prefix.load();

        new SpawnCommand(getCommand("spawn"), new Permission("tdrstudios.SpawnPlugin.spawn")).register();
        new SetSpawnCommand(getCommand("setspawn") , new Permission("tdrstudios.SpawnPlugin.setspawn")).register();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    protected static void setPlugin(JavaPlugin Pplugin) {
        plugin = Pplugin;
    }
}
