package Model;

import View.ViewGame;

public class Camera {
	private float xOffset, yOffset;
	private Handler handler;
	
	public Camera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	}
	
	public void verifiarEspacoEmBranco() {
		if(xOffset < 0) {
			xOffset = 0;
			
		}else if(xOffset > handler.getWorld().getLargura() * Tile.TILE_LARGURA - handler.getLargura()) {
			
			xOffset = handler.getWorld().getLargura() * Tile.TILE_LARGURA - handler.getLargura();
			
		}
		
		if(yOffset < 0) {
			yOffset = 0;
			
		}else if(yOffset >  handler.getWorld().getAltura() * Tile.TILE_ALTURA - handler.getAltura()) {
			yOffset = handler.getWorld().getAltura() * Tile.TILE_ALTURA - handler.getAltura();
			
			
		}
		
	}
	
	public float getXoffset() {
		return xOffset;
		
	}
	public void setXoffset(float xoffset) {
		this.xOffset = xoffset;
	}
	public float getYoffset() {
		return yOffset;
	}
	public void setYoffset(float yoffset) {
		this.yOffset = yoffset;
	}
	
	public void move(float xAmt,  float  yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		verifiarEspacoEmBranco();
	}
	
	public void centralizarEntidade(Entidade e ) {	
		xOffset = e.getX() - handler.getLargura() / 2 + e.getLargura() / 2; // isso � uma subtra��o onde eu reduzo a largura da tela por exemplo e.getx � zero que �e o x do nosos hero na tela 									 
		yOffset = e.getY() - handler.getAltura() / 2 + e.getAltura() / 2;// 0 - 450 + 16 = -434 ent�o nossa tela vai ficar em - 4
		verifiarEspacoEmBranco();// 0 - 450 + 16 = -434 ent�o nossa tela vai ficar em - 4
		
	}

	
	

}
