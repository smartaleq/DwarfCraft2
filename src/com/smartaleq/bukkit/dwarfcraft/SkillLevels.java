package com.smartaleq.bukkit.dwarfcraft;

import java.io.*;
import org.bukkit.entity.Player;
import org.bukkit.croemmich.searchids.Colors;


public class SkillLevels {

	static String playerSkillsFileName = "DwarfCraftPlayers.data";
	static String playerSkillsBackupName = "DwarfCraftPlayers.data.backup";
	static String playerSkillsDirectory = "./plugins/DwarfCraft/";
		
	static int maxPlayers = 100;
	static int[][] playerSkillsArray; 
	static String[] playerNamesArray;
	
	
	
	static int maximumSkillCount = 100;
		
	public static int getPlayerNumber(Player player){
		int playerNumber = -1;
		String playerName = player.getDisplayName();
		for(int i=0; i < maxPlayers; i++){
			if(playerNamesArray[i] == null){
				continue;
				}
			if(playerNamesArray[i].length() == 0){
				continue;
				}
			if(playerNamesArray[i].equalsIgnoreCase(playerName)){playerNumber = i;};
		}
		return playerNumber;
	}
	
	public static int countPlayers(){
		int playerCount = 0;
		for(int i=0; i < maxPlayers; i++){
			if(playerNamesArray[i] == null){continue;}
			if(playerNamesArray[i].length() != 0){playerCount++;};
		}
		System.out.println("counted " + playerCount + " players");
		return playerCount;
	}
	
	static void addNewPlayer(Player player){
		int newPlayerNumber = countPlayers()+1;
		String playerName = player.getDisplayName();
		playerNamesArray[newPlayerNumber] = playerName;
		player.sendMessage("Welcome to the server, " + Colors.Blue + playerName);
		backupSkills();
		saveSkills();		
		Training.makeDwarf(player);
	}
	
	public static int getSkillLevel(Skills skill, Player player){
		int playerNumber = getPlayerNumber(player);
		int skillLevel = playerSkillsArray[playerNumber][skill.skillId]; 
		if(skill.skillId > Skills.values().length-1){return -1;}
		return skillLevel;
	}
	
	public static Boolean isPlayerElf(Player player){
		int playerNumber = getPlayerNumber(player);
		Boolean isElf = false;
		int elfValue = playerSkillsArray[playerNumber][0];
		if(elfValue != 0){isElf = true;}
		return isElf;
	}
	
	public static void readPlayers(){
		String line = "";
		System.out.println("Attempting to read players file");
		/*
		 * schema: index of string playername is playernumber
		 */
	    playerNamesArray= new String[maxPlayers];		
		/*
		 * schema: playernumber, isElf, player skillvalue by skillID
		 */	
	    playerSkillsArray = new int[maxPlayers][maximumSkillCount];
		try {
			FileReader fr = new FileReader(playerSkillsDirectory + playerSkillsFileName);
			BufferedReader br = new BufferedReader(fr);
			for(int row = 0; row < maxPlayers; row++) {
				int column;
				line = br.readLine();
				if(line != null){
					String[] theline = line.split(",");
					playerNamesArray[row] = theline[0];
					column = 0;
						while(column < maximumSkillCount-1){
						playerSkillsArray[row][column] = Integer.parseInt(theline[column+1]);
						column++;
					}
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
	public static void backupSkills(){
		File current = new File(playerSkillsDirectory + playerSkillsFileName);
		File backup = new File(playerSkillsDirectory + playerSkillsBackupName);
		current.renameTo(backup);
		current.delete();
	}
	
	public static void saveSkills() {
		File file = new File(playerSkillsDirectory + playerSkillsFileName);
		Writer writer = null;
		for(int i=0;i<maxPlayers;i++){
			if(playerNamesArray[i] == null){
				playerNamesArray[i]="";}
			}
	
		try{
			writer = new BufferedWriter(new FileWriter(file));
			for(int row=0 ; row < maxPlayers-1 ; row++){
				int column=0;
				writer.write(playerNamesArray[row]);
				while (column < maximumSkillCount-1){
					writer.write(","+playerSkillsArray[row][column]);
					column++;
				}
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

	public static void skillSheet(Player player, Player viewer) {
		String[] skillNames;
		skillNames = new String[3];
		int[] skillLevels;
		skillLevels = new int[3];
		String playerName = player.getDisplayName();
	
		viewer.sendMessage("Printing Skill Sheet for " + playerName + "  Player Level is " + Training.playerLevel(player));
		int skillId=0;
		int printLineSkillCount=0;
		if(SkillLevels.isPlayerElf(player)){
			viewer.sendMessage(Colors.Red+"Elves don't have skills, numbskull");
			return;
		}
		while (skillId<maximumSkillCount){
			if (printLineSkillCount == 3) skillId++;
			printLineSkillCount = 0;
			skillNames[0] = "";
			skillNames[1] = "";
			skillNames[2] = "";
			Skills skill;
			while (printLineSkillCount < 3){
				if (skillId == 100) break;
				skill = Skills.values()[skillId];
				if (skill != null){
					skillNames[printLineSkillCount] = skill.professionName;
					skillLevels[printLineSkillCount] = SkillLevels.getSkillLevel(skill, player);
					printLineSkillCount++;
				}
				skillId++;
			}
			if (printLineSkillCount == 3) {
				viewer.sendMessage(Colors.White+"  "+skillNames[0]+": "+Colors.Yellow+skillLevels[0]+"  "+Colors.White+skillNames[1]+": "+Colors.Yellow+skillLevels[1]+"  "+Colors.White+skillNames[2]+": "+Colors.Yellow+skillLevels[2]);
			}
		}
//		if (printLineSkillCount==2){
//			player.sendMessage("  "+skillNames[0]+": "+skillLevels[0]+"  "+skillNames[1]+": "+skillLevels[1]+"  "+skillNames[2]+": "+skillLevels[2]);
//		}
		if (printLineSkillCount==2){
			viewer.sendMessage(Colors.White+"  "+skillNames[0]+": "+Colors.Yellow+Colors.White+skillLevels[0]+"  "+skillNames[1]+": "+Colors.Yellow+skillLevels[1]);
		}
		if (printLineSkillCount==1){
			viewer.sendMessage(Colors.White+"  "+skillNames[0]+": "+Colors.Yellow+skillLevels[0]);
		}		
	}	
	
}
