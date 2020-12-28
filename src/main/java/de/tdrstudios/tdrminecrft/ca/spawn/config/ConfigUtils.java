package de.tdrstudios.tdrminecrft.ca.spawn.config;

import de.tdrstudios.tdrminecrft.ca.spawn.SpawnPlugin;

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

        registerConfiguration("tdrstudios.spawn.X");
        registerConfiguration("tdrstudios.spawn.Y");
        registerConfiguration("tdrstudios.spawn.Z");

        registerConfiguration("tdrstudios.msg.only.player" , "Diese Aktion kann nur ein Spieler ausfueren!");


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