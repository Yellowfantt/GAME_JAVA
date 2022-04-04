package Model;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;
	
	
	public SpriteSheet(BufferedImage sheet) { // recebe por parametro a imagem que será cortada 
		this.sheet = sheet;
		
		
	}
	
	
	public  BufferedImage cortar(int x, int y , int largura, int altura) {			// metodo que vai cortar nossa imagem 
		return sheet.getSubimage(x, y, largura, altura); // 0, 0 ,236,236
		
		
	}



}
