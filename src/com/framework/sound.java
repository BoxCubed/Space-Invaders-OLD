package com.framework;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
class MyClass extends Thread{
	/*public static void main(String[]args){
		File file_LOCATION = new File ("src/laser.wav");
		play_sound(file_LOCATION);
		
	}*/
	String s;
	File file_LOCATION;
	boolean loop;
	
	MyClass(String s,boolean i){
		this.s=s;
		this.loop=i;
		
	}
	public void run(){
		//if(!keyListener.mute){
		if(s.equals("shoot"))
		file_LOCATION = new File ("sounds/laser.wav");//LOCATION OF THE FILE IS CRUCIAL BECAUSE... DO u want sound or not??????
		if(s.equals("background"))
			file_LOCATION=new File("sounds/backgroundMusic.wav");
		//System.out.println("new sound thread started: Playing File: "+file_LOCATION.getName());
		do{
		try{
			Clip audio_player = AudioSystem.getClip(); 				//THIS S**T does the audio. DONT MESS WITH IT OR JAVA WILL F UP
			audio_player.open(AudioSystem.getAudioInputStream(file_LOCATION));
			audio_player.start();
			
			Thread.sleep(audio_player.getMicrosecondLength()/1000); //REMOVING a 0 from that just fixed everything ALL G 
			audio_player.stop();
			audio_player.close();
			//Thread.sleep(10); //I HOPE THIS WORKS
			//The is iufhjgf gsjf sajfgshjvf 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Sound Error: "+e.getMessage());
			e.printStackTrace();
		}finally{
			//System.out.println("finished music");
		}
		
	}while(loop);
		}}
//}
/**
 * 
 * @author ryan9
 * Plays a sound. Create a new instance to play a sound.
 *
 */
public class sound{
	MyClass myclass;
/**
 * 
 * @param soundFile
 * The sound to play
 * @param loop
 * Whether to loop the sound for the duration of the game or not. Can be stopped by calling halt
 */
	
public sound(String soundFile,boolean loop){//program this into a handler pls! so only one instance and muting is possible
	myclass = new MyClass(soundFile,loop);
	//This code initializes the thread 
	myclass.start();
	
	//JUST FOUND THAT IT CREATE A NEW THREAD EVERY TIME and i have like 94 threads running HAVE 
	//TO FIND A WAY TO DESTROY IT AFTER IT FINISHES RUNNING
	
	
	
	//YOU HAVE TO MAKE THE THREAD STOP AFTER IT FINISHES RUNNING IN THIS METHOD OR THE ONE THAT IT IS HAPPENING IN
	}
public void halt(){
	myclass.loop=false;
}

}
