package meujogo.Modelo;

import java.awt.Graphics;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Introdução.GameOver;
import Introdução.Inicio;
import meujogo.Container;

import java.awt.Color;

public class Fase extends JPanel implements ActionListener {

	private Image fundo;
	private Player player;
	private Timer timer;
	private List<Enemy1> enemy1;
	
	private List<Stars> stars;
	private boolean emJogo;
	public double cont;
	private boolean telas = true;
	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon(getClass().getResource("fundo.jpg"));
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		 
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		setLayout(null);
		timer.start();
		inicializarContagem();
		inicializaInimigos1();
		inicializaEstrelas();
		emJogo = true;
	}
	
	public double getCont() {
		return cont;
	}

	public void setCont(double cont) {
		this.cont = cont;
	}

	public void inicializarContagem() {
		JLabel texto;
		texto = new JLabel("ola mundo");
	}
	
	public void inicializaInimigos1() {
		int cordenadas [] = new int [150];
		enemy1 = new ArrayList<Enemy1>();
		
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 50000 + 1920);
			int y = (int)(Math.random() * 1080 + 10);
		
			enemy1.add(new Enemy1(x, y));
			
			
		}
	}
	
	
	//metodo para iniciar as estrelas
	public void inicializaEstrelas() {
		int cordenadas [] = new int [25];
		stars = new ArrayList<Stars>();
		for (int i = 0; i < cordenadas.length; i++) {
			int x = (int)(Math.random() * 1920 + 0);
			int y = (int)(Math.random() * 1080 + 0);
			stars.add(new Stars(x, y));
			
		}
			
	}
	
	public void paint(Graphics g) {
		
		Graphics2D graficos = (Graphics2D) g;
		if(emJogo == true) {
			graficos.drawImage(fundo, 0, 0, null);
			
			for(int p = 0; p < stars.size(); p++) {
				Stars q = stars.get(p);
				q.load();
				graficos.drawImage(q.getImagem(), q.getX(), q.getY(), this);
			}
			
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
			
			List<Tiro> tiros = player.getTiros();
			for(int i = 0; i < tiros.size(); i++) {
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}
			
			for (int o = 0; o < enemy1.size(); o++) {
				Enemy1 in = enemy1.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}
			
		}
		else {
				
				//para reiniciar o jogo faça isso
				
				if(telas == true) {  // isso serve para abrir o inicio quando morrer 
					GameOver fim = new GameOver(); //é um sistema para abrir só uma vez
					fim.setVisible(true);
					telas = false;
					g.dispose();
					
				}
			
		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		
		if(player.isTurbo() == true) {//verifica se o turbo está ativado ou não
			Stars estrela = new Stars();
			estrela.setVELOCIDADE(20);
			//Enemy1 inimigo = new Enemy1();
			//estrela.setVELOCIDADE(40);
		}
		
		else{
			Enemy1 inimigo = new Enemy1();
			inimigo.setVELOCIDADE(10);//setta a velocidade dos inimigos 
			Stars estrela = new Stars();
			estrela.setVELOCIDADE(4);//setta a velocidade das estrelas
			
		}
		
		
		
		for(int p =0;p<stars.size();p++) {
			Stars on = stars.get(p);
			if(on.isVisivel()) {
				on.update();
			}else {
				stars.remove(p);
			}
		}
		
		List<Tiro> tiros = player.getTiros();
		for(int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
				if(m.isVisivel()) {
					m.update();
					if(player.isTurbo()) {
						tiros.get(i).setVELOCIDADE(-1);
					}
					if(player.isTurbo()==false) {
						tiros.get(i).setVELOCIDADE(5);
					}
				} else {
					tiros.remove(i);
				}
		}
		
		for (int o = 0; o < enemy1.size(); o++) {
			Enemy1 in = enemy1.get(o);
			if(in.isVisivel()) {
				in.update();
			} else {
				enemy1.remove(o);
			}
		}
		checarColisoes();
		repaint();
	
	}
	
	public void checarColisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaEnemy1;
		Rectangle formaTiro;
		int cont = 0;
		
		
		for(int i = 0; i < enemy1.size(); i++) {
			Enemy1 tempEnemy1 = enemy1.get(i);
			formaEnemy1 = tempEnemy1.getBounds();
				if(formaNave.intersects(formaEnemy1)) {
					if(player.isTurbo()==true) {//nessa parte basicamente quando o turbo estiver ligado os inimigos 
						tempEnemy1.setVisivel(false);//vão desaparecer, por isso o setVisible, sem fazer o player desaparecer tbm
						
					}else {//caso não estiver ligado eles vão ficar normal, quando encostar o player vai sumir tbm
					player.setVisivel(false);
					tempEnemy1.setVisivel(false);
					emJogo = false;
					}
				}
				
				List<Tiro> tiros = player.getTiros();
				for(int j = 0; j < tiros.size(); j++) {
					Tiro tempTiro = tiros.get(j);
					formaTiro = tempTiro.getBounds();
					for (int o = 0; o < enemy1.size(); o++) {
						Enemy1 tempEnemy11 = enemy1.get(o);
						formaEnemy1 = tempEnemy11.getBounds();
						if(formaTiro.intersects(formaEnemy1)) {
							this.cont = this.cont +1;
							System.out.println(this.cont);//ele printa os pontos
							tempEnemy11.setVisivel(false);
							tempTiro.setVisivel(false);
							
						}
					}
				}
				
				
		}
	}
 
	
	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e ) {
			player.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e ) {
			player.keyRelease(e);
		}
	}
}