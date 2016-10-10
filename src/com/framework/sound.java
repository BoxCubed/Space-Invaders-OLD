package com.framework;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sound {
	public void playSound(String sound) {
		  AudioInputStream audioInputStream = null;
	    try {if(sound.equals("shoot"))
	        audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Desktop/shooting.mp3").getAbsoluteFile());
	        Clip popplayer = AudioSystem.getClip();
	        popplayer.open(audioInputStream);
	        popplayer.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
}
