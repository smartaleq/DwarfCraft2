package com.smartaleq.bukkit.dwarfcraft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ZoneLogger {

	static String zoneLoggerFileName = "Zones.data";
	static String zoneLoggerBackupName = "Zones.data.backup";
	static String zoneLoggerDirectory = "./DwarfCraft/";
		
	static int maxZones = 100;
	 
	public static TrainingZone[] Zones;
	
	static int zoneDataFields = 7;
		
	
	public static int countZones(){
		int zoneCount = 0;
		for(int i=0; i < maxZones; i++){
			if(Zones[i] != null){zoneCount++;}
		}
		return zoneCount;
	}
	
	static void addNewZone(String lowerX, String upperX, String lowerY, String upperY, String lowerZ, String upperZ, String school){
		readZones(false);
		String[] newZoneArray;
		newZoneArray = new String[7];
		newZoneArray[0] = lowerX;
		newZoneArray[1] = upperX;
		newZoneArray[2] = lowerY;
		newZoneArray[3] = upperY;
		newZoneArray[4] = lowerZ;
		newZoneArray[5] = upperZ;		
		newZoneArray[6] = school;
		backupZones();
		saveZones(newZoneArray);
		readZones(false);
	}
	
	 static boolean isPlayerInside(Player player, Zone zone){
		Location playerLocation = player.getLocation();
		if (
				playerLocation.getX() < zone.upperX && playerLocation.getX() > zone.lowerX &&
				playerLocation.getY() < zone.upperY && playerLocation.getY() > zone.lowerY &&
				playerLocation.getZ() < zone.upperZ && playerLocation.getZ() > zone.lowerZ){
			return true;
		}
		return false;
		
	}
	
	public static TrainingZone[] isInZones(Player player){
		TrainingZone[] playerZoneList = new TrainingZone[5];
		int zoneCount = 0;
		for(int zoneNumber = 0; zoneNumber < countZones(); zoneNumber++){
			if(isPlayerInside(player, Zones[zoneNumber])){
				playerZoneList[zoneCount]= Zones[zoneNumber];
				zoneCount++;
				if (zoneCount > 4) break;
			}
		}
		return playerZoneList;
	}
	
	public static void readZones(boolean firstRun){
		String line = "";
		System.out.println("Attempting to read zones file");
	    if (firstRun) Zones = new TrainingZone[maxZones];
	    else Zones = new TrainingZone[maxZones];	// this is wrong, but at least working for now
		try {
			FileReader fr = new FileReader(zoneLoggerDirectory + zoneLoggerFileName);
			BufferedReader br = new BufferedReader(fr);
			for(int row = 0; row < maxZones; row++) {
				line = br.readLine();
				if(line != null){
					String[] theline = line.split(",");
					int lowerX = Integer.parseInt(theline[0]);
					int upperX = Integer.parseInt(theline[1]);
					int lowerY = Integer.parseInt(theline[2]);
					int upperY = Integer.parseInt(theline[3]);
					int lowerZ = Integer.parseInt(theline[4]);
					int upperZ = Integer.parseInt(theline[5]);
					String school = theline[6];
					Zones[row]= new TrainingZone(lowerX, upperX, lowerY, upperY, lowerZ, upperZ, school);
				}
			}
		}
		catch(FileNotFoundException fN) {
			fN.printStackTrace();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
	public static void backupZones(){
		File current = new File(zoneLoggerDirectory + zoneLoggerFileName);
		File backup = new File(zoneLoggerDirectory + zoneLoggerBackupName);
		current.renameTo(backup);
		current.delete();
	}
	
	public static void saveZones(String[] newZoneArray) {
		File file = new File(zoneLoggerDirectory + zoneLoggerFileName);
		Writer writer = null;
		for(int i=0;i<maxZones;i++){
		
			try{
				writer = new BufferedWriter(new FileWriter(file));
				for(int row=0 ; row < countZones() ; row++){
					writer.write(Zones[row].lowerX+",");
					writer.write(Zones[row].upperX+",");
					writer.write(Zones[row].lowerY+",");
					writer.write(Zones[row].upperY+",");
					writer.write(Zones[row].lowerZ+",");
					writer.write(Zones[row].upperZ+",");
					writer.write(Zones[row].school);
					writer.write(",\n");
				}
				if(newZoneArray[0] != null){
					writer.write(newZoneArray[0]+",");
					writer.write(newZoneArray[1]+",");
					writer.write(newZoneArray[2]+",");
					writer.write(newZoneArray[3]+",");
					writer.write(newZoneArray[4]+",");
					writer.write(newZoneArray[5]+",");
					writer.write(newZoneArray[6]+",");
					writer.write(",\n");
				}
				writer.close();
			}	
			catch(FileNotFoundException fN) {
				fN.printStackTrace();
			}
			catch(IOException e){
				System.out.println(e);
			}
		}
	}		
	
	
}
