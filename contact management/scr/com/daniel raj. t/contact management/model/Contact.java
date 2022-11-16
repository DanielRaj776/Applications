package model;

public class Contact {
    private Integer id;
    private String name;
    private String phoneNumber;
    private Integer favourite;
    
    public Contact() {
	setFavourite(0);
    }
    
    public void setId (Integer id) {
	this.id = id;
    }
    public Integer getId () {
	return id;
    }
    public String getName() {
	return name;
    }
    public void setName(String name) {
	this.name = name;
    }
    public String getPhoneNumber() {
	return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString () {
	StringBuilder builder = new StringBuilder("");
	builder.append('[');
	builder.append(name).append(", ");
	builder.append(phoneNumber).append(", ");
	builder.append(id);
	builder.append(']');
	return builder.toString();
    }

    public Integer getFavourite() {
	return favourite;
    }

    public void setFavourite(Integer favourite) {
	this.favourite = favourite;
    }
}
