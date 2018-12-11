package com.java.exceptionhandling;

import org.apache.log4j.Logger;

import com.log4J.fileappender.LoggerObjectClass;

public class CEForUncheckedExceptions extends RuntimeException {

	private String message;
	private static Logger log = LoggerObjectClass.getLoggerObject();

	public CEForUncheckedExceptions(String errorMessage, Throwable err) {
		super(errorMessage, err);
		this.message = errorMessage;
		log.error(errorMessage, err);
	}

	@Override
	public String getMessage() {
		return "Exception occured because " + this.message;
	}
}
