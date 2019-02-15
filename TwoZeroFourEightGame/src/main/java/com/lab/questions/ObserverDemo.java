package com.lab.questions;
import java.util.Scanner;

public class ObserverDemo {

	ClockTimerModel clockObj;
	DigitalClockView viewObject;
	
	public ObserverDemo(){
		clockObj	=	new ClockTimerModel();
		viewObject	=	new DigitalClockView();
		clockObj.addObserver(viewObject);
	}
	
	public static void main(String[] args) {
		ObserverDemo obj	=	new ObserverDemo();
		
		obj.demo();
	}
	
	public void demo() {
		Scanner sc	=	new Scanner(System.in);
		int sec	=	sc.nextInt();
		clockObj.start(sec);
		sc.close();
	}
}
