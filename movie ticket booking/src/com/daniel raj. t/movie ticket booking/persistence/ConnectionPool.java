package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    static Connection connection = null;
    
    private ConnectionPool() {    }
    
    public static Connection getConnection () {
	if(connection == null) {
	    try {
		String URL = "jdbc:mysql://localhost:3306/theatres?autoReconnect=true&useSSL=false";
		connection = DriverManager.getConnection(URL, "root", "LetItGo");
	    } catch (SQLException e) {
		System.out.println("A Problem Has Occurred Please Try Again");
	    }
	}
	return connection;
    }
}
