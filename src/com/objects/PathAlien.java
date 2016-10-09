package com.objects;

import java.util.Timer;
import java.util.TimerTask;

import com.framework.gameObject;

public class PathAlien {
	public void moveRight(gameObject object, Timer t,int delay,int delay2){
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
	
	
	public void moveLeft(gameObject object,Timer t,int delay,int delay2){
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
	public void moveDown(gameObject object,Timer t,int delay,int delay2){
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
