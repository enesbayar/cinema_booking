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
		
		String query = "INSERT INTO tblMovie" + "(movieName,movieUrl,description,movieRate,price,sessions,seats) VALUES" + "(?,?,?,?,?,?,?)";
		boolean key = false;
		try {
			statement = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, movieName);
			preparedStatement.setString(2, movieUrl);
			preparedStatement.setString(3, description);
			preparedStatement.setFloat(4, Float.parseFloat(movieRate));
			preparedStatement.setFloat(5, Float.parseFloat(price));
			preparedStatement.setString(6, sessions);
			preparedStatement.setString(7, "B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B;B");
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
	public boolean updateSeats(String newSeats, String movieName) {
		String query = "UPDATE tblMovie SET seats = ? WHERE movieName = ?";
		boolean key = false;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, newSeats);
			preparedStatement.setString(2, movieName);
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
	
	@SuppressWarnings("finally")
	@Override
	public ArrayList<Movie> getMoviesFromDatabase() throws SQLException {
		Movie movie;
		try{
			statement = con.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM tblMovie");
			while(resultSet.next()){
				movie = new Movie(resultSet.getString("movieName"),resultSet.getString("movieUrl"),resultSet.getString("description"),
						resultSet.getString("sessions"),resultSet.getFloat("movieRate"),resultSet.getFloat("price"),resultSet.getString("seats"));
				movieList.add(movie);
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
