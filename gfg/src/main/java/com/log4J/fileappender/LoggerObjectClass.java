package com.log4J.fileappender;

import org.apache.log4j.Logger;

public class LoggerObjectClass {

	private final static Logger log = Logger.getLogger(Logger.class);

	private LoggerObjectClass() {
	}

	public static Logger getLoggerObject() {
		synchronized (LoggerObjectClass.class) {
			return log;
		}

	}

}
