package com.smartaleq.bukkit.dwarfcraft;

import java.io.IOException;
import org.bukkit.croemmich.searchids.Colors;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
// import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;


public class DCPlayerListener extends PlayerListener {
	 @SuppressWarnings("unused")
	private final DwarfCraft plugin;
	 
	 public DCPlayerListener(final DwarfCraft plugin) {
	     this.plugin = plugin;
	 }
	 
	@SuppressWarnings("unused")
	@Override
	public void onPlayerCommand(PlayerChatEvent event) {
		String[] split = event.getMessage().split(" ");
		Player player = event.getPlayer();
		String playerInput = "";
		for(int i=2; i < split.length; i++){
			playerInput = playerInput + split[i]+ " ";
		}
		playerInput = playerInput.trim();
		if (split.length >= 1) {
			try{
				if (split[0].equalsIgnoreCase("/dc")){
					if (split[1].equalsIgnoreCase("help")) {
						//print help info
						player.sendMessage(Colors.Red + "      Commands List");
						player.sendMessage("/dc skillinfo <SkillId>");
						player.sendMessage("/dc schoolinfo <School Name>");
						player.sendMessage("/dc canitrain <skillId>");
						player.sendMessage("/dc train <skillId>");
						player.sendMessage("/dc skillsheet");
						player.sendMessage("/dc skillsheet <playerName>");
						player.sendMessage("/dc increaseskill <skillId>");
						player.sendMessage("/dc zonelist");
						player.sendMessage("/dc myzones");
						player.sendMessage("/dc addzone <lowerX upperX lowerY upperY lowerZ upperZ school>");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("skillinfo")) {
						Training.skillInfo(player, Skills.findSkill(playerInput));
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("schoolinfo")) {
						player.sendMessage("Caught schoolinfo");
						Training.schoolInfo(player);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("canitrain")) {
						player.sendMessage("Caught canitrain");
						Skills skill = Skills.findSkill(playerInput);
						int trainResult = Training.attemptSkillUp(skill, player);
						if(trainResult == 1){
							player.sendMessage("Yes, you can train this skill right now!");
						}
						else if (trainResult == -1){
							player.sendMessage("No. You need more payment, check cost with /dc skillinfo <id>");
						}
						else if (trainResult == -2){
							player.sendMessage("No. You're already max level!");
						}
						else if (trainResult == -3){
							player.sendMessage("No. There is no such skill!");
						}
						else {
							player.sendMessage("No. training wouldn't work");
						}
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("train")) {
						Skills skill = Skills.findSkill(playerInput);
						if(Training.attemptSkillUp(skill, player) == 1){
							Training.increaseSkill(skill, player);
						}
						player.sendMessage("Skill level increased!");
						Training.skillInfo(player, skill );
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("increaseskill")) {
						Skills skill = Skills.findSkill(playerInput);
						if(Integer.parseInt(split[2]) < 100 && Integer.parseInt(split[2]) > 0){
							int skillId = Integer.parseInt(split[2]);
							Training.increaseSkill(skill, player);
							int skillLevel = SkillLevels.getSkillLevel(skill, player);
							player.sendMessage("Your skill #" + skillId + " has been increased to level " + skillLevel);
							event.setCancelled(true);
							return;
						}
						else throw new IOException( "Bad argument");
					}
					else if (split[1].equalsIgnoreCase("skillsheet")){
						Player viewer = player;
						if (split.length == 3 ){
							String playerViewedName = split[2];
		//					player  = getplayer(playerViewedName); not working due to getserver() vs staticness
						}
						SkillLevels.skillSheet(player, viewer);
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("makemeadwarf")){
						if(!SkillLevels.isPlayerElf(player)){
							player.sendMessage("You're already a dwarf. If you want to reset                     skills  use"+Colors.Gold+" /dc REALLYmakemeadwarf");
							event.setCancelled(true);
							return;
						}
						player.sendMessage("A wise decision. One second...*poof*");
						Training.makeDwarf(player);
						player.sendMessage("Welcome back to the dwarven brotherhood!");
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("reallymakemeadwarf")){
						player.sendMessage("Alright, I guess...*poof*");
						Training.makeDwarf(player);
						player.sendMessage("Welcome back to the dwarven brotherhood!");
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("makemeanelf")){
						player.sendMessage("Elves have no skill levels and act like a vanilla player");
						player.sendMessage("if this is what you want, try saying "+Colors.Gold+"/dc iREALLYwanttobeanelf");
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("ireallywanttobeanelf")){
						player.sendMessage("Ok, wussy...*poof*");
						Training.makeElf(player);
						player.sendMessage("Now you're an elf! *ick!*");
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("zonelist")){
						//print zone list
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("addzone")){
						String lowerX = split[2];
						String upperX = split[3];
						String lowerY = split[4];
						String upperY = split[5];
						String lowerZ = split[6];
						String upperZ = split[7];
						String school = split[8];
						ZoneLogger.addNewZone(lowerX, upperX, lowerY, upperY, lowerZ, upperZ, school);
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("myzones")){
						TrainingZone[] zones = new TrainingZone[5];
						zones = ZoneLogger.isInZones(player);
						for(int i=0; i<5;i++){	
							if(zones[i] != null){
								player.sendMessage("In a " + zones[i].school + "training zone");
							}
						}
						event.setCancelled(true);
						return;
					}
					else {
						player.sendMessage("DC command not found");
						event.setCancelled(true);
					}
				}
			}
			catch (IOException e) {return;}
			catch (NumberFormatException f) {return;}
		}
	}

	@Override
	public void onPlayerJoin(PlayerEvent event){
		Player player = event.getPlayer();
		String playerName = player.getDisplayName();
		if(SkillLevels.getPlayerNumber(player) == -1){
			int playerCount = SkillLevels.countPlayers();
			if(playerCount != SkillLevels.maxPlayers){
				SkillLevels.addNewPlayer(player);
				playerCount++;
				System.out.println("Added new player: " + player.getDisplayName());
				System.out.println("There are now " + playerCount + " players registered with DwarfCraft");
			}
			else {
				//throw max players in database reached thingamabob
			}
		}
		else {
			if(Training.isPlayerElf(player)){
				player.sendMessage("Welcome, "+Colors.White+ "elf " +Colors.Gray + playerName);
				//welcome elf, may you die often due to your unskilled nature
			}
			else{
				player.sendMessage("Welcome, "+Colors.Gold+ "dwarf " +Colors.Purple + playerName);
				//print to screen "welcome dwarf whatever of playerskilllevel whatever"
			}
		 }
	 }

}