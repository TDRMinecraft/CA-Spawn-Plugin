package de.tdrstudios.tdrminecrft.ca.spawn;

import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;

public class Prefix {

    private static ChatColor Color;
    private static ChatColor ErrorColor;

    static {
        try {
            Color = ChatColor.valueOf(ConfigUtils.getString("tdrstudios.color"));
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    static {
        try {
            ErrorColor = ChatColor.valueOf(ConfigUtils.getString("tdrstudios.color.error"));
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    private static String prefix;

    static {
        try {
            prefix = ConfigUtils.getString("tdrstudios.prefix");
        }catch (InvalidConfigurationException e)  {
            e.printStackTrace();
        }
    }

    public static ChatColor getErrorColor() {
        return ErrorColor;
    }

    public static String getPrefix() {
        return prefix + Color;
    }
    public static String getPrefix_RAW() {
        return prefix;
    }

    public static ChatColor getColor() {
        return Color;
    }

    public static void setPrefix(String newPrefix) {
        prefix = newPrefix;
    }

    public static void setColor(ChatColor color) {
        Color = color;
    }

    public static void setErrorColor(ChatColor errorColor) {
        ErrorColor = errorColor;
    }

    public static void register() {
        ConfigUtils.registerConfiguration("tdrstudios.color" , ChatColor.GREEN.name());
        ConfigUtils.registerConfiguration("tdrstudios.color.error" , ChatColor.RED.name());
        ConfigUtils.registerConfiguration("tdrstudios.prefix" , "§1[§5Dein§9Server§1] §7: ");
    }



    public static String toPrefix() {
        return getPrefix();
    }

    @Override
    public String toString() {
        return getPrefix();
    }
}
