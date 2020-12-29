package de.tdrstudios.tdrminecraft.ca.spawn;

import de.tdrstudios.tdrminecraft.ca.spawn.commands.commands.SpawnCommand;
import de.tdrstudios.tdrminecraft.ca.spawn.config.ConfigUtils;
import de.tdrstudios.tdrminecraft.ca.spawn.commands.commands.SetSpawnCommand;

import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    private static JavaPlugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        setPlugin(this);
        ConfigUtils.registerAllConfigurations();
        Prefix.register();
        Prefix.load();

        System.out.println("[TDRStudios]: Dieses Plugin wurde von TDRStudios entwickelt!");
        System.out.println("Link: https://discord.gg/MPJ8w6ehNM");
        System.out.println("[TDRStudios]: Dieses Plugin wurde von TDRStudios entwickelt!");

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
