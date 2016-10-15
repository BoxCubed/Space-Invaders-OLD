package com.framework;

import java.awt.Color;
import java.awt.Graphics;

import com.display.Display;

public class checkWin {
	public static int alienNumber=0;
	public void check(Graphics g){
		if(alienNumber==0){System.exit(1);}
	
		}
	public void addAlienCount(){
		alienNumber++;
	}
	public void decreaseAlienCount(){
		alienNumber--;
	}
	public int alienCount(){
		return alienNumber;
	}
	}

