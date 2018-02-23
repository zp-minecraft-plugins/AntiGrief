package us.GreenZack.AntiGrief;

//import java.io.File;
import java.io.IOException;
//import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
//import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiGrief extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
//	private FileConfiguration eggConfig;
//	private File eggConfigFile;
	
	
	public void onDisable() {
		this.logger.info("AntiGrief 3.2 is now disabled.");
	}
	public void onEnable() {
		
		createDefaultConfig();
		initializeListeners();
		
		this.logger.info("AntiGrief Version 3.2 is enabled.");
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
		    // Failed to submit the stats :-(
		}
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
	    if(label.equalsIgnoreCase("ag")){
	        if(sender instanceof Player){
	        	if(sender.hasPermission("antigrief.reload")){
	        		this.reloadConfig();
	        		return false;
	        	}
	    	    sender.sendMessage(ChatColor.RED + "Sorry... You don't have permission to do this");
	    	    return true;
			}
	    }
	    sender.sendMessage(ChatColor.RED + "The command is /ag reload");
		return true;
	}
	
/*	public void reloadFeastConfig() {
		if (this.eggConfigFile == null) {
			this.eggConfigFile = new File(getDataFolder(), "eggConfig.yml");
		}
		this.eggConfig = YamlConfiguration.loadConfiguration(this.eggConfigFile);
		
		InputStream defConfigStream = getResource("egg.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			this.eggConfig.setDefaults(defConfig);
		}
	}
	public void saveDefaultFeastConfig() {
		if (!this.eggConfigFile.exists()) {
			saveResource("eggConfig.yml", false);
		}
	}
	
	public FileConfiguration getFeast() {
		if (this.eggConfig == null) {
			reloadFeastConfig();
		}
		return this.eggConfig;
	}*/
	public void createDefaultConfig(){
		
		final FileConfiguration config = this.getConfig();
		config.options().header("Sets what is blocked ingame");
        config.addDefault("AntiGrief.LavaBlocking", true);
        config.addDefault("AntiGrief.WaterBlocking", true);
        config.addDefault("AntiGrief.PlaceBlocking.tnt", true);
        config.addDefault("AntiGrief.PlaceBlocking.bedrock", true);
        config.addDefault("AntiGrief.PlaceBlocking.mob_spawner", true);
        config.addDefault("AntiGrief.PlaceBlocking.ender_portal_frame", true);
        config.addDefault("AntiGrief.PlaceBlocking.ender_portal", true);
        config.addDefault("AntiGrief.PlaceBlocking.ice", true);
        config.addDefault("AntiGrief.DestroyBlocking.tnt", true);
        config.addDefault("AntiGrief.DestroyBlocking.mob_spawner", true);
        config.addDefault("AntiGrief.IgniteBlocking", true);
        config.addDefault("AntiGrief.Build", false);
        config.addDefault("AntiGrief.Item.FireChargeBlocking", true);
        //Egg Blocking Config From Here Down
        config.addDefault("AntiGrief.EggBlocking", true);
        config.addDefault("AntiGrief.Eggs.CreeperEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.OcelotEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SkeletonEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SpiderEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.GiantEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.ZombieEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SlimeEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.GhastEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.ZombieEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.ZombiePigmanEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.EnderManEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.CaveSpiderEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SilverFishEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.BlazeEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.MagmaCubeEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.EnderDragonEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.PigEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SheepEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.CowEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.ChickenSpawnEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.NormalChickenEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SquidEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.WolfEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.MooshroomEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.SnowGolemEggBlocking", true);
        config.addDefault("AntiGrief.Eggs.VillagerEggBlocking", true);
        config.addDefault("AntiGrief.XPBottleBlocking", true);
        //Dispenser Blocking
        config.addDefault("AntiGrief.Dispenser.MonsterEggsDispenseBlocking", true);
        config.addDefault("AntiGrief.Dispenser.XPBottleDispenseBlocking", true);
        config.addDefault("AntiGrief.Dispenser.FireChargeDispenseBlocking", true);
        config.addDefault("AntiGrief.Dispenser.WaterDispenseBlocking", true);
        config.addDefault("AntiGrief.Dispenser.LavaDispenseBlocking", true);
        config.addDefault("AntiGrief.Explosion.TntExplosionBlocking", true);
        config.addDefault("AntiGrief.Explosion.CreeperExplosionBlocking", true);
        String[] firechargeignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Dispenser.IgnoredWorlds.FireCharge", Arrays.asList(firechargeignoredworlds));
        String[] monstereggignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Dispenser.IgnoredWorlds.MonsterEgg", Arrays.asList(monstereggignoredworlds));
        String[] xpbottleignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Dispenser.IgnoredWorlds.XPBottle", Arrays.asList(xpbottleignoredworlds));
        String[] lavaignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Dispenser.IgnoredWorlds.Lava", Arrays.asList(lavaignoredworlds));
        String[] waterignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Dispenser.IgnoredWorlds.Water", Arrays.asList(waterignoredworlds));
        String[] tntignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Explosion.IgnoredWorlds.TntExplosionBlocking", Arrays.asList(tntignoredworlds));
        String[] creeperignoredworlds = {"world1", "world2", "world3"};
        config.addDefault("AntiGrief.Explosion.IgnoredWorlds.CreeperExplosionBlocking", Arrays.asList(creeperignoredworlds));
        config.addDefault("AntiGrief.Auto-Updater-Enabled", true);
        config.options().copyDefaults(true);
        saveConfig();
		
	}
	
	public void initializeListeners(){
		
		new MyPlayerListener(this);
		new MyPlaceListener(this);
		new MyDestroyListener(this);
		new MyIgniteListener(this);
		new MyXPBottleListener(this);
		new MyMonsterEggListener(this);
		new MyDispenserListener(this);
		new MyExplosionListener(this);
		new MyPlayerJoinListener(this);
		
	}
}