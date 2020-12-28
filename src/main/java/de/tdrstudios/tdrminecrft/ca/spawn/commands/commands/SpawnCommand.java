package de.tdrstudios.tdrminecrft.ca.spawn.commands.commands;

import de.tdrstudios.tdrminecrft.ca.spawn.Chat;
import de.tdrstudios.tdrminecrft.ca.spawn.Prefix;
import de.tdrstudios.tdrminecrft.ca.spawn.commands.MyCommand;
import de.tdrstudios.tdrminecrft.ca.spawn.config.ConfigUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import java.util.List;

public class SpawnCommand extends MyCommand {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            Chat.send(p, "Befehl funktioniert!");
        }else {
            sender.sendMessage(Prefix.toPrefix() + ConfigUtils.getString("tdrstudios.msg.only.player"));
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {

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
