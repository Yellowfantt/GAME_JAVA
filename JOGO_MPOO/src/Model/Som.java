package Model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som  extends Thread{
	
	public void run() {
	        try {
	            //URL do som que no caso esta no pendrive, mais ainda é uma fase de teste.
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("res//imagens//Musica.wav.wav").getAbsoluteFile());
	            Clip clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.start();
	            clip.loop(Clip.LOOP_CONTINUOUSLY); //Para repetir o som.
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    
	}
	

}
