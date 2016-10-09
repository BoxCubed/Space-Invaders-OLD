package com.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.objects.Handler;
import com.objects.PlayerBullet;

public class keyListener extends KeyAdapter{
	
	Handler handler;
	long timer;
	
	public keyListener(Handler handler){
		this.handler=handler;
	}
	public void keyPressed(KeyEvent e){
		int key=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++){
			if(key==KeyEvent.VK_ESCAPE){System.exit(1);}
			if(key==KeyEvent.VK_T){timer=System.currentTimeMillis();}
			gameObject tempObject = handler.object.get(i);
			if(tempObject.getID()==objectID.Player){
				if(key==KeyEvent.VK_RIGHT){tempObject.setVelX(5);}
				if(key==KeyEvent.VK_LEFT){tempObject.setVelX(-5);}
				
			}
			
			if(tempObject.getID()==objectID.Alien){
				if(key==KeyEvent.VK_NUMPAD1){tempObject.setVelX(2);}
				if(key==KeyEvent.VK_NUMPAD2){tempObject.setVelY(2);}   //controls for alien simulator 2016
				if(key==KeyEvent.VK_NUMPAD3){tempObject.setVelX(-2);}
		}
		}
	}
	public void keyReleased(KeyEvent e){
		int key=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++){
			gameObject tempObject = handler.object.get(i);
			if(key==KeyEvent.VK_T){long elapsed=System.currentTimeMillis()-timer; System.out.println(elapsed);}
			if(tempObject.getID()==objectID.Player){
				if(key==KeyEvent.VK_LEFT){tempObject.setVelX(0);}
				if(key==KeyEvent.VK_RIGHT){tempObject.setVelX(0);}
			}
			if(tempObject.getID()==objectID.Alien){
				if(key==KeyEvent.VK_NUMPAD1){tempObject.setVelX(0);}
				if(key==KeyEvent.VK_NUMPAD2){tempObject.setVelY(0);}
				if(key==KeyEvent.VK_NUMPAD3){tempObject.setVelX(0);}
		}
			if(tempObject.getID()==objectID.Player){
				if(key==KeyEvent.VK_SPACE){
					handler.addObject(new PlayerBullet(tempObject.getX()+27,
							tempObject.getY()-15,objectID.PlayerBullet));
			}
			}
			if(tempObject.getID()==objectID.PlayerBullet){
				if(key==KeyEvent.VK_SPACE){tempObject.setVelY(-5);}
			}
		}
	}
}
