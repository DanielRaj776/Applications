package controller;

import java.sql.SQLException;
import java.util.List;

import model.Contact;
import persistence.ContactCRUD;

public class ManipulateContact {
    ContactCRUD crud;
    public ManipulateContact() {
	crud = new ContactCRUD();
    }
    
    public List<Contact> allContact () {
	List<Contact> contactList = null;
	try {
	    contactList = crud.searchContact("");
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
	return contactList;
    }
    public void addContact (Contact contact) {
	try {
	    crud.addContact(contact);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
    }
    public List<Contact> searchContact (String word) {
	List<Contact> contactList = null;
	try {
	    contactList = crud.searchContact(word);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
	return contactList;
    }
    public void updateContactName (Contact contact) {
	try {
	    crud.updateName(contact);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
    }
    public void updateContactPhoneNumber (Contact contact) {
	try {
	    crud.updatePhoneNumber(contact);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
    }
    public void updateContact (Contact contact) {
	try {
	    crud.updateContact(contact);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
    }
    public void deleteContact (Integer id) {
	try {
	    crud.deleteContact(id);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
    }
    public void updateFavourite (Contact contact) {
	try {
	    crud.updateIsFavourite(contact);
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
    }
    public List<Contact> getFavorite (){
	List<Contact> contactList = null;
	try {
	    contactList = crud.searchFavorite();
	} catch (SQLException e) {
	    System.out.println("       A Problem Has Occurred.     Try Again.");
	}
	return contactList;
    }
}