package com.java.exceptionhandling;

import org.apache.log4j.Logger;

import com.log4J.fileappender.LoggerObjectClass;

public class CEForCheckedExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private static final Logger log = LoggerObjectClass.getLoggerObject();

	public CEForCheckedExceptions(String message) {
		super(message);
		this.message = message;
		log.error(message);

	}

	@Override
	public String getMessage() {
		return "Exception occured because " + this.message;
	}

}
