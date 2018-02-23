package us.GreenZack.AntiGrief;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MyPlayerListener implements Listener {
	public static AntiGrief plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public MyPlayerListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	} 
	@EventHandler(ignoreCancelled = true)
	public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event){
		Player player = event.getPlayer();
		//Antigrief.Build For Water Buckets
		if (plugin.getConfig().getBoolean("AntiGrief.Build")){
			if(!player.hasPermission("antigrief.build")){
				if (player.getItemInHand().getTypeId() == 326){
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "You don't have permission to wreak havock yet. Please contact a Moderator or Admin.");
					return;
				}
			}
		}
		//Antigrief.Build For Water Buckets
		if (plugin.getConfig().getBoolean("AntiGrief.Build")){
			if(!player.hasPermission("antigrief.build")){
				if (player.getItemInHand().getTypeId() == 327){
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "You don't have permission to wreak havock yet. Please contact a Moderator or Admin.");
					return;
				}
			}
		}
		if (plugin.getConfig().getBoolean("AntiGrief.LavaBlocking")){
			if(!player.hasPermission("antigrief.bypass.bucket.lava")){
				if (player.getItemInHand().getTypeId() == 327) {
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to place " + "lava");
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you do that " + player.getDisplayName());
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
						if(p.hasPermission("antigrief.alert.bucket.lava")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to place lava");
							return;
						}
					}
				}
			}
		}
		if (plugin.getConfig().getBoolean("AntiGrief.WaterBlocking")){
			if(!player.hasPermission("antigrief.bypass.bucket.water")){
				if (player.getItemInHand().getTypeId() == 326){
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to place " + "water");
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you do that " + player.getDisplayName());
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
						if(p.hasPermission("antigrief.alert.bucket.water")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to place water");
							return;
						}
					}
				}
			}
		}
	}
	@EventHandler(ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		//Fire Charge Blocking Section
		if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)){
			return;
		}
		if (plugin.getConfig().getBoolean("AntiGrief.Item.FireChargeBlocking")){
			if(!player.hasPermission("antigrief.bypass.firecharge")){
				if (player.getItemInHand().getTypeId() == 385){
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a fire charge");
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you do that " + player.getDisplayName());
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
						if(p.hasPermission("antigrief.alert.firecharge")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a fire charge");
							return;
						}
					}
				}
			}
		}
	}
}