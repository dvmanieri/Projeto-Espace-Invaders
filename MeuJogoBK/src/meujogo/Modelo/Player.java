package meujogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener {

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List<Tiro> tiros;
	private  boolean isVisivel,isTurbo;
	private Timer timer;// ele vai vir para o turbo
	private int quantidade=4;//ele regula quando turbos pode ter
	public Player() {
		this.x = 250;
		this.y = 250;
		isVisivel = true;
		setTurbo(false);// para não ter o turbo o tempo todo

		tiros = new ArrayList<Tiro>();
		timer = new Timer(5000, this);// cronometro para o turbo
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(isTurbo()==true) {
			turbo();
			setTurbo(false);
		}
		
		if(isTurbo() == false) {
			load();
		}
		
		
	}

	public void load() {
		ImageIcon referencia = new ImageIcon(getClass().getResource("imgPlayer.gif"));
		imagem = referencia.getImage();
		altura = imagem.getHeight(null) / 2;
		largura = imagem.getWidth(null) / 2;
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void tiroSimples() {
		this.tiros.add(new Tiro((x + largura) + 10, (y + altura) - 10));
	}//aqui regula aonde dá onde os tiros vão sair

	public void turbo() {
		
		

		if(isTurbo()==false) { //ele so consta o turbo quando aperta o PRIMEIRO espaço
			this.quantidade = this.quantidade - 1;
			
		}
		
		if(this.quantidade>0) {//um if para regular quantos turbos podem ter
		setTurbo(true);// deixa o turbo como verdadeiro para funcionar e depois troca a imagem
		ImageIcon referencia = new ImageIcon(getClass().getResource("imgNaveTurbo.png"));
		imagem = referencia.getImage();
		}
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void keyPressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		if (codigo == KeyEvent.VK_SPACE) {//identificador para o turbo
			turbo();
		}
		
		
		if (codigo == KeyEvent.VK_UP) {
			dy = -6;
		}
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 6;
		}
		if (codigo == KeyEvent.VK_LEFT) {
			dx = -6;
		}
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 6;
		}
	}

	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		if (codigo == KeyEvent.VK_A) {
			if(isTurbo()==false) {//só vai poder atirar se não estiver no modo turbo
				
				tiroSimples();
				
			}
		}
		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

	}

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
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

	public List<Tiro> getTiros() {
		return tiros;
	}

	public boolean isTurbo() {
		return isTurbo;
	}

	public void setTurbo(boolean isTurbo) {
		this.isTurbo = isTurbo;
	}

}
