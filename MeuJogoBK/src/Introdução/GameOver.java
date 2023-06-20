package Introdução;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import meujogo.Modelo.Fase;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class GameOver extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver frame = new GameOver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameOver() {
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\r\n");
		btnNewButton.setBackground(new Color(39, 39, 39));
		btnNewButton.setIcon(new ImageIcon(GameOver.class.getResource("/img/voltar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio voltar = new Inicio();
				voltar.setVisible(true);
				dispose();
			
				
			}
		});
		btnNewButton.setBounds(656, 900, 673, 80);
		contentPane.add(btnNewButton);
		
		Fase pontuacao = new Fase();
//		
//		JLabel lblNewLabel_2 = new JLabel("A SUA PONTUA\u00C7\u00C3O FOI:");
//		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
//		lblNewLabel_2.setForeground(new Color(255, 255, 255));
//		lblNewLabel_2.setBounds(789, 363, 451, 69);
//		contentPane.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_1 = new JLabel(""+pontuacao.getCont());
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 42));
//		lblNewLabel_1.setForeground(new Color(255, 255, 255));
//		lblNewLabel_1.setBounds(899, 444, 217, 56);
//		contentPane.add(lblNewLabel_1);
//		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GameOver.class.getResource("/img/gamOver.png")));
		lblNewLabel.setBounds(0, 0, 1940, 1080);
		contentPane.add(lblNewLabel);
		
		
		

		
	}

}
