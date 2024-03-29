package Services;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Movie;

public interface IMovieServices {
	public boolean addMovie(String movieName, String movieUrl, String description, String sessions, String movieRate, String price);
	public boolean deleteMovie(String movieName);
	public ArrayList<Movie> getMoviesFromDatabase() throws SQLException;
	public boolean updateSeats(String splittedSeats, String movieName);
}
