package com.smartaleq.bukkit.dwarfcraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.croemmich.searchids.Colors;
import org.bukkit.entity.Player;
	
public enum Skills {
    PICKAXEUSE (1,"Pickaxe Use","Tool Use",1,4,16,0,0,0,0,1,1.3),
	SHOVELUSE (2,"Shovel Use","Tool Use",1,3,32,0,0,0,0,0.5,1.3),
	AXEDURABILITY (3,"Axe Durability","Tool Use",1,17,16,0,0,0,0,0.5,1.3),
	PLOWMAN (4,"Plowman","Tool Use",2,295,1,296,1,0,0,1,1.4),
	SWORDSMAN (5,"Swordsman","Tool Use",2,334,1,0,1,0,0,0.5,1.36),
	SMELTER (8,"Smelter","Tool Use",1,327,1,0,0,0,0,1,1.22),
	EXCAVATOR (11,"Excavator","Mining",1,4,16,0,0,0,0,1,1.3),
	QUARRY_WORKER (12,"Quarry Worker","Mining",1,4,16,0,0,0,0,1,1.3),
	ORE_MINER (13,"Ore Miner","Mining",2,263,2,265,2,0,0,1,1.32),
	PRECIOUSSTONEMINER (14,"Precious Stone Miner","Mining",3,266,2,264,1,331,4,1,1.25),
	SANDDIGGER (21,"Sand Digger","Digging",1,12,32,0,0,0,0,0.5,1.3),
	GRAVELDIGGER (22,"Gravel Digger","Digging",1,13,16,0,0,0,0,1,1.28),
	DIRTDIGGER (23,"Dirt Digger","Digging",1,3,32,0,0,0,0,1,1.3),
	WOODCUTTING (31,"Woodcutting","Lumberjack",1,17,16,0,0,0,0,0.5,1.3),
	WOODSPLITTING (32,"Wood Splitting","Lumberjack",1,17,16,0,0,0,0,0.5,1.3),
	WHEATFARMER (41,"Wheat Farmer","Farming",2,296,1,295,1,0,0,1,1.4),
	REEDCACTUSFARMER (42,"Reed/Cactus Farmer","Farming",2,338,1,81,1,0,0,1,1.4),
	TILELAYER (51,"Tile Layer","Decorating",1,44,16,0,0,0,0,1,1.3),
	GLASSWORKER (52,"Glassworker","Decorating",1,20,8,0,0,0,0,1,1.35),
	WOODCRAFTING (53,"Woodcrafting","Decorating",2,5,4,280,4,0,0,1,1.4),
	BOOKMAKER (61,"Bookmaker","Specialist",2,339,1,340,1,0,0,1,1.36),
	BRICKMAKER (62,"Brickmaker","Specialist",2,336,1,45,1,0,0,0.5,1.4),
	DEMOLITIONIST (63,"Demolitionist","Specialist",2,289,1,46,1,0,0,0.5,1.4),
	FIRESTARTER (64,"Firestarter","Specialist",1,259,1,0,0,0,0,1,1.3),
	RAILWORKER (65,"Railworker","Specialist",1,343,1,0,0,0,0,0.5,1.3),
	TRAVELING (71,"Traveling","Exploration",1,337,4,0,0,0,0,1,1.3),
	CLIMBING (72,"Climbing","Exploration",1,86,1,0,0,0,0,0.5,1.3),
	SURVIVALIST (73,"Survivalist","Exploration",1,39,1,0,0,0,0,1,1.32),
	SUSTAINABLEHARVESTING (74,"Harvester","Exploration",2,37,1,38,1,0,0,1,1.32),
	ANIMALHUNTER (81,"Animal Hunter","Combat",3,319,1,334,1,35,2,1,1.36),
	MONSTERHUNTER (82,"Monster Hunter","Combat",2,287,2,289,2,0,0,0.5,1.4),
	SCOUT (83,"Scout (Light Armor)","Combat",1,299,1,0,0,0,0,0.5,1.3),
	SOLDIER (84,"Soldier (Heavy Armor)","Combat",1,307,1,0,0,0,0,0.5,1.3),
	FLETCHER (85,"Fletcher","Combat",2,288,5,318,1,0,0,1,1.3),
	CITIZEN (91,"Citizen","Civic",1,329,0,0,0,0,0,0.5,1.3),
	LEADER (92,"Leader","Civic",2,57,1,354,1,0,0,0.5,1.3),
	NOBLE (99,"Noble","Civic",1,344,16,0,0,0,0,1,1.3);
	

	public int skillId;
	public final String professionName; 
	public final String school;
	public final int trainingPaymentCount;
	public final int trainingPaymentMat1Type;
	public final int trainingPaymentMat1Count;
	public final int trainingPaymentMat2Type;
	public final int trainingPaymentMat2Count;
	public final int trainingPaymentMat3Type;
	public final int trainingPaymentMat3Count;
	public final double trainingNoviceIncrement;
	public final double trainingMasterMultiplier;
	

