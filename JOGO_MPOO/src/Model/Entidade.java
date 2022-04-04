package Model;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entidade {
	protected  float x ,y ; 
	protected int largura, altura;
	protected int vida;
	public static final int VIDA_PADRAO = 10;
	protected Handler handler;
	protected Rectangle bounds;
	protected boolean ative = true;
	
	public Entidade(Handler handler, float x, float y, int largura, int altura) {
		this.handler = handler;
		vida = VIDA_PADRAO;		
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
		
		bounds = new Rectangle(0,0, largura, altura); // cordenas x e y do retangulo isso significa que estara apenas no canto superior esquerda da imagem ou seja tudo normal por aqui kk ou na posição x e y real da entidade , não recebe variações apenas váriaveis padrões 
		// meu inimgo tera a caixa do mesmo tamanho que definirmos ou seja do mesmo tamanho da imagem 
	
	}

	public abstract void tick();
	public abstract void render(Graphics g);
	
	public  boolean checkEntitycolisions(float xOffset, float yOffset) {
		for(Entidade e : handler.getWorld().getEntidadeManage().getEntidades()) {
			if(e.equals(this)) {
				continue;
			}
			//0x e 0y se eu quiser posso mudar aqui a altura para colição tipo por 3 e 3 
			if(e.getColisaobounds(0f, 0f).intersects(getColisaobounds(xOffset, yOffset))) {
				return true;
			} // se a entidade pela qual a gente percorre o caminho cruzar o caminho com o nosso ai temos uma intersenção
			 // retornando true quer dizer que houve uma colissão 
		}
		return false;
	
	}
	public Rectangle getColisaobounds(float xOffset, float yOffset) {
		return new Rectangle((int)(x + bounds.x + xOffset),(int) (y + bounds.y + yOffset), bounds.width,bounds.height);
		// me retorna o retangulo qudrado que cobre o corpo do objeto 
	}
	public float getX() {
		return x;
	}

	public void setX(float x) {	
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isAtive() {
		return ative;
	}

	public void setAtive(boolean ative) {
		this.ative = ative;
	}
	
	public abstract  void die();
	public void hurt(int amt) {
		vida -= amt;
		if(vida <=0) {	// se a vida dessa entidade for menor ou igual a zero a gente vai remover ele definindo ativo como false, pq enquanto for ativo ele está tivo 
			ative = false;
			die();
			
		}
		
	}
	
	
	
	
}
