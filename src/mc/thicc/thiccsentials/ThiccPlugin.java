package mc.thicc.thiccsentials;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public class ThiccPlugin extends JavaPlugin {

	public static Logger logger;
	public static Server server;
	
	@Override
	public void onEnable() {
		server = getServer();
		logger = getLogger();
		logger.log(Level.INFO, "Started THICCsentials.");
		
		registerEvents();
	}
	
	@Override
	public void onDisable() {
		logger.log(Level.INFO, "Stopped THICCsentials.");
		logger = null;
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new SleepListener(this), this);
		getServer().getPluginManager().registerEvents(new MobGriefListener(this), this);
	}
	
}
