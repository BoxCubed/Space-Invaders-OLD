package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.display.Display;
import com.framework.Texture;
import com.framework.gameObject;
import com.framework.objectID;

public class Shield extends gameObject{
int width = 80;
int height = 45;
Texture tex = Display.getInstance();
	
	public Shield(float x, float y, objectID id) {
		super(x, y, id);
		
	}
	public void render(Graphics g) {
	g.drawImage(tex.shield[0],(int)x,(int)y,null);
		
		Graphics2D g2d = (Graphics2D)g;
		
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}
	public void tick(LinkedList<gameObject> object) {
		x+=velX;
		
		collision(object);
	}
	
	private void collision(LinkedList<gameObject> object){
		
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x=x;
		
	}

	public void setY(float y) {
		this.y=y;
		
	}

	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelX(float velX) {
		this.velX=velX;
		
	}

	public void setVelY(float velY) {
		this.velY=velY;
	}

	public objectID getID() {
		return id;
	}


}
