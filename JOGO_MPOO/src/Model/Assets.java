package Model;


import java.awt.image.BufferedImage;

public class Assets {
	private static final int largura = 32 , altura = 32; // representa a altura e largura de cada quadrado 
	// imagine que as imagens são o player e hul é o piso eo homem arranha são as arvores e o homem arranha negro é as pedras 
	public static BufferedImage pisoMap1,paredeMap1, porta,chave,pisoMapa2, dragao,  tumulo, estatuaMulher, fogueiras,estatuaCaveira, arroz,cenoura,legumesJuntos,mesa,bandeira,barril, moeda;
	public static BufferedImage[] player_parado, player_down, player_up, player_left, player_right, downAtq, upAtq, leftAtq, rightAtq;
	
	public static void init() {	// é o metodo que vai carregr tudo// por que vai carregar tudo e vai ser chamado uma vez 
		
		SpriteSheet sheet = new SpriteSheet(CarregarImagenss.loadImage("Sprite Sheet2.png")); // agr 
		SpriteSheet sheet2 = new SpriteSheet(CarregarImagenss.loadImage("dngn_open_door.png")); // pega o da porta
		SpriteSheet sheet3 = new SpriteSheet(CarregarImagenss.loadImage("Sprite SheetPisos.png")); // mada dois ter um novo piso
		
		
		SpriteSheet sheet5 = new SpriteSheet(CarregarImagenss.loadImage("herfo_left1.png"));
		SpriteSheet sheet6 = new SpriteSheet(CarregarImagenss.loadImage("hero_left2.png"));
		
		SpriteSheet sheet7 = new SpriteSheet(CarregarImagenss.loadImage("hero_low11.png"));
		SpriteSheet sheet8 = new SpriteSheet(CarregarImagenss.loadImage("hero_low22.png"));
		
		SpriteSheet sheet9 = new SpriteSheet(CarregarImagenss.loadImage("hero_righ.png"));
		SpriteSheet sheet10 = new SpriteSheet(CarregarImagenss.loadImage("hero_right2.png"));
		
		SpriteSheet sheet11 = new SpriteSheet(CarregarImagenss.loadImage("hero_up1.png"));
		SpriteSheet sheet12 = new SpriteSheet(CarregarImagenss.loadImage("hero_up2.png"));
		SpriteSheet sheet13 = new SpriteSheet(CarregarImagenss.loadImage("hero_parado.png"));
		
		SpriteSheet sheet0 = new SpriteSheet(CarregarImagenss.loadImage("enfeites_Sprite3.png"));
		SpriteSheet sheet33 = new SpriteSheet(CarregarImagenss.loadImage("HeroAtaques.png"));
		SpriteSheet sheet34 = new SpriteSheet(CarregarImagenss.loadImage("Fogueiras.png"));
		SpriteSheet sheet35 = new SpriteSheet(CarregarImagenss.loadImage("EnfeitesEst.png"));
		SpriteSheet sheet36 = new SpriteSheet(CarregarImagenss.loadImage("Enigmas.png"));
		SpriteSheet sheet37 = new SpriteSheet(CarregarImagenss.loadImage("Moeda1.png"));

		
		player_parado = new BufferedImage[1];
		player_down = new  BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2] ;
		
		player_right[0] = sheet9.cortar(0, 0, 38, 66);
		player_right[1] = sheet10.cortar(0, 0, 38, 66);
		
		player_left[0] = sheet5.cortar(0, 0, 38, 66);
		player_left[1] = sheet6.cortar(0, 0, 38, 66);
		
		player_up[0] = sheet11.cortar(0, 0, 38, 66);
		player_up[1] = sheet12.cortar(0, 0, 38, 66);
		
		player_down[0] = sheet7.cortar(0, 0, 38, 66);
		player_down[1] = sheet8.cortar(0, 0, 38, 66);
		player_parado[0] = sheet13.cortar(0, 0, 38, 66);
		
		upAtq = new BufferedImage[3];
		leftAtq = new BufferedImage[3];
		rightAtq = new BufferedImage[3];
		downAtq= new BufferedImage[3];
		
		downAtq[0] = sheet33.cortar(18, 35, 64, 70);
		downAtq[1] = sheet33.cortar(120, 35, 64, 70);
		downAtq[2] = sheet33.cortar(228, 35, 64, 70);
		
		leftAtq[0] = sheet33.cortar(31, 133, 64, 64);
		leftAtq[1] = sheet33.cortar(113, 133, 64, 64);
		leftAtq[2] = sheet33.cortar(213, 133, 64, 64);
		
		rightAtq[0] = sheet33.cortar(30, 233, 64, 69);
		rightAtq[1] = sheet33.cortar(131, 233, 64, 69);
		rightAtq[2] = sheet33.cortar(230, 233, 64, 69);
		
		upAtq[0] = sheet33.cortar(29, 333, 64, 66);
		upAtq[1] = sheet33.cortar(130, 333, 64, 66);
		upAtq[2] = sheet33.cortar(213, 333, 64, 66);
		
		pisoMap1 = sheet.cortar(0,0, largura, altura); // grama 
		paredeMap1 = sheet.cortar(32,0, largura, altura);
		chave = sheet.cortar(0, 32, largura, altura);
		pisoMapa2 = sheet3.cortar(0, 128, largura, altura);
		dragao = sheet0.cortar(0, 96 , 64, 64);// arvore é 0 224 e 64 e 64 
		tumulo = sheet0.cortar(160, 96, 96, 64);
		estatuaMulher = sheet0.cortar(0, 160, 32, 64);
		porta = sheet2.cortar(0, 0, 32, 32);
		fogueiras = sheet34.cortar(290, 0, 46, 42);
		
		estatuaCaveira = sheet35.cortar(290, 648, 47, 120);	
		arroz = sheet35.cortar(0, 287, 48, 48);	
		cenoura = sheet35.cortar(0, 335, 48, 48);
		legumesJuntos = sheet35.cortar(0, 406, 290, 51);
		mesa = sheet35.cortar(145, 152, 89, 88);
		bandeira = sheet36.cortar(321, 0, 63, 63);
		barril = sheet35.cortar(98, 0,50, 47);
		moeda = sheet37.cortar(0, 0, 83, 96);
		
	}


}
