package model;

public enum Gender {
    MALE(1), FEMALE(2), TRANCE(3);
    private int id;
    
    Gender(int id) {
	this.id = id; 
    }
    
    public int getID () {
	return id;
    }
    
    public static Gender getGender (int id) {
	for(Gender x :Gender.values()) {
	    if(x.getID() == id) {
		return x;
	    }
	}
	return null;
    }
}
