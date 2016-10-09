package com.framework;

import java.awt.image.BufferedImage;

import com.display.BufferedImageLoader;

public class Texture {

	SpriteSheet as,ps;
	private BufferedImage aliensheet;
	private BufferedImage playersheet;
	
	public BufferedImage[] alien = new BufferedImage[2];
	public BufferedImage[] player = new BufferedImage[2];
	public BufferedImage[] shield = new BufferedImage[1];
	
	public Texture(){
		BufferedImageLoader imgloader=new BufferedImageLoader();
		try{
			aliensheet=imgloader.loadImage("/ss1.png");
			playersheet=imgloader.loadImage("/ps.png");
		}catch(Exception e){e.printStackTrace();}
		
		
		as = new SpriteSheet(aliensheet);
		ps = new SpriteSheet(playersheet);
		
		getTextures();
	}
	
	private void getTextures(){
		alien[0]=as.getImage(1, 1, 40, 38);
		alien[1]=as.getImage(2, 1, 40, 38);
		player[0]=ps.getImage(1, 1, 55, 38);
		player[1]=ps.getImage(2, 1,57, 38);
		shield[0]=ps.getImage(1, 2, 90, 45);
	}
}
