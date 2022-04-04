package View;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.CarregarImagenss;



public class ViewHelp extends JFrame {	
	public ViewHelp() {
		
		setTitle("Help ");
		setSize(1280,730);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		add(BorderLayout.CENTER, new JLabel(new ImageIcon(CarregarImagenss.url("TelaHelp.png"))));
		setVisible(true);
		closeJanela();
		System.out.println("Execute");
	}
	
	public void closeJanela() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ESCAPE)  
					dispose();	
			}
		});
	}


}
