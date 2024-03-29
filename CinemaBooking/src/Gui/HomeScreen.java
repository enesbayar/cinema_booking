package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

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
import java.awt.Cursor;
import java.awt.Toolkit;

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen homeScreen = new HomeScreen();
					homeScreen.setLocationRelativeTo(null);
					homeScreen.setVisible(true);
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeScreen.class.getResource("/homeScreen/stage.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setForeground(new Color(0, 0, 0));
		setResizable(false);
		setTitle("SineMovie");
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon costumerManIcon = new ImageIcon(new ImageIcon("images/homeScreen/costumerMan.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
		ImageIcon costumerWomanIcon = new ImageIcon(new ImageIcon("images/homeScreen/costumerWoman.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
		ImageIcon adminIcon = new ImageIcon(new ImageIcon("images/homeScreen/admin.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
		
		JLabel lbl_costumerWoman = new JLabel("");
		lbl_costumerWoman.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_costumerWoman.setBounds(10, 185, 400, 400);
		lbl_costumerWoman.setIcon(costumerWomanIcon);
		contentPane.add(lbl_costumerWoman);
		
		JLabel lbl_costumerMan = new JLabel("");
		lbl_costumerMan.setIcon(costumerManIcon);
		lbl_costumerMan.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_costumerMan.setBounds(198, 185, 400, 400);
		contentPane.add(lbl_costumerMan);
		
		JLabel lbl_admin = new JLabel("");
		lbl_admin.setIcon(adminIcon);
		lbl_admin.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_admin.setBounds(760, 185, 400, 400);
		contentPane.add(lbl_admin);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(HomeScreen.class.getResource("/homeScreen/wallpaper.jpg")));
		lblBackground.setBounds(0, 0, 1274, 771);
		contentPane.add(lblBackground);
		
		lbl_costumerMan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CustomerScreen costumerScreen;
				try {
					costumerScreen = new CustomerScreen();
					costumerScreen.setVisible(true);
					costumerScreen.setLocationRelativeTo(null);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		lbl_costumerWoman.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CustomerScreen costumerScreen;
				try {
					costumerScreen = new CustomerScreen();
					costumerScreen.setVisible(true);
					costumerScreen.setLocationRelativeTo(null);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		lbl_admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					AdminScreen	adminScreen = new AdminScreen();
					adminScreen.setVisible(true);
					adminScreen.setLocationRelativeTo(null);
					dispose();
			}
		});
	
	}
}

