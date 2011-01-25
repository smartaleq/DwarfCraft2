package com.smartaleq.bukkit.dwarfcraft;

import java.io.*;
import java.util.*;
import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

public class DwarfCraft extends JavaPlugin {

/**
 * A Block listener.
 */
private final DCBlockListener blockListener = new DCBlockListener(this);
private final DCPlayerListener playerListener = new DCPlayerListener(this);
private final DCEntityListener entityListener = new DCEntityListener(this);
/**
 * Something related to debugging
 */
private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();

/**
 * Constructor; not all that much should be done here
 */
public DwarfCraft(PluginLoader pluginLoader, Server instance, PluginDescriptionFile desc, File folder, File plugin, ClassLoader cLoader) {
    super(pluginLoader, instance, desc, folder, plugin, cLoader);
}


/**
 * Called upon enabling the plugin
 */
@Override
public void onEnable() {
    // TODO: Place any custom enable code here including the registration of any events

    // Register our events
    PluginManager pm = getServer().getPluginManager();
	pm.registerEvent(Event.Type.BLOCK_DAMAGED, blockListener, Priority.High, this);
	pm.registerEvent(Event.Type.PLAYER_COMMAND, playerListener, Priority.Normal, this);
	pm.registerEvent(Event.Type.PLAYER_JOIN, playerListener, Priority.Normal, this);
	pm.registerEvent(Event.Type.ENTITY_DAMAGEDBY_ENTITY, entityListener, Priority.Low, this);

	SkillLevels.readPlayers();
	ZoneLogger.readZones(true);
	
    PluginDescriptionFile pdfFile = this.getDescription();


    System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
}

/*
 * Called upon disabling the plugin.
 */
public void onDisable() {
	SkillLevels.saveSkills();

}
public boolean isDebugging(final Player player) {
    if (debugees.containsKey(player)) {
        return debugees.get(player);
    } else {
        return false;
    }
}

public void setDebugging(final Player player, final boolean value) {
    debugees.put(player, value);
}
}
