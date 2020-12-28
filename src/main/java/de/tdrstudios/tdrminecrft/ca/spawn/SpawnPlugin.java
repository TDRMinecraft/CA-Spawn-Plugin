package de.tdrstudios.tdrminecrft.ca.spawn;

import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    private static JavaPlugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        setPlugin(this);

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
