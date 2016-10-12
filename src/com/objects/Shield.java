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
int counter=0;
static boolean destroyed=false;
	
	public Shield(int x, int y, objectID id) {
		super(x, y, id);
	}
	public void render(Graphics g) {
	g.drawImage(tex.shield[0],(int)x,(int)y,null);
		
	Graphics2D g2d = (Graphics2D)g;
	g.setColor(Color.MAGENTA);
	g2d.draw(getBounds());
	g2d.draw(getBoundsRight()[0]);
	g2d.draw(getBoundsRight()[1]);
	g2d.draw(getBoundsLeft()[0]);
	g2d.draw(getBoundsLeft()[1]);
	g2d.draw(getBoundsDown());
	}
	public Rectangle getBounds() {
		return new Rectangle((int)x+21,(int)y+6,(int)33,(int)3);
	}
	public Rectangle[] getBoundsRight(){
		Rectangle r = new Rectangle((int)x+53,(int)y+7,10,10);
		Rectangle r2 = new Rectangle((int)x+62,(int)y+11,10,10);
		Rectangle[] rightside = {r,r2};
		return rightside;
	}
	
	public Rectangle[] getBoundsLeft(){
		Rectangle r = new Rectangle((int)x+10,(int)y+7,10,10);
		Rectangle r2 = new Rectangle((int)x+4,(int)y+11,10,10);
		Rectangle[] leftside = {r,r2};
		return leftside;
	}
	public Rectangle getBoundsDown(){
		return new Rectangle(x,y+20,width-5,height-25);}
	
	public void tick(LinkedList<gameObject> object) {
		x+=velX;
		collision(object);
	}
	
	private void collision(LinkedList<gameObject> object){
		for(int i=0;i<Display.handler.object.size();i++){
			gameObject tempObject = Display.handler.object.get(i);
			if(tempObject.getID()==objectID.AlienBullet){
				if(tempObject.getBounds().intersects(getBounds())){
					hit();
					Display.handler.removeObject(tempObject);
					Display.handler.object.add(new Crack(tempObject.getX(), tempObject.getY(), objectID.Crack,0));
				}
				if(tempObject.getBounds().intersects(getBoundsRight()[0])){
					hit();
					Display.handler.removeObject(tempObject);
					Display.handler.object.add(new Crack(x, (int)y, objectID.Crack,1));
					
				}
				if(tempObject.getBounds().intersects(getBoundsRight()[1])){
					hit();
					Display.handler.removeObject(tempObject);
					Display.handler.object.add(new Crack(tempObject.getX()-5, tempObject.getY()+5, objectID.Crack,1));
					
				}
				if(tempObject.getBounds().intersects(getBoundsLeft()[0])){
					hit();
					Display.handler.removeObject(tempObject);
					Display.handler.object.add(new Crack(tempObject.getX()+5, tempObject.getY()+5, objectID.Crack,0));
				}
				if(tempObject.getBounds().intersects(getBoundsLeft()[1])){
					hit();
					Display.handler.removeObject(tempObject);
				Display.handler.object.add(new Crack(tempObject.getX(), tempObject.getY(), objectID.Crack,0));
				}
			}
			if(tempObject.getID()==objectID.PlayerBullet){
				if(tempObject.getBounds().intersects(getBoundsDown())){
					hit();
					Display.handler.removeObject(tempObject);
					Display.handler.addObject(new Crack(tempObject.getX(),tempObject.getY(),objectID.Crack,0));
				}
			}
		}
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
	
	public void halt() {
		
	}
	public void hit(){
		counter++;
		System.out.println(counter);
		if(counter==5){
			Shield.destroyed=true;
			System.out.println("remove");
			Display.handler.removeObject(this);
			counter=0;
		}
	}
	
	

}
