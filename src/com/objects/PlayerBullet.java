package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;



public class PlayerBullet extends gameObject {
	float width=4;
	float height=10;
	
	public PlayerBullet(float x, float y, objectID id) {
		super(x, y, id);
	}

	public void render(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect((int)x,(int)y,(int)width,(int)height);
			
			Graphics2D g2d = (Graphics2D)g;
			//g.setColor(Color.MAGENTA);
			//g2d.draw(getBounds());
	}

	public void tick(LinkedList<gameObject> object) {
		x+=velX;
		y+=velY;
		
		collision(object);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
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
	
	private void collision(LinkedList<gameObject> object){
		for(int i=0;i<Display.handler.object.size();i++){
			gameObject tempObject = Display.handler.object.get(i);
			if(tempObject.getID()==objectID.Alien){
				if(getBounds().intersects(tempObject.getBounds())){
					Display.handler.removeObject(tempObject);;
					Display.handler.removeObject(this);
				}
			}
			if(tempObject.getID()==objectID.PlayerBullet){
				if(getY()<-5){Display.handler.removeObject(this);}
			}
			if(tempObject.getID()==objectID.Shield){
				if(getBounds().intersects(tempObject.getBounds())){
				Shield shield=(Shield) tempObject;
				shield.hit();
				Display.handler.removeObject(this);
				}
			}
		}
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height/3);
	}
}
