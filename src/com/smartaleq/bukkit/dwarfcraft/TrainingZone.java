package com.smartaleq.bukkit.dwarfcraft;

public class TrainingZone extends Zone {

	String school;
	TrainingZone(
			int lowerX, 
			int upperX, 
			int lowerY, 
			int upperY, 
			int lowerZ,
			int upperZ,
			String school) {
		super(lowerX, upperX, lowerY, upperY, lowerZ, upperZ);
		this.school = school;
	
	}

}

