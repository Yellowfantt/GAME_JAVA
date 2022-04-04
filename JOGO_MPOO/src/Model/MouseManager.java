package Model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
	private boolean leftPressed, hightPressed;
	private int mouseX, mouseY; // para manter a posição do mouse a tela 
	
	
	public MouseManager() {
		 
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() ==  MouseEvent.BUTTON1) {
			leftPressed = true;          // ou seja o botão esquerdo está sendo precionado 
		}else {
			if(e.getButton() == MouseEvent.BUTTON3) {
				hightPressed = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() ==  MouseEvent.BUTTON1) {
			leftPressed = false;          // ou seja o botão esquerdo está sendo precionado 
		}else {
			if(e.getButton() == MouseEvent.BUTTON3) {
				hightPressed = false;
			}
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	public boolean isLeftPressed() {
		return leftPressed;
	}
	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}
	public boolean isHightPressed() {
		return hightPressed;
	}
	public void setHightPressed(boolean hightPressed) {
		this.hightPressed = hightPressed;
	}
	public int getMouseX() {
		return mouseX;
	}
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}
	public int getMouseY() {
		return mouseY;
	}
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	

}
