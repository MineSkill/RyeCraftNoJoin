package com.xexnetwork.nojoin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

public class Listenerlogin implements Listener{

	NoJoin plugin;
	
	public Listenerlogin(NoJoin plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e){
		String ip = e.getAddress().toString().replaceFirst("/", "");
		if(plugin.ips.contains(ip)) return;
		e.disallow(Result.KICK_OTHER, NoJoin.TAG + "\nTo join this server connect to hub.xex-mc.info");
	}
}