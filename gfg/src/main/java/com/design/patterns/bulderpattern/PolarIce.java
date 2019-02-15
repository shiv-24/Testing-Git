package com.design.patterns.bulderpattern;

public class PolarIce extends ShelterBuilder{

	@Override
	public void buildRoof() {
		shelterProduct.setRoof("Ice");
		
	}

	@Override
	public void buildStructure() {
		// TODO Auto-generated method stub
		shelterProduct.setStructure("Ice Dome");
	}

	@Override
	public void buildFloor() {
		// TODO Auto-generated method stub
		shelterProduct.setFloor("Icy Ice");
	}

}
