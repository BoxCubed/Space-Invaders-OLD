package com.framework;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sound{
public static void main(String[]args){
	File file_LOCATION = new File ("src/laser.wav");
	playSOund(file_LOCATION);
}
static void playSOund(File Sound){
	try{
		Clip audio_player = AudioSystem.getClip();
		audio_player.open(AudioSystem.getAudioInputStream(Sound));
		audio_player.start();
		
		Thread.sleep(audio_player.getMicrosecondLength()/1000);
		audio_player.stop();
		audio_player.close();
	}catch(Exception e){
	}
}
}
