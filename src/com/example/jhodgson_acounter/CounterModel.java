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
	public CounterModel() {
		this.name = "No name";
		this.count = 0;
		countTimes = new ArrayList<Calendar>();
	}

	public CounterModel(String users_name) {
		this.name = users_name;
		this.count = 0;
		countTimes = new ArrayList<Calendar>();
	}

	public int getCount() {
		return this.count;
	}

	public String getCountString() {
		return Integer.toString(this.count);
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void increment() {
		this.count++;
		this.countTimes.add(Calendar.getInstance());
	}

	public void reset() {
		this.count = 0;
		this.countTimes.clear();
	}

	@Override
	public int compareTo(CounterModel second) {
		return this.count < second.getCount() ? 1 : (this.count > second
				.getCount() ? -1 : 0);
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Calendar> getCountTimes() {
		return this.countTimes;
	}
}
