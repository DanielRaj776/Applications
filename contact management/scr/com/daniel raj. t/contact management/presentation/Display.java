package presentation;

import java.util.List;

import model.Contact;

public class Display {
    public void displayContacts (List<Contact> list) {
	System.out.println("      ID       NAME                    PHONE NUMBER");
	System.out.println();
	for(Contact contact : list) {
	    int len = 18 - contact.getName().length();
	    System.out.printf("     %3d       %s%" + len + "s       %10s", contact.getId(), contact.getName(),"", contact.getPhoneNumber());
	    System.out.println();
	}
	System.out.println("__________________________________________________");
    }
}
