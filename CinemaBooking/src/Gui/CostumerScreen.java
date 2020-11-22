package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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

public class CostumerScreen extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JLabel[] labelImages;
	private MovieServices movieServices;
	private ArrayList<Movie> movieList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumerScreen frame = new CostumerScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public CostumerScreen() throws IOException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		contentPane.setLayout(null);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 1270, 760);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000,1200));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		
		drawLabels(panel);
		
		
		
	}

	private void drawLabels(JPanel panel) throws IOException {
		movieServices = new MovieServices();
		try {
			movieList = movieServices.getMoviesFromDatabase();
			labelImages = new JLabel[movieList.size()];
			for(int i = 0; i< movieList.size(); i++){
				labelImages[i] = new JLabel();
				labelImages[i].setText(null);
				if(i>2){
					System.out.println("i "+ String.valueOf(i));
					labelImages[i].setBounds(50+(250*(i-3)), 460 , 200, 400);
				}
				else{
					System.out.println("i "+ String.valueOf(i));
					labelImages[i].setBounds(50+(250*i), 20 , 200, 400);
				}
				BufferedImage image = null;
				URL url = new URL(movieList.get(i).getMovieUrl());
		        image = ImageIO.read(url);
		        ImageIcon imageIcon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(200, 400, Image.SCALE_DEFAULT));
				labelImages[i].setIcon(imageIcon);
				panel.add(labelImages[i]);
				panel.repaint();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
