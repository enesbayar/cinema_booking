package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
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
	public HomeScreen() {
		setResizable(false);
		setTitle("SineMovie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_costumer = new JPanel();
		pnl_costumer.setBackground(UIManager.getColor("Button.disabledForeground"));
		pnl_costumer.setBounds(0, 0, 400, 571);
		contentPane.add(pnl_costumer);
		pnl_costumer.setLayout(null);
		
		JLabel lbl_costumer = new JLabel("");
		
		lbl_costumer.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_costumer.setIcon(new ImageIcon("D:\\Java\\ileriDuzeyJavaProgramlama\\CinemaBooking\\CinemaBooking\\images\\Costumers.png"));
		lbl_costumer.setBounds(0, 11, 382, 539);
		pnl_costumer.add(lbl_costumer);
		
		JPanel pnl_admin = new JPanel();
		pnl_admin.setBackground(UIManager.getColor("Button.disabledForeground"));
		pnl_admin.setBounds(400, 0, 400, 571);
		contentPane.add(pnl_admin);
		
		JLabel lbl_admin = new JLabel("");
		
		lbl_admin.setIcon(new ImageIcon("D:\\Java\\ileriDuzeyJavaProgramlama\\CinemaBooking\\CinemaBooking\\images\\admin.png"));
		lbl_admin.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_admin.add(lbl_admin);
		lbl_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame adminScreen = new AdminScreen();
				adminScreen.setVisible(true);
				dispose();
			}
		});
		lbl_costumer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFrame costumerScreen;
				try {
					costumerScreen = new CostumerScreen();
					costumerScreen.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dispose();
			}
		});
	}
}