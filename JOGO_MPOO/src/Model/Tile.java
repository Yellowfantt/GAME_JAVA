package Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
// ids = 0 é grama 
// 64 corresponde a dois quadrados do mapa ou seja será desenhado do tamanho de 2 quadrados do mapa 
public class Tile {
	public static final int TILE_LARGURA = 64, TILE_ALTURA = 64; // e aqui posso mudar a largura e altura para a que eu quiser do objeto pq o corte já foi feito de forma certa
	protected BufferedImage imagem;	    
	protected final int id;		
	//static stuff here 
	public static Tile[] tiles = new Tile[256];
	public static Tile pisoMapa1 = new pisoMapa1(0);					
	public static Tile parede = new paredeMapa1(1);					
	public static Tile porta = new porta (2);	
	public static Tile chave = new chave(3);
	public static Tile pisoMapa2 = new pisoMapa2(4) ;
	
	
						
													//cada quadradinho tera um id para podermos identificar eles 
	public Tile(BufferedImage imagem, int id) { // vamos precisar de uma imagem ou seja como o bloco se parece 
		this.imagem = imagem;
		this.id = id;
		
		tiles[id] = this; 
		//entendi tipo se eu instncio grass o super recebe o id dele e aqui nesse contrutor como uma instancia de uma filha executa a do pai 
		// eu já estou passando a imagem lá agr só falta o id, ai eu paso lá tmb ai vai ter que seta aqui o objeto 
		// ai quando executar esse construtor sentando a imagem e o id o objeto atual ou seja id dele vai ser a indice eo objeto vai set this. que se refere ao objeto atual 
		// ou seja pegando o id e o objeto do tipo Tile 
		
	
		
		
		
	}
	
	public boolean isSolid() {
		return false;				// se retornar false então você pode andar sobre, se ele retornar falso quer dizer que não é solido e você podera andar sobre ele ou seja permiçãpo 
									//se retornar true significa que é solido e vc n tem permição e nem pode andar sobre ele 
	}
	public void tick() {
		
	}
	
	public void render(Graphics g, int x , int y ) {
		
		g.drawImage(imagem, x, y, TILE_LARGURA, TILE_ALTURA, null);
		
	}
	public int getId() {
		return id;
	}
	
	
	
}


class pisoMapa1 extends Tile{

public pisoMapa1(int id) {		// já passei o que vai ser na sup pelo metodo sup e no meu construtor eu só passo o id 
	 super(Assets.pisoMap1, id); // já defini quem vai ser a imagem agora basta desenha-lá, toda vez que eu chamar ou criar um objeto do tipo grass tile a imagme dele é essa aew
	}
							 // como a grama não é algo que 

}


 class paredeMapa1  extends  Tile{

	public paredeMapa1(int id) {
		super(Assets.paredeMap1, id);
	}
	
	public boolean isSolid() {
		return true;
	}

}
 class porta  extends  Tile{

		public porta(int id) {
			super(Assets.porta, id);
		}
		
		public boolean isSolid() {
			return true;
		}
		
		
	}
 
 class chave  extends  Tile{

		public chave(int id) {
			super(Assets.chave, id);
		}
		
		

	}

 
 class pisoMapa2  extends  Tile{

		public pisoMapa2(int id) {
			super(Assets.pisoMapa2, id);
		}
		
		

	}
 
 
		
		
	
 
 

 


	



