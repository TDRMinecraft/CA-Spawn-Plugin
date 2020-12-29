package de.tdrstudios.tdrminecrft.ca.spawn.config;

import de.tdrstudios.tdrminecrft.ca.spawn.SpawnPlugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class ConfigUtils {
    public static FileConfiguration getConfig() {
        return SpawnPlugin.getPlugin().getConfig();
    }
    public static void saveConfig() {
        SpawnPlugin.getPlugin().saveConfig();
    }
    public static void registerAllConfigurations() {

        registerConfiguration("tdrstudios.spawn.X", Bukkit.getWorld("world").getSpawnLocation().getBlockX());
        registerConfiguration("tdrstudios.spawn.Y", Bukkit.getWorld("world").getSpawnLocation().getBlockY());
        registerConfiguration("tdrstudios.spawn.Z", Bukkit.getWorld("world").getSpawnLocation().getBlockZ());
        registerConfiguration("tdrstudios.spawn.world", "world");

        registerConfiguration("tdrstudios.msg.only.player" , "Diese Aktion kann nur ein Spieler ausfueren!");
        registerConfiguration("tdrstudios.msg.setspawn" , "Der Spawnpunkt wurde erfolgreich gesetzt!");
        registerConfiguration("tdrstudios.msg.noperm" , "Keine Rechte!");
        registerConfiguration("tdrstudios.msg.teleport.spawn" , "Du wurdest zum Spawn teleportiert!");
        registerConfiguration("tdrstudios.msg.set.spawn" , "Der Spawn wurde gesetzt!");

        registerConfiguration("tdrstudios.msg.notonline" , "%Player% ist nicht Online!");
        registerConfiguration("tdrstudios.msg.other.tp" , "%Player% wurde zum Spawn geschickt!");
        registerConfiguration("tdrstudios.msg.other.tpd" , "%Player% hat dich zum Spawn geschickt!");


    }
    public static void registerConfiguration(String path) {
        //if(getConfig().isSet(path)) {
        if(getConfig().get(path) != null) {
        }else {
            getConfig().set(path , "");
        }
        saveConfig();
    }
    public static void registerConfiguration(String path , Object object) {
        System.out.println("ConfigUtils.registerConfiguration");
        System.out.println("path = " + path + ", object = " + object);
        // if(getConfig().isSet(path)) {
        if(getConfig().get(path) != null) {

        }else {

            getConfig().set(path , object);

        }
        saveConfig();
    }

    /**
     *
     * @param path
     * @return
     * @throws InvalidConfigurationException
     */
    public static String getString(String path) {
        System.out.println("ConfigUtils.getString");
        System.out.println("path = " + path);
        String r = getConfig().getString(path);
        try {
            if(r != null) {
                return r;
            }else {
                throw new InvalidConfigurationException("The String on path \"" + path + "\" isn´s set in the Configuration!");
            }
        }catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return r;
    }



    public static boolean getBoolean(String path) throws InvalidConfigurationException {
        Boolean r = getConfig().getBoolean(path);
        if(r != null) {
            return r;
        }else {
            throw new InvalidConfigurationException("The String on path \"" + path + "\" isn´s set in the Configuration!");
        }
    }



}