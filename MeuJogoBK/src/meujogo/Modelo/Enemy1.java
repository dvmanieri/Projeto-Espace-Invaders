package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy1 {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	
//	private static final int LARGURA = 938;
	private static int VELOCIDADE = 4;
	
	
	public Enemy1(int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}
	
	public Enemy1() {
		// TODO Auto-generated constructor stub
	}

	public void load() {
		ImageIcon referencia = new ImageIcon(getClass().getResource("imgInimigo.png"));
		imagem = referencia.getImage();
		
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}
	
	public void update() {
		if (this.x < 0) {
			this.x = largura;
			Random a = new Random();
			int m = a.nextInt(500);// gera um numero aleatorio
			this.x = m + 1024;// 1024 é a largura dá tela, os inimigos vem de fora dá tela
			Random r = new Random();
			int n = r.nextInt(768);
			this.y = n;// agora é para definir aleatoriamente a altura em que os inimigos vão aparecer
		} else {
			this.x -= VELOCIDADE;
		}
	
		   this.x -= VELOCIDADE;
//			if(this.x > LARGURA) {
//				isVisivel = false;
//			}
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,largura,altura);
	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
}
