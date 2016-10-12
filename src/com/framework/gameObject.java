
package com.framework;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.objects.Alien;
import com.objects.Crack;
import com.objects.Player;
import com.objects.PlayerBullet;
import com.objects.Shield;

public abstract class gameObject {
	
	protected int x,y;
	protected objectID id;                         //Note: protected means something that can only be accessed by its package buddies (classes)
	protected int velX=0, velY=0;
	protected int width;
	protected int height;
	
	public gameObject(int x, int y, objectID id){
		this.x = x;
		this.y = y;
		this.id = id;
		if(this instanceof Alien) id=objectID.Alien;
		if(this instanceof PlayerBullet)id=objectID.PlayerBullet;
		if(this instanceof Shield)id=objectID.Shield;
		if(this instanceof Player)id=objectID.Player;
		if(this instanceof Crack)id=objectID.Crack;
	}
	
	public abstract void tick(LinkedList<gameObject> object);     //A Linked List is a list that does not have a fixed amount of data like an Array
	public abstract void render(Graphics g);                    //renders object using graphics 'g'?
	public abstract Rectangle getBounds();
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int x){
		this.x=x;
	}               
	public void setY(int y){
		this.y=y;
	}                       
	public int getVelX(){
		return velX;
	}
	public int getVelY(){
		return velY;
	}
	public void setVelX(int velX){
		this.velX=velX;
	}
	public void setVelY(int velY){
		this.velY=velY;
	}

	public abstract objectID getID();
	public abstract void halt();
}

