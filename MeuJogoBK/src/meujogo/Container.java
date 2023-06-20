package meujogo;

import javax.swing.JFrame;

import meujogo.Modelo.Fase;

public class Container extends JFrame{
	
	public Container() {
		setResizable(false);
		setUndecorated(true);
		getContentPane().add(new Fase());
		setTitle("Meu Jogo");
		setSize(1920,1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//setExtendedState(MAXIMIZED_BOTH);
	}

	public static void main (String []args) {
		new Container();
	}
}
