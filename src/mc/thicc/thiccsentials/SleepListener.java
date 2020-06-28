package mc.thicc.thiccsentials;

import java.util.Collection;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
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
		//Collection<? extends Player> players = ThiccPlugin.server.getOnlinePlayers();
		
		if(eventPlayer.getWorld().getTime() < 12542) {
			eventPlayer.sendMessage("Cannot sleep before night.");
			event.setCancelled(true);
			return;
		}
		
		if(event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
			event.setUseBed(Result.ALLOW);
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
		ThiccPlugin.server.broadcastMessage(eventPlayer.getDisplayName() + " is out of bed.");
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
