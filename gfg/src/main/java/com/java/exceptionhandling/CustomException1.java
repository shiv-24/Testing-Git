package com.java.exceptionhandling;

import java.io.PrintStream;

public class CustomException1 extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private static final Logger log	=	Logger.getLogger(Logger.class);
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		
//		log.error(s);
		super.printStackTrace(s);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}
