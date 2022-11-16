package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class ReadInput {
    
    private void readFile() {
	File inputFile = new File("\\Users\\Daniel Raj\\eclipse-workspace\\Cricket3\\src\\repository\\input");
	try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
	    Queue<String> list = new LinkedList<>();
	    String line = null;
	    while ((line = reader.readLine()) != null) {
		list.add(line);
	    }
	    new Match().setTeams(list);
	}catch (FileNotFoundException e) {
	    System.out.println("file not found");
	} catch (IOException e1) {
	    System.out.println("io exception");
	}
    }
    
    public static void main(String[] args) {
	ReadInput ob = new ReadInput();
	ob.readFile();
    }
}
