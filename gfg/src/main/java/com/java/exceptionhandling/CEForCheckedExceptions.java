package com.java.exceptionhandling;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.log4J.fileappender.LoggerObjectClass;

public class CEForCheckedExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private static final Logger log = LoggerObjectClass.getLoggerObject();

//	public CEForCheckedExceptions(String message) {
//		super(message);
//		this.message = message;
//		log.error(message);
//
//	}
	
//	public CEForCheckedExceptions() {
//		// TODO Auto-generated constructor stub
//		SimpleDateFormat sdf	=	new SimpleDateFormat("yyyyMMdd :HH mm ss");
//		message	=	sdf.format(System.currentTimeMillis());
//	}

	@Override
	public String getMessage() {
		return "Exception occured At" + this.message;
	}

}
