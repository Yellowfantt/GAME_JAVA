package Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hero  extends Criatura{
	private  Animacoes animadow, animaUp, animaleft, animahight, animaHero, ataqueup, ataqueleft, ataquehight, ataquedown;
	private long lasAttackTimer, tempodeAtaque = 300, ataqueTempo = tempodeAtaque;	// 800 milesegundo para atacar de novo 	
	// o player dele � 64 por 64 ai ele definiu y = 32 ai vai ficar 32 pixel alem da cabe�a dele, o certo seria eu por zero ali que ai quando eu adicionar o player vai ter o mesmo tamanho do bloco
	public Hero(Handler handler, float x, float y) {
		super(handler, x, y,Criatura.LARGURA_PADRAO,Criatura.ALTURA_PADRAO); // se eu precisar mudar a altura e largura do meu personagem � s� mudar em criatura
		bounds.x = 10;               // isso aqui muda o da esquerda para ficar junto da parede																			// posso meter um 32 aqui ai fica do lado
		bounds.y = 44; 	            // muda o de cima para ficar junto    													// bounds x � tipo se meu personagem est� em 0 e 0 do mapa a caixa est� em 16 agr se y est� em 0 nossa caixa est� em 30
		bounds.width = 40;				//50									// 16 � a metade da largura ent�o estariamos pegando a metade do personagem e setando em x e 30 � equivalente altura -2 pixel 
		bounds.height = 15;			   // 53												//dividir a largura em 2 agr � 16 a largura do quadrado que o cerca ent�o a direita vai ser 16
		iniciar();
															// aumento ou reduzo que est� tudo ok						//	 hero tera seu proprio tamanho de quadrado
		
		
	}
	
	public void iniciar() {
		animadow = new Animacoes(350, Assets.player_down);     //500 milisegundo � metade de 1 segundo
		animaUp = new Animacoes(350, Assets.player_up);
		animaleft = new Animacoes(350, Assets.player_left);
		animahight = new Animacoes(350, Assets.player_right);
		animaHero = new Animacoes(350, Assets.player_parado); // 350
		
		ataquedown = new Animacoes(400, Assets.downAtq);
		ataqueup = new Animacoes(400, Assets.upAtq);
		ataquehight = new Animacoes(400, Assets.rightAtq);
		ataqueleft = new Animacoes(400, Assets.leftAtq);
		
	}

	@Override
	public void tick() {
		//anima��es
		animadow.tick();
		animaUp.tick();
		animahight.tick();
		animaleft.tick();
		animaHero.tick();
		ataquedown.tick();
		ataquehight.tick();
		ataqueleft.tick();
		ataqueup.tick();
	
		//movimentos
		configMovimentos();
		move(); 
		handler.getCamera().centralizarEntidade(this);
		
		//ataque 
		verificarAtaques();
		
	}
	
	private void verificarAtaques() { // aqui � onde vamos verificar se o usuarios est� precionando a tecla de ataque 
		ataqueTempo += System.currentTimeMillis() - lasAttackTimer;
		lasAttackTimer = System.currentTimeMillis();
		if(ataqueTempo < tempodeAtaque)
			return;
		Rectangle cb = getColisaobounds(0, 0);
		Rectangle re = new Rectangle();
		int reSize = 20; // se o meu hero estiver a 20 pixel do inimigo ele deve acertar se n, ele n�o aceta 
		re.width = reSize; // largura e altura do nosso retangulo
		re.height = reSize;
		
		if(handler.getKeyManager().aUp) {
			re.x = cb.x + cb.width / 2 - reSize / 2;
			re.y = cb.y - reSize;
		}else if(handler.getKeyManager().aDown) {
				re.x = cb.x + cb.width / 2 - reSize / 2;
				re.y = cb.y + cb.height;
			}else if(handler.getKeyManager().aLeft) {
				re.x = cb.x - reSize;
				re.y = cb.y + cb.height / 2 - reSize / 2;
			}else if(handler.getKeyManager().aright) {
				re.x =  cb.x + cb.width;
				re.y = cb.y + cb.height / 2 - reSize / 2;
			}else {
				return;
		}
		ataqueTempo = 0;
		for(Entidade e : handler.getWorld().getEntidadeManage().getEntidades()) {
			if(e.equals(this)) {
				continue;
			}
			if(e.getColisaobounds(0, 0).intersects(re)) {
				e.hurt(1); // -1 de vida 
				return;
			}
		}
		
		
	}
	// no caso meu y vai receber o y atual menos a velocidade de 3f ou seja y = 30 e velocidade por padr�o � 3f ent�o 30-3 = 27 pq � y
   // ymove vai ser igual a velocidade do personagem negativa pq estamos subindo o eixo y 
	
	public void configMovimentos() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -velocidade;			//isso � a mesma coisa de por um -3 mano ele s� adicionou na v�riavel pra ficar mudando kkk 
		}
		
		if(handler.getKeyManager().down) {
			yMove = velocidade; // ou seja a velocidade normal
		}
		
		if(handler.getKeyManager().left) {
			xMove = -velocidade;
		} 
		
		if(handler.getKeyManager().right) {
			xMove = +velocidade;
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		// vou fazer aqui antes de desenhar o hero vou perguntar se ele t� atacando
		g.drawImage(getCurrentAnimacao(), (int) (x - handler.getCamera().getXoffset()), (int) (y - handler.getCamera().getYoffset()), largura, altura, null);

	}
	
	private BufferedImage getCurrentAnimacao() {
		if(handler.getKeyManager().aUp) {
			return ataqueup.getCurrentFrame();
		}
		if(handler.getKeyManager().aDown) {
			return ataquedown.getCurrentFrame();
		}
		if(handler.getKeyManager().aLeft) {
			return ataqueleft.getCurrentFrame();
		}
		if(handler.getKeyManager().aright) {
			return ataquehight.getCurrentFrame();
		}
		
		if (xMove < 0) { // estamos nos movendo para a esquerda, n�meros negativos nos diz que estamos
							// nos movendo par a esquerda
			return animaleft.getCurrentFrame();
	
		}
		if(xMove > 0) {
			return animahight.getCurrentFrame();
			
		}
		if(yMove < 0) {
			return animaUp.getCurrentFrame();
		}else if(yMove > 0) {
			return animadow.getCurrentFrame();
		}
		else {
			return animaHero.getCurrentFrame();
		}
		
		
	}

	@Override
	public void die() {
		System.out.println("O tempo acabou! ");
	}

	
}
