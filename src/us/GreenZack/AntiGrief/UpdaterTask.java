package us.GreenZack.AntiGrief;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class UpdaterTask implements Runnable {
	
	public static AntiGrief plugin;
	private Player p;
	public final Logger logger = Logger.getLogger("Minecraft");
	

	public UpdaterTask(Player p, AntiGrief instance) {
		this.p = p;
		plugin = instance;
	}

	@Override
	public void run() {
		
        if(!plugin.getConfig().getBoolean("AntiGrief.Auto-Updater-Enabled", true)){
        	
        	p.sendMessage(ChatColor.RED + "Auto-Updater and Changelog are disabled, Please enable it to automatically download the plugin :)");
        	return;
        }
		
		 String buffer = "";
	     String response = "";
		
        try {
            URL apiUrl = new URL("http://forgottenislands.co.uk/coding/files/AntiGrief/AntiGriefNew.txt");
            URLConnection apiConnection = apiUrl.openConnection();
            
            apiConnection = (HttpURLConnection) apiUrl.openConnection();
            apiConnection.setConnectTimeout(2000);
            apiConnection.setReadTimeout(2000);
            apiConnection.connect();
           
            BufferedReader in = new BufferedReader(new InputStreamReader(apiUrl.openStream()));
                while ((buffer = in.readLine()) != null) {
                        response += buffer;
                }
                in.close();
        } catch (MalformedURLException e) {
                logger.info("Error: " + e);
        } catch (IOException e) {
            if (e.equals("Network is unreachable: connect")) {
                    logger.severe("Failed to establish a connection");
            } else {
                    logger.info("An error occured when trying to grab update information");
            }   
        }
        if(response.isEmpty()){
        	
        	p.sendMessage(ChatColor.DARK_RED + "Could not retrieve update data!");
        }
        
		String[] split1 = response.split("@");
		String version = split1[0];
		if(!version.equals("3.2")){
			String changes = split1[1];
			String fileURL = "http://dev.bukkit.org/" + split1[2];
			String[] split2 = changes.split(";");
			p.sendMessage("");
	        p.sendMessage(ChatColor.GOLD + " " + ChatColor.UNDERLINE + "AntiGrief Version " + version + " Now Available!");
	        p.sendMessage("");
	        p.sendMessage(ChatColor.BLUE + " " + ChatColor.UNDERLINE + "Changes:");
	        p.sendMessage("");
	        
	        for(String c : split2){
	        	p.sendMessage(ChatColor.AQUA + " - " + c);
	        }
	        
	        String saveDir = "plugins" + File.separatorChar + "AntiGrief" + File.separatorChar + "Updates";
	        String fileName = "AntiGrief " + version + ".jar";
	        File update = new File(saveDir + File.separatorChar + fileName);
	        if(update.isFile()){
		        p.sendMessage(ChatColor.RED + " " + "AntiGrief version " + version + " has already been downloaded to /plugins/AntiGrief/updates");
		        p.sendMessage(ChatColor.RED + " " + "Copy it into your plugins folder and then restart the server to complete the update!");
		        return;
	        }
	        File dir = new File(saveDir);
	        
	        if(!dir.isDirectory()) dir.mkdirs();
	        try {
	            HttpDownloadUtility.downloadFile(fileURL, saveDir, fileName);
	        } catch (IOException ex){
	        	p.sendMessage(ChatColor.RED + " " + "Failed to download latest version!");
	            p.sendMessage(ChatColor.RED + ex.toString());
	            return;
	        }
	        p.sendMessage(ChatColor.RED + " " + "AntiGrief version " + version + " has been downloaded to the AntiGrief updates folder");
	        p.sendMessage(ChatColor.RED + " " + "Copy it into your plugins folder and then restart the server to complete the update!");
	        return;
		}
	}
}