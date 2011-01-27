package com.smartaleq.bukkit.dwarfcraft;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


public class Inventory {

	/**
	 * Counts number of an item in a player's inventory across all stacks
	 * 
	 * @param inventory
	 * @param itemId
	 * @return int Total item number
	 */
	static public int countItem(PlayerInventory inventory,int itemId) {
		int itemCount = 0;
		ItemStack[] items = inventory.getContents();
		for(int i=0; i < items.length; i++){
			if(items[i].getTypeId() == itemId){
				itemCount += items[i].getAmount();
			}
		}
		return itemCount;
	}

	/**
	 * Removes a number of a particular item from a player's inventory across all stacks.
	 * Begins with slot 1 for item removal (quickbar left)
	 * 
	 * TODO Reverse slot removal order, check armor slots
	 * 
	 * @param inventory
	 * @param itemId
	 * @param amount
	 */
	static public void removeInventoryItems(PlayerInventory inventory, int itemId, int amount){
		ItemStack[] items = inventory.getContents();
		int amountLeft = amount;
			Loop1: for(int i=0; i < items.length; i++){
				if(items[i].getTypeId() == itemId){
					if(items[i].getAmount() > amountLeft){
						items[i].setAmount(items[i].getAmount()-amountLeft);
						inventory.setContents(items);
						break Loop1;
						
					}
					else if(items[i].getAmount() == amountLeft){
						inventory.setContents(items);
						inventory.remove(items[i]);
						break Loop1;
					}
					else {
						amountLeft = amountLeft - items[i].getAmount();
						inventory.remove(items[i]);
					}
				}
			}
		;
	}
	
	
}
