package mc.thicc.thiccsentials;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.Entity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class MobGriefListener implements Listener {

	public ThiccPlugin plugin;
	public MobGriefListener(ThiccPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void onEntityExplode(EntityExplodeEvent event) {
		Entity e = event.getEntity();
		
		if(e instanceof Creeper || e instanceof Explosive) {
			event.setCancelled(true);
		}
	}

}
