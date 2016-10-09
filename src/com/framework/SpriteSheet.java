package com.framework;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage img;
	
	public SpriteSheet(BufferedImage img){
		this.img=img;
	}
	
	public BufferedImage getImage(int col, int row, int width, int height){
		BufferedImage image = img.getSubimage((col*width)-width,(row*height)-height,width,height);
		return image;
	}
}
