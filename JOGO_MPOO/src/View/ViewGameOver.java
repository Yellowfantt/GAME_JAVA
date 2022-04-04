package View;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Model.CarregarImagenss;

public class ViewGameOver extends JFrame {
	public ViewGameOver() {
		setTitle("Perdeu o jogo");
		setSize(852,480);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		configJanela();
		
	}
	public void configJanela() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
					System.exit(0);
			}
		});
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon(CarregarImagenss.url("GameOver.jpg")).getImage(), 0, 0, this);
		
	}

}
