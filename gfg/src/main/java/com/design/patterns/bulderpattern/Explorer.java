package com.design.patterns.bulderpattern;

public class Explorer {

	private ShelterBuilder shelterBuilder;
	
	public void setShelterBuilder(ShelterBuilder shelterBuilder) {
		this.shelterBuilder		=	shelterBuilder;
	}
	
	public void constructShelter() {
		shelterBuilder.createNewShelter();
		shelterBuilder.buildStructure();
		shelterBuilder.buildRoof();
		shelterBuilder.buildFloor();
		
		
	}
	
	public Shelter getShelter() {
		return shelterBuilder.getShelter();
	}
}
