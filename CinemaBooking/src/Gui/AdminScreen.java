package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import Services.AdminServices;
import Model.Admin;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class AdminScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdmin;
	private JPasswordField passwordField;
	private AdminServices adminServices;
	private ArrayList<Admin> adminList;
	private JLabel lblWallpaper;

	public AdminScreen(){
		setUndecorated(true);
		adminServices = new AdminServices();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(71, 71, 206, 23);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(71, 136, 206, 1);
		contentPane.add(separator);
		
		txtAdmin = new JTextField();
		txtAdmin.setToolTipText("");
		txtAdmin.setOpaque(false);
		txtAdmin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
		txtAdmin.setBorder(null);
		txtAdmin.setForeground(new Color(192, 192, 192));
		txtAdmin.setBounds(71, 105, 203, 33);
		contentPane.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBorder(null);
		passwordField.setToolTipText("");
		passwordField.setOpaque(false);
		passwordField.setBounds(71, 204, 206, 23);
		contentPane.add(passwordField);
		
		JLabel lblPassword = new JLabel("Sifre :");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPassword.setBounds(71, 160, 203, 23);
		contentPane.add(lblPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(68, 228, 206, 1);
		contentPane.add(separator_1);
		
		JLabel lblSignIn = new JLabel("Giri\u015F");
		
		lblSignIn.setFont(new Font("Georgia", Font.BOLD, 14));
		lblSignIn.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setForeground(new Color(255, 255, 255));
		lblSignIn.setBounds(71, 261, 193, 33);
		contentPane.add(lblSignIn);
		
		JLabel lblButton = new JLabel("");
		lblButton.setForeground(new Color(255, 255, 255));
		lblButton.setIcon(new ImageIcon(AdminScreen.class.getResource("/adminScreen/button.png")));
		lblButton.setBounds(71, 261, 193, 33);
		contentPane.add(lblButton);
		
		lblWallpaper = new JLabel("");
		lblWallpaper.setIcon(new ImageIcon(AdminScreen.class.getResource("/adminScreen/wallpaper.jpg")));
		lblWallpaper.setBounds(0, 0, 800, 600);
		contentPane.add(lblWallpaper);
		lblSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					adminList = adminServices.login();
					Admin admin = new Admin(txtAdmin.getText(), passwordField.getText());
					for(int i = 0; i<adminList.size(); i++){
						Admin tempAdmin = new Admin(adminList.get(i).getUserName(),adminList.get(i).getPassword());
						if(admin.getUserName().equals(tempAdmin.getUserName())&& admin.getPassword().equals(tempAdmin.getPassword())){
							JFrame adminManagement = new AdminManagement();
							adminManagement.setLocationRelativeTo(null);
							adminManagement.setVisible(true);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"Bulunamadi");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
