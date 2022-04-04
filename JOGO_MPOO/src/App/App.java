package App;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

import Controll.Control;
import View.ViewGame;

public class App {
	
	
	public static void main(String[] args) {
		new Control(new ViewGame());
		
	}

}
