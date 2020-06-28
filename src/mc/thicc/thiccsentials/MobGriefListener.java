package mc.thicc.thiccsentials;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class MobGriefListener implements Listener {

	public ThiccPlugin plugin;
	public MobGriefListener(ThiccPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void onExplosionPrime(ExplosionPrimeEvent event) {
		event.setCancelled(true);
	}
	
	public void onExplosion(EntityExplodeEvent event) {
		event.setCancelled(true);
	}

}
