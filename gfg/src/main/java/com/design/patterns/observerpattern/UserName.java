package com.design.patterns.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class UserName extends Observable{

	private String name;
	private Boolean ifNamePresent;
	private List<String>allUserNames;
	
	public UserName() {
		name	=	new String();
		ifNamePresent	=	false;
		allUserNames	=	new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Boolean getIfNameIsPresent() {
		return ifNamePresent;
	}
	
	public void setName(String name) {
		this.name	=	name;
		change();
	}
	
	
	public void change() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void setIfNameIsPresentOrNot(Boolean ifNamePresent) {
		this.ifNamePresent	=	ifNamePresent;
	}
	
	public void setAllUserNameList(List<String> allUserNames) {
		this.allUserNames	=	allUserNames;
	}
	
	public List<String> getAllUserNameLsit(){
		return this.allUserNames;
	}
}
