package com.design.patterns.bulderpattern;

public abstract class ShelterBuilder {

	protected Shelter shelterProduct;
	
	
	public ShelterBuilder() {
		// TODO Auto-generated constructor stub
	}
	
//	public void setShelter(Shelter shelterProduct) {
//		this.shelterProduct	=	shelterProduct;
//	}
	
	public void createNewShelter() {
		shelterProduct	=	new Shelter();
	}
	
	public Shelter getShelter() {
		return this.shelterProduct;
	}
	
	public abstract void buildRoof();
	
	public abstract void buildStructure();
	
	public abstract void buildFloor();
}
