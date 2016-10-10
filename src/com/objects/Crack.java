package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.framework.gameObject;
import com.framework.objectID;

public class Crack extends gameObject{

	public Crack(float x, float y, objectID id) {
		super(x-5, y-15, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<gameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillOval((int)x,(int) y, 20, 20);
		//g.setColor(Color.magenta);
		//g.drawRect((int)x, (int)y, 20, 20);
		
		
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,20,20);
	}

	@Override
	public objectID getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void halt() {
		// TODO Auto-generated method stub
		
	}


}
