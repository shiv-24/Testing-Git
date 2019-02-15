package com.lab.questions;

import java.util.Observer;
import java.util.Observable;
import com.lab.questions.GunSlinger;

public class Camera implements Observer{

	GunSlinger shooter;
	
	public Camera(GunSlinger slinger) {
		shooter	=	slinger;
	}

	public void showClip() {
		
		switch(shooter.getState()) {
		case "Duel": System.out.println(shooter.name+" : stands, tickly fingers");
					break;
		case "Blink": System.out.println(shooter.name+" : sweating, blinks");
					break;
		case "Dead": System.out.println(shooter.name+" : knees bend, falls dead");
					break;
		case "Shooting": System.out.println(shooter.name+" : lighting-fast shot");
					break;
		}
	}
	@Override
	public void update(Observable obj, Object x) {
		showClip();
	}
}
