package de.tdrstudios.tdrminecraft.ca.spawn;

import de.tdrstudios.tdrminecraft.ca.spawn.config.ConfigUtils;
import org.bukkit.entity.Player;

public class Chat {

    public static void send(Player player, String message) {
        player.sendMessage(Prefix.getPrefix() + message);
    }

    public static void NoPerm(Player player) {
        player.sendMessage(Prefix.getPrefix()  + Prefix.getErrorColor() + ConfigUtils.getString("tdrstudios.msg.noperm"));
    }
}
