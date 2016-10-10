package com.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.framework.gameObject;
import com.framework.objectID;

public class Crack extends gameObject{

	public Crack(float x, float y, objectID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<gameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.fillOval((int)x,(int) y, 10, 10);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public objectID getID() {
		// TODO Auto-generated method stub
		return id;
	}


}
