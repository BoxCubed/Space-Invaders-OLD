package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;
import com.framework.checkWin;



public class PlayerBullet extends gameObject {
	int width=4;
	int height=10;
	checkWin c;
	public PlayerBullet(int x, int y, objectID id) {
		super(x, y, id);
		c = new checkWin();
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
	
	private void collision(LinkedList<gameObject> object){
		for(int i=0;i<Display.handler.object.size();i++){
			
			gameObject tempObject = Display.handler.object.get(i);
			if(tempObject.getID()==objectID.PlayerBullet){
				if(getY()<-5){Display.handler.removeObject(this);}
			}
			if(tempObject.getID()==objectID.Alien){
		
				if(getBounds().intersects(tempObject.getBounds())){
						Display.handler.removeObject(tempObject);;
						Display.handler.removeObject(this);
						checkWin.alienNumber--;
				}
			}

			if(tempObject.getID()==objectID.PlayerBullet){
				if(getY()<-5){Display.handler.removeObject(this);}
			}

		}
			}
		
			
	

	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,(int)width,(int)height/3);
	}

	@Override
	public void halt() {
		// TODO Auto-generated method stub
		
	}
	
}
