package Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Dictionary;

import View.ViewDica;

public class KeyManager extends KeyAdapter {
	private boolean[] teclas ;
	public boolean up ,down ,left , right;
	public boolean aUp, aDown, aLeft, aright;
	private ViewDica dica;
	 
	
	public  KeyManager() {
		teclas = new boolean [256];
		dica = new ViewDica();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
		if(e.getKeyCode() == e.VK_J) {
			dica.setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	
	
	public void tick() {						// posso simplesmente iniciar isso no construtor 
		up =   teclas[KeyEvent.VK_W];  		    // tô iniciando as teclas da minha classe up será a tela precionada em 38
		down = teclas[KeyEvent.VK_S];			// ENTÃO TODA VEZ QUE NOSSO METODO TICK É CHAMADO ESTAMOS ATUALIZANDO AS VÁRIAVEIS 
		left = teclas[KeyEvent.VK_A];
		right= teclas[KeyEvent.VK_D];
		
		aUp =   teclas[KeyEvent.VK_UP];  		    // tô iniciando as teclas da minha classe up será a tela precionada em 38
		aDown = teclas[KeyEvent.VK_DOWN];			// ENTÃO TODA VEZ QUE NOSSO METODO TICK É CHAMADO ESTAMOS ATUALIZANDO AS VÁRIAVEIS 
		aLeft = teclas[KeyEvent.VK_LEFT];
		aright= teclas[KeyEvent.VK_RIGHT];
	
		
	}
	public ViewDica getDica() {
		return dica;
	} 
	
	
	
}
