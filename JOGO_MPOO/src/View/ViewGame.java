package View;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Model.CarregarImagenss;

public class ViewGame extends JFrame{
	private Canvas canvas;
	private int largura = 1200;
	private int altura = 636;
	private JPanel jp ;
	private JProgressBar barra = new JProgressBar();

	public ViewGame() {
//		setLayout(null);
		setTitle("Janela Principal");
		setSize(largura,altura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		antes();
		canvass();
		
	//	config();
		
		
		
		
	}
	public void antes() {
		//barra.setBounds(200, 350, 500, 50);

		barra.setBounds(0,0,400,30);
		barra.setForeground(Color.green);
		
		barra.setMaximum(300);
		barra.setValue(300);
		add(barra);
	}
	
	public void canvass() { // é tipo um painel no caso eu adicionei na tela um painel 
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(largura,altura));
		canvas.setMaximumSize(new Dimension(largura,altura ));
		canvas.setMinimumSize(new Dimension(largura,altura));
		canvas.setFocusable(false);
		
		add(canvas);
		pack();
		
		
	
	}
	public void config() {
		jp = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(new ImageIcon(CarregarImagenss.url("TelaFinal.png")).getImage(), 0, 0, this);
			}
		};
	
		add(BorderLayout.SOUTH,jp);
		

	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	
	public JFrame getFrame() {
		return getFrame();
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	public JProgressBar getBarra() {
		return barra;
	}
	public void setBarra(JProgressBar barra) {
		this.barra = barra;
	}
	
	
	
	

}
