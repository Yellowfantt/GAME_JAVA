package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.CarregarImagenss;

public class ViewDica extends JFrame {
	private JLabel dica = new JLabel(new ImageIcon(CarregarImagenss.url("PerguntaMapa1Tela.jpg")));

	public ViewDica() {
		setTitle("DICA!");
		setSize(626,440);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(dica);
		configJanela();

	}
	public void configJanela() {
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ESCAPE) 
					dispose();
			}
			
			
		});
		
	}

	public JLabel getDica() {
		return dica;
	}

	public void setDica(JLabel dica) {
		this.dica = dica;
	}
	
	
	
	
	
	
	

}
