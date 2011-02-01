package com.smartaleq.bukkit.dwarfcraft;

import java.io.*;
import org.bukkit.entity.Player;
import org.bukkit.croemmich.searchids.Colors;


public class SkillLevels {

	static String playerSkillsFileName = "DwarfCraftPlayers.data";
	static String playerSkillsBackupName = "DwarfCraftPlayers.data.backup";
	static String playerSkillsDirectory = "./DwarfCraft/";
		
	static int maxPlayers = 100;
	static int[][] playerSkillsArray; 
	public static String[] playerNamesArray;
	
	
	
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
	
	public static int getPlayerNumber(String playerName){
		int playerNumber = -1;
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

	public static boolean isPlayerElf(String playerName) {
		int playerNumber = getPlayerNumber(playerName);
		Boolean isElf = false;
		int elfValue = playerSkillsArray[playerNumber][0];
		if(elfValue != 0){isElf = true;}
		return isElf;
	}

	public static int getSkillLevel(Skills skill, String playerName) {
		int playerNumber = getPlayerNumber(playerName);
		int skillLevel = playerSkillsArray[playerNumber][skill.skillId]; 
		return skillLevel;
	}


	
}
