package com.lab.questions;
import java.util.Observable;

public class ClockTimerModel extends Observable{

	private int hour,min,sec;
	public	int getHour() {
		return hour;
	}
	public	int getMins() {
		return min;
	}
	public	int getSecs() {
		return sec;
	}
	
	void tick() {
		sec++;
		if (sec >= 60) {
			min++;
			sec = 0;
			if (min >= 60) {
				hour++;
				min = 0;
			}
			if (hour >= 24) {
				hour = 0;
			}
		}
		setChanged();
		notifyObservers(this);
	}
	
	void start(int sec) {
		
		for(int i=0;i<sec;i++) {
			tick();
		}
	}
	
}
