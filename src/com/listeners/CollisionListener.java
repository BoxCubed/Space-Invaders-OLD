package com.listeners;

import java.io.File;
import java.util.LinkedList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;
/**
 * Listens for Collisions 
 * @author ryan9
 * {@code}
 * 
 * 
 *
 */
public class CollisionListener {
	gameObject ob1;
	objectID ob2;
	Events e=new Events();
	gameObject tempObject;
	public CollisionListener(gameObject ob1, objectID ob2, Events e){
		/*this.ob1=ob1;
		this.ob2=ob2;
		this.e=e;
		Display.handler.clistener.add(this);*/
		}
	/**
	 * 
	 * @author ryan9
	 * @
	 */
	public void tick(LinkedList<gameObject> object){
		
		for(int i=0;i<object.size();i++){
			 tempObject = object.get(i);
			if(tempObject.getID()==ob2){
				if(ob1.getBounds().intersects(tempObject.getBounds())){
				e.collisionEvent();
				    try {
				        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/MusicPlayer/fml.mp3").getAbsoluteFile());
				        Clip clip = AudioSystem.getClip();
				        clip.open(audioInputStream);
				        clip.start();
				    } catch(Exception ex) {
				        System.out.println("Error with playing sound.");
				    }
				}
			}
			if(tempObject.getID()==ob1.getID()){
				e.after();
			}
		}
		
		
	}
	int[] getCollisionPoint(){
		int[] i=new int[2];
	i[0]=(int)ob1.getX();
	i[1]=(int)ob1.getY();
	return i;
			
		}
	gameObject getCollisionObject(){
		return tempObject;
	}
	
	public class Events{
		
		public Events(){}

		void collisionEvent(){}
		void after(){}
		}
	
}
