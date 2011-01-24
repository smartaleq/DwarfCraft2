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
	 @SuppressWarnings("unused")
	private final DwarfCraft plugin;
	 
	 public DCBlockListener(final DwarfCraft plugin) {
	     this.plugin = plugin;
	 }
	 
	 public void onBlockDamage(BlockDamageEvent event)
	{
		if (event.getDamageLevel() == org.bukkit.block.BlockDamageLevel.BROKEN && !event.isCancelled())
		{	
			/* 
			 * capture data about destroyed block
			 */
			Block block = event.getBlock();
			Location destroyedBlockLocation = new Location(event.getBlock().getWorld(), event.getBlock().getX(), event.getBlock().getY(), event.getBlock().getZ(), 0, 0);
			int destroyedBlockType = block.getTypeId();
			Player player = event.getPlayer();
			/* 
			 * check to see if block destroyed has itemdrop effects listed
			 */
			List<SkillEffects> applicableEffects = SkillEffects.getEffectsForItemIdAndType(destroyedBlockType, "itemdrop");
			if (applicableEffects.size() == 0)
				return;

			//replace block with air and drop appropriate results
			event.setCancelled(true); 	
			block.setType(Material.AIR);
			for(SkillEffects se : applicableEffects) {
			    int playerSkillLevel;
			    if(SkillLevels.isPlayerElf(player)){
				playerSkillLevel = se.elfEffectLevel;
			    }
			    else {
				playerSkillLevel = SkillLevels.getSkillLevel(se.getSkillForEffect(), player);
			    }					
			    if (/* Output Block*/ se.createdItemId > 0){
				event.getBlock().getWorld().dropItem(
								     destroyedBlockLocation,
								     new ItemStack(
										   // Output Block
										   se.createdItemId,
										   // Output Count
										   se.getRandomBlockCount(playerSkillLevel),
										   // OutputDamage
										   (byte)0
										   )
								     );
			    }
			}
		}
	}
}
