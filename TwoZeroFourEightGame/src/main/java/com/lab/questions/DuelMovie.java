package com.lab.questions;

import com.lab.questions.GunSlinger;
import com.lab.questions.Camera;

public class DuelMovie {

	
	GunSlinger	g1,g2;
	Camera      c1,c2;
	
	public DuelMovie() {
		g1	=	new GunSlinger("Lee vanCleef");
		g2	=	new GunSlinger("John Wayne");
		
		c1	=	new Camera(g1);
		c2	=	new Camera(g2);
		
		g1.addObserver(c1);
		g2.addObserver(c2);
	}
	
	public static void main(String[] args) {
		DuelMovie obj	=	new DuelMovie();
		obj.workMethod();
	}
	
	public void workMethod() {
		g1.setTarget(g2);
		g2.setTarget(g1);
		g1.blink();
		g2.shoot();
	}
}
