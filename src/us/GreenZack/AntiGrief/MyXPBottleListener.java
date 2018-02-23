package us.GreenZack.AntiGrief;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MyXPBottleListener implements Listener{
	public static AntiGrief plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public MyXPBottleListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler
	public void onBottleThrow(PlayerInteractEvent event){
		Player player = event.getPlayer();
		
		if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)){
			return;
		}
		if(plugin.getConfig().getBoolean("AntiGrief.XPBottleBlocking")){
			if(!player.hasPermission("antigrief.bypass.xpbottle")){
				if (player.getItemInHand().getTypeId() == 384){
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use an XP bottle");
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "" + ("You don't have permission to use an XP Bottle yet. Please contact a Moderator or Admin. ") + player.getDisplayName());
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
						if(p.hasPermission("antigrief.alert.xpbottle")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use an XP bottle without the antigrief.build permission node");
						}
					}
				}
			}
		}
		if(plugin.getConfig().getBoolean("AntiGrief.XPBottleBlocking")){
			if(!player.hasPermission("antigrief.bypass.xpbottle")){
				if (player.getItemInHand().getTypeId() == 384){
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use an XP bottle");
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "" + ("Sorry i cannot let you use an XP Bottle ") + player.getDisplayName());
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
						if(p.hasPermission("antigrief.alert.xpbottle")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a XP bottle");
						}
					}
				}
			}
		}
	}
}