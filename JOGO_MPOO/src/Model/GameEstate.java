package Model;

import java.awt.Graphics;

public class GameEstate extends States { // isso � um controlador  mover ele depois para controll
	//private Hero hero;
	private World world;
//	private Tree tree;
	String path = "res//worlds//world1.txt";
	public GameEstate(Handler handler) {
		super(handler);
		world = new World(handler, path);
		handler.setWorld(world);
		//hero = new Hero(handler,64,64);
		//handler.getCamera().move(100, 200); //100/200
		//tree = new Tree(handler,100,200);
		

		 // como hero � executado nessa classe e gameestado recebe game como v�riavel no construtor passei logo
		
	}
	@Override
	public void tick() {
		world.tick();

	}
	
	@Override
	public void render(Graphics g) {
		world.render(g);

	}
	

}
