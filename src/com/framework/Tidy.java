package com.framework;

import com.display.Display;
import com.objects.Alien;
import com.objects.Block;
import com.objects.Handler;
import com.objects.Player;
import com.objects.Shield;

public class Tidy {
	public void initTidy(){
		Display.handler = new Handler();
		
		Display.handler.addObject(new Player(280,580,objectID.Player,Display.handler));
		for(int i=-95;i<250;i+=50){
			Display.handler.addObject(new Alien(i,100,objectID.Alien,0));
		}
		for(int i=-100;i<245;i+=50){
			Display.handler.addObject(new Alien(i,150,objectID.Alien,0));
		}
		for(int i=-95;i<250;i+=50){
			Display.handler.addObject(new Alien(i,50,objectID.Alien,1));
		}
		for(int i=-100;i<245;i+=50){
			Display.handler.addObject(new Alien(i,200,objectID.Alien,1));
		}
		for(int i=45;i<480;i+=140){
			Display.handler.addObject(new Shield(i, 500, objectID.Shield));
		}
		Display.handler.addObject(new Block(-52, 560, objectID.Block));
		Display.handler.addObject(new Block(595, 560, objectID.Block));

	}

}
