package com.example.jhodgson_acounter;

import java.util.ArrayList;

public class CounterListModel {

	private ArrayList<CounterModel> list;

	public CounterListModel() {
		super();
		list = new ArrayList<CounterModel>();
	}

	public ArrayList<CounterModel> getList() {
		return list;
	}

	public void setList(ArrayList<CounterModel> list) {
		this.list = list;
	}
}
