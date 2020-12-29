package de.tdrstudios.tdrminecraft.ca.spawn;

import de.tdrstudios.tdrminecraft.ca.spawn.config.ConfigUtils;
import org.bukkit.ChatColor;

public class Prefix {

    private static ChatColor Color;
    private static ChatColor ErrorColor;

    public static void load() {
        Color = ChatColor.valueOf(ConfigUtils.getString("tdrstudios.color.info"));
        ErrorColor = ChatColor.valueOf(ConfigUtils.getString("tdrstudios.color.error"));
        prefix = ConfigUtils.getString("tdrstudios.prefix");
    }


    private static String prefix;



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
        System.out.println("Prefix.register");
        ConfigUtils.registerConfiguration("tdrstudios.color.info" , ChatColor.GREEN.name());
        ConfigUtils.registerConfiguration("tdrstudios.color.error" , ChatColor.RED.name());
        ConfigUtils.registerConfiguration("tdrstudios.prefix" , "§1[§3Dein§6Server§1] §7: ");
    }



    public static String toPrefix() {
        return getPrefix();
    }

    @Override
    public String toString() {
        return getPrefix();
    }
}
