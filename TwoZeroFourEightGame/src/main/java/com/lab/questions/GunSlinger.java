package com.lab.questions;

import java.util.Observable;

public class GunSlinger extends Observable{

	String name,state;
	GunSlinger target;
	
	public GunSlinger(String newName) {
		name = newName;

	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String newState) {
		state	=	newState;
		setChanged();
		notifyObservers(this);
	}
	
	public void setTarget(GunSlinger newObj) {
		target	=	newObj;
		setState("Duel");
	}
	
	public void shot() {
		setState("Dead");
	}
	
	public void shoot() {
		setState("Shooting");
		target.shot();
	}
	public void blink() {
		setState("Blink");
	}
}
