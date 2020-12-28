package de.tdrstudios.tdrminecrft.ca.spawn.commands.commands;

import de.tdrstudios.tdrminecrft.ca.spawn.commands.MyCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import java.util.List;

public class SpawnCommand extends MyCommand {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        return null;
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
