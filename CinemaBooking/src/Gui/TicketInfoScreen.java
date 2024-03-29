package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import Model.Movie;
import Services.MovieServices;
import java.util.ArrayList;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicketInfoScreen extends JFrame {

	private JPanel optionPane;
	private String[] splittedSeats;
	public String newSeats;
	private MovieServices movieServices;
	private boolean result;
	
	
	public TicketInfoScreen(Movie movie, int selectedSeatCount, String[] splittedSeats) {
		setUndecorated(true);
		setResizable(false);
		this.splittedSeats = splittedSeats;
		
		movieServices = new MovieServices();
		newSeats = new String("");
		createNewSeats();
		DateFormat dform = new SimpleDateFormat("dd/MM/yyyy");
		Date obj = new Date();
		System.out.println("New Seats " + newSeats);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		optionPane = new JPanel();
		optionPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(optionPane);
		optionPane.setLayout(null);
		
		JLabel lblCinemaName = new JLabel("SineMovie");
		lblCinemaName.setForeground(Color.WHITE);
		lblCinemaName.setBounds(13, 26, 424, 19);
		lblCinemaName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		lblCinemaName.setHorizontalAlignment(SwingConstants.CENTER);
		optionPane.add(lblCinemaName);
		
		JLabel lblMovieName = new JLabel("Film Ad\u0131              : " + movie.getMovieName());
		lblMovieName.setForeground(Color.WHITE);
		lblMovieName.setBounds(20, 65, 276, 25);
		lblMovieName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblMovieName.setVerticalAlignment(SwingConstants.TOP);
		lblMovieName.setHorizontalAlignment(SwingConstants.LEFT);
		optionPane.add(lblMovieName);
		
		JLabel lblMovieSession = new JLabel("Seans                  : " + movie.getSessions());
		lblMovieSession.setForeground(Color.WHITE);
		lblMovieSession.setVerticalAlignment(SwingConstants.TOP);
		lblMovieSession.setHorizontalAlignment(SwingConstants.LEFT);
		lblMovieSession.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblMovieSession.setBounds(20, 101, 276, 25);
		optionPane.add(lblMovieSession);
		
		JLabel lblMovieDate = new JLabel("Tarih                   : " + dform.format(obj));
		lblMovieDate.setForeground(Color.WHITE);
		lblMovieDate.setVerticalAlignment(SwingConstants.TOP);
		lblMovieDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblMovieDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblMovieDate.setBounds(20, 137, 276, 25);
		optionPane.add(lblMovieDate);
		
		JLabel lblSeilenKoltukSays = new JLabel("Koltuk Say\u0131s\u0131        : " + String.valueOf(selectedSeatCount));
		lblSeilenKoltukSays.setForeground(Color.WHITE);
		lblSeilenKoltukSays.setVerticalAlignment(SwingConstants.TOP);
		lblSeilenKoltukSays.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeilenKoltukSays.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSeilenKoltukSays.setBounds(20, 173, 276, 25);
		optionPane.add(lblSeilenKoltukSays);
		
		JLabel lbldenecekTutar = new JLabel("\u00D6denecek Tutar    : " + String.valueOf((movie.getPrice()*selectedSeatCount))+ " TL");
		lbldenecekTutar.setForeground(Color.WHITE);
		lbldenecekTutar.setVerticalAlignment(SwingConstants.TOP);
		lbldenecekTutar.setHorizontalAlignment(SwingConstants.LEFT);
		lbldenecekTutar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lbldenecekTutar.setBounds(20, 213, 276, 25);
		optionPane.add(lbldenecekTutar);
		
		JLabel btnApprove = new JLabel("Onayla");
		btnApprove.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnApprove.setHorizontalAlignment(SwingConstants.CENTER);
		btnApprove.setForeground(Color.WHITE);
		btnApprove.setBounds(175, 249, 100, 25);
		optionPane.add(btnApprove);
		
		JLabel lblApprove = new JLabel("");
		lblApprove.setIcon(new ImageIcon(TicketInfoScreen.class.getResource("/adminScreen/button.png")));
		lblApprove.setBounds(174, 250, 100, 25);
		optionPane.add(lblApprove);
		
		JLabel lblWallpaper = new JLabel("");
		lblWallpaper.setIcon(new ImageIcon(TicketInfoScreen.class.getResource("/adminScreen/wallpaper.jpg")));
		lblWallpaper.setBounds(0, 0, 450, 300);
		optionPane.add(lblWallpaper);
		
		btnApprove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				result = movieServices.updateSeats(newSeats, movie.getMovieName());
				if(result){
					JOptionPane.showMessageDialog(null, "Biletiniz Onayland�!");
				}
				else{
					JOptionPane.showMessageDialog(null, "Hata Olu�tu!");
				}
				newSeats = "";
				HomeScreen homeScreen = new HomeScreen();
				homeScreen.setVisible(true);
				dispose();
			}
		});
		
	}


	private void createNewSeats() {
		for(int i = 0; i< splittedSeats.length; i++){
			if(i!=33){
				newSeats += splittedSeats[i] + ";"; 
			}
			else{
				newSeats += splittedSeats[i];
			}
		}
	}
}
