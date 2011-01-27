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
	 /**
	  * Player Command listener: parses first two sections of input and passes input on to the Messaging methods
	  */
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
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.help(player,playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("info")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.dwarfCraftInfo(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("rules")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.rules(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("?")) {
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.commandHelp(player,playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("skillinfo")) {
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.skillInfo(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("schoolinfo")) {
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.schoolInfo(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("canitrain")) {
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.canitrain(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("train")) {
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.train(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("increaseskill")) {
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.admin")) messaging.increaseSkill(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("skillsheet")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.skillSheet(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("makemeadwarf")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.makemeadwarf(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("reallymakemeadwarf")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.reallymakemeadwarf(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("makemeanelf")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic"))messaging.makemeanelf(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("ireallywanttobeanelf")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.reallymakemeanelf(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("zonelist")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic")) messaging.zoneList(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("readzones")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.admin")) messaging.readZones(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					if (split[1].equalsIgnoreCase("addzone")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.mod")) messaging.addZones(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
						event.setCancelled(true);
						return;
					}
					else if (split[1].equalsIgnoreCase("area")){
						if(!DwarfCraft.Permissions.has(player, "DwarfCraft.basic"))messaging.zonesAtPlayer(player, playerInput);
						else player.sendMessage("You don't have permission to use this command");
	
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

	/**
	 * This listener catches when a player joins the server. If they are a new player, they are initialized as a level 0 Dwarf. 
	 * 
	 * Players are greeted with their race and TODO level.
	 * 
	 * If maximum player number is reached, this method will crash and burn into a fiery orgy of death and burning.
	 */
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
			player.sendMessage(Colors.Yellow+"*        *read /dc rules and /dc info*          *");
		}
		else {
			if(Training.isPlayerElf(player)){
				player.sendMessage("Welcome, "+Colors.Gray+ "elf " +Colors.DarkPurple + playerName);
				//welcome elf, may you die often due to your unskilled nature
			}
			else{
				player.sendMessage("Welcome, "+Colors.DarkPurple+ "dwarf " +Colors.DarkPurple + playerName);
				//print to screen "welcome dwarf whatever of playerskilllevel whatever"
			}
		 }
	 }
	
	/**
	 * Catches Food eating events and adjusts health gained to reflect skill values.
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
		
	/**
	 * catch crafting
	 * TODO
	 */
//	@Override
//	public void onInventoryClick(InventoryClickEvent event){
//		
//	}
}
	
