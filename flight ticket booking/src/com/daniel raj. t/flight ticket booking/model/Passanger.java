package model;

public class Passanger {
    String name;
    int age;
    Gender gender;
    int id;
    
    public Passanger() {
	this.name = "";
	this.age = -1;
	this.gender = null;
	this.id = -1;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getID() {
        return id;
    }
    public void setID(int id) {
        this.id = id;
    }
}
