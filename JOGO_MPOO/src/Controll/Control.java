package Controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Game;
import Model.Som;
import Model.Tempo;
import View.ViewGame;
import View.ViewHelp;
import View.ViewMenu;

public class Control {
	private ViewMenu viewMenu;
	private ViewGame viewGame;

	public Control(ViewGame viewGame) {
		new Game(viewGame);
		this.viewGame = viewGame;
		viewMenu = new ViewMenu();
		
		
		tratarJB();
		
	}

	public void tratarJB() {
		viewMenu.getPlay().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewGame.setVisible(true);
				viewMenu.dispose();
				new Tempo(viewGame).start();
				new Som().start();
			}
			
		});
		viewMenu.getHelp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewHelp();
				
			}
			
		});
		viewMenu.getExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
	}

}
