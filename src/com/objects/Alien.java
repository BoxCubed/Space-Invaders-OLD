
package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import java.util.Timer;
import java.util.TimerTask;

import com.display.Display;
import com.framework.Texture;
import com.framework.gameObject;
import com.framework.objectID;



public class Alien extends gameObject{
	int width=20;
	int height=20;
	
	private int type;
	
	Timer t;
	
	PathAlien p;
	
	Texture tex = Display.getInstance();
	
	public Alien(int x, int y, objectID id,int type) {
		super(x, y, id);
		t=new Timer();
		p = new PathAlien();
		this.type=type;
		path();
	}
	
	public void render(Graphics g) {
		if(type==0){
			g.drawImage(tex.alien[0], (int)x, (int)y, null);
		}
		if(type==1){
			g.drawImage(tex.alien[1], (int)x, (int)y, null);
		}
		
		//Graphics2D g2d = (Graphics2D)g;

	}

	public void tick(LinkedList<gameObject> object) {
		x+=velX;
		y+=velY;
		
	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x=x;
	}

	public void setY(int y) {
		this.y=y;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelX(int velX) {
		this.velX=velX;
	}

	public void setVelY(int velY) {
		this.velY=velY;
	}

	public objectID getID() {
		return id;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x+8,(int)y+5,(int)width+5,(int)height);
	}
	
	public void path(){
		p.moveRight(this, 100,7000);
		p.moveDown(this, 7100,300);
		p.moveLeft(this, 7400, 7000);
		p.moveDown(this, 14400, 300);
		p.moveRight(this, 14700,7000);
		p.moveDown(this, 21700,300);
		p.moveLeft(this, 22000, 7000);
		p.moveDown(this, 29000, 300);
		p.moveRight(this, 29300,7000);
		p.moveDown(this, 36300,300);
		p.moveLeft(this, 36600, 7000);
		p.moveDown(this, 43000, 300);
	}

	@Override
	public void halt() {
		// TODO Auto-generated method stub
		
	}
		
}

