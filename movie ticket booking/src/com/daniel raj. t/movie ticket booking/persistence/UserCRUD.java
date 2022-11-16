package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;

public class UserCRUD {
    private Connection connection;
    
    public UserCRUD() {
	connection = ConnectionPool.getConnection();
    }
    public User signUp (User owner) throws SQLException {
	String insertStatement = "INSERT INTO USER (USER_NAME, PASSWORD, CONTACT_NUMBER) VALUES (?, ?, ?)";
	try(PreparedStatement statement = connection.prepareStatement(insertStatement,  Statement.RETURN_GENERATED_KEYS)){
	    statement.setString(1, owner.getName());
	    statement.setString(2, owner.getPassword());
	    statement.setString(3, owner.getContactNumber());
	    statement.executeUpdate();
	    ResultSet generatedValues = statement.getGeneratedKeys();
	    if(generatedValues.next()) {
		int userId = generatedValues.getInt(1);
		owner.setUserID(userId);
	    }
	}
	return owner;
    }
    public boolean signIn (User owner) throws SQLException {
	String selectStatement = "SELECT USER_ID, USER_NAME, PASSWORD, CONTACT_NUMBER FROM USER WHERE USER_NAME = ? AND PASSWORD = ?";
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    statement.setString(1, owner.getName());
	    statement.setString(2, owner.getPassword());
	    ResultSet result = statement.executeQuery();
	    if(result.next()) {
		owner.setUserID(result.getInt(1));
		owner.setContactNumber(result.getString(4));
		return true;
	    }
	    return false;
	}
    }
}
