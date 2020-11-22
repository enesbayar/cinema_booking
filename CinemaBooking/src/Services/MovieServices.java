package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Admin;
import Model.Movie;

public class MovieServices implements IMovieServices {
	SQLConnect sqlConnect = new SQLConnect();
	Connection con = sqlConnect.connDB();
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	public MovieServices(){
		
	}
	@Override
	public boolean addMovie(String movieName, String movieUrl, String description, String sessions, String movieRate, String price) {
		
		String query = "INSERT INTO tblMovie" + "(movieName,movieUrl,description,sessions,movieRate,price) VALUES" + "(?,?,?,?,?,?)";
		boolean key = false;
		try {
			statement = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, movieName);
			preparedStatement.setString(2, movieUrl);
			preparedStatement.setString(3, description);
			preparedStatement.setString(4, sessions);
			preparedStatement.setFloat(5, Float.parseFloat(movieRate));
			preparedStatement.setFloat(6, Float.parseFloat(price));
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(key)
			return key;
		else
			return false;
	}
	@Override
	public boolean deleteMovie(String movieName) {
		String query = "DELETE FROM tblMovie where movieName = ?";
		boolean key = false;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1,movieName);
			preparedStatement.executeUpdate();
			key = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(key)
			return key;
		else
			return false;
	}
	@Override
	public ArrayList<Movie> getMoviesFromDatabase() throws SQLException {
		Movie movie;
		try{
			statement = con.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM tblMovie");
			System.out.println("tablodan filmler çekiliyor");
			while(resultSet.next()){
				movie = new Movie(resultSet.getString("movieName"),resultSet.getString("movieUrl"),resultSet.getString("description"),
						resultSet.getString("sessions"),resultSet.getFloat("movieRate"),resultSet.getFloat("price"));
				movieList.add(movie);
				System.out.println("Filmler oluşturuldu");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			statement.close();
			resultSet.close();
			con.close();
			return movieList;
		}
	}

	
}
