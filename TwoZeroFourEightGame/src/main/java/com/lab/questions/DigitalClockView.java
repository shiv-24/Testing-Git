package com.lab.questions;

import java.util.Observer;
import java.util.Observable;
import com.lab.questions.ClockTimerModel;

public class DigitalClockView implements Observer{

	
	public void update(Observable o, Object x) {
//		System.out.println("Hour : Mins : Secs" );
		int hour	=	((ClockTimerModel)o).getHour();
		int min		=	((ClockTimerModel)o).getMins();
		int sec		=	((ClockTimerModel)o).getSecs();
		System.out.println(hour+" : "+min+" : "+sec);
	}
}
