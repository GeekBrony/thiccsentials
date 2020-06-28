package mc.thicc.thiccsentials;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class MobGriefListener implements Listener {

	public ThiccPlugin plugin;
	public MobGriefListener(ThiccPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void onExplosionPrime(ExplosionPrimeEvent event) {
		Entity e = event.getEntity();
		
		if(e instanceof Creeper || e instanceof Explosive || e instanceof TNTPrimed) {
			event.setCancelled(true);
		}
	}

}
