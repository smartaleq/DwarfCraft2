package com.smartaleq.bukkit.dwarfcraft;

import org.bukkit.Material;
import org.bukkit.croemmich.searchids.Colors;
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
	public static int attemptSkillUp(Skills skill, Player player){ 
		if(SkillLevels.getSkillLevel(skill, player) == -1){return -3;}
		if(SkillLevels.getSkillLevel(skill, player) == 30){return -2;}
		//if player is not in training zone
		String school = skill.school;
		Boolean correctZone = false;
		for(int i=0; i < ZoneLogger.countZones() ; i++){
			if(ZoneLogger.Zones[i].school.equalsIgnoreCase(school)){
				correctZone = true;
				break;
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
		for (int i = 0; i < skillCost[0];i++){
			Inventory.removeInventoryItems(inv, skillCost[2*i + 1], skillCost[2*i+2]);
		}
		return 1;
	}
	
	/*
	 * increases a players skill by skillId then backs up skills data
	 */
	public static void increaseSkill(Skills skill, Player player){
		int playerNumber = getPlayerNumber(player);
		playerSkillsArray[playerNumber][skill.skillId]++;
		backupSkills();
		saveSkills();
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

	public static void skillInfo(Player player, Skills skill) {

		int newSkillLevel = SkillLevels.getSkillLevel(skill, player) + 1;
		player.sendMessage("-----------------------------------------------------");	
		player.sendMessage("Skill Information for: " + Colors.Green + skill.professionName + Colors.White + " (id: " + Colors.Blue + skill.skillId + Colors.White + ")");
		player.sendMessage("To train to level " + Colors.Yellow + newSkillLevel + Colors.White + " will cost:");
		int[] trainingCosts;
		trainingCosts = new int[7];
		trainingCosts = skill.getSkillTrainingCost(newSkillLevel, player);
		player.sendMessage("item Id: " + trainingCosts[1] + "  number required: " + trainingCosts[2]);
		if (trainingCosts[0]>1){player.sendMessage("item Id: " + Material.getMaterial(trainingCosts[3]).name() + "  number required: " + trainingCosts[4]);}
		if (trainingCosts[0]>2){player.sendMessage("item Id: " + Material.getMaterial(trainingCosts[5]).name() + "  number required: " + trainingCosts[6]);}
		player.sendMessage("-----------------------------------------------------");
	}

	public static int getSkillIdFromName(String string) {
		for(int skillId = 0; skillId < maximumSkillCount; skillId++){
			System.out.println("trying to get skill name " + string + "at skillId " + skillId);
			if(string.regionMatches(0, Skills.values()[skillId].professionName, 0, 6 /*length to compare skill names*/)){return skillId;}
		}
		return 0;
	}
	
	public static void schoolInfo(Player player) {
		player.sendMessage(Colors.Gold + " List of Schools");
		player.sendMessage(Colors.Blue + "Tool Use");
		player.sendMessage(Colors.Blue + "Mining");
		player.sendMessage(Colors.Blue + "Digging");
		player.sendMessage(Colors.Blue + "Lumberjack");
		player.sendMessage(Colors.Blue + "Farming");
		player.sendMessage(Colors.Blue + "Decorating");
		player.sendMessage(Colors.Blue + "Specialist");
		player.sendMessage(Colors.Blue + "Exploration");
		player.sendMessage(Colors.Blue + "Combat");
		player.sendMessage(Colors.Blue + "Civic");
		
	}			
}
