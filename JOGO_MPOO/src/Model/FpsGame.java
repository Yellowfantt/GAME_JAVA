package Model;

public class FpsGame {
	private double tempoPorTick;
	private double delta ;
	private long novoTempo;
	private long lasTime;
	private long timer;
	private long ticks;
	
	
	public FpsGame(int fps) {
	
		this.tempoPorTick = 1000000000/fps;
		this.delta = 0;
		this.lasTime = System.nanoTime();
		this.timer = 0;
		this.ticks = 0;
	
	}
	
	public boolean verificar() {
		novoTempo = System.nanoTime();
		delta +=(novoTempo - lasTime) / tempoPorTick; // isso aqui vai gerar a qauntidade de tempo que eu tenho até chamar os metodos o número gerado aqui fica entre 0 e 1 
		timer += novoTempo - lasTime;
		lasTime = novoTempo;
		

		
		if(delta >=1) {	
			ticks++;
			delta--;
		   return true;
				
			
		}
		else {
			return false;
		}
		
		
	}

	public boolean ticksporsegundo() {
		if(timer >= 1000000000) {
			//System.out.println(ticks); //isso me retorna os fps por segundo
			timer = 0;
			ticks = 0;
			return true;
		}
		
		
		return false;
		
	}
	


}
