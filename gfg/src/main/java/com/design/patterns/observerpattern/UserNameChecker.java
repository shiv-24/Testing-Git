package com.design.patterns.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class UserNameChecker implements Observer{

	List<String> allNames	=	new ArrayList<>();
	String userName;
	
	@Override
	public void update(Observable o, Object arg) {
		UserName obj	=	(UserName)o;
		
		userName	=	obj.getName();
		if(allNames.contains(userName)) {
			obj.setIfNameIsPresentOrNot(true);
		}else if(obj.getIfNameIsPresent()!=false){
			allNames.add(userName);
			obj.setIfNameIsPresentOrNot(false);
		}
		obj.setAllUserNameList(allNames);
	}

	
	
}
