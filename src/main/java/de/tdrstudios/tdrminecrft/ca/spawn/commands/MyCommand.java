package de.tdrstudios.tdrminecrft.ca.spawn.commands;

import de.tdrstudios.tdrminecrft.ca.spawn.SpawnPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;


import java.util.*;

/**
 * The type My command.
 */
public abstract class MyCommand implements CommandExecutor, TabCompleter {
    private Command command;
    private Permission permission;
    private List<String> tab = new ArrayList<>();

    @Override
    public abstract boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

    @Override
    public abstract List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args);

    private List<String> getTab() {
        return tab;
    }

    /**
     * Sets tab.
     *
     * @param tab the tab
     */
    public void setTab(List<String> tab) {
        this.tab = tab;
    }

    /**
     * Add tab.
     *
     * @param tab the tab
     */
    public void addTab(String tab) {
        getTab().add(tab);
    }

    /**
     * Remove tab.
     *
     * @param tab the tab
     */
    public void removeTab(String tab) {
        getTab().remove(tab);
    }

    /**
     * Clear tab.
     */
    public void clearTab() {
        getTab().clear();
    }

    /**
     * Add players to tab.
     */
    public void addPlayersToTab() {
        Collection<Player> players = (Collection<Player>) Bukkit.getOnlinePlayers();
        for(Player p : players) {
            addTab(p.getName());
        }
    }

    public List<String> extractTab() {
        List<String> extract = getTab();
        return extract;
    }

    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    /**
     * Sets command.
     *
     * @param command the command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * Gets permission.
     *
     * @return the permission
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Instantiates a new My command.
     *
     * @param command    the command
     * @param permission the permission
     */
    public MyCommand(Command command, Permission permission) {
        setCommand(command);
        setPermission(permission);
        clearTab();
    }

    /**
     * Register.
     */
    public void register() {
        SpawnPlugin.getPlugin().getCommand(command.getName()).setExecutor(this);
        SpawnPlugin.getPlugin().getCommand(command.getName()).setTabCompleter(this);
    }
}
