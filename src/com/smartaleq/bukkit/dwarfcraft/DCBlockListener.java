package com.smartaleq.bukkit.dwarfcraft;

import java.util.*;
import org.bukkit.block.Block;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;



/*
 * This java file watches for broken blocks and passes info to SkillEffects
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

			//replace block with air and drop appropriate results
			event.setCancelled(true); 	
			block.setType(Material.AIR);
			for(SkillEffects se : applicableEffects) {
				
			    if (/* Output Block*/ se.createdItemId > 0){
			    	if(destroyedBlockType == 59 && data < 0x07) continue; //not fully grown crops drop NOTHING
			    	dropBlocks(player, destroyedBlockLocation, se, true);
		    	}
			}
		}
	 }

	 static void dropBlocks(Player player, Location location, SkillEffects skillEffect,boolean naturally){
		 ItemStack itemStack = new ItemStack(skillEffect.createdItemId,skillEffect.getRandomAmount(SkillEffects.getPlayerSkillLevel(player, skillEffect)));
		 if(naturally)plugin.getServer().getWorlds()[0].dropItemNaturally(location, itemStack);
		 else plugin.getServer().getWorlds()[0].dropItem(location, itemStack);
	 }
}
