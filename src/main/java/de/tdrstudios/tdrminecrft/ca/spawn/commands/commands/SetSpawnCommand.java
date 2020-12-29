package de.tdrstudios.tdrminecrft.ca.spawn.commands.commands;

import de.tdrstudios.tdrminecrft.ca.spawn.Chat;
import de.tdrstudios.tdrminecrft.ca.spawn.commands.MyCommand;
import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import sun.security.provider.ConfigFile;

import java.util.List;
import java.util.Locale;

public class SetSpawnCommand extends MyCommand {


    /**
     * Instantiates a new My command.
     *
     * @param command    the command
     * @param permission the permission
     */
    public SetSpawnCommand(Command command, Permission permission) {
        super(command, permission);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            FileConfiguration c = ConfigUtils.getConfig();
            Player player = (Player) sender;
            if(player.hasPermission(getPermission())) {
                Location spawn = player.getLocation();
                player.playSound(spawn, Sound.AMBIENT_UNDERWATER_EXIT , 30, 4);
                c.set("tdrstudios.spawn.X" , spawn.getBlockX());
                c.set("tdrstudios.spawn.Y", spawn.getY()); // No Block because of Stairs usw
                c.set("tdrstudios.spawn.Z" , spawn.getBlockZ());
                c.set("tdrstudios.spawn.world" , spawn.getWorld().getName());
                ConfigUtils.saveConfig();
                Chat.send(player , ConfigUtils.getString("tdrstudios.msg.set.spawn"));
            }else {
                Chat.NoPerm(player);
            }
        }else {
            sender.sendMessage(ConfigUtils.getString("tdrstudios.msg.only.player"));
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        return null;
    }
}
