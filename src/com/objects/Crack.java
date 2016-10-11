package com.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;

public class Crack extends gameObject{
Handler h=Display.handler;
	public Crack(float x, float y, objectID id) {
		super(x-5, y-15, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<gameObject> object) {
		// TODO Auto-generated method stub
		collision();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		g.fillOval((int)x,(int) y, 10, 20);
		//g.setColor(Color.magenta);
		//g.drawRect((int)x, (int)y, 20, 20);

		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.magenta);
		g2d.drawRect((int)x, (int)y, 10, 20);  //plz updat		
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
		h.runAllCodetoID(h.new execute(objectID.PlayerBullet){
			@Override
			void executecode() {
				if(tempObject.getBounds().intersects(getBounds())){
					h.removeObject(tempObject);
				}
			}
			
			
		});
		
	}


}
