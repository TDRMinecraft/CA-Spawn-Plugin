package de.tdrstudios.tdrminecrft.ca.spawn;

import org.bukkit.entity.Player;

public class Chat {

    public static void send(Player player, String message) {
        player.sendMessage(Prefix.getPrefix() + message);
    }
}
