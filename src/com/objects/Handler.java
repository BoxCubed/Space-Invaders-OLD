
package com.objects;

import java.awt.Graphics;
import java.util.LinkedList;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;

public class Handler {
	public static int alienBulletCount;
	public LinkedList<gameObject> object = new LinkedList<gameObject>();
	private gameObject tempObject;
	
	public void tick(){
		for(int i=0; i<object.size();i++){
			tempObject=(object.get(i));
			tempObject.tick(object);
		}
		
	}
	public synchronized void render(Graphics g){
		for(int i=0; i<object.size();i++){
			tempObject=object.get(i);
			tempObject.render(g);
		}
	}
	public synchronized void addObject(gameObject object){
		this.object.add(object);
	}
	public synchronized void removeObject(gameObject object){
		object.halt();
		this.object.remove(object);
	}

}

