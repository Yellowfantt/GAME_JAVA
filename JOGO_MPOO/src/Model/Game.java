package Model;
//canvas que nos permite desenhar coisas na tela 
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JComboBox.KeySelectionManager;
import javax.swing.JFrame;

import View.ViewGame;

public class Game implements Runnable{
	private ViewGame viewGame;
	private int largura ;
	private int altura;
	private boolean flag = false;
	private Thread thread;
	
	private Graphics g;
	private BufferStrategy bs;
	//estados 	
	public States gameEstado;
	public States menuEstado;
	
	//tecla
	private KeyManager teclas;
	// camera
	private  Camera camera;
	//Handler
	// MouseListener
	private MouseManager mouseManager;
	private Handler handler;
	public Game(ViewGame viewGame) { 
		this.viewGame = viewGame;
		teclas = new KeyManager();
		mouseManager = new MouseManager();
		this.largura = viewGame.getLargura();
		this.altura = viewGame.getAltura();
		start();
		
		

	}
	
	public void init() {
	viewGame.addKeyListener(teclas);
	
	viewGame.addMouseListener(mouseManager);
	viewGame.addMouseMotionListener(mouseManager);
	

	viewGame.getCanvas().addMouseListener(mouseManager);
	viewGame.getCanvas().addMouseMotionListener(mouseManager);
	

	Assets.init();
	handler = new Handler(this);													// a váriavel que é um objeto ganhou uma instancia de uma classe ou seja ganhou um objeto
	camera = new Camera(handler, 0,0);
	
	gameEstado = new GameEstate(handler);
	menuEstado = new MenuState(handler);
	States.setEstado(gameEstado); 
	}
	// poderia ter criado a classe pai states e ela vai ser pai de gameestado e hero onde
	public void tick() {
		teclas.tick();  // é pq eu preciso tá verificando o tempo todo, se a tecla foi precionada ou não
		if(States.getEstado() != null) {
			States.getEstado().tick(); // aqui que estou chamando o metodo tick de hero
		}
		
	
		
	}
	
	public void render() {		
		bs = viewGame.getCanvas().getBufferStrategy(); // são as telinhas oculas existem 3 no máximo
		if(bs == null) { // se o canvas não tiver um buff de estrateia eu crio um 
			viewGame.getCanvas().createBufferStrategy(3);
			return;
			
		}
		
		g = bs.getDrawGraphics(); // nos permite desenhar coisas na tela são graficos  é o pincel 
		g.clearRect(0, 0, largura,altura );
		
		if(States.getEstado() != null) {
			States.getEstado().render(g);
		}
//		g.drawImage(Assets.player, 10, 10, null);
//		g.drawImage(Assets.homemaranhanegro, 100, 100, null);
//		g.drawImage(Assets.hulk, 300, 300, null);
//		g.drawImage(Assets.ciclope,500 , 400, null);
		bs.show();
		g.dispose();
	
		
	}													
	@Override				// fps significa frames por segundos ou tick por segundo 
	public void run() {		// fps vai ser a quantidade de vezes que queremos que tick e render sejam executados 
		init();				// ou seja quero que sejam chamados a cada 60 segundos 
		FpsGame fpsgame = new FpsGame(60);
		while(flag) {
			
			if(fpsgame.verificar()) {
				tick();
				render();
				
			}
			fpsgame.ticksporsegundo();
		
		}
		stop();
	
	}
	
	public synchronized void start() {
		if(flag)
		return;
		flag = true;
		thread = new Thread(this); // a classe que vai executar essa thrade, ou seja precisa passar um objeto que implementa runnable
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(!flag)
		 return;
		flag = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public  KeyManager getKeyManager() {
		return teclas;
		
	}
	
	public Camera getCamera() {
		return camera;
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
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public ViewGame getViewGame() {
		return viewGame;
	}
	
	
	



}
