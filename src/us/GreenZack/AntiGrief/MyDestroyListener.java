package us.GreenZack.AntiGrief;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MyDestroyListener implements Listener {
	public static AntiGrief plugin;
	public static Material[] destroyedBlacklist = {Material.TNT, Material.MOB_SPAWNER, Material.COMMAND};
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public MyDestroyListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		if (plugin.getConfig().getBoolean("AntiGrief.Build")){
			if(!player.hasPermission("antigrief.build")){
				event.setCancelled(true);
				player.sendMessage(ChatColor.YELLOW + "You don't have permission to destroy yet. Please contact a Moderator or Admin.");
				return;
			}
		}
		for(Material b : destroyedBlacklist){
			if(plugin.getConfig().getBoolean("AntiGrief.DestroyBlocking." + b.toString().toLowerCase())){
				if(!player.hasPermission("antigrief.bypass.destroy." + b.toString().toLowerCase())){
					if(b == block){
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to place " + b.toString().toLowerCase());
						event.setCancelled(true);
						player.sendMessage(ChatColor.RED + "[AntiGrief] " + ChatColor.YELLOW + "I'm afraid you're not allowed to destroy " + b.toString().toLowerCase() + " " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.place." + b.toString().toLowerCase())){
								p.sendMessage(ChatColor.RED + "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to destroy " + b.toString().toLowerCase());
							}
						}
					}
				}
			}
		}
	}
}