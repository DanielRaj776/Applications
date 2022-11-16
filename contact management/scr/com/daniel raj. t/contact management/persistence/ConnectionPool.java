package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
//    static {
//	loadDriver();
//    }
//    private static void loadDriver () {
//	try {
//	    Class.forName("com.mysql.cj.jdbc.Driver");
//	} catch (ClassNotFoundException e) {
//	    e.printStackTrace();
//	}	
//    } 
    private static Connection connection = null;
    
    private ConnectionPool() {
    }
    
    public static Connection getConnection () {
	if(connection == null) {
	    String connectionURL = "jdbc:mysql://localhost:3306/contact_db?autoReconnect=true&useSSL=false";
		try {
		    connection = DriverManager.getConnection(connectionURL, "root", "LetItGo");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	return connection;
    }
    
    public void closeConnection () {
	try {
	    connection.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }
}
