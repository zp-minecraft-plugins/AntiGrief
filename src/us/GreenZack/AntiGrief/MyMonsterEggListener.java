package us.GreenZack.AntiGrief;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MyMonsterEggListener implements Listener{
	public static AntiGrief plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public MyMonsterEggListener(AntiGrief instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)){
			return;
		}
		if(!plugin.getConfig().getBoolean("AntiGrief.EggBlocking", true)){
			return;
		}
		//Egg Blocking From Here Down
		//Creeper Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.NormalChickenEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.egg")){
				if(player.getItemInHand().getTypeId() == 344){
					logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a normal chicken egg");
					event.setCancelled(true);
					player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you use that chicken egg " + player.getDisplayName());
					for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
						if(p.hasPermission("antigrief.alert.egg")){
							p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a normal chicken egg");
							return;
						}
					}
				}					
			}
		}
		//Egg Blocking From Here Down
		//Creeper Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.CreeperEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.creeper")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 50) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a creeper egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a creeper " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.creeper")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a creeper egg");
								return;
							}
						}
					}					
				}
			}
		}
		//Ocelot Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.OcelotEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.ocelot")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 98) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use an ocelot egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn an ocelot " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.ocelot")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use an ocelot egg");
								return;
							}
						}
					}					
				}
			}
		}
		//Skeleton Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SkeletonEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.skeleton")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 51) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a skeleton egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a skelton " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.skeleton")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a skeleton egg");
								return;
							}
						}
					}
				}
			}
		}
		//Spider Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SpiderEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.spider")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 52) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a spider egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a spider " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.spider")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a spider egg");
								return;
							}
						}
					}
				}
			}
		}
		//Giant Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.GiantEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.giant")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 53) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a giant egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a giant " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.giant")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a giant egg");
								return;
							}
						}
					}
				}
			}
		}
		//Zombie Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.ZombieEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.zombie")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 54) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a zombie egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a zombie " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.zombie")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a zombie egg");
								return;
							}
						}
					}
				}
			}
		}
		//Slime Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SlimeEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.slime")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 55) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a slime egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a slime " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.slime")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a slime egg");
								return;
							}
						}
					}
				}
			}
		}
		//Ghast Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.GhastEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.ghast")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 56) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a ghast egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a ghast " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.ghast")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a ghast egg");
								return;
							}
						}
					}
				}
			}
		}
		//Zombie Pigman Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.ZombiePigmanEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.zombiepigman")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 57) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a zombie pigman egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a zombie pigman " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.zombiepigman")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a zombie pigman egg");
								return;
							}
						}
					}
				}
			}
		}
		//Enderman Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.EnderManEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.enderman")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 58) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a enderman egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn an enderman " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.enderman")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a enderman egg");
								return;
							}
						}
					}
				}
			}
		}
		//Cave Spider Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.CaveSpiderEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.cavespider")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 59) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a cave spider egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a cave spider " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.cavespider")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a cave spider egg");
								return;
							}
						}
					}
				}
			}
		}
		//Silverfish Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SilverFishEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.silverfish")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 60) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a silverfish egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a silverfish " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.silverfish")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a silverfish egg");
								return;
							}
						}
					}
				}
			}
		}
		//Blaze Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.BlazeEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.blaze")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 61) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a blaze egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a blaze " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.blaze")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a blaze egg");
								return;
							}
						}
					}
				}
			}
		}
		//Magma Cube Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.MagmaCubeEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.magmacube")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 62) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a magma cube egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a magma cube " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.magmacube")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a magma cube egg");
								return;
							}
						}
					}
				}
			}
		}
		//Enderdragon Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.EnderDragonEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.enderdragon")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 63) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use an enderdragon egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn an enderdragon " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.enderdragon")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use an enderdragon egg");
								return;
							}
						}
					}
				}
			}
		}
		//Pig Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.PigEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.pig")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 90) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a pig egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a pig " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.pig")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a pig egg");
								return;
							}
						}
					}
				}
			}
		}
		//Sheep Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SheepEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.sheep")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 91) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a sheep egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a sheep " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.sheep")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a sheep egg");
								return;
							}
						}
					}
				}
			}
		}
		//Cow Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.CowEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.cow")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 92) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a cow egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a cow " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.cow")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a cow egg");
								return;
							}
						}
					}
				}
			}
		}
		//Chicken Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.ChickenSpawnEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.chicken")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 93) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a chicken egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a chicken " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.chicken")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a chicken egg");
								return;
							}
						}
					}
				}
			}
		}
		//Squid Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SquidEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.squid")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 94) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a squid egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a squid " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.squid")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a squid egg");
								return;
							}
						}
					}
				}
			}
		}
		//Wolf Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.WolfEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.wolf")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 95) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a wolf egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a wolf " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.wolf")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a spawn egg");
								return;
							}
						}
					}
				}
			}
		}
		//Mooshroom Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.MooshroomEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.mooshroom")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 96) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a mooshroom egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a mooshroom " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.mooshroom")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a mooshroom egg");
								return;
							}
						}
					}
				}
			}
		}
		//Snow Golem Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.SnowGolemEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.snowgolem")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 97) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a snow golem egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a snow golem " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.snowgolem")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a snow golem egg");
								return;
							}
						}
					}
				}
			}
		}
		//Villager Egg Blocking
		if (plugin.getConfig().getBoolean("AntiGrief.Eggs.VillagerEggBlocking")){
			if(!player.hasPermission("antigrief.bypass.spawnegg.villager")){
				if(player.getItemInHand().getTypeId() == 383){
					if (event.getItem().getDurability() == 120) {
						logger.info("[AntiGrief] " + player.getDisplayName() + " tried to use a villager egg");
						event.setCancelled(true);
						player.sendMessage(ChatColor.YELLOW + "I'm afraid I can't let you spawn a villager " + player.getDisplayName());
						for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
							if(p.hasPermission("antigrief.alert.spawnegg.villager")){
								p.sendMessage(ChatColor.RED+ "[AntiGrief] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to use a villager egg");
								return;
							}
						}
					}
				}
			}
		}
	}
}