	Skills(
	       int skillId, 
	       String professionName, 
	       String school,
	       int trainingPaymentCount,
	       int trainingPaymentMat1Type,
	       int trainingPaymentMat1Stack,
	       int trainingPaymentMat2Type,
	       int trainingPaymentMat2Stack,
	       int trainingPaymentMat3Type,
	       int trainingPaymentMat3Stack,
	       double trainingNoviceIncrement,
	       double trainingMasterMultiplier)
	    {
		this.skillId = skillId;
		this.professionName = professionName; 
		this.school = school; 
		this.trainingPaymentCount = trainingPaymentCount;
		this.trainingPaymentMat1Type = trainingPaymentMat1Type;
		this.trainingPaymentMat1Count = trainingPaymentMat1Stack;
		this.trainingPaymentMat2Type = trainingPaymentMat2Type;
		this.trainingPaymentMat2Count = trainingPaymentMat2Stack;
		this.trainingPaymentMat3Type = trainingPaymentMat3Type;
		this.trainingPaymentMat3Count = trainingPaymentMat3Stack;
		this.trainingNoviceIncrement = trainingNoviceIncrement;
		this.trainingMasterMultiplier = trainingMasterMultiplier;
	    }

	
	public static Skills findSkill (String playerInput){
		String[] split = playerInput.split(" ");
		if(Integer.parseInt(split[0]) >0 && Integer.parseInt(split[0])<100){
			playerInput = split[0];
			return getSkillBySkillId(Integer.valueOf(playerInput));
		}
		else if(split[0].length() > 0) {
			if(split[1] != null){split[0] = split[0] + " " + split[1];};
			playerInput = split[0];
			return getSkillBySkillName(playerInput);
		}
		return null;
	}
	
	public static Skills getSkillBySkillId(int skillId){
		for( Skills s: Skills.values()){
			if (s.skillId == skillId) return s;
		}	
		return null;
	}
	
	//TODO
	public static Skills getSkillBySkillName(String skillName){
		for( Skills s: Skills.values()){
			if (s.professionName.equalsIgnoreCase(skillName.trim())) return s;
		}	
		return null;
	}
	

	public int[] getSkillTrainingCost(int newSkillLevel, Player player){
	    int[] trainingCosts;
	    trainingCosts = new int[7];
	    trainingCosts[0] = this.trainingPaymentCount;
	    
	    // Calculate multiplier for this level
	    double baseMultiplier;
	    //multiplier for levels 0-5
	    baseMultiplier = Math.ceil(Math.min((double)newSkillLevel, 5) * this.trainingNoviceIncrement);
	    //multiplier for levels 6-30
	    if(newSkillLevel > 5){
		baseMultiplier = baseMultiplier * (Math.pow(this.trainingMasterMultiplier, Math.min(0,newSkillLevel-5)));
	    }
		//mutliplier for secondary skill training
		if(newSkillLevel > 5 && newSkillLevel < Training.topQuartileThreshold(player)){
		    baseMultiplier = baseMultiplier * (1 + (Training.playerLevel(player)/100+2*Training.playerLevel(player)));
		}
		//insert training items into cells 1, 3, 5 and insert cost into 2,4,6
		trainingCosts[0] = this.trainingPaymentCount;
		trainingCosts[1] = this.trainingPaymentMat1Type;
		trainingCosts[2] = (int)((double)this.trainingPaymentMat1Count * baseMultiplier);
		trainingCosts[3] = this.trainingPaymentMat2Type;
		trainingCosts[4] = (int)((double)this.trainingPaymentMat2Count * baseMultiplier);
		trainingCosts[5] = this.trainingPaymentMat3Type;
		trainingCosts[6] = (int)((double)this.trainingPaymentMat3Count * baseMultiplier);
	    return trainingCosts;
	}
	
	public static List<Skills> getSkillsList(int schoolId){
		List<Skills> outputArray = new ArrayList<Skills>();
		for(Skills s : Skills.values())
			if(s.skillId/10 == schoolId)
				outputArray.add(s);
		return outputArray;
	}


	public static int findSchool(String playerInput) {
		String[] split = playerInput.split(" ");
		if(Integer.parseInt(split[0]) >=0 && Integer.parseInt(split[0])<10){
			return Integer.valueOf(split[0]);
		}
		else if(split[0].length() > 0) {
			if(split[1] != null){split[0] = split[0] + " " + split[1];};
			playerInput = split[0];
			return getSchoolIdBySchoolName(playerInput);
		}
		return -1;
	}


	private static int getSchoolIdBySchoolName(String playerInput) {
		for (Skills s : Skills.values()){
			if(s.school.equalsIgnoreCase(playerInput)) return (s.skillId/10);
		}
		return -1;
	}
	
	public static String levelColors(Skills skill, Player player){
		if (SkillLevels.getSkillLevel(skill, player) == 30) return Colors.Purple;		
		if (SkillLevels.getSkillLevel(skill, player) > 20) return Colors.LightPurple;
		if (SkillLevels.getSkillLevel(skill, player) > 10) return Colors.Green;
		if (SkillLevels.getSkillLevel(skill, player) > 5) return Colors.LightGreen;
		if (SkillLevels.getSkillLevel(skill, player) > 4) return Colors.Yellow;
		if (SkillLevels.getSkillLevel(skill, player) > 1) return Colors.Gray;	
		if (SkillLevels.getSkillLevel(skill, player) == 0) return Colors.LightGray;
		else return Colors.Gold;
	}



}

