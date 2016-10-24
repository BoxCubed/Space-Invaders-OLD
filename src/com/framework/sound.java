package com.framework;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
class MyClass extends Thread{
	/*
	_ooOoo_
    o8888888o
    88" . "88
    (| -_- |)
    O\  =  /O
 ____/`---'\____
.'  \\|     |//  `.
/  \\|||  :  |||//  \
/  _||||| -:- |||||_  \
|   | \\\  -  /'| |   |
| \_|  `\`---'//  |_/ |
\  .-\__ `-. -'__/-.  /
___`. .'  /--.--\  `. .'___
."" '<  `.___\_<|>_/___.' _> \"".
| | :  `- \`. ;`. _/; .'/ /  .' ; |
\  \ `-.   \_\_`. _.'_/_/  -' _.' /
===========`-.`___`-.__\ \___  /__.-'_.'_.-'================
ONLY BUDDHA CAN HELP TO SAVE THIS CODE
*/
	/*public static void main(){
		File file_LOCATION = new File ("sounds/laser.wav");
		run(file_LOCATION);
		
	}*/
	//@SuppressWarnings("unused")
	public void run(){
		//boolean loop=true;
		//LOCATION OF THE FILE IS CRUCIAL BECAUSE... DO u want sound or not??????
		//System.out.println("new sound thread started: Playing File: "+file_LOCATION.getName());
		
		try{
			File file_LOCATION = new File ("src/laser.wav");
			Clip audio_player = AudioSystem.getClip(); 				//THIS does the audio. DONT MESS WITH IT OR JAVA WILL F UP
			audio_player.open(AudioSystem.getAudioInputStream(file_LOCATION));
			audio_player.start();
			Thread.sleep(audio_player.getMicrosecondLength()/100); //REMOVING a 0 from that just fixed everything ALL G 
			audio_player.stop();
			audio_player.close();	
			System.out.println("The sound finished playing");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Sound Error: "+e.getMessage());
			e.printStackTrace();
		}/*finally{
			System.out.println("finished music");
			try {
				Thread.sleep(MAX_PRIORITY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		}}

//}

public class sound{		
public void play_sound(){//program this into a handler pls! so only one instance and muting is possible
	MyClass MYCLASSobject= new MyClass();
	
	//This code initializes the thread 
	MYCLASSobject.start();
	//myclass.run();
	//JUST FOUND THAT IT CREATE A NEW THREAD EVERY TIME and i have like 94 threads running HAVE 
	//TO FIND A WAY TO DESTROY IT AFTER IT FINISHES RUNNING
	}
}
