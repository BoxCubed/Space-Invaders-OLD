package com.objects;

import java.util.Timer;
import java.util.TimerTask;

import com.framework.gameObject;


public class PathAlien {
	Timer t = new Timer();
	public void moveRight(gameObject object,int delay,int delay2){
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				t.schedule(new TimerTask() {
					@Override
					public void run() {					
				    	object.setVelX(0);
					}
				}, delay2);
		    	object.setVelX(1);
			}
		}, delay);	
	}
	
	
	public void moveLeft(gameObject object,int delay,int delay2){
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				t.schedule(new TimerTask() {
					@Override
					public void run() {					
				    	object.setVelX(0);
					}
				}, delay2);
		    	object.setVelX(-1);
			}
		}, delay);		
	}
	public void moveDown(gameObject object,int delay,int delay2){
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				t.schedule(new TimerTask() {
					@Override
					public void run() {					
				    	object.setVelY(0);
					}
				}, delay2);
		    	object.setVelY(1);
			}
		}, delay);		
	}

}
