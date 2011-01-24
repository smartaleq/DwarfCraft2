package com.smartaleq.bukkit.dwarfcraft;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Zone {
	int lowerX;
	int upperX;
	int lowerY;
	int upperY;
	int lowerZ;
	int upperZ;
	
	Zone(
			int lowerX,
			int upperX,
			int lowerY,
			int upperY,
			int lowerZ,
			int upperZ
			){
		this.lowerX = lowerX;
		this.upperX = upperX;
		this.lowerY = lowerY;
		this.upperY = upperY;
		this.lowerZ = lowerZ;
		this.upperZ = upperZ;
	}
	
	
	Boolean isPlayerInside(Player player){
		Location playerLocation = player.getLocation();
		if (
				playerLocation.getX() < upperX && playerLocation.getX() > lowerX &&
				playerLocation.getY() < upperY && playerLocation.getY() > lowerY &&
				playerLocation.getZ() < upperZ && playerLocation.getZ() > lowerZ){
			return true;
		}
		return false;
		
	}
}
