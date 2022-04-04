package Model;

public abstract class Criatura extends Entidade {
	public static final float VELOCIDADE_PADRAO = 3.0f;
	public static final int LARGURA_PADRAO = 64; // 60
	public static final int ALTURA_PADRAO = 64; //60
	protected float velocidade;
	protected float xMove;
	protected float yMove;
	

	public Criatura(Handler handler, float x, float y ,int largura, int altura) {
		super(handler, x, y,largura, altura);
		velocidade = VELOCIDADE_PADRAO; 
		xMove = 0;
		yMove = 0;
		
	}
	
	public void move() { // vamos mover nossas/ então aqui eu recebo x = 30 e y = 30 e em hero nas congig eu defino se xmove vai ser possitivo ou n
		
		// e aqui simplesmente se for possitivo eu somo e x vai valer aquilo 30+3 = 33 e ele anda
		// agr se for negativo eu farei 30-3 =27 e ele volta, tudo isso atravez da variavel speed
		// pq eu defini movex e movey sendo speed ou mais ou menos
		// se eu quiser aumentar a velocidade é só mudar em speed

	if(!checkEntitycolisions(xMove, 0f))
			moveX();
	if(!checkEntitycolisions(0f, yMove))
		moveY();
	      
	}

	public void  moveX() {
		if(xMove > 	0) { // se for maior que zero então estamos nos movendo para a direita 
			int tx = (int) ( x + xMove + bounds.x + bounds.width) / Tile.TILE_LARGURA;
			if(!colisaoWithTile(tx, (int)(y + bounds.y) / Tile.TILE_ALTURA) &&
					!colisaoWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_ALTURA)) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILE_LARGURA - bounds.x - bounds.width -1;	
			}
			
		}else if(xMove < 0) { // estamos se movendo para a esquerda x é menor que zero então estamos indo para a esqueda que n é adicionado a largura
			int tx = (int) (x + xMove + bounds.x) / Tile.TILE_LARGURA ;
			
			if(!colisaoWithTile(tx, (int)(y + bounds.y) / Tile.TILE_ALTURA) &&
					!colisaoWithTile(tx,(int)(y + bounds.y + bounds.height) / Tile.TILE_ALTURA)) {
				x += xMove;
			}else {
			  x = tx * Tile.TILE_LARGURA  + Tile.TILE_LARGURA - bounds.x ;
			 
				
			}
			
		}
			
	}
	
	public void moveY() { // cima
		if(yMove < 	0) {
			int ty = (int) (y + yMove + bounds.y) / Tile.TILE_ALTURA;
			
			if(!colisaoWithTile((int)( x + bounds.x) / Tile.TILE_LARGURA, ty) &&
					!colisaoWithTile((int)( x + bounds.x + bounds.width)/ Tile.TILE_LARGURA, ty)) {
				y += yMove;
				
			}else {
				y =  ty * Tile.TILE_ALTURA + Tile.TILE_ALTURA - bounds.y ;
			}
			
		}else if(yMove > 0) { // baixo
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_ALTURA;
			
			if(!colisaoWithTile((int)( x + bounds.x)/ Tile.TILE_LARGURA, ty) &&
					!colisaoWithTile((int)( x + bounds.x + bounds.width) / Tile.TILE_LARGURA, ty)) {
				y += yMove;
			}else {
				y =  ty * Tile.TILE_ALTURA - bounds.y - bounds.height -1;
				
			}
			
			
		}
		
	}
	
	protected boolean colisaoWithTile(int x, int y) {
			return handler.getWorld().getTile(x, y).isSolid();
		
	}
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	

}
