
package com.objects;

import java.awt.Graphics;
import java.util.LinkedList;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;
import com.listeners.CollisionListener;
import com.objects.Handler.execute;

public class Handler {
	public static int alienBulletCount;
	public LinkedList<gameObject> object = new LinkedList<gameObject>();
	public LinkedList<CollisionListener> clistener=new LinkedList<CollisionListener>();
	private gameObject tempObject;
	private CollisionListener tempListener;
	
	public void tick(){
		for(int i=0; i<object.size();i++){
			tempObject=(object.get(i));
			tempObject.tick(object);
		}
		for(int i=0; i<clistener.size();i++){
			tempListener=(clistener.get(i));
			tempListener.tick(object);
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
	public LinkedList<gameObject> getAllObjectsbyID(objectID id) throws NullPointerException{
		LinkedList<gameObject> list=new LinkedList<gameObject>();
		for(int i=0;i<Display.handler.object.size();i++){
			gameObject tempObject = Display.handler.object.get(i);
			if(tempObject.getID()==id) {
				list.add(tempObject);
			}
			
		}
		if(list.isEmpty()) throw new NullPointerException("No results were found for ID: "+id);
		else return list;
		
		
		
	}
	public void runAllCodetoID(execute ex){
		
	}
	
	class execute{
		objectID id;
		gameObject tempObject;
		
		public execute(objectID id) {
			// TODO Auto-generated constructor stub
			this.id=id;
			
			for(int i=0;i<Display.handler.object.size();i++){
				gameObject tempObject = Display.handler.object.get(i);
				this.tempObject=tempObject;
				if(tempObject.getID()==id) {
					executecode();
				}}
				
		}
		void executecode(){
			throw new NullPointerException("No code to run given!");
		}
		
	}
	

}

