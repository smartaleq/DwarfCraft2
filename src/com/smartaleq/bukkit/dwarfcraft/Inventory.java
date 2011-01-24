package com.smartaleq.bukkit.dwarfcraft;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;


public class Inventory {


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

	static public void removeInventoryItems(PlayerInventory inventory, int itemId, int amount){
		ItemStack[] items = inventory.getContents();
		int amountLeft = amount;
			for(int i=0; i<100; i++){
				if(items[i].getTypeId() == itemId){
					if(items[i].getAmount() > amountLeft){
						items[i].setAmount(items[i].getAmount()-amountLeft);
						break;
						
					}
					else if(items[i].getAmount() == amountLeft){
						inventory.remove(items[i]);
						break;
					}
					else {
						amountLeft = amountLeft - items[i].getAmount();
						inventory.remove(items[i]);
					}
				}
			}
		inventory.setContents(items);
	}
}
