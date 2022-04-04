package Model;

import java.awt.Graphics;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class World {
	private int largura, altura; // por exemplo um mundo de 5x5 5 de largura e 5 de altura  
	private int tiles[][];       //linhas e colunas 
	private int spawnX, spawnY ; // onde o personagem nasce no mapa 
	private Handler handler;
	static final String  CAMADA_2 = Paths.get("res//worlds//world2.txt").toString();
	static final String  CAMADA_3 = Paths.get("res//worlds//world3.txt").toString();
	public static int cont = 0;
	public String[] tokens;
	private int xStart ; 
	private int xEnd;
	private int yStart; // onde o hero inicia 
	private int yEnd ; // onde o hero inicia n  são as variaveis de respal do meu arquivo ou seja onde vão iniciar as coisas 
	private Hero hero;
	private EntidadeManage entidadeManage;
	//item 
	private GerenciadorItens gerenciadorItens;
	
	public World(Handler handler, String path) {
		 this.handler = handler; 
		 hero =  new Hero(handler, 100,100);
		 entidadeManage = new EntidadeManage(handler,hero); // precisa iniciar antes de carregar mapa, para carregar o mundo com as entidades no caso o array n iniciar vazio		
		 objetosMapa1();
		 carregarMapa(path);
		 gerenciadorItens = new GerenciadorItens(handler);
		 

//		 entidadeManage.getHero().setX(spawnX);
//		 entidadeManage.getHero().setY(spawnY);
		 
		
		
	}
	
	
											
	public void carregarMapa(String path) {	
		
		String 	file = BancoDados.carregarArquivo(path);
		tokens = file.split("\\s+");
		largura = BancoDados.parseInt(tokens[0]);
		altura = BancoDados.parseInt(tokens[1]);
		
		spawnX = BancoDados.parseInt(tokens[2]);
		spawnY = BancoDados.parseInt(tokens[3]);
	
		tiles = new int[largura][altura];
		
		for(int y = 0 ;y <altura ; y++) {
			for(int x = 0; x < largura; x++) { 
				tiles[x][y] = BancoDados.parseInt(tokens[(x + y * largura) + 4 ]); 
				
			}
			
		}
		
	}
	
	public void tick() { 
		gerenciadorItens.tick();
		entidadeManage.tick();
		atualizarMapa();
		
	
	
	}

	public EntidadeManage getEntidadeManage() {
		return entidadeManage;
	}


	public void atualizarMapa() {
		if(hero.getX() == 1727 && hero.getY() == 20 ||hero.getX() == 1733 && hero.getY() == 20||hero.getX() == 1715 && hero.getY() == 20||
				hero.getX() == 1742 && hero.getY() == 20 || hero.getX() == 1730 && hero.getY() == 20 || hero.getX() == 1729 && hero.getY() == 20 ||
				hero.getX() == 1728 && hero.getY() == 20 || hero.getX() == 1734 && hero.getY() == 20 ) {
				entidadeManage.getEntidades().clear();
				carregarMapa(CAMADA_2);
				objetosMapa2();
				entidadeManage.adicionarEntidade(hero);
				hero.setX(spawnX);
				hero.setY(spawnY);
				handler.getKeyManager().getDica().getDica().setIcon(new ImageIcon(CarregarImagenss.url("PerguntaMapa2Tela.jpg")));
			
		}
		if(hero.getX() == 1217 && hero.getY() == 1108||hero.getX() == 1206 && hero.getY() == 1108 || hero.getX() == 1229 && hero.getY() == 1108 ) {
			entidadeManage.getEntidades().clear();
			carregarMapa(CAMADA_3);
			entidadeManage.adicionarEntidade(hero);
			objetosMapa3();
			hero.setX(spawnX);
			hero.setY(spawnY);
			handler.getKeyManager().getDica().getDica().setIcon(new ImageIcon(CarregarImagenss.url("PerguntaMapa3Tela.jpg")));

			
		}
		if(hero.getX() == 829 && hero.getY() == 1236 ||hero.getX() == 837 && hero.getY() == 1236|| hero.getX() == 832 && hero.getY() == 1236 ) {
			
			int i = handler.getGame().getViewGame().getBarra().getValue();
			JOptionPane.showMessageDialog(null, "Seu tempo foi de : " +  (300-i)  +" Segundos");
			handler.getGame().getViewGame().dispose();			
			System.exit(0);
			
		}
		
		
		
		
		
				
			
		
	}
	public void render(Graphics g) {
		xStart = (int) Math.max(0, handler.getCamera().getXoffset() / Tile.TILE_LARGURA); // vai me retornar o maior dos dois números 
	 	xEnd 	= (int) Math.min(largura, (handler.getCamera().getXoffset() + handler.getLargura()) / Tile.TILE_LARGURA +2); //quantidade de blocos que será redrizado na tela ou seja desenhado
		yStart = (int) Math.max(0, handler.getCamera().getYoffset() / Tile.TILE_ALTURA);
		yEnd = (int) Math.min(altura, (handler.getCamera().getYoffset() + handler.getAltura()) / Tile.TILE_ALTURA +1);
		
		for(int y = yStart ; y < yEnd ; y ++) {
			for(int x = xStart ; x <xEnd; x++) {
				getTile(x, y).render(g, (int)(x * Tile.TILE_LARGURA - handler.getCamera().getXoffset()), (int)(y * Tile.TILE_ALTURA - handler.getCamera().getYoffset()));			
			}																						
		}
		//itens 
		gerenciadorItens.render(g);
		//entidades
		
		entidadeManage.render(g);
	
	}

	public int getAltura() {
		return largura;
	}
	
	public int getLargura() {
		return largura;
	}
	public Tile getTile (int x , int y) {
													
		if(x <  0 || y < 0 || x >= largura || y >= altura) {
			return Tile.parede;	
		}
		
		int i = tiles[x][y]; 	
		Tile tile = Tile.tiles[i]; 
		if(tile == null) {						 
			return Tile.pisoMapa1;			
		}
		return tile;
	}
	
	public void objetosMapa1() {
		 entidadeManage.adicionarEntidade(new Objetos(handler, 100, 250)) ;	 
		 entidadeManage.adicionarEntidade(new Objetos(handler, 100 -15, 1217)) ;	 
	     entidadeManage.adicionarEntidade(new Objetos(handler, 100, 450)) ;	 
		 entidadeManage.adicionarEntidade(new Objetos(handler, 100, 650));	 
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1342, 1336));	 //esse é o que vou por a fogueira esse é o que tem que ter a chave
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler, 1371, 1490 ));	 //esse é o que vou por a fogueira
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1348, 406 ));	 //esse é o que vou por a fogueira
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 697 +32, 1216 -64 ));	 //esse é o que vou por a fogueira
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 722 , 873));	 
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 213 , 1725));	 
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 1342 , 1731));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 644 , 0));
		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 1728 - 64,0 ));
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 1177, 64 ));
		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 448, 64 ));
		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 1728 +128 - 64 ,0));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1699, 1235));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1702, 1778 -64));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1699, 1472 ));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1699, 1472 ));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1596, 384 -128 ));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1596 + 128, 384 -128 ));
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler, 1535 ,954 ));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 634 ,1725 ));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1342 -320, 1336));	 
		 
	}
	public void objetosMapa2() {
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1280, 0)) ;	 
	     entidadeManage.adicionarEntidade(new Objetos(handler, 256, 0)) ;	 
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1792 -64 - 64, 640 - 64));	 
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 1216 -128 ,640 - 128 - 128));	 
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 1289  ,1115+ 128 +128+64));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 128+64 , 1600));
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 583, 64));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 803, 760));
		 entidadeManage.adicionarEntidade(new Objetos.Cenoura(handler, 175, 946 - 64));//vai conter a chave
		 entidadeManage.adicionarEntidade(new Objetos.Arroz(handler, 175 -64, 946 - 64));
		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 790, 979-64 ));
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler, 283, 175 ));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 115, 636 ));
		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 649, 1639 -64 ));
		 entidadeManage.adicionarEntidade(new Objetos.Arroz(handler, 319, 952 ));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1699, 1235));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1702, 1778 -64));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1699, 1472 ));
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler, 1698, 755 ));
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler, 755, 1212 ));
//		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 1728 +128 -64 ,0));
	}
	
	public void objetosMapa3() {
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 256 + 64, 64));
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 256 + 64 + 384, 64));
		 entidadeManage.adicionarEntidade(new Objetos(handler, 1604 , 64));
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler, 1630 , 239));
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 766 , 388));
		 entidadeManage.adicionarEntidade(new Objetos.Estatua(handler, 215 , 736));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler, 1222 , 559));
		 entidadeManage.adicionarEntidade(new Objetos.Mesa(handler, 1539 , 1423));
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 451 , 1156));
		 entidadeManage.adicionarEntidade(new Objetos.LegumesJuntos(handler, 451 +384 , 1156));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1528, 706));
		 entidadeManage.adicionarEntidade(new Objetos.EstatuaCaveira(handler, 1528, 1102 -64));
		 entidadeManage.adicionarEntidade(new Objetos.Bandeira(handler,766 , 1268 -64));
		 entidadeManage.adicionarEntidade(new Objetos.Bandeira(handler,766 + 128, 1268 -64));
		 entidadeManage.adicionarEntidade(new Objetos.Bandeira(handler,766 , 1268 ));
		 entidadeManage.adicionarEntidade(new Objetos.Bandeira(handler,766 + 128, 1268 ));
		 entidadeManage.adicionarEntidade(new Objetos(handler,574, 1268 ));
		 entidadeManage.adicionarEntidade(new Objetos(handler,574 + 128 + 128 + 128 + 64, 1268 ));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler,454 ,1759 -64 ));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler,922 ,1759 -64 ));
		 entidadeManage.adicionarEntidade(new Objetos.tumulo(handler,1513 ,1759 -64 ));
		 entidadeManage.adicionarEntidade(new Objetos.Fogueira(handler,1507 +30 ,877 ));
		 entidadeManage.adicionarEntidade(new Objetos.Arroz(handler,256,1215 ));
		 entidadeManage.adicionarEntidade(new Objetos.Cenoura(handler,256 +64,1215 ));
		 entidadeManage.adicionarEntidade(new Objetos.Cenoura(handler,256 +128,1215 ));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler,192 ,451));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler,192 +64 ,451));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler,192 +64 +64 ,451));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler,1168 ,388));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler,1514 ,1341));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler, 1339,1525));
		 entidadeManage.adicionarEntidade(new Objetos.Barril(handler, 1339,1525 + 64));

	}



	public GerenciadorItens getGerenciadorItens() {
		return gerenciadorItens;
	}



	public void setGerenciadorItens(GerenciadorItens gerenciadorItens) {
		this.gerenciadorItens = gerenciadorItens;
	}



	public void setEntidadeManage(EntidadeManage entidadeManage) {
		this.entidadeManage = entidadeManage;
	}
	
	
}	

