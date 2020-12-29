package de.tdrstudios.tdrminecrft.ca.spawn.commands.commands;

import de.tdrstudios.tdrminecrft.ca.spawn.Chat;
import de.tdrstudios.tdrminecrft.ca.spawn.Prefix;
import de.tdrstudios.tdrminecrft.ca.spawn.commands.MyCommand;
import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
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
            FileConfiguration c = ConfigUtils.getConfig();
            if(args.length == 0) {
                if(p.hasPermission(getPermission())) {


                    Location spawn = new Location(Bukkit.getWorld(ConfigUtils.getString("tdrstudios.spawn.world")) , c.getDouble("tdrstudios.spawn.X") , c.getDouble("tdrstudios.spawn.Y") ,c.getDouble("tdrstudios.spawn.Z"));
                    spawn.setX(c.getDouble("tdrstudios.spawn.X"));
                    spawn.setY(c.getDouble("tdrstudios.spawn.Y"));
                    spawn.setZ(c.getDouble("tdrstudios.spawn.Z"));
                    p.teleport(spawn);
                    p.playSound(spawn, Sound.AMBIENT_UNDERWATER_ENTER , 30, 3);
                    Chat.send(p, ConfigUtils.getString("tdrstudios.msg.teleport.spawn"));
                }else {
                    Chat.NoPerm(p);
                }
            }else if(args.length == 1) {
                if(p.hasPermission(getPermission().getName() + ".other")) {
                    Location spawn = new Location(Bukkit.getWorld(ConfigUtils.getString("tdrstudios.spawn.world")) , c.getDouble("tdrstudios.spawn.X") , c.getDouble("tdrstudios.spawn.Y") ,c.getDouble("tdrstudios.spawn.Z"));
                    spawn.setX(c.getDouble("tdrstudios.spawn.X"));
                    spawn.setY(c.getDouble("tdrstudios.spawn.Y"));
                    spawn.setZ(c.getDouble("tdrstudios.spawn.Z"));
                    if(Bukkit.getOfflinePlayer(args[0]).isOnline()){
                        Player t = Bukkit.getPlayer(args[0]);
                        Chat.send(t, ConfigUtils.getString("tdrstudios.msg.other.tpd").replace("%Player%" , p.getName()));
                        Chat.send(p, ConfigUtils.getString("tdrstudios.msg.other.tp").replace("%Player%" , t.getName()));
                        t.teleport(spawn);
                    }else {
                    Chat.send(p, ConfigUtils.getString("tdrstudios.msg.notonline").replace("%Player%" , args[0]));
                    }
                }else {
                    Chat.NoPerm(p);
                }
            }else {
                return false;
            }

        }else {
            sender.sendMessage(Prefix.toPrefix() + ConfigUtils.getString("tdrstudios.msg.only.player"));
        }
        return true;
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
