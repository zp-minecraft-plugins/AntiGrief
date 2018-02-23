package us.GreenZack.AntiGrief;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyPlaceListener implements Listener {
	public static AntiGrief plugin;
	public static Material[] placedBlacklist = {Material.TNT, Material.COMMAND, Material.BEACON, Material.BEDROCK, Material.MOB_SPAWNER, Material.ENDER_PORTAL_FRAME, Material.ENDER_PORTAL, Material.ICE};
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public MyPlaceListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		if (plugin.getConfig().getBoolean("AntiGrief.Build")){
			if(!player.hasPermission("antigrief.build")){
				event.setCancelled(true);
				player.sendMessage(ChatColor.YELLOW + "You don't have permission to build yet. Please contact a Moderator or Admin.");
				return;
			}
		}
		for(Material b : placedBlacklist){
			if(plugin.getConfig().getBoolean("AntiGrief.PlaceBlocking." + b.toString().toLowerCase())){
				if(!player.hasPermission("antigrief.bypass.place." + b.toString().toLowerCase())){
					if(b == block){
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to place " + b.toString().toLowerCase());
						event.setCancelled(true);
						player.sendMessage(ChatColor.RED + "[AntiGrief] " + ChatColor.YELLOW + "I'm afraid you're not allowed to place " + b.toString().toLowerCase() + " " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.place." + b.toString().toLowerCase())){
								p.sendMessage(ChatColor.RED + "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to place " + b.toString().toLowerCase());
							}
						}
					}
				}
			}
		}
	}
}