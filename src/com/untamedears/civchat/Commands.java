package com.untamedears.civchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {
	channel ch= new channel();
	CivChat chat= new CivChat();
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		Player playerreciever= Bukkit.getPlayerExact(args[0]);
		if (label.equalsIgnoreCase("tell") || label.equalsIgnoreCase("message")){
			if (playerreciever.isOnline()==false){
				sender.sendMessage("Player is offline");
				return true;
			}
			sender.sendMessage(ChatColor.RED+"To player: "+ args);
			playerreciever.sendMessage(ChatColor.RED+"From "+sender.getName()+": "+ args[+1]);
			ch.setChannel(sender.getName(), playerreciever.getName(), true);
			return true;
		}
		if (label.equalsIgnoreCase("civchat")){
			if (args[0]=="save"){
				sender.sendMessage("saved config");
				chat.saveConfig();
			}
			if (args[0]=="reload"){
				sender.sendMessage("reloaded config");
				chat.reloadConfig();
			}
			else{ sender.sendMessage("Incorrect arg");}
		}
		return true;
	}
	
}