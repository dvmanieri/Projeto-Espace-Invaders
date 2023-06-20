package Introdução;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Tutorial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutorial frame = new Tutorial();
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
	public Tutorial() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1980, 1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(39, 39, 39));
		btnNewButton.setIcon(new ImageIcon(Tutorial.class.getResource("/img/voltar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio voltar = new Inicio(); //é um sistema para abrir só uma vez
				voltar.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(661, 917, 557, 63);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Tutorial.class.getResource("/img/Tiro.gif")));
		lblNewLabel_1.setBounds(763, 616, 374, 275);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Tutorial.class.getResource("/img/Boost.gif")));
		lblNewLabel_2.setBounds(1366, 594, 345, 318);
		contentPane.add(lblNewLabel_2);
		

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Tutorial.class.getResource("/img/Movimentacao.gif")));
		lblNewLabel_3.setBounds(64, 594, 461, 204);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Tutorial.class.getResource("/img/Movimenta\u00E7\u00E3o.png")));
		lblNewLabel.setBounds(-26, -34, 1972, 1146);
		contentPane.add(lblNewLabel);
		
		
	
		
		
	
	}
}
