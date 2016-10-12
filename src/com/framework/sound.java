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
		
		if(s.equals("shoot"))
		file_LOCATION = new File ("sounds/laser.wav");//LOCATION OF THE FILE IS CRUCIAL BECAUSE... DO u want sound or not??????
		if(s.equals("background"))
			file_LOCATION=new File("sounds/backgroundMusic.wav");
		System.out.println("new sound thread started: Playing File: "+file_LOCATION.getName());
		do{
		try{
			Clip audio_player = AudioSystem.getClip(); 				//THIS S**T does the audio. DONT MESS WITH IT OR JAVA WILL F UP
			audio_player.open(AudioSystem.getAudioInputStream(file_LOCATION));
			audio_player.start();
			
			Thread.sleep(audio_player.getMicrosecondLength()/100); //REMOVING a 0 from that just fixed everything ALL G 
			audio_player.stop();
			audio_player.close();
			Thread.sleep(MAX_PRIORITY); //I HOPE THIS WORKS
			//The is iufhjgf gsjf sajfgshjvf 
		}catch(NullPointerException e){
			System.out.println("file no found");
			e.printStackTrace(); //INCASE OF FUCK UP IN THE SOUND FOR SUM REASON
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Thread couldn't sleep");
			e.printStackTrace();
			
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			System.out.println("sound Error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Internal IO Sound Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			System.out.println("Unknown Format");
			e.printStackTrace();
		}
		
	}while(loop);
		}
}
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
	
sound(String soundFile,boolean loop){
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
