package com.practice.game;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

public class DrawUtils {

	private DrawUtils() {}
	
	public static int getMessageWidth(String message, Font font, Graphics2D g ) {
		
		g.setFont(font);
		Rectangle2D bound	=	g.getFontMetrics(font).getStringBounds(message, g);
		return (int)bound.getWidth();
	}
	
	public static int getMessageHeight(String message, Font font, Graphics2D g ) {
		
		g.setFont(font);
		if(message.length()==0)return 0;
		TextLayout tl	=	new TextLayout(message, font, g.getFontRenderContext());
		return (int)tl.getBounds().getHeight();
	}
}
