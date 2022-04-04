package Model;

import View.ViewGame;
import View.ViewGameOver;

public class Tempo extends Thread{
	private ViewGame viewGame;
	
	public Tempo(ViewGame viewgame) {
		this.viewGame = viewgame;
	}
	
	
	public void run() {
		try {
			for(int i = 0 ; i < 300 ; i++) {
				viewGame.getBarra().setValue(viewGame.getBarra().getValue()-1);
				if(viewGame.getBarra().getValue() == 0) {
					viewGame.dispose();
					new ViewGameOver().setVisible(true);
				}
				sleep(1000);
				
			}
			
		} catch (Exception e) {
		}
		
		
	}

}
