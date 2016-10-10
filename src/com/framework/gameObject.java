package com.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class gameObject {
	
	protected float x,y;
	protected objectID id;                         //Note: protected means something that can only be accessed by its package buddies (classes)
	protected float velX=0, velY=0;
	protected float width;
	protected float height;
	public int type;
	
	public gameObject(float x, float y, objectID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick(LinkedList<gameObject> object);     //A Linked List is a list that does not have a fixed amount of data like an Array
	public abstract void render(Graphics g);                    //renders object using graphics 'g'?
	public abstract Rectangle getBounds();
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public void setX(float x){
		this.x=x;
	}               
	public void setY(float y){
		this.y=y;
	}                       
	public float getVelX(){
		return velX;
	}
	public float getVelY(){
		return velY;
	}
	public void setVelX(float velX){
		this.velX=velX;
	}
	public void setVelY(float velY){
		this.velY=velY;
	}

	public abstract objectID getID();
}
