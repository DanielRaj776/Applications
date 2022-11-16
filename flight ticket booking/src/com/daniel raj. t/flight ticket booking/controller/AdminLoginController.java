package controller;

import repository.Admin;
import view.AdminLoginView;

public class AdminLoginController {
    private AdminLoginView adminLoginView = null;
    
    public AdminLoginController(AdminLoginView adminLoginView) {
	this.adminLoginView = adminLoginView;
    }
    
    public void loginCheck(String name, String password) {
	Admin admin = new Admin();
	if(admin.getName().equals(name) && admin.getPassword().equals(password)) {
	    adminLoginView.adminOptions();
	}else {
	    System.out.println("User name or Password is worng");
	}
    }
}
