package Model;

import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends States{
	
	
   
	public MenuState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		if(handler.getMouseManager().isHightPressed() && handler.getMouseManager().isLeftPressed()) { // se os dois botões estiverem sendo precionados 
			States.setEstado(handler.getGame().gameEstado);
			
		}
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
		
	}


}
