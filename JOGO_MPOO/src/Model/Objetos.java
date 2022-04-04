package Model;

import java.awt.Color;
import java.awt.Graphics;

public class Objetos  extends StaticEntidade{

	public Objetos(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILE_LARGURA *2 , Tile.TILE_ALTURA *2);
//		bounds.x = 10;
//		bounds.y = (int) (altura / 1.5f);
//		bounds.width = largura - 20;
//		bounds.height = (int)(altura - altura/ 1.5f); // o retangulo  do dragão 
//		bounds.x = 0;
//		bounds.y = 0;
//		bounds.height = 160;
//		bounds.width = 128;
		
		bounds.x = 0;
		bounds.y = 64;
		bounds.width = largura ;
		bounds.height = altura - 64; // o retangulo  do dragão 
		
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.dragao,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
		
	}
	
	
	
	public static class  tumulo extends  StaticEntidade{

			public tumulo(Handler handler, float x, float y) {
				super(handler, x, y, Tile.TILE_LARGURA *2 , Tile.TILE_ALTURA *2 );
				bounds.x = 12;
				bounds.y = 64;
				bounds.width = largura -20;
				bounds.height = altura - 64;
				
			}

			@Override
			public void tick() {
				
			}

			@Override
			public void render(Graphics g) {
				g.drawImage(Assets.tumulo,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
		
			}

			@Override
			public void die() {
				
			}

			

		
	

	}
	public static class  Estatua extends  StaticEntidade{

		public Estatua(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA  , Tile.TILE_ALTURA *2);
			bounds.x = 12;
			bounds.y = 64;
			bounds.width = largura -20;
			bounds.height = (altura /2) -11;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.estatuaMulher,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}

	
		}
	
	
	public static class  Fogueira extends  StaticEntidade{

		public Fogueira(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA  , Tile.TILE_ALTURA );
			bounds.x = 15;
			bounds.y = 30;
			bounds.width = (largura / 2) ;  //esquerda
			bounds.height = altura /2;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.fogueiras,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}

	
		}
	
	public static class  EstatuaCaveira extends  StaticEntidade{

		public EstatuaCaveira(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA  , Tile.TILE_ALTURA *2);
			bounds.x = 10;
			bounds.y = 75;
			bounds.width = largura -15;
			bounds.height = (64 -15);
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.estatuaCaveira,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}

	
		}
	
	public static class  Arroz extends  StaticEntidade{

		public Arroz(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA    , (Tile.TILE_ALTURA) );
			bounds.x = 0;
			bounds.y = 2;
			bounds.width = largura ;
			bounds.height = altura;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.arroz,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}

	
		}
	public static class  LegumesJuntos extends  StaticEntidade{

		public LegumesJuntos(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA *6 ,(Tile.TILE_ALTURA) );
			bounds.x =1;
			bounds.y =2;
			bounds.width = 64*6;
			bounds.height =51;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.legumesJuntos,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}

	
		}
	public static class  Cenoura extends  StaticEntidade{

		public Cenoura(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA    , (Tile.TILE_ALTURA) );
			bounds.x = 0;
			bounds.y = 2;
			bounds.width = largura;
			bounds.height = altura;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.cenoura,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}
	}

	public static class  Mesa extends  StaticEntidade{

		public Mesa(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA * 2 , Tile.TILE_ALTURA* 2 );
			bounds.x =15;
			bounds.y = 20;
			bounds.width = largura -25 ;
			bounds.height = altura -30;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.mesa,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}

	
	}
	public static class  Bandeira extends  StaticEntidade{

		public Bandeira(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA    , (Tile.TILE_ALTURA) );
			bounds.x = 0;
			bounds.y = 2;
			bounds.width = largura;
			bounds.height = altura;
			
		}

		@Override
		public void tick() {
			
		}

		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.bandeira,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		@Override
		public void die() {
			// TODO Auto-generated method stub
			
		}
	}
	public static class  Barril extends  StaticEntidade{

		public Barril(Handler handler, float x, float y) {
			super(handler, x, y, Tile.TILE_LARGURA    , (Tile.TILE_ALTURA) );
			bounds.x = 0;
			bounds.y = 2;
			bounds.width = largura;
			bounds.height = altura;
			
		}

		@Override
		public void tick() {
			
		}
		
		@Override
		public void render(Graphics g) {
			g.drawImage(Assets.barril,(int) (x - handler.getCamera().getXoffset()), (int)(y - handler.getCamera().getYoffset()), largura, altura, null);
	
		}

		public void die() {
			// TODO Auto-generated method stub
			
		}
	}
	@Override
	public void die() { // eu posso mudar onde será dropada mudando o x e y dessa classe mas foda-se 
		handler.getWorld().getGerenciadorItens().adicionarItens(Item.moeda.creatNew((int) x,(int) y));
	}
	
}
