package Model;

import java.awt.Graphics;

public abstract  class States {
	private static States estado = null;	// isso aqui sempre vai colocar a classe que eu setar no caso State.setESTADO(QUALQUEROUTRO); EM UM LOOP PQ EU CHAMO O TICK DESSA CLASSE NO TICK DA THREAD E NO RENDER DA THREAD EU CHAMO O RENDER DO OBJETO
	protected Handler handler;
	 
	public States(Handler handler) {
		this.handler = handler;
		
	}
	public static void setEstado(States estadoo) {
		estado = estadoo;
	}
	
	public static States getEstado() {
		return estado;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}
