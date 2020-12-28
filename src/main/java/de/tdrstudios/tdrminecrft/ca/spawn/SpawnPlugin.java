package de.tdrstudios.tdrminecrft.ca.spawn;

import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    private static JavaPlugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        setPlugin(this);
        ConfigUtils.registerAllConfigurations();

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
