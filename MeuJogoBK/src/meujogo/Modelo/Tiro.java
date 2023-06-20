 package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Tiro {

	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	private int InimigosDerrotados;
	
	private static final int LARGURA = 1280;
	private static int VELOCIDADE = 7;
	
	
	public Tiro(int x, int y) {
		this.x = x;
		this.y = y-37;
		isVisivel = true;
	}
	
	
	//a imagem do tiro está na própria classe
	public void load() {
		ImageIcon referencia = new ImageIcon(getClass().getResource("TiroSimples.png"));
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}
	
	public void update() {
		//inimigos derrotados
		this.x += VELOCIDADE;
			if(this.x > LARGURA) {
				isVisivel = false;
				ImageIcon referencia = new ImageIcon(getClass().getResource("TiroSimples.png"));
				imagem = referencia.getImage();
				
			}
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
