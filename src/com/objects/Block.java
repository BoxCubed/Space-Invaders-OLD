package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.display.Display;
import com.framework.Texture;
import com.framework.gameObject;
import com.framework.objectID;

public class Block extends gameObject{
	Texture tex = Display.getInstance();
	
	public Block(float x, float y, objectID id) {
		super(x, y, id);
	}
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawRect((int)x,(int)y,50,50);
}

public void tick(LinkedList<gameObject> object) {
	x+=velX;
	y+=velY;
}

public objectID getID() {
	return id;
}

public Rectangle getBounds() {
	return new Rectangle((int)x,(int)y,50,50);
}

}
