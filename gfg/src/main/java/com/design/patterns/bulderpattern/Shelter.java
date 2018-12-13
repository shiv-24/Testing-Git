package com.design.patterns.bulderpattern;

public class Shelter {

	private String roof, floor, structure;

	public void setRoof(String roof) {
		this.roof = roof;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String toString() {
		return "Structure is " + this.structure + " :: " + "Roof is " + this.roof + " :: " + "Floor is " + this.floor;
	}
}
