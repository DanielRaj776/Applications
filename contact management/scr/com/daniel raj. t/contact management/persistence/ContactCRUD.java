package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class ContactCRUD {
    Connection connection = null;
    public ContactCRUD() {
	connection = ConnectionPool.getConnection();
    }
    public void addContact (Contact contact) throws SQLException {
	String insertStatement = "INSERT INTO CONTACT (NAME, PHONE_NUMBER, IS_FAVOURITE) VALUES (?, ?, 0)";
	try(PreparedStatement statement = connection.prepareStatement(insertStatement)){
	    statement.setString(1, contact.getName());
	    statement.setString(2, contact.getPhoneNumber());
	    statement.executeUpdate();
	}
    }
    public List<Contact> searchContact (String word) throws SQLException{
	String selectStatement = "SELECT NAME, PHONE_NUMBER, ID FROM CONTACT WHERE NAME LIKE ?";
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    statement.setString(1, word+ "%");
	    ResultSet result = statement.executeQuery();
	    List<Contact> contacts = new ArrayList<>();
	    while(result.next()) {
		Contact contact = new Contact();
		contact.setName(result.getString(1));
		contact.setPhoneNumber(result.getString(2));
		contact.setId(result.getInt(3));
		contacts.add(contact);
	    }
	    return contacts;
	}
    }
    public List<Contact> searchFavorite () throws SQLException {
	String selectStatement = "SELECT NAME, PHONE_NUMBER, ID FROM CONTACT WHERE IS_FAVOURITE = 1";
	try(PreparedStatement statement = connection.prepareStatement(selectStatement)){
	    ResultSet result = statement.executeQuery();
	    List<Contact> contacts = new ArrayList<>();
	    while(result.next()) {
		Contact contact = new Contact();
		contact.setName(result.getString(1));
		contact.setPhoneNumber(result.getString(2));
		contact.setId(result.getInt(3));
		contacts.add(contact);
	    }
	    return contacts;
	}
    }

    public void updateContact (Contact contact) throws SQLException {
	String updateStatement = "UPDATE CONTACT SET NAME = ?, PHONE_NUMBER = ? WHERE ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(updateStatement)){
	    statement.setString(1, contact.getName());
	    statement.setString(2, contact.getPhoneNumber());
	    statement.setInt(3, contact.getId());
	    statement.executeUpdate();
	}
    }
    public void updatePhoneNumber (Contact contact) throws SQLException {
	String updateStatement = "UPDATE CONTACT SET PHONE_NUMBER = ? WHERE ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(updateStatement)){
	    statement.setString(1, contact.getPhoneNumber());
	    statement.setInt(2, contact.getId());
	    statement.executeUpdate();
	}
    }
    public void updateName (Contact contact) throws SQLException {
	String updateStatement = "UPDATE CONTACT SET NAME = ? WHERE ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(updateStatement)){
	    statement.setString(1, contact.getName());
	    statement.setInt(2, contact.getId());
	    statement.executeUpdate();
	}
    }
    public void deleteContact (Integer id) throws SQLException {
	String deleteStatement = "DELETE FROM CONTACT WHERE ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(deleteStatement)){
	    statement.setInt(1, id);
	    statement.executeUpdate();
	}
    }
    public void updateIsFavourite (Contact contact) throws SQLException {
	String updateStatement = "UPDATE CONTACT SET IS_FAVOURITE = ? WHERE ID = ?";
	try(PreparedStatement statement = connection.prepareStatement(updateStatement)){
	    statement.setInt(1, contact.getFavourite());
	    statement.setInt(2, contact.getId());
	    statement.executeUpdate();
	}
    }
    
}
