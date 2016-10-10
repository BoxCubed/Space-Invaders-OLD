package com.objects;

import java.awt.Graphics;
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
int counter=0;
	
	public Shield(float x, float y, objectID id) {
		super(x, y, id);
		
	}
	public void render(Graphics g) {
	g.drawImage(tex.shield[0],(int)x,(int)y,null);
		
		//Graphics2D g2d = (Graphics2D)g;
		
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
	public void hit(){
		counter++;

		if(counter==20){
			Display.handler.removeObject(this);
		}
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
	public boolean isHit(){
		if (counter==0) return false;
		else return true;
		
	}
	@Override
	public void halt() {
		// TODO Auto-generated method stub
		Display.handler.runAllCodetoID(Display.handler.new execute(objectID.Crack){
			
			@Override
			void executecode() {
				// TODO Auto-generated method stub
				if(getBounds().intersects(tempObject.getBounds())) tempObject.halt();
			}
			
		});
		
	}


}
