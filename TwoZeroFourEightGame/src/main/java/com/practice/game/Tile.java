package com.practice.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tile {

	public static final int WIDTH	=	100;
	public static final int HEIGHT	=	100;
	public static final int SLIDE_SPEED	=	20;
	public static final int ARC_WIDTH	=	15;
	public static final int ARC_HEIGHT	=	15;
	
	private int value;
	private BufferedImage tileImage;
	private Color background;
	private Color text;
	private Font font;
	private int x;
	private int y;
	
	public Tile(int vaue,int x, int y) {
		this.value=value;
		this.x=x;
		this.y=y;
		tileImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		drawImage();
		
	}
	
	public void drawImage() {
		Graphics2D g	=	(Graphics2D)tileImage.getGraphics();
		
		switch(value) {
		case 2: 
				background	=	Color.lightGray;
				text		=	Color.black;
				break;
		case 4:
				background	=	Color.pink;
				text		=	Color.black;
				break;
		case 8:
				background	=	Color.blue;
				text		=	Color.black;
				break;
		case 16:
				background	=	Color.cyan;
				text		=	Color.black;
				break;
		case 32:
				background	=	Color.green;
				text		=	Color.black;
				break;
		case 64:
				background	=	Color.magenta;
				text		=	Color.black;
				break;
		case 128:
				background	=	Color.orange;
				text		=	Color.black;
				break;
		case 256:
				background	=	Color.red;
				text		=	Color.black;
				break;
		case 512:
				background	=	Color.yellow;
				text		=	Color.black;
				break;
		case 1024:
				background	=	Color.black;
				text		=	Color.RED;
				break;
		case 2048:
				background	=	Color.WHITE;
				text		=	Color.black;
				break;
		default :
				background	=	Color.black;
				text		=	Color.WHITE;
				break;
		}
		
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(background);
		g.fillRoundRect(0, 0, WIDTH, HEIGHT, ARC_WIDTH, ARC_HEIGHT);
		
		g.setColor(text);
		
		if(value<=64) {
			font	= Font.getFont("30F");
		}else {
			font 	=	Font.getFont("40F");
		}
		g.setFont(font);
		
		int drawX	=	WIDTH/2- DrawUtils.getMessageWidth(""+value, font, g)/2;
		int drawY	=	HEIGHT/2+ DrawUtils.getMessageHeight(""+value, font, g)/2;
		
		g.drawString(""+value, drawX, drawY);
		g.dispose();
	}
}
