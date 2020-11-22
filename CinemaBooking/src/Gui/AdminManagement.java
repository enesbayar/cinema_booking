package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import Services.MovieServices;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminManagement extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField_movieName;
	private JTextField textField_movieUrl;
	private JTextField textField_description;
	private JTextField textField_movieRate;
	private JTextField textField_price;
	private JTextField textField_sessions;
	private MovieServices movieServices = new MovieServices();
	private boolean isSuccessful = false;
	private JTextField textField_deleteMovieName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManagement frame = new AdminManagement();
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
	public AdminManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHoGeldiniz = new JLabel("Ho\u015F Geldiniz");
		lblHoGeldiniz.setBounds(39, 28, 106, 31);
		contentPane.add(lblHoGeldiniz);
		
		JLabel lblFilmEkle = new JLabel("Film Ekle");
		lblFilmEkle.setBounds(137, 82, 54, 31);
		contentPane.add(lblFilmEkle);
		
		JLabel lblFilmAd = new JLabel("Film Ad\u0131 :");
		lblFilmAd.setBounds(39, 151, 54, 25);
		contentPane.add(lblFilmAd);
		
		JLabel lblFilmUrl = new JLabel("Film Url :");
		lblFilmUrl.setBounds(39, 187, 54, 25);
		contentPane.add(lblFilmUrl);
		
		JLabel lblAklama = new JLabel("A\u00E7\u0131klama  :");
		lblAklama.setBounds(39, 225, 54, 25);
		contentPane.add(lblAklama);
		
		JLabel lblSeanslar = new JLabel(" Seanslar :");
		lblSeanslar.setBounds(39, 272, 54, 25);
		contentPane.add(lblSeanslar);
		
		JLabel lblFilmPuan = new JLabel(" Film Puan\u0131 :");
		lblFilmPuan.setBounds(39, 314, 67, 25);
		contentPane.add(lblFilmPuan);
		
		JLabel lblFiyat = new JLabel(" Fiyat :");
		lblFiyat.setBounds(39, 368, 67, 25);
		contentPane.add(lblFiyat);
		
		textField_movieName = new JTextField();
		textField_movieName.setBounds(174, 153, 134, 20);
		contentPane.add(textField_movieName);
		textField_movieName.setColumns(10);
		
		textField_movieUrl = new JTextField();
		textField_movieUrl.setColumns(10);
		textField_movieUrl.setBounds(174, 189, 134, 20);
		contentPane.add(textField_movieUrl);
		
		textField_description = new JTextField();
		textField_description.setColumns(10);
		textField_description.setBounds(174, 227, 134, 20);
		contentPane.add(textField_description);
		
		textField_movieRate = new JTextField();
		textField_movieRate.setColumns(10);
		textField_movieRate.setBounds(174, 316, 134, 20);
		contentPane.add(textField_movieRate);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(174, 370, 134, 20);
		contentPane.add(textField_price);
		
		JButton btn_Ekle = new JButton("Ekle");
		
		btn_Ekle.setBounds(85, 435, 89, 23);
		contentPane.add(btn_Ekle);
		
		textField_sessions = new JTextField();
		textField_sessions.setBounds(174, 274, 134, 20);
		contentPane.add(textField_sessions);
		textField_sessions.setColumns(10);
		
		JLabel lblFilmSil = new JLabel("Film Sil");
		lblFilmSil.setBounds(555, 82, 54, 31);
		contentPane.add(lblFilmSil);
		
		JLabel lblFilmAd_1 = new JLabel("Film Ad\u0131 :");
		lblFilmAd_1.setBounds(443, 151, 54, 25);
		contentPane.add(lblFilmAd_1);
		
		textField_deleteMovieName = new JTextField();
		textField_deleteMovieName.setColumns(10);
		textField_deleteMovieName.setBounds(547, 153, 134, 20);
		contentPane.add(textField_deleteMovieName);
		
		JButton btn_sil = new JButton("Sil");
		btn_sil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSuccessful = movieServices.deleteMovie(textField_deleteMovieName.getText());
				if(isSuccessful)
					JOptionPane.showMessageDialog(null,"��lem tamamland�");
				else
					JOptionPane.showMessageDialog(null,"��lem Ba�ar�s�z");
					
			}
		});
		btn_sil.setBounds(512, 212, 89, 23);
		contentPane.add(btn_sil);
		
		btn_Ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				isSuccessful =  movieServices.addMovie(textField_movieName.getText(),textField_movieUrl.getText(), textField_description.getText(), textField_sessions.getText(), textField_movieRate.getText(), textField_price.getText());
				if(isSuccessful)
					JOptionPane.showMessageDialog(null,"��lem tamamland�");
				else
					JOptionPane.showMessageDialog(null,"��lem Ba�ar�s�z");
			}
		});
	}
}