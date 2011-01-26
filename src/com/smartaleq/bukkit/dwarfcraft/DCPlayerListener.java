package com.smartaleq.bukkit.dwarfcraft;

import java.util.List;

import org.bukkit.croemmich.searchids.Colors;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerItemEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;


public class DCPlayerListener extends PlayerListener {
	 @SuppressWarnings("unused")
	private final DwarfCraft plugin;
	 
	 public DCPlayerListener(final DwarfCraft plugin) {
	     this.plugin = plugin;
	 }
	 
	@Override
	public void onPlayerCommand(PlayerChatEvent event) {
		String[] split = event.getMessage().split(" ");
		Player player = event.getPlayer();
		String playerInput = "";
		for(int i=2; i < split.length; i++){
			playerInput = playerInput + split[i]+ " ";
		}
		playerInput = playerInput.trim();
		if (split.length >= 2) {
			try{
				if (split[0].equalsIgnoreCase("/dc")){
					if (split[1].equalsIgnoreCase("help")) {
						messaging.help(player,playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("info")){
						messaging.dwarfCraftInfo(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("rules")){
						messaging.rules(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("?")) {
						messaging.commandHelp(player,playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("skillinfo")) {
						messaging.skillInfo(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("schoolinfo")) {
						messaging.schoolInfo(player, playerInput);
						
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("canitrain")) {
						messaging.canitrain(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("train")) {
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("increaseskill")) {
						//if player is not admin throw notadmin exception
						messaging.increaseSkill(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("skillsheet")){
						messaging.skillSheet(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("makemeadwarf")){
						messaging.makemeadwarf(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("reallymakemeadwarf")){
						messaging.reallymakemeadwarf(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("makemeanelf")){
						messaging.makemeanelf(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("ireallywanttobeanelf")){
						messaging.reallymakemeanelf(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("zonelist")){
						messaging.zoneList(player, playerInput);
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("addzone")){
						//if player is not admin throw notadmin exception
						messaging.addZones(player, playerInput);
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("area")){
						messaging.zonesAtPlayer(player, playerInput);
						event.setCancelled(true);
						return;
					}
					else {
						player.sendMessage("DC command not found");
						event.setCancelled(true);
					}
				}
			}
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
			player.sendMessage(Colors.Yellow+"*   *Since this is your first time playing, please*    *");
			player.sendMessage(Colors.Yellow+"*       *read /dc rules and /dc info*          *");
		}
		else {
			if(Training.isPlayerElf(player)){
				player.sendMessage("Welcome, "+Colors.Gray+ "elf " +Colors.DarkPurple + playerName);
				//welcome elf, may you die often due to your unskilled nature
			}
			else{
				player.sendMessage("Welcome, "+Colors.Gold+ "dwarf " +Colors.DarkPurple + playerName);
				//print to screen "welcome dwarf whatever of playerskilllevel whatever"
			}
		 }
	 }
	
	/*
	 * Catch Food eating events
	 */
	@Override
	public void onPlayerItem(PlayerItemEvent event){
		ItemStack itemUsed = event.getItem();
		Player player = event.getPlayer();
		int itemId = itemUsed.getTypeId();
		List<SkillEffects> skillList = SkillEffects.getEffectsForType("eatfood", itemId);
		if(skillList.isEmpty()) return;
		SkillEffects se = SkillEffects.getEffectsForType("eatfood", itemId).get(0);
		int HP = player.getHealth();
		int foodHP = (int)se.getEffectValue(SkillLevels.getSkillLevel(Skills.getSkillBySkillId(se.effectId/10), player));
		int newHP = Math.min(20, HP+foodHP);
		player.setHealth(newHP);
		player.getInventory().remove(itemUsed);
		event.setCancelled(true);
	}
		
	/* 
	 * catch crafting
	 */
//	@Override
//	public void onInventoryClick(InventoryClickEvent event){
//		
//	}
}
	
