package Model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorItens { // classe que usaremos para desenhar no chão o item 
								// essa classe ira apenas armazenar os itens que estãp atualmente no jogo no chão do jogo
	private Handler handler;
	private ArrayList<Item> itens ;
	private static int pontuacao = 0;
	
	public GerenciadorItens(Handler handler) {
		this.handler = handler;
		itens = new ArrayList<>();
		
	}
	public void tick() {
		Iterator <Item> i = itens.iterator();
		while(i.hasNext()) {
			Item item = i.next();
			item.tick();
			if(item.getCont() == item.PICK_UP) {	
				i.remove();			// no caso ele está apenas removendo , mas para cada moeda que ele pegar vou adicionar em um array
				pontuacao +=10; // toda vez que ele pega uma moeda pontuação vai valer a quantidade de moedas 
			}    // se entrar aqui significa que o jogador pegou aquele item e devemos removo do mundo 
	            // faço a mesma coisa mas agora busco o id e se o id for zero então ele pegou a chave e adiciono em um arraylist 
		}
		
	}
	
	public void render(Graphics g ) {
		
		for(Item i : itens){
			i.render(g);
		}
		
	}
	
	public void adicionarItens(Item i) {
		i.setHandler(handler);
		itens.add(i);        // estou adicionado o item ao nosso array
	}
	
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	

}
