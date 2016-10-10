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

public class Player extends gameObject{
	float width=50;
	float height=20;
	
	private Handler handler;
	Texture tex = Display.getInstance();
	
	public Player(float x,float y, objectID id, Handler handler) {
		super(x, y, id);
		this.handler=handler;
		System.out.println("Created New Player at X: "+x+" Y: "+y+" id="+id);
	}

	public void render(Graphics g) {                         //METHODS GALORE BOIIIIIIIIISSSSSSSSSSSSSSSSS!!!
		//g.setColor(Color.BLUE);
		//g.fillRect((int)x, (int)y, (int)width, (int)height);
		//g.fillRect((int)x+21, (int)y-4, 8, 8);
		
		if(this.type==0){
			g.drawImage(tex.player[0],(int)x, (int)y, null);
		}
		
		if(this.type==1){
			g.drawImage(tex.player[1],(int)x, (int)y, null);
		}
		
		Graphics2D g2d = (Graphics2D)g;
		
		g.setColor(Color.MAGENTA);
		g2d.draw(getBounds());
		//g2d.draw(getBoundsRight());
		//g2d.draw(getBoundsLeft());
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x+4,(int)y+5,(int)width,(int)height);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int) ((int)x+width-5),(int)y,(int)5,(int)height);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x,(int)y,(int)5,(int)height);
	}

	public void tick(LinkedList<gameObject> object) {
		x+=velX;
		
		collision(object);
	}
	
	private void collision(LinkedList<gameObject> object){
		for(int i=0;i<handler.object.size();i++){
			gameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==objectID.Block){
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x = tempObject.getX()-width;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds())){
					x = tempObject.getX()+width;
				}
			}
			if(tempObject.getID()==objectID.AlienBullet){
				if(getBounds().intersects(tempObject.getBounds())){
					this.type=1;
				}
			}
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

	
}
