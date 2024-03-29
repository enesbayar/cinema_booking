package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Model.Movie;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.Color;

public class SeatScreen extends JFrame {

	private JPanel contentPane;
	private Movie movie;
	private JLabel[] labelSeats = new JLabel[34];
	private BufferedImage availableSeatImage = null;
	private BufferedImage unavailableSeatImage = null;
	private BufferedImage selectedSeatImage = null;
	private MouseAdapter ma;
	public int selectedSeatCount = 0;
	public File availableImage = new File("images/seatScreen/available.png");
	public File unavailableImage = new File("images/seatScreen/unavailable.png");
	public File selectedImage = new File("images/seatScreen/selectedSeat.png");
	public JLabel lblSelectedSeatCount;
	public JLabel lblPrice;
	private String[] splittedSeats;
	private JLabel lblBuy;
	private JLabel btnBuy;
	private JLabel lblCurtain;
	
	public SeatScreen(Movie movie) {
		setUndecorated(true);
		setResizable(false);
		this.movie = movie;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCurtain = new JLabel("");
		lblCurtain.setIcon(new ImageIcon(SeatScreen.class.getResource("/seatScreen/curtain.png")));
		lblCurtain.setBounds(236, 539, 550, 250);
		contentPane.add(lblCurtain);
		
		lblSelectedSeatCount = new JLabel("Se\u00E7ilen Koltuk Say\u0131s\u0131   : 0");
		lblSelectedSeatCount.setForeground(Color.BLACK);
		lblSelectedSeatCount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblSelectedSeatCount.setBounds(943, 49, 220, 39);
		contentPane.add(lblSelectedSeatCount);
		
		lblPrice = new JLabel("\u00D6denecek Tutar        : 0.0");
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		lblPrice.setBounds(943, 112, 220, 39);
		contentPane.add(lblPrice);
		
		btnBuy = new JLabel("Sat\u0131n Al");
		btnBuy.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnBuy.setHorizontalAlignment(SwingConstants.CENTER);
		btnBuy.setForeground(Color.WHITE);
		btnBuy.setBounds(943, 174, 160, 30);
		contentPane.add(btnBuy);
		
		lblBuy = new JLabel("");
		lblBuy.setIcon(new ImageIcon(SeatScreen.class.getResource("/adminScreen/button.png")));
		lblBuy.setBounds(943, 174, 160, 30);
		contentPane.add(lblBuy);
		
		drawSeats();
		
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				TicketInfoScreen ticketInfoScreen = new TicketInfoScreen(movie,selectedSeatCount,splittedSeats);
				ticketInfoScreen.setLocationRelativeTo(null);
				ticketInfoScreen.setVisible(true);
				dispose();
			}
		});
	}

	private String[] splitSeats() {
		String splitString = movie.getSeats();
		System.out.println("splitString" + splitString);
		String[] splittedString = splitString.split(";");
		return splittedString;
	}
	
	private void drawSeats() {
		splittedSeats = splitSeats();
		for(int i = 0; i<labelSeats.length; i++){
			
			labelSeats[i] = new JLabel();
			//labelSeats[i].setText(null);
			
			if(i<10){
				labelSeats[i].setBounds(250 + (i*50), 50, 50, 75);
			}
			else if(i>9 && i < 18 ){
				if(i<14){
					labelSeats[i].setBounds(250 + (50*(i-10)), 150, 50, 75);
				}
				else{
					labelSeats[i].setBounds(350 + (50 * (i-10)), 150, 50, 75);
				}
			}
			else if(i>17 && i < 26 ){
				if(i<22){
					labelSeats[i].setBounds(250 + (50*(i-18)), 250, 50, 75);
				}
				else{
					labelSeats[i].setBounds(350 + (50 * (i-18)), 250, 50, 75);
				}
				
			}
			else if(i>25 && i < 34 ){
				if(i<30){
					labelSeats[i].setBounds(250 + (50*(i-26)), 350, 50, 75);
				}
				else{
					labelSeats[i].setBounds(350 + (50 * (i-26)), 350, 50, 75);
				}
			}
			
			try {
				if(splittedSeats[i].contains("B")){
					
					availableSeatImage = ImageIO.read(availableImage);
					ImageIcon availableSeatIcon = new ImageIcon(new ImageIcon(availableSeatImage).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
					labelSeats[i].setIcon(availableSeatIcon);
				}
				else{
					
					unavailableSeatImage = ImageIO.read(unavailableImage);
					ImageIcon unavailableSeatIcon = new ImageIcon(new ImageIcon(unavailableSeatImage).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
					labelSeats[i].setIcon(unavailableSeatIcon);
					
				}
				String seatNo = String.valueOf((i+1));
				labelSeats[i].setText(seatNo);
				labelSeats[i].setVerticalTextPosition(SwingConstants.BOTTOM);
				labelSeats[i].setHorizontalTextPosition(SwingConstants.CENTER);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contentPane.add(labelSeats[i]);
			contentPane.repaint();
			
			try {
				selectedSeatImage = ImageIO.read(selectedImage);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			ma = new MouseAdapter(){
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					for(int i = 0; i<34; i++){
						if(e.getSource() == labelSeats[i]){
							ImageIcon selectedSeatIcon = new ImageIcon(new ImageIcon(selectedSeatImage).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
							ImageIcon availableSeatIcon = new ImageIcon(new ImageIcon(availableSeatImage).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
							ImageIcon tempIcon = ((ImageIcon) labelSeats[i].getIcon());
							selectedSeatIcon.setDescription("selectedSeatDescription");
							System.out.println("tempIcon " + tempIcon.getDescription());
							System.out.println("SelectedSeatIcon " + selectedSeatIcon.getDescription());
							boolean bool = selectedSeatIcon.getDescription().equals(tempIcon.getDescription());
							if(bool){
								labelSeats[i].setIcon(availableSeatIcon);
								tempIcon.setDescription("available");
								selectedSeatCount--;
								splittedSeats[i] = "B";
								System.out.println("splittedSeats " + splittedSeats[i].toString() );
								lblSelectedSeatCount.setText("Se\u00E7ilen Koltuk Say\u0131s\u0131   : " + String.valueOf(selectedSeatCount));
								lblPrice.setText("\u00D6denecek Tutar        : " + String.valueOf(movie.getPrice()*selectedSeatCount));
								System.out.println("count " + String.valueOf(selectedSeatCount));
							}
							else{
								labelSeats[i].setIcon(selectedSeatIcon);
								tempIcon.setDescription("selectedSeatDescription");
								selectedSeatCount++;
								splittedSeats[i] = "D";
								System.out.println("splittedSeats " + splittedSeats[i].toString() );
								lblSelectedSeatCount.setText("Se\u00E7ilen Koltuk Say\u0131s\u0131   : " + String.valueOf(selectedSeatCount));
								lblPrice.setText("\u00D6denecek Tutar        : " + String.valueOf(movie.getPrice()*selectedSeatCount));
								System.out.println("count " + String.valueOf(selectedSeatCount));
							}
							
							contentPane.repaint();

					}
					}
				}
			};
			labelSeats[i].addMouseListener(ma);
		}
	}
}
