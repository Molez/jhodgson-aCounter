package com.example.jhodgson_acounter;

import java.util.ArrayList;
import java.util.Collections;

/*This class is the controller for the list of counters this program has. 
 * All control of the list and the counters goes through this class. 
 * For simplicity this class keeps track of a current editable counter. 
 * This is the active counter when in the Counter Activity and most functions
 * only alter that counter*/

import android.content.Context;

public class CounterListController {

	// We keep track of a current editable counter
	private static CounterModel currentCounter = null;
	//This is the list of counters that this class controls.
	private static CounterListModel counterListModel = null;

	//Constructor
	public CounterListController() {
		super();
		if (counterListModel == null)
			counterListModel = new CounterListModel();
	}

	/*Returns the list of counters. This is ONLY so that we can build adapters on
	top of the list. Shoud look into a better way to do this that does not expose the list*/
	public ArrayList<CounterModel> getList() {
		return counterListModel.getList();
	}

	//Adds a new counter to the list with a specific name
	public void addCounter(String name) {
		counterListModel.getList().add(new CounterModel(name));
	}
	
	//Returns the current editable counter
	public CounterModel getCurrentCounter() {
		return currentCounter;
	}
	
	//Sets the current editable counter to a specific index
	public void setCurrentCounter(int index) {
		currentCounter = counterListModel.getList().get(index);
	}

	//Increments the count in the counter
	public void incrementCounter() {
		currentCounter.increment();
	}

	// Returns the count for the current editable counter
	public int getCurrentCount() {
		return currentCounter.getCount();
	}

	//Returns the name for the current editable counter
	public String getCurrentName() {
		return currentCounter.toString();
	}

	// Clears the current editable counter
	public void clearCurrentCounter() {
		currentCounter = null;
	}
	
	//Resets the current editable counter
	public void resetCounter() {
		currentCounter.reset();
	}
	
	//Deletes the current editable counter from the list
	public void deleteCurrentCounter() {
		counterListModel.getList().remove(currentCounter);
		currentCounter = null;
	}
	
	//Sorts the counter list from highest count to lowest
	public void sortCounters() {
		Collections.sort(counterListModel.getList());
	}
	
	//Sorts the counter list from lowest to highest
	public void sortCountersReverse() {
		Collections
				.sort(counterListModel.getList(), Collections.reverseOrder());
	}

	//Renames the current editable counter
	public void renameCurrentCounter(String name) {
		currentCounter.setName(name);
	}
	
	//Saves the list of counters to disk
	public void saveState(Context context) {
		counterListModel.save(context);
	}

	//Restores the list of counters from disk into the program
	public void restoreState(Context context) {
		counterListModel.restore(context);
	}
}
