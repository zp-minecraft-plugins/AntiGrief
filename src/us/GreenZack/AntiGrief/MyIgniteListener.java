package us.GreenZack.AntiGrief;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class MyIgniteListener implements Listener {
	public static AntiGrief plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public MyIgniteListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onBlockIgnite(BlockIgniteEvent event){
		Player player = event.getPlayer();
		if (event.getPlayer() instanceof Player) {
			if (plugin.getConfig().getBoolean("AntiGrief.Build")){
				if(!player.hasPermission("antigrief.build")){
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "You don't have permission to wreak havock yet. Please contact a Moderator or Admin.");
					return;
				}
			}
			if (plugin.getConfig().getBoolean("AntiGrief.IgniteBlocking")) {
				if(!player.hasPermission("antigrief.bypass.ignite")){
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a lighter.");
					event.setCancelled(true);
					player.sendMessage(ChatColor.RED + "[AntiGrief] " + ChatColor.YELLOW + "Sorry " + player.getDisplayName() + "I'm afraid you're not allowed to use a lighter here");
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){							
						if(p.hasPermission("antigrief.alert.ignite")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a lighter.");
						}
					}
				}
			}
		}
	}
}