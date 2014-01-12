package com.example.jhodgson_acounter;

import java.util.ArrayList;

public class counter {
	//Holds all the counters
	private static ArrayList<counter> counters = new ArrayList<counter>(); 
	
	//------Local Counter Variables---------
	private String name;
	private int count;
	
	//------Counter Functions---------
	public counter(){
		this.name = "No name";
		this.count = 0;
	}
	
	public counter(String users_name){
		this.name = users_name;
		this.count = 0;
	}

	@Override
	public String toString(){
		return this.name;
	}
	
	public void incrementCounter(){
		count++;
	}
	
	
	//---------------------Static functions---------------------------
	
	//Return the array
	//For the purpose of creating an adapter on top of this array.
	public static ArrayList<counter> getArray(){
		return counters;
	}
	
	//Add a new counter to the list
	public static void addNewCounter(String name){
		counters.add(new counter(name));
	}
	
	//Get the name of a specific counter
	public static String getName(int index){
		return counters.get(index).toString();
	}
}
