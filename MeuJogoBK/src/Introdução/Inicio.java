package Introdução;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import meujogo.Container;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Inicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo( null );
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Container fase = new Container();
				fase.setVisible(true);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(65, 65, 65));
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/img/imgJogar1.png")));
		btnNewButton.setBounds(102, 514, 716, 85);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tutorial tutorial = new Tutorial();
				tutorial.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Inicio.class.getResource("/img/imgTutoras.png")));
		btnNewButton_1.setBackground(new Color(65, 65, 65));
		btnNewButton_1.setBounds(102, 653, 716, 85);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/img/Design sem nome.png")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);

		
		
	
		
		
		

		
		
	}
}
