package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Stars {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;

//	private static final int LARGURA = 938;
	private static int VELOCIDADE = 4;

	public Stars(int x, int y) {
		this.x = x;
		this.y = y;
		isVisivel = true;
	}

	public Stars() {
		// TODO Auto-generated constructor stub
	}

	public void load() {
		ImageIcon referencia = new ImageIcon(getClass().getResource("imgEstrelas.png"));
		imagem = referencia.getImage();

		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}

	public void update() {
		if (this.x < 0) {
			this.x = largura;
			Random a = new Random();
			int m = a.nextInt(1000);// gera um numero aleatorio
			this.x = m + 2000;// 1024 � a largura d� tela, as estrelas vem de fora d� tela
			Random r = new Random();
			int n = r.nextInt(1080);
			this.y = n;// agora � para definir aleatoriamente a altura em que as estrelas v�o aparecer
		} else {
			this.x -= VELOCIDADE;
		}
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
