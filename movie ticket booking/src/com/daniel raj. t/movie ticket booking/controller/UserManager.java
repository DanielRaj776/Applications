package controller;

import java.sql.SQLException;

import model.User;
import persistence.UserCRUD;

public class UserManager {
    private UserCRUD crud = new UserCRUD();
    public User signUp (User user) {
	User result = null;
	try {
	    result = crud.signUp(user);
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return result;
    }
    public boolean signIn (User user) {
	try {
	    if(crud.signIn(user)) {
	        return true;
	    }
	} catch (SQLException e) {
	    System.out.println("A Problem Has Occurred Please Try Again");
	}
	return false;
    }
}
