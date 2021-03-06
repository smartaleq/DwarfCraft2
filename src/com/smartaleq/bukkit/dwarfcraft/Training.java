package com.smartaleq.bukkit.dwarfcraft;

import java.util.Arrays;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

public class Training extends SkillLevels{

	
	/*
	 * Results from attemptSkillUp:
	 * return -1: not enough items
	 * return -2: skill max
	 * return -3: no such skill
	 * return -4: not in training zone
	 * return 0: failed
	 * return 1: success
	 */
	public static int checkSkillUp(Skills skill, Player player){ 
		if(SkillLevels.getSkillLevel(skill, player) == -1){return -3;}
		if(SkillLevels.getSkillLevel(skill, player) == 30){return -2;}
		//if player is not in training zone
		String school = skill.school;
		Boolean correctZone = false;
		if (ZoneLogger.Zones.length==0) return 0;
		for (TrainingZone z: ZoneLogger.Zones){
			if(z.school.equalsIgnoreCase(school)){
				if (ZoneLogger.isPlayerInside(player, z)){
				correctZone = true;
				break;
				}
			}
		}
		if (!correctZone) return -4;
		int newSkillLevel = SkillLevels.getSkillLevel(skill, player)+1;
		int[] skillCost;
		skillCost = skill.getSkillTrainingCost(newSkillLevel, player);
		PlayerInventory inv = player.getInventory();			
		for (int i = 0; i < skillCost[0];i++){
			if(Inventory.countItem(inv, skillCost[2*i + 1]) < skillCost[2*i+2]) return -1;
		}
		return 1;
	}
	
	public static int skillUp(Skills skill, Player player){ 
		int newSkillLevel = SkillLevels.getSkillLevel(skill, player)+1;
		int[] skillCost;
		skillCost = skill.getSkillTrainingCost(newSkillLevel, player);
		PlayerInventory inv = player.getInventory();	
		if (checkSkillUp(skill, player)== 1){
			for (int i = 0; i < skillCost[0];i++){
			Inventory.removeInventoryItems(inv, skillCost[2*i + 1], skillCost[2*i+2]);
			}
			increaseSkill(skill,player);
			return 1;
		}
		else return checkSkillUp(skill, player);
	}
	
	/*
	 * increases a players skill by skillId then backs up skills data
	 */
	public static void increaseSkill(Skills skill, Player player){
		int playerNumber = getPlayerNumber(player);
		playerSkillsArray[playerNumber][skill.skillId]++;
	}
	
	
	/*
	 * makes a player an elf, making most skills behave similarly to vanilla
	 */
	public static void makeElf(Player player){
		int playerNumber = getPlayerNumber(player);
		for(int i = 0; i < maximumSkillCount; i++){
			playerSkillsArray[playerNumber][i] = 0;
		}
		playerSkillsArray[playerNumber][0] = 1;
		SkillLevels.backupSkills();
		SkillLevels.saveSkills();
	}
	
	/*
	 * resets a player to dwarfmode with all skills 0
	 */
	public static void makeDwarf(Player player){
		int playerNumber = getPlayerNumber(player);
		for(int i = 0; i < maximumSkillCount; i++){
			playerSkillsArray[playerNumber][i] = 0;
		}
		SkillLevels.backupSkills();
		SkillLevels.saveSkills();
	}
	
	/*
	 * this will count how many skills a player has above level 5
	 */
	public static int countHighSkills(Player player){
		int playerNumber = getPlayerNumber(player);
		int highSkillsCount = 0;
		for(int i = 0; i < maximumSkillCount; i++){
			if(playerSkillsArray[playerNumber][i] > 5){ highSkillsCount++;};
		}
		return highSkillsCount;
	}
	
	/*
	 * this will return the skill level of a players 4th highest skill if they have less that 16 skills above 5
	 * if they have 17+ skills above 5, it will return their top 25th percentile skill level
	 */
	public static int topQuartileThreshold(Player player){
		int[] tempArray;
		tempArray = new int[99];
		int playerNumber = getPlayerNumber(player);
		tempArray = playerSkillsArray[playerNumber];
		Arrays.sort(tempArray);
		int highestQuartileValue = Math.min(tempArray[99-(Math.min((countHighSkills(player)+3)/4,4))],5);
		return highestQuartileValue;
	}
	
	public static int topThreeQuartileThreshold(Player player){
		int[] tempArray;
		tempArray = new int[99];
		int playerNumber = getPlayerNumber(player);
		tempArray = playerSkillsArray[playerNumber];
		Arrays.sort(tempArray);
		int topThreeQuartileValue = Math.min(tempArray[99-(Math.min(3*(countHighSkills(player))/4,12))],5);
		return topThreeQuartileValue;
	}
		
	public static int playerLevel(Player player){
		int playerNumber = getPlayerNumber(player);
		int playerLevel = 5;
		int highestSkill = 0;
		
		for(int i = 0; i < maximumSkillCount; i++){
			int thisSkillLevel = playerSkillsArray[playerNumber][i];
			if(thisSkillLevel > highestSkill){highestSkill = thisSkillLevel;};
			if(thisSkillLevel > 5){playerLevel = playerLevel + thisSkillLevel - 5;};

		}
		if(playerLevel == 5){playerLevel = highestSkill;};
		return playerLevel;
	}

	public static int playerLevel(String playerName){
		int playerNumber = getPlayerNumber(playerName);
		int playerLevel = 5;
		int highestSkill = 0;
		
		for(int i = 0; i < maximumSkillCount; i++){
			int thisSkillLevel = playerSkillsArray[playerNumber][i];
			if(thisSkillLevel > highestSkill){highestSkill = thisSkillLevel;};
			if(thisSkillLevel > 5){playerLevel = playerLevel + thisSkillLevel - 5;};

		}
		if(playerLevel == 5){playerLevel = highestSkill;};
		return playerLevel;
	}
	
	public static int getSkillIdFromName(String string) {
		for(int skillId = 0; skillId < maximumSkillCount; skillId++){
			System.out.println("trying to get skill name " + string + "at skillId " + skillId);
			if(string.regionMatches(0, Skills.values()[skillId].professionName, 0, 6 /*length to compare skill names*/)){return skillId;}
		}
		return 0;
	}
	

}
