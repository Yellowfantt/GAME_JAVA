package Model;

import java.awt.Graphics;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EntidadeManage { // será a classe que gerenciar todas as entidades do meu game 
	private Handler handler;
	private Hero hero;
	private List<Entidade> entidades = new LinkedList<>();
	//private ArrayList<Entidade> entidades;
	private Comparator<Entidade> renderSorted = new Comparator<Entidade>() {
		@Override
		public int compare(Entidade a, Entidade b) {
			if(a.getY() + a.getAltura() < b.getY()+ b.getAltura())
					return -1;
			return 1;
		}
		
	};
	
	public EntidadeManage(Handler handler, Hero hero) {
		this.handler = handler;
		this.hero = hero;
		entidades = new LinkedList<Entidade>(); // atravez desse arrya eu vou poder remover e adicionar minhas entidades
		adicionarEntidade(hero);
		
	}
	public void tick() {
			Iterator<Entidade> it = entidades.iterator();
			while(it.hasNext()) {// se tiver itens na lista me retorna true ou seja enquanto tiver um próximo ele faz o que tem aqui 
			Entidade e = it.next();
			e.tick();
			if(!e.isAtive())			// verifico se aquela entidade está viva 
				it.remove();
		}
		entidades.sort(renderSorted);
		
	}
	
	public void render(Graphics g) {
		for(Entidade e : entidades) {
			e.render(g);
		}
		 // eu desenho hero independente do meu array ser vazio, hero é especial
		
			
			
		}
		
		
	
	
	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	
	public void adicionarEntidade(Entidade e) {
		entidades.add(e);
		
	}
	public List<Entidade> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<Entidade> entidades) {
		this.entidades = entidades;
	}
	
	

}
