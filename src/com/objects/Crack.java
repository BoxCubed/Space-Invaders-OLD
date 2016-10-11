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

public class Crack extends gameObject{
Texture tex = Display.getInstance();
Handler h=Display.handler;
private int type;
	public Crack(float x, float y, objectID id,int type) {
		super(x, y, id);
		this.type=type;
	}

	@Override
	public void tick(LinkedList<gameObject> object) {
		// TODO Auto-generated method stub
		collision();
	}

	@Override
	public void render(Graphics g) {
		if(type==1){g.drawImage(tex.crack[1],(int)x,(int)y,null);}
		if(type==0){;g.drawImage(tex.crack[0],(int)x,(int)y,null);}
		//g.setColor(Color.magenta);
		//g.drawRect((int)x, (int)y, 20, 20);

		
		Graphics2D g2d = (Graphics2D) g;
	
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,10,20);
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
	public void collision(){
		
	}
	public void hit(){
		for(int i=0; i<Display.handler.object.size();i++){
			gameObject tempObject = Display.handler.object.get(i);
		}
		
	}

}
