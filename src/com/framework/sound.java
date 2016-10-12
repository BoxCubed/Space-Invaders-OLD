package com.framework;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
class MyClass extends Thread{
	/*public static void main(String[]args){
		File file_LOCATION = new File ("src/laser.wav");
		play_sound(file_LOCATION);
	}*/
	public void run(){
		
		File file_LOCATION = new File ("sounds/laser.wav");//LOCATION OF THE FILE IS CRUCIAL BECAUSE... DO u want sound or not??????
		try{
			Clip audio_player = AudioSystem.getClip(); 				//THIS S**T does the audio. DONT MESS WITH IT OR JAVA WILL F UP
			audio_player.open(AudioSystem.getAudioInputStream(file_LOCATION));
			audio_player.start();
			
			Thread.sleep(audio_player.getMicrosecondLength()/100); //REMOVING a 0 from that just fixed everything ALL G 
			audio_player.stop();
			audio_player.close();
			Thread.sleep(MAX_PRIORITY); //I HOPE THIS WORKS
			//The is iufhjgf gsjf sajfgshjvf 
		}catch(Exception e){
			e.printStackTrace(); //INCASE OF FUCK UP IN THE SOUND FOR SUM REASON
		}
	}
}

public class sound{

public static void main(){
	MyClass myclass = new MyClass();
	//This code initializes the thread 
	myclass.start();
	
	//JUST FOUND THAT IT CREATE A NEW THREAD EVERY TIME and i have like 94 threads running HAVE 
	//TO FIND A WAY TO DESTROY IT AFTER IT FINISHES RUNNING
	
	
	
	//YOU HAVE TO MAKE THE THREAD STOP AFTER IT FINISHES RUNNING IN THIS METHOD OR THE ONE THAT IT IS HAPPENING IN

	
}

}
