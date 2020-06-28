package mc.thicc.thiccsentials;

import java.util.Collection;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class SleepListener implements Listener {
	
	public ThiccPlugin plugin;
	public SleepListener(ThiccPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		
		Player eventPlayer = event.getPlayer();
		
		// get all players
		Collection<? extends Player> players = ThiccPlugin.server.getOnlinePlayers();
		
		if(eventPlayer.getWorld().getTime() < 12542) {
			eventPlayer.sendMessage("Cannot sleep before night.");
			event.setCancelled(true);
			return;
		}
		
		// get percentage of players who are sleeping
		float percentPlayersSleeping = (1 + playersSleeping(players)) / players.size();
		float percent = (percentPlayersSleeping * 100);
		
		ThiccPlugin.server.broadcastMessage(eventPlayer.getDisplayName() + " is in bed~ ("+percent+"% sleeping)");
		
		// make sure 50% (configurable) is in bed
		if(percent < 50) {
			return;
		}
		
		ThiccPlugin.server.broadcastMessage("Time set to 0.");
		
		for(World w : ThiccPlugin.server.getWorlds()) {
			w.setTime(0);
		}
		
		// get all players out of bed?
		
	}
	
	@EventHandler
	public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
		Player eventPlayer = event.getPlayer();
		
		// get all players
		Collection<? extends Player> players = ThiccPlugin.server.getOnlinePlayers();
		
		// get percentage of players who are sleeping
		float percentPlayersSleeping = playersSleeping(players) / players.size();
		float percent = (percentPlayersSleeping * 100);
		
		ThiccPlugin.server.broadcastMessage(eventPlayer.getDisplayName() + " is out of bed. ("+percent+"% sleeping)");
	}
	
	
	
	public int playersSleeping(Collection<? extends Player> players) {
		int playersSleeping = 0;
		for (Player player : players) {
			if(player.isSleeping()) {
				playersSleeping++;
			}
		}
		return playersSleeping;
	}
	
}
