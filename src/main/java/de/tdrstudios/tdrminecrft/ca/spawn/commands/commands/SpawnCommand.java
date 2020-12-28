package de.tdrstudios.tdrminecrft.ca.spawn.commands.commands;

import de.tdrstudios.tdrminecrft.ca.spawn.Chat;
import de.tdrstudios.tdrminecrft.ca.spawn.Prefix;
import de.tdrstudios.tdrminecrft.ca.spawn.commands.MyCommand;
import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.List;

public class SpawnCommand extends MyCommand {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            Chat.send(p, "Test!");

            if(p.hasPermission(getPermission())) {
                FileConfiguration c = ConfigUtils.getConfig();
                Location spawn = new Location(Bukkit.getWorld(ConfigUtils.getString("tdrstudios.spawn.world")) , c.getDouble("tdrstudios.spawn.X") , c.getDouble("tdrstudios.spawn.Y") ,c.getDouble("tdrstudios.spawn.Z"));
                spawn.setX(c.getDouble("tdrstudios.spawn.X"));
                spawn.setY(c.getDouble("tdrstudios.spawn.Y"));
                spawn.setZ(c.getDouble("tdrstudios.spawn.Z"));
                p.teleport(spawn);
                Chat.send(p, ConfigUtils.getString("tdrstudios.msg.teleport.spawn"));
            }else {
                Chat.NoPerm(p);
            }
        }else {
            sender.sendMessage(Prefix.toPrefix() + ConfigUtils.getString("tdrstudios.msg.only.player"));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {

        if(args.length == 0) {
            addPlayersToTab();
        }else {
            if(args.length ==1) {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(player.getName().startsWith(args[0])) {
                        addTab(player.getName());
                    }
                }
            }
        }

        return extractTab();
    }

    /**
     * Instantiates a new SpawnCommand.
     *
     * @param command    the command
     * @param permission the permission
     */
    public SpawnCommand(Command command, Permission permission) {
        super(command, permission);
    }


}
