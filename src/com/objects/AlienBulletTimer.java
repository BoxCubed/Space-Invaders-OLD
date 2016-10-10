package com.objects;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.display.Display;
import com.framework.gameObject;
import com.framework.objectID;

public class AlienBulletTimer {
	
Timer t;
Random r;
int i=0;

public AlienBulletTimer(){
	r = new Random();
	t = new Timer();
}	
public void start(){
	int time = r.nextInt(7000)+5000;
		t.schedule(new TimerTask(){
			public void run() {
				for(int i=0;i<Display.handler.object.size();i++){
					gameObject tempObject = Display.handler.object.get(i);
					if(tempObject.getID()==objectID.Alien){
						AlienBullet ab = new AlienBullet((int)tempObject.getX(), (int)tempObject.getY(), objectID.AlienBullet);
						Display.handler.addObject(ab);
						i++;
					}
					
				
				
			}
			}
		},time);
		
}
public void stop(){
	t.cancel();
}

public void countReset(){
	Handler.alienBulletCount=0;
}

}
