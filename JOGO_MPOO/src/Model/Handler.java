package Model;

public class Handler {
	private Game game;
	private World world;
	
	public Handler(Game game ) {
		this.game = game;
		
	}
	
	public Camera getCamera() {
		return game.getCamera();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getLargura() {
		return game.getLargura();
	}
	
	public int getAltura() {
		return game.getAltura();
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	
	
	

}
