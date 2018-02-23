package us.GreenZack.AntiGrief;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyPlayerJoinListener implements Listener {
	
	public static AntiGrief plugin;
	
	public MyPlayerJoinListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerJoin(PlayerJoinEvent event){
		
        Player p = (Player) event.getPlayer();
        
        if(p.isOp() || p.hasPermission("antigrief.alert.update")){
        	
	        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new UpdaterTask(p, plugin), 20);
        }
	}
}