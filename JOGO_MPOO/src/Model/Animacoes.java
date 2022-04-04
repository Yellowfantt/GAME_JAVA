package Model;

import java.awt.image.BufferedImage;

public class Animacoes {
	private int speed, index;
	private BufferedImage[] frames;
	private long lasTime, timer;
	
	public Animacoes(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lasTime = System.currentTimeMillis();
		
	}
	
	public void tick() {
		timer+= System.currentTimeMillis() - lasTime; // no caso vai me retornar os segundos 
		lasTime = System.currentTimeMillis();
		if(timer > speed) {
			index++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
		
	}
	public BufferedImage getCurrentFrame() {
		 return frames[index];
	}
}
