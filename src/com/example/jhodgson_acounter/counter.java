package com.example.jhodgson_acounter;

/*This class implements both the counter objects and the counter object management.
All counter objects are create and stored in a private array which only allows 
access through private static functions.*/

import java.util.ArrayList;
import java.util.Calendar;

public class counter {
	//Holds all the counters
	private static ArrayList<counter> counters = new ArrayList<counter>(); 
	private static counter currentCounter;
	
	//------Local Counter Variables---------
	private String name;
	private int count;
	private ArrayList<Calendar> countTimes;
	
	//------Counter Functions---------
	public counter(){
		this.name = "No name";
		this.count = 0;
		currentCounter = null;
		countTimes = new ArrayList<Calendar>();
	}
	
	public counter(String users_name){
		this.name = users_name;
		this.count = 0;
		currentCounter = null;
		countTimes = new ArrayList<Calendar>();
	}
	
	private int count(){
		return this.count;
	}

	@Override
	public String toString(){
		return this.name;
	}
	
	private void increment(){
		this.count++;
		this.countTimes.add(Calendar.getInstance());
	}
	
	private void reset(){
		this.count = 0;
		this.countTimes.clear();
	}
	
	
	//---------------------Static functions---------------------------
	
	//Return the array
	//For the purpose of creating an adapter on top of this array.
	
	//**TO DO**
	//Consider creating the adapter and passing it back instead of exposing the array
	public static ArrayList<counter> getArray(){
		return counters;
	}
	
	//Add a new counter to the list
	public static void addNewCounter(String name){
		counters.add(new counter(name));
	}
	
	//Sets the current editable counter
	public static void setCurrentCounter(int index){
		currentCounter = counters.get(index);
	}
	
	//Increment the current editable counter
	public static void incrementCounter(){
		currentCounter.increment();
	}
	
	//Returns the count for the current editable counter
	public static int getCurrentCount(){
		return currentCounter.count();
	}
	
	//Get the name of a specific counter
	public static String getName(){
		return currentCounter.toString();
	}
	
	//Clears the current editable counter
	public static void clearCurrentCounter(){
		currentCounter = null;
	}
	
	//Returns existance of editable counter
	public static Boolean hasEditableCounter(){
		if(currentCounter == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void resetCounter(){
		currentCounter.reset();
	}
}
