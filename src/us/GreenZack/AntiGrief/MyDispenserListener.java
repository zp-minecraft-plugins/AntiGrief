package us.GreenZack.AntiGrief;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class MyDispenserListener implements Listener {
	public static AntiGrief plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	public MyDispenserListener(AntiGrief instance) {
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this, instance);
	}
	@EventHandler
	public void onBlockDispense(BlockDispenseEvent event){
		//Strings for ignored worlds
		List<String> firechargeignoredworlds = plugin.getConfig().getStringList("AntiGrief.Dispenser.IgnoredWorlds.FireCharge");
		List<String> xpbottleignoredworlds = plugin.getConfig().getStringList("AntiGrief.Dispenser.IgnoredWorlds.XPBottle");
		List<String> monstereggignoredworlds = plugin.getConfig().getStringList("AntiGrief.Dispenser.IgnoredWorlds.MonsterEgg");
		List<String> lavaignoredworlds = plugin.getConfig().getStringList("AntiGrief.Dispenser.IgnoredWorlds.Lava");
		List<String> waterignoredworlds = plugin.getConfig().getStringList("AntiGrief.Dispenser.IgnoredWorlds.Water");
		
		//Monster egg blocking
		if(event.getItem().getTypeId() == 383){
			for (String worldname : monstereggignoredworlds){
				if(event.getBlock().getWorld().getName().equals(worldname))return;
			}
			if(plugin.getConfig().getBoolean("AntiGrief.Dispenser.MonsterEggsDispenseBlocking")){
				event.setCancelled(true);
				logger.info("[AntiGrief] A player tried to dispense a monster egg.");
			}
		}
		//Fire charge blocking
		if(event.getItem().getTypeId() == 385){
			for (String worldname : firechargeignoredworlds){
				if(event.getBlock().getWorld().getName().equals(worldname))return;
			}
			if(plugin.getConfig().getBoolean("AntiGrief.Dispenser.FireChargeDispenseBlocking")){
				event.setCancelled(true);
				logger.info("[AntiGrief] A player tried to dispense a fire charge.");
			}
		}
		//XP bottle blocking
		if(event.getItem().getTypeId() == 384){
			for (String worldname : xpbottleignoredworlds){
				if(event.getBlock().getWorld().getName().equals(worldname))return;
			}
			if(plugin.getConfig().getBoolean("AntiGrief.Dispenser.XPBottleDispenseBlocking")){
				event.setCancelled(true);
				logger.info("[AntiGrief] A player tried to dispense a xp bottle.");
			}
		}
		if(event.getItem().getType().equals(Material.WATER_BUCKET)){
			for (String worldname : waterignoredworlds){
				if(event.getBlock().getWorld().getName().equals(worldname))return;
			}
			if(plugin.getConfig().getBoolean("AntiGrief.Dispenser.WaterDispenseBlocking")){
				event.setCancelled(true);
				logger.info("[AntiGrief] A player tried to dispense a some water.");
			}
		}
		if(event.getItem().getType().equals(Material.LAVA_BUCKET)){
			for (String worldname : lavaignoredworlds){
				if(event.getBlock().getWorld().getName().equals(worldname))return;
			}
			if(plugin.getConfig().getBoolean("AntiGrief.Dispenser.LavaDispenseBlocking")){
				event.setCancelled(true);
				logger.info("[AntiGrief] A player tried to dispense some lava.");
			}
		}
	}
}