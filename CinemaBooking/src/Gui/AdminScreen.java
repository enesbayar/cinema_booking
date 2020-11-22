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
public class AdminScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_userName;
	private JPasswordField passwordField;
	private AdminServices adminServices;
	private ArrayList<Admin> adminList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen frame = new AdminScreen();
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
	public AdminScreen(){
		adminServices = new AdminServices();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_signIn = new JButton("Giri\u015F");
		
		btn_signIn.setBounds(124, 238, 89, 23);
		contentPane.add(btn_signIn);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 Ad\u0131 :");
		lblNewLabel.setBounds(59, 114, 59, 23);
		contentPane.add(lblNewLabel);
		
		textField_userName = new JTextField();
		textField_userName.setBounds(127, 115, 86, 20);
		contentPane.add(textField_userName);
		textField_userName.setColumns(10);
		
		JLabel lblifre = new JLabel("\u015Eifre :");
		lblifre.setBounds(59, 151, 59, 23);
		contentPane.add(lblifre);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 152, 89, 20);
		contentPane.add(passwordField);
		btn_signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					adminList = adminServices.login();
					Admin admin = new Admin(textField_userName.getText(), passwordField.getText());
					for(int i = 0; i<adminList.size(); i++){
						Admin tempAdmin = new Admin(adminList.get(i).getUserName(),adminList.get(i).getPassword());
						if(admin.getUserName().equals(tempAdmin.getUserName())&& admin.getPassword().equals(tempAdmin.getPassword())){
							JFrame adminManagement = new AdminManagement();
							adminManagement.setVisible(true);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"Bulunamadi");
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}