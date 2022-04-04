package Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hero  extends Criatura{
	private  Animacoes animadow, animaUp, animaleft, animahight, animaHero, ataqueup, ataqueleft, ataquehight, ataquedown;
	private long lasAttackTimer, tempodeAtaque = 300, ataqueTempo = tempodeAtaque;	// 800 milesegundo para atacar de novo 	
	// o player dele é 64 por 64 ai ele definiu y = 32 ai vai ficar 32 pixel alem da cabeça dele, o certo seria eu por zero ali que ai quando eu adicionar o player vai ter o mesmo tamanho do bloco
	public Hero(Handler handler, float x, float y) {
		super(handler, x, y,Criatura.LARGURA_PADRAO,Criatura.ALTURA_PADRAO); // se eu precisar mudar a altura e largura do meu personagem é só mudar em criatura
		bounds.x = 10;               // isso aqui muda o da esquerda para ficar junto da parede																			// posso meter um 32 aqui ai fica do lado
		bounds.y = 44; 	            // muda o de cima para ficar junto    													// bounds x é tipo se meu personagem está em 0 e 0 do mapa a caixa está em 16 agr se y está em 0 nossa caixa está em 30
		bounds.width = 40;				//50									// 16 é a metade da largura então estariamos pegando a metade do personagem e setando em x e 30 é equivalente altura -2 pixel 
		bounds.height = 15;			   // 53												//dividir a largura em 2 agr é 16 a largura do quadrado que o cerca então a direita vai ser 16
		iniciar();
															// aumento ou reduzo que está tudo ok						//	 hero tera seu proprio tamanho de quadrado
		
		
	}
	
	public void iniciar() {
		animadow = new Animacoes(350, Assets.player_down);     //500 milisegundo é metade de 1 segundo
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
		//animações
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
	
	private void verificarAtaques() { // aqui é onde vamos verificar se o usuarios está precionando a tecla de ataque 
		ataqueTempo += System.currentTimeMillis() - lasAttackTimer;
		lasAttackTimer = System.currentTimeMillis();
		if(ataqueTempo < tempodeAtaque)
			return;
		Rectangle cb = getColisaobounds(0, 0);
		Rectangle re = new Rectangle();
		int reSize = 20; // se o meu hero estiver a 20 pixel do inimigo ele deve acertar se n, ele não aceta 
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
	// no caso meu y vai receber o y atual menos a velocidade de 3f ou seja y = 30 e velocidade por padrão é 3f então 30-3 = 27 pq é y
   // ymove vai ser igual a velocidade do personagem negativa pq estamos subindo o eixo y 
	
	public void configMovimentos() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -velocidade;			//isso é a mesma coisa de por um -3 mano ele só adicionou na váriavel pra ficar mudando kkk 
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
		// vou fazer aqui antes de desenhar o hero vou perguntar se ele tá atacando
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
		
		if (xMove < 0) { // estamos nos movendo para a esquerda, números negativos nos diz que estamos
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
