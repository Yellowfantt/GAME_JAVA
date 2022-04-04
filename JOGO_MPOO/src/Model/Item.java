package Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Item {
	// handler
	public static Item[] itens = new Item[256];
	public static Item chave = new Item(Assets.chave, "Chave", 0);  // criei meu item chave 
	public static Item moeda = new Item(Assets.moeda, "Moeda", 1);  // criei meu item moeda 
	
	// classe
	protected Handler handler;
	protected BufferedImage imagem;
	public static final int  ITEMLARGURA = 32, ITEMALTURA = 32, PICK_UP = -1; 
	protected String name;  // será o nome do item 
	protected final int ID; // id do item 
	protected int x, y , cont;  // contador vai armazenar a quantidade de itens no objeto, por exemplo se tivermos um item de madeira ao invez de criar 50 instancias desse item vamos
	// podemos ter apenas uma instancia desse item e definir a contagem igual a 50 e teremos 50 itens 
	// agora se cont for negativo significa que temos que remover esse item e colocalo no inventario do jogador 
								
	
	
	public Item(BufferedImage imagem, String nome, int id) {
		this.imagem = imagem;
		this.name = nome;
		this.ID = id;
		cont = 1;
		itens[ID] = this; // no caso a matriz de itns em 0 vai valer um objeto item com a imagem da chave e id 0 no caso depois no
		
		
		
	}
	
	public void tick() {
		
	}
	public void render(Graphics g) {
		if(handler == null)
			return ;
		render(g, (int) (x - handler.getCamera().getXoffset()), (int) (y - handler.getCamera().getYoffset()));
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(imagem, x, y, ITEMLARGURA, ITEMALTURA, null);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getImagem() {
		return imagem;
	}

	public void setImagem(BufferedImage imagem) {
		this.imagem = imagem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getID() {
		return ID;
	}
	
	public void setPosition(int x , int y) {
		this.x = x;
		this.y = y;
	}
	
	public Item creatNew(int x, int y) { // ira criar uma copia da classe do item que está aqui atualmente 
		Item item =  new Item(imagem, name, ID);
		item.setPosition(x, y);
		return item;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
}
