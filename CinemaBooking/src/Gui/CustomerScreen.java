package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

import java.awt.Color;

import javax.swing.ScrollPaneConstants;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import Model.Movie;
import Services.MovieServices;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class CustomerScreen extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JLabel[] labelImages;
	private JLabel[] labelMovieName;
	private JLabel[] labelStar;
	private JLabel[] labelSession;
	private JButton[] buttonSelectSeat;
	private MovieServices movieServices;
	private ArrayList<Movie> movieList;
	private BufferedImage image = null;
	private BufferedImage starImage = null;
	private ActionListener al;

	public CustomerScreen() throws IOException {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 1280, 800);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(1000,1400));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		drawLabels(panel);
		
		
			
	}

	private void drawLabels(JPanel panel) throws IOException {
		movieServices = new MovieServices();
		
		try {
			movieList = movieServices.getMoviesFromDatabase();
			labelImages = new JLabel[movieList.size()];
			labelMovieName = new JLabel[movieList.size()];
			labelStar = new JLabel[movieList.size()];
			labelSession = new JLabel[movieList.size()];
			buttonSelectSeat = new JButton[movieList.size()];
			
			for(int i = 0; i< movieList.size(); i++){
				labelImages[i] = new JLabel();
				labelImages[i].setText(null);
				labelMovieName[i] = new JLabel();
				labelStar[i] = new JLabel();
				labelSession[i] = new JLabel();
				buttonSelectSeat[i] = new JButton();
				
				buttonSelectSeat[i].setText(null);
				buttonSelectSeat[i].setIcon(new ImageIcon(CustomerScreen.class.getResource("/customerScreen/button.jpg")));
				
				labelSession[i].setText("Seans: " +String.valueOf(movieList.get(i).getSessions()));
				labelSession[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
				labelSession[i].setForeground(Color.BLACK);
				
				labelStar[i].setText(String.valueOf(movieList.get(i).getMovieRate()));
				labelStar[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
				labelStar[i].setForeground(Color.BLACK);
				
				labelMovieName[i].setText(movieList.get(i).getMovieName());
				labelMovieName[i].setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
				labelMovieName[i].setForeground(Color.BLACK);
				
				if(i>2){
					System.out.println("i "+ String.valueOf(i));
					labelImages[i].setBounds(92+(389*(i-3)), 710 , 300, 450);
					labelMovieName[i].setBounds(132+(389*(i-3)),1160,350,50);
					labelStar[i].setBounds(132+(389*(i-3)),1200,350,50);
					labelSession[i].setBounds(132+(389*(i-3)),1230,350,50);
					buttonSelectSeat[i].setBounds(132+(389*(i-3)),1280,120,35);
				}
				else{
					System.out.println("i "+ String.valueOf(i));
					labelImages[i].setBounds(92+(389*i), 20 , 300, 450);
					labelMovieName[i].setBounds(192+(389*i),470,350,50);
					labelStar[i].setBounds(192+(389*i),510,350,50);
					labelSession[i].setBounds(192+(389*i),540,350,50);
					buttonSelectSeat[i].setBounds(192+(389*i),590,120,35);
				}
				
				File url = new File(movieList.get(i).getMovieUrl());
		        image = ImageIO.read(url);
		        ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(300, 450, Image.SCALE_DEFAULT));
				labelImages[i].setIcon(imageIcon);
				
				File sourceimage = new File("images/customerScreen/star.png");
				starImage = ImageIO.read(sourceimage);
				ImageIcon starIcon = new ImageIcon(new ImageIcon(starImage).getImage().getScaledInstance(14, 14, Image.SCALE_DEFAULT));
				labelStar[i].setIcon(starIcon);
				
				panel.add(buttonSelectSeat[i]);
				panel.add(labelSession[i]);
				panel.add(labelStar[i]);
				panel.add(labelImages[i]);
				panel.add(labelMovieName[i]);
				panel.repaint();
				
				al = new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						for(int i = 0; i<movieList.size(); i++){
							if(event.getSource() == buttonSelectSeat[i]){
								Movie movie = new Movie(movieList.get(i).getMovieName(),movieList.get(i).getMovieUrl(),movieList.get(i).getDescription(),movieList.get(i).getSessions(),
										movieList.get(i).getMovieRate(),
										movieList.get(i).getPrice(),
										movieList.get(i).getSeats());
								SeatScreen seatScreen = new SeatScreen(movie);
								seatScreen.setLocationRelativeTo(null);
								seatScreen.setVisible(true);
								dispose();
								
							}
						}
					}
					
				};
				buttonSelectSeat[i].addActionListener(al);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
