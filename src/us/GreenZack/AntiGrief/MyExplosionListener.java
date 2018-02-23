package us.GreenZack.AntiGrief;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class MyExplosionListener implements Listener{
	public static AntiGrief plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public MyExplosionListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onEntityExplode(EntityExplodeEvent event) {
		if (event.isCancelled()) return;
       	Entity entity = event.getEntity();
		//Strings for ignored worlds
		List<String> tntignoredworlds = plugin.getConfig().getStringList("AntiGrief.Explosion.IgnoredWorlds.TntExplosionBlocking");
		List<String> creeperignoredworlds = plugin.getConfig().getStringList("AntiGrief.Explosion.IgnoredWorlds.CreeperExplosionBlocking");
        if (entity instanceof TNTPrimed){
			for (String worldname : tntignoredworlds){
				if(event.getEntity().getWorld().getName().equals(worldname))return;
				if (plugin.getConfig().getBoolean("AntiGrief.Explosion.TntExplosionBlocking")){
					event.setCancelled(true);
				}
			}
        }
       	if (entity instanceof Creeper){
			for (String worldname : creeperignoredworlds){
				if(event.getEntity().getWorld().getName().equals(worldname))return;
				if (plugin.getConfig().getBoolean("AntiGrief.Explosion.CreeperExplosionBlocking")){
					event.setCancelled(true);
				}
			}
       	}
	}
}