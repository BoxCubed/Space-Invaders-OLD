package com.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.framework.Texture;
import com.framework.Tidy;
import com.framework.keyListener;
import com.objects.Handler;

public class Display extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static int WIDTH=600,HEIGHT=660;
	
	public static Handler handler;
	
	public static boolean running=false;
	private Thread thread;
	
	Tidy t;
	
	static Texture tex;
	
	private void initialize(){
		t = new Tidy(); 
		tex = new Texture();
		t.initTidy();
		this.addKeyListener(new keyListener(handler));
	}
	
	public synchronized void start(){
		if(running){return;}   //if its running then do nothing
		running=true;    //otherwise set running to true
		thread=new Thread(this);      //create a thread in Runnable
		thread.start();  //does what it does
	}
	public synchronized void stop(){
		if(!running){return;}
		running=false;
		try {thread.join(); //this waits for the thread to 'die'
		} catch (InterruptedException e) {e.printStackTrace();}
	}

	public Display(){
		this.setSize(WIDTH,HEIGHT);
	}
	
	
	@Override
	public void run() {
		initialize();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		@SuppressWarnings("unused")
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick(){
		handler.tick();
	}	
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){                                             //When you create a buffer strategy its default set to null
			this.createBufferStrategy(3);                         //Creating the buffer strategy (triple buffering) and rendering 
			return;                                                //a black background along with a moving blue box
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();    //disposes of the frames that it buffered
		bs.show();   //not sure what this is
	}
	
	public static Texture getInstance(){
		return tex;
	}

}



