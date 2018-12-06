package com.log4J.fileappender;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

public class NewFileRebootAppender extends FileAppender{

	public NewFileRebootAppender() {
		
	}

	@Override
	public void setFile(String file) {
		// TODO Auto-generated method stub
		super.setFile(prependFileDate(file));
	}
	
	private static String prependFileDate(String file) {
		SimpleDateFormat sdf	=	new SimpleDateFormat("yyyy-MM-dd");
		return file+"_"+sdf.format(new Date(System.currentTimeMillis()));
	} 
	
}
