package com.smartaleq.bukkit.dwarfcraft;

import java.util.*;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;



/**
 * This listener watches for block events
 * currently: onBlockDamage results in skill-based drops
 * TODO: Fueling of forges
 * 
 */
public class DCBlockListener extends BlockListener {
	private static DwarfCraft plugin;
	 
	 public DCBlockListener(final DwarfCraft plugin) {
	     DCBlockListener.plugin = plugin;
	 }
		 
	 
	 public void onBlockDamage(BlockDamageEvent event){
		if (event.getDamageLevel() == org.bukkit.block.BlockDamageLevel.BROKEN && !event.isCancelled())
		{	
			/* 
			 * capture data about destroyed block
			 */
			Block block = event.getBlock();
			Location destroyedBlockLocation = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0, 0);
			int destroyedBlockType = block.getTypeId();
			Player player = event.getPlayer();
			byte data = block.getData();
			/* 
			 * check to see if block destroyed has itemdrop effects listed
			 */
			List<SkillEffects> applicableEffects = SkillEffects.getEffectsForType( "itemdrop",destroyedBlockType);
			if (applicableEffects.size() == 0)
				return;


			boolean blocksWereDropped = false;
			for(SkillEffects se : applicableEffects) {
				
			    if (/* Output Block*/ se.createdItemId > 0){
			    	if(destroyedBlockType == 59 && data < 0x06) continue; //Modified: crops at level 6 and 7 have full drops- encourage active farming
			    	for(int toolId : se.allowableTools){
			    		if (player.getItemInHand().getTypeId() == toolId || player.getItemInHand().getTypeId() == -1) {
					    	dropBlocks(player, destroyedBlockLocation, se, true);
					    	blocksWereDropped = true;
					    	break;
			    		}
			    	}
		    	}
			}
			//replace block with air and drop appropriate results
			if(blocksWereDropped){
				event.setCancelled(true); 	
				block.setType(Material.AIR);
			}
		}
	 }
	/**
	 * dropBlocks will create a new item stack at a location based on a particular skillEffect's drop profile
	 * @param naturally true for dropItemNaturally, false for dropItem
	 * @param player The player that caused the itemDrop
	 * @param skillEffect The player's skillEffect that determines type and quantity of drop
	 * @param location The location that the ItemStack is created at.
	 */
	 static void dropBlocks(Player player, Location location, SkillEffects skillEffect,boolean naturally){
		 int randomAmount = skillEffect.getRandomAmount(SkillEffects.getPlayerSkillLevel(player, skillEffect));
		 ItemStack itemStack = new ItemStack(skillEffect.createdItemId,randomAmount);
		 if(randomAmount == 0) return;
		 if(naturally)plugin.getServer().getWorlds()[0].dropItemNaturally(location, itemStack);
		 else plugin.getServer().getWorlds()[0].dropItem(location, itemStack);
	 }
}
