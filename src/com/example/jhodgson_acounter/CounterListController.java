package com.example.jhodgson_acounter;

import java.util.ArrayList;
import java.util.Collections;

public class CounterListController {

	private static CounterModel currentCounter = null;
	private static CounterListModel counterListModel = null;

	public CounterListController() {
		super();
		if (counterListModel == null)
			counterListModel = new CounterListModel();
	}

	public ArrayList<CounterModel> getList() {
		return counterListModel.getList();
	}

	public void addCounter(String name) {
		counterListModel.getList().add(new CounterModel(name));
	}

	public void setCurrentCounter(int index) {
		currentCounter = counterListModel.getList().get(index);
	}

	public void incrementCounter() {
		currentCounter.increment();
	}

	// Returns the count for the current editable counter
	public int getCurrentCount() {
		return currentCounter.getCount();
	}

	public String getCurrentName() {
		return currentCounter.toString();
	}

	// Clears the current editable counter
	public void clearCurrentCounter() {
		currentCounter = null;
	}

	// Returns existence of editable counter
	public Boolean hasEditableCounter() {
		if (currentCounter == null) {
			return false;
		} else {
			return true;
		}
	}

	public void resetCounter() {
		currentCounter.reset();
	}

	public void sortCounters() {
		Collections.sort(counterListModel.getList());
	}

}
