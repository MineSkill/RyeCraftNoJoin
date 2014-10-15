package com.xexnetwork.nojoin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class NoJoin extends JavaPlugin{
	public static String TAG = ChatColor.DARK_RED + "[" ChatColor.RED + "RyeCraft" + ChatColor.DARK_RED + "]" + ChatColor.YELLOW + " ";
	public List<String> ips;
	public List<String> pardons;
	
	public void onEnable(){
		saveDefaultConfig();
		
		ips = getConfig().getStringList("BungeeCord-Ip");
		
		new Listenerlogin(this);
	}

	
	public void reloadConfigFile() throws IOException{
		File file = new File(getDataFolder(), "config.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			
		ips = config.getStringList("BungeeCord-Ip");
	}
}
