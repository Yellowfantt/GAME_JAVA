package View;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.CarregarImagenss;



public class ViewMenu extends JFrame {
	
	private JButton play = new JButton("Play");
	private JButton help = new JButton("Help");
	private JButton exit = new JButton("Exit");
	private JLabel fundo = new JLabel(new ImageIcon(CarregarImagenss.url("TelaInicialFinal.png")));
	public ViewMenu() {
		
		setTitle("Break Time");
		setSize(900, 700);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		editarComponente();
		setVisible(true);
		
		
		
	}
	
	public void editarComponente() {
		play.setBounds(370, 271, 120, 30);
		help.setBounds(370, 371, 120, 30);
		exit.setBounds(370, 471, 120, 30);
		fundo.setBounds(1,1, 900, 700);
	
		add(play);
		add(help);
		add(exit);
		add(fundo);
		
	}

	public JButton getPlay() {
		return play;
	}

	public JButton getHelp() {
		return help;
	}

	public JButton getExit() {
		return exit;
	}

}
