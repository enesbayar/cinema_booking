package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnect {
	Connection connection = null;
	String url = "jdbc:sqlserver://localhost:1433;databaseName=SineMovie;integratedSecurity=true";
		
	public SQLConnect(){
		
	}
	
	public Connection connDB(){
		try{
			this.connection = DriverManager.getConnection(url);
			System.out.println("Connected to mssql");
			return connection;
		}catch(SQLException e){
			System.out.println(e.toString());
		}
		return connection;
	}

}
