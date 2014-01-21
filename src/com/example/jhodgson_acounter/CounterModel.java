package com.example.jhodgson_acounter;

/*This class implements  the counter object*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class CounterModel implements Comparable<CounterModel>, Serializable {

	private static final long serialVersionUID = 1L;
	// ------Local Counter Variables---------
	private String name;
	private int count;
	private ArrayList<Calendar> countTimes;

	// ------Counter Functions---------
	
	//Constructor
	public CounterModel() {
		this.name = "No name";
		this.count = 0;
		countTimes = new ArrayList<Calendar>();
	}
	
	//Constructor that takes a name
	public CounterModel(String users_name) {
		this.name = users_name;
		this.count = 0;
		countTimes = new ArrayList<Calendar>();
	}

	//returns the count
	public int getCount() {
		return this.count;
	}
	
	//Returns the count as a string
	public String getCountString() {
		return Integer.toString(this.count);
	}
	
	//Returns the name of this counter
	@Override
	public String toString() {
		return this.name;
	}
	
	//Increments the counter
	public void increment() {
		this.count++;
		this.countTimes.add(Calendar.getInstance());
	}

	//Resets the count to 0
	public void reset() {
		this.count = 0;
		this.countTimes.clear();
	}
	
	//A comparator for counters using the count
	@Override
	public int compareTo(CounterModel second) {
		return this.count < second.getCount() ? 1 : (this.count > second
				.getCount() ? -1 : 0);
	}
	
	//Give the counter a new name
	public void setName(String name) {
		this.name = name;
	}
	
	//Returns the list of calendar items that hold the time of the count increments
	public ArrayList<Calendar> getCountTimes() {
		return this.countTimes;
	}
}
