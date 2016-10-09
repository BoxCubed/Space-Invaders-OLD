package com.main;

import javax.swing.JFrame;

import com.display.Display;

public class mainclass {
	public static void main(String[] args) {
		Display d = new Display();
		JFrame f = new JFrame();
		f.add(d);
		f.pack();
		f.setSize(600,660);
		f.setLocation(350, 50);
		f.setTitle("Space Invaders: Now with sprites!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
		d.start();
	}

}